package ldr.filter;

import com.talebase.common.constant.global.ServiceParamEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.addOriginalRequestUrl;

/**
 * Created by Administrator on 2021/8/29.
 */
@Component
@Slf4j
public class MyGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        addOriginalRequestUrl(exchange, request.getURI());
        List<String> tenants =  request.getHeaders().get(ServiceParamEnum.TENANTID.getValue());

        String  tenant = "";
        if (null != tenants && tenants.size() > 0){
            tenant = tenants.get(0);
        }

        request = exchange.getRequest().mutate().header(ServiceParamEnum.TENANTID.getValue(), tenant).build();
        return chain.filter(exchange.mutate().request(request).build());
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
