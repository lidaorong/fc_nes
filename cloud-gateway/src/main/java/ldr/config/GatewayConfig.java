package ldr.config;

import java.util.Collections;

/**
 * Created by Administrator on 2021/8/29.
 */
@Configuration
public class GatewayConfig {
    private  final List<ViewResolver> viewResolvers;
    private  final ServerCodecConfigurer serverCodecConfigurer;

    public GatewayConfig(ObjectProvider<List<ViewResolver>> viewResolvers, ServerCodecConfigurer serverCodecConfigurer) {
        this.viewResolvers = viewResolvers.getIfAvailable(Collections::emptyList);
        this.serverCodecConfigurer = serverCodecConfigurer;
    }

    @Bean
    @Order
    public SentinelGatewayFilter sentinelGatewayFilter(){
        return new SentinelGatewayFilter();
    }

    @Bean
    @Order
    public SentinelGatewayBlockExceptionHandler SentinelGatewayBlockExceptionHandler(){
        return new SentinelGatewayBlockExceptionHandler(viewResolvers,serverCodecConfigurer);
    }
}
