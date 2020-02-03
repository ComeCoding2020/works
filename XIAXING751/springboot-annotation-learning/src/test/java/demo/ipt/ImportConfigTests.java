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
 * 验证什么可以加载扫描路径以外的config
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Import({ ProcessConfig.class, TaskConfig.class })
public class ImportConfigTests {

	@Test
	public void contextLoads() {
	}

}
