package com.saksham.SpringAnnotationPractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TvRemote {
	
	@Autowired				// We can use here or in setter method, going to inject dependencies  
	public TV tv;

	public TV getTv() {
		return tv;
	}

	//@Autowired
	public void setTv(TV tv) {
		this.tv = tv;
	}
	
	public void performAction() {
		tv.turnOn();
		tv.channelChange();
	}


}
