package me.ele.download.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jiahuizhai.zjh
 * @create 2021-08-23 5:20 下午
 * @description
 */
@Configuration
public class OSSConfiguration {

    // 获取阿里云存储相关常量
    String endPoint = ConstantPropertiesUtil.END_POINT;
    String accessKeyId = ConstantPropertiesUtil.ACCESS_KEY_ID;
    String accessKeySecret = ConstantPropertiesUtil.ACCESS_KEY_SECRET;

    @Bean
    public OSS ossClient() {
        OSS ossClient = new OSSClientBuilder().build(endPoint, accessKeyId, accessKeySecret);
        return ossClient;
    }
}
