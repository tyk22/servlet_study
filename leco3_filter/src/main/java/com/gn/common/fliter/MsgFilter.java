package com.gn.common.fliter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import com.gn.common.wrapper.MsgReqeustWrapper;


public class MsgFilter extends HttpFilter implements Filter{
       
	private static final long serialVersionUID = 1L;

	public MsgFilter() {
        super();
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("[MsgFilter]요청 가로챔");
		MsgReqeustWrapper mrw
			= new MsgReqeustWrapper((HttpServletRequest)request);
		chain.doFilter(mrw, response);
		System.out.println("[msgFilter]응답 가로챔");
		
		
	}



}
