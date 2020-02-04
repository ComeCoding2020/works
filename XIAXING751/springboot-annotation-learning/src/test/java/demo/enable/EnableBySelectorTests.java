package demo.enable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
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
public class EnableBySelectorTests {

	@Test
	public void contextLoads() {
	}

}
