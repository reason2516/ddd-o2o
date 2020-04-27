package com.wmx.o2o.gateway.customer.filter;

import com.wmx.o2o.gateway.customer.config.xservice.auth.AuthTokenRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.RequestPath;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@Component
public class AuthGatewayFilterFactory extends AbstractGatewayFilterFactory<AuthGatewayFilterFactory.Config> {

    @Autowired
    private AuthTokenRegister authTokenRegister;

    public AuthGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("enable");
    }

    @Override
    public GatewayFilter apply(Config config) {
        return new AuthGatewayFilter(authTokenRegister);
    }

    public static class Config {
        boolean enable;

        public Config() {
        }

        public Config(boolean enable) {
            this.enable = enable;
        }

        public boolean isEnable() {
            return enable;
        }

        public void setEnable(boolean enable) {
            this.enable = enable;
        }
    }

    private static class AuthGatewayFilter implements GatewayFilter {
        private final AuthTokenRegister authTokenRegister;

        public AuthGatewayFilter(AuthTokenRegister authTokenRegister) {
            this.authTokenRegister = authTokenRegister;
        }

        @Override
        public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
            ServerHttpRequest request = exchange.getRequest();
            RequestPath path = request.getPath();
            return chain.filter(exchange);
        }
    }
}
