package it.ph.com.cn.filter;

import com.alibaba.nacos.api.utils.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义全局过滤器
 *
 * @author penghai
 * @type Interface
 * @date 2022年02月21日 17:20
 */
//@Component(注释掉，不让Spring扫描)
public class UserGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getHeaders().getFirst("token");
        //TODO 根据业务实现具体的鉴权规则，（常用的鉴权规则JWT）
        //判断是否为空
        if (StringUtils.isBlank(token)) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        //否则继续往下执行，进入下一个过滤
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
