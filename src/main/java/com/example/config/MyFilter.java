package com.example.config;

import lombok.extern.slf4j.Slf4j;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 过滤器几乎对所有的请求起作用
 */
@WebFilter
@Slf4j
public class MyFilter  implements Filter {
    /**
     *
     * @param filterConfig
     * @throws ServletException
     *
     * web应用程序启动时，web服务器将创建filter对象，并且调用init()方法，为对后续用户请求的拦截过滤工作
     * 做好准备，filter对象只会创建一个，init方法也只会调用一次。
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filter初始化完成");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("filter在工作");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        log.info("filter销毁完成");
    }

}
