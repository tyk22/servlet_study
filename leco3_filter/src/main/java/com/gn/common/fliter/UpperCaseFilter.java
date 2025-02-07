package com.gn.common.fliter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import com.gn.common.wrapper.MsgReqeustWrapper;
import com.gn.common.wrapper.StringUpperWrapper;


@WebFilter("/*")
public class UpperCaseFilter extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = 1L;


	public UpperCaseFilter() {
    }


	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		MsgReqeustWrapper mrw
//		= new MsgReqeustWrapper((HttpServletRequest)request);
		StringUpperWrapper upg = new StringUpperWrapper((HttpServletRequest)request);
		chain.doFilter(upg, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {

	}

}
