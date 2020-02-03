package config;

import org.springframework.context.annotation.Configuration;

import demo.service.Process1Service;

@Configuration
public class ProcessConfig {
	public ProcessConfig(Process1Service p1s) {
		System.out.println("ProcessConfig start");
		System.out.println(p1s.toString());
	}
}
