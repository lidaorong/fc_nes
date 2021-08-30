package ldr;

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
