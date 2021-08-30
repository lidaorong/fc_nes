package ldr.filter;

import java.util.List;

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
