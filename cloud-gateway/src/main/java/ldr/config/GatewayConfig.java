package ldr.config;

import com.alibaba.csp.sentinel.adapter.gateway.sc.SentinelGatewayFilter;
import com.alibaba.csp.sentinel.adapter.gateway.sc.exception.SentinelGatewayBlockExceptionHandler;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.result.view.ViewResolver;

import java.util.Collections;
import java.util.List;

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
