package ldr;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * Created by Administrator on 2021/8/29.
 */
@RefreshScope
@EnableDiscoveryClient
public class NesApplication {
    public static void main(String[] args){
        SpringApplication.run(NesApplication.class, args);
    }
}
