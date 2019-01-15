package infoplat.demo.filter;


import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.io.IOException;

@Configuration
public class CharSetFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest Request, ServletResponse Response, FilterChain filterChain) throws IOException, ServletException {
        String encoding = "UTF-8";
        Request.setCharacterEncoding(encoding);
        Response.setCharacterEncoding(encoding);
        filterChain.doFilter(Request,Response);
    }

    @Override
    public void destroy() {

    }
}
