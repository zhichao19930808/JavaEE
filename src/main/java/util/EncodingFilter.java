package util;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by mingfei.net@gmail.com
 * 6/14/17 14:07
 * https://github.com/thu/JavaEE_1702/
 * filter 过滤器\ ['fɪltə] encoding 编码\ [ɪn'kəʊdɪŋ]
 */
@WebFilter(urlPatterns = "/*")
public class EncodingFilter implements Filter { // JSP "ISO8859-1"

    private static final String ENCODING = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // initialization 初始化\ [ɪ,nɪʃəlaɪ'zeɪʃən]
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(ENCODING);
        response.setCharacterEncoding(ENCODING);
        // chain 链\ [tʃeɪn] jQuery
        chain.doFilter(request, response); // 链子
    }

    @Override
    public void destroy() {
        // destroy 销毁
    }
}