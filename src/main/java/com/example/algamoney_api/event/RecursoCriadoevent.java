package com.example.algamoney_api.event;

import org.apache.catalina.filters.ExpiresFilter.XHttpServletResponse;
import org.springframework.context.ApplicationEvent;

public class RecursoCriadoevent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	public RecursoCriadoevent(Object source, XHttpServletResponse response, Long codigo) {
		super(source);
	
	}

}
