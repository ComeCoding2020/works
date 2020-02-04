package work_0204.configuration;

import org.springframework.context.annotation.Configuration;
import work_0204.annotation.EnableHelloWorld;
import work_0204.condition.ConditionalOnSystemProperty;

@Configuration // Spring 模式注解装配
@EnableHelloWorld // Spring @Enable 模块装配
@ConditionalOnSystemProperty(name = "user.name", value = "Mercy") // 条件装配
public class HelloWorldAutoConfiguration {
}