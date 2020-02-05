package demo.config;

import org.springframework.context.annotation.Configuration;

import demo.service.Process1Service;

@Configuration
public class ProcessConfig2 {
	
	public ProcessConfig2(Process1Service p1s) {
		System.out.println("ProcessConfig2 start");
		System.out.println(p1s.toString());
	}
}
