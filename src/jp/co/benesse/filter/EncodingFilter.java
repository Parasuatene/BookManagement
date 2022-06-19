package jp.co.benesse.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(
	urlPatterns = { "/*" },
	initParams = { @WebInitParam(name = "encoding", value = "UTF-8") }
)
public class EncodingFilter implements Filter {

	// エンコーディング文字コード
	private String encoding;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//エンコーディング
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		encoding = fConfig.getInitParameter("encoding");
	}

}
