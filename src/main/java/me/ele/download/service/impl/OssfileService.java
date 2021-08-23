package me.ele.download.service.impl;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.aliyuncs.utils.StringUtils;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;



import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Random;
@Data
@Component
public class OssfileService {

    private static final Logger logger = LoggerFactory.getLogger(OssfileService.class);


    private String endpoint = "oss-cn-beijing.aliyuncs.com";
    private String accessKeyId = "LTAI5tCqg8HaNumzLeAgmQbb";
    private String accessKeySecret = "vmVP7h15NuWqePcHPssfbGu8ZtVFlB";
    private String bucketName = "e-zhan-download";

    //文件存储目录
    private String filedir = "mall/";
    private String endDir = "/";


    public String uploadExcel2OSS(InputStream instream, String fileName) {
        String ret = "";
        this.setFiledir("osc/");
        //String fileDir = "osc/";
        try {
            //创建上传Object的Metadata
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(instream.available());
            objectMetadata.setCacheControl("no-cache");
            objectMetadata.setHeader("Pragma", "no-cache");
            objectMetadata.setContentType("application/vnd.ms-excel");
            objectMetadata.setContentDisposition("inline;filename=" + URLEncoder.encode(fileName,"UTF-8"));
            //上传文件

            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            PutObjectResult putResult = ossClient.putObject(bucketName, this.filedir + fileName, instream, objectMetadata);
            ret = putResult.getETag();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            try {
                if (instream != null) {
                    instream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //return ret;
        String key = this.filedir + fileName.substring(0,fileName.lastIndexOf("."));
        return getUrl(key);
    }

    /**
     * 获得url链接
     *
     * @param key
     * @return
     */
    public String getUrl(String key) {
        // 设置URL过期时间为10年  3600l* 1000*24*365*10
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
        // 生成URL
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
        if (url != null) {
            return url.toString();
        }
        return null;
    }

}
