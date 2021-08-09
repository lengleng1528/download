package me.ele.download;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//相当于给这个包所有类都加了mapper注解
@MapperScan(value = "me.ele.download.mapper")
@SpringBootApplication
public class DownloadApplication {

    public static void main(String[] args) {
        SpringApplication.run(DownloadApplication.class, args);
    }

}
