package demo.ipt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import config.ProcessConfig;
import config.TaskConfig;

/**
 * @author xiaxingzzz
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Import({ ProcessConfig.class, TaskConfig.class })
public class ImportResourcesTests {
	@Test
	public void contextLoads() {
	}
}
