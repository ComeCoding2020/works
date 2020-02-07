package com.saksham.SpringAnnotationPractice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.saksham.SpringAnnotationPractice ")
public class CollegeConfiguration {
	

	@Bean
	public Principal principalBeanMethod() {
		return new Principal();
	}
	
	
	@Bean(name= "colBean")		// for multiple name use=> @Bean(name={"abc","bcd"})
	public College collegeBeanMethod() {		//by default method name will be bean ID
		College college=new College(principalBeanMethod());
		return college;
	}

}
