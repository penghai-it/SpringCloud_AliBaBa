package it.ph.com.cn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author penghai
 * @type Class
 * @date 2022年01月13日 16:25
 */
@SpringBootApplication
@MapperScan("it.ph.com.cn.dao")//或者dao层加@Mapper注解
@EnableDiscoveryClient
public class VideoApplication {
    public static void main(String[] args) {
        SpringApplication.run(VideoApplication.class, args);
    }
}
