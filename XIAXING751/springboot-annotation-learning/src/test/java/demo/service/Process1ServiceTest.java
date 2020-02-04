package demo.service;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import demo.service.Process1ServiceTest.TestConfig;

@ContextConfiguration(classes=TestConfig.class)
public class Process1ServiceTest {
	
	@Configuration
	static class TestConfig {
		public TestConfig() {
			// TODO Auto-generated constructor stub
		}
		
		//MockBean
		
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
