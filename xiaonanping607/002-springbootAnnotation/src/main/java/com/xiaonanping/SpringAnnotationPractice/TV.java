package com.saksham.SpringAnnotationPractice;

import org.springframework.stereotype.Component;

@Component
public class TV {
	
	// using @component shows that this class will be use as Bean which will be injected to other class
	
	public TV() {
		System.out.println("TV recieved a signal");
	}
	
	public void  turnOn() {
		System.out.println("TV is turned ON");
	}

	public void channelChange() {
		System.out.println("Channel has changed");
	}

}
