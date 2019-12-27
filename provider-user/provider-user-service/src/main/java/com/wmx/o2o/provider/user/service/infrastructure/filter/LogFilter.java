package com.wmx.o2o.provider.user.service.infrastructure.filter;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Log4j2
@Component
public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("LogFilter start");
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("LogFilter end");
    }

    @Override
    public void destroy() {

    }
}
