package com.yogesh.zuul.zuul.filter;

import java.util.logging.Logger;

import org.apache.http.protocol.RequestContent;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulAPIFilter extends ZuulFilter {
	
	private Logger logger = Logger.getGlobal();

	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext requestContext = RequestContext.getCurrentContext().getCurrentContext();
		logger.fine(requestContext.toString());
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
