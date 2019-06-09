package com.edu.schoolT.event;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;

public abstract class EventListener implements InitializingBean {
	
	@Autowired 
	EventDispatcher eventDispatcher;
	public EventDispatcher getEventDispatcher() {
		return eventDispatcher;
	}

	public void setEventDispatcher(EventDispatcher eventDispatcher) {
		this.eventDispatcher = eventDispatcher;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// As soon as the new eventlistener is created, 
		//it would be registered in the list of listeners. 
		
		eventDispatcher.regiserListener(this);
	}
	
	public abstract boolean canHandle(ApplicationEvent  event);
	public abstract void handle(ApplicationEvent  event);
	
	

}
