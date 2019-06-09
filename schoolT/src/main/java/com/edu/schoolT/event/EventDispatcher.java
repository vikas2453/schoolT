package com.edu.schoolT.event;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EventDispatcher implements ApplicationListener {

	private List<EventListener> eventListenerList = new ArrayList<EventListener>();
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		// TODO Auto-generated method stub
		
		for(EventListener e:eventListenerList){
			if(e.canHandle(event)){
				e.handle(event);
			}
		}
		
	}
	
	public void regiserListener(EventListener eventListener){
		eventListenerList.add(eventListener);
	}

}
