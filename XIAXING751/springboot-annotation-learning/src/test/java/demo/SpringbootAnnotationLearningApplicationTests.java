package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import config.ProcessConfig;
import config.TaskConfig;

/**
 * @author xiaxingzzz
 * 验证什么情况下config不能使用构造方法 TODO
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Import({ ProcessConfig.class, TaskConfig.class })
//@ComponentScan(basePackages = {"demo"} )
public class SpringbootAnnotationLearningApplicationTests {

//	@Configuration
//	static class TestConfig {
//		public TestConfig() {
//			System.out.println("init test config");
//		}
//		
//	}
	
	@Component
	static class TestInit {
		//auto
		
		//postconstruct
		// modify auto
		
	}
	
	
	@Test
	public void contextLoads() {
	}
	
	

}
