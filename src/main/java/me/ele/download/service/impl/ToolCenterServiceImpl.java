package me.ele.download.service.impl;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import lombok.extern.slf4j.Slf4j;
import me.ele.download.constant.PublicConstant;
import me.ele.download.service.ToolCenterService;
import me.ele.download.utils.ConstantPropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.Date;
import java.util.Objects;

/**
 * @author jiahuizhai.zjh
 * @create 2021-08-23 11:48 上午
 * @description
 */
@Service
@Slf4j
public class ToolCenterServiceImpl implements ToolCenterService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 获取阿里云存储相关常量
    String bucketName = ConstantPropertiesUtil.BUCKET_NAME;

    @Autowired
    private OSS ossClient;

    @Override
    public String getFilePath(String fileName) {
        // 过期时间设为1小时
        Date expiration = new Date(new Date().getTime() + PublicConstant.URL_EXPIRATION_TIME);
        // 生成URL
        URL url = null;
        try {
            url = ossClient.generatePresignedUrl(bucketName, fileName, expiration);
        } catch (ClientException e) {
            logger.error("OSS返回文件url异常", e);
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message: " + e.getMessage());
        } finally {
            ossClient.shutdown();
        }
        // 返回url
        if (Objects.nonNull(url)) {
            return url.toString();
        }
        return null;
    }
}
