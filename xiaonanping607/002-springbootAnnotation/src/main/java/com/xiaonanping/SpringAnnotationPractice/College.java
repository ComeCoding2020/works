package com.saksham.SpringAnnotationPractice;

import org.springframework.beans.factory.annotation.Autowired;

//@Component("name")
public class College {
	
	@Autowired
	private Principal principal;
	
	
	public College(Principal principal) {
		this.principal = principal;
	}



	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}



	public void test() {
		principal.principalInfo();
		System.out.println("This is test method");
	}
}
