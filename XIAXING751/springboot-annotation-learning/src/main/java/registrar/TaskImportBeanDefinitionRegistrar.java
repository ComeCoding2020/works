package registrar;

import java.util.Map;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.core.type.filter.TypeFilter;

import demo.service.Process1Service;

/**
 * @author xiaxingzzz
 * ImportBeanDefinitionRegistrar类只能通过其他类@Import的方式来加载，通常是启动类或配置类
 * 与config和selector最大的不同在于，它可以用于扫描class
 *
 */
public class TaskImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		//扫描注解
        Map<String, Object> annotationAttributes = importingClassMetadata
            .getAnnotationAttributes(ComponentScan.class.getName());
        String[] basePackages = (String[]) annotationAttributes.get("basePackages");

        //扫描类
        ClassPathBeanDefinitionScanner scanner =
                new ClassPathBeanDefinitionScanner(registry, false);
        TypeFilter helloServiceFilter = new AssignableTypeFilter(Process1Service.class);
        
        scanner.addIncludeFilter(helloServiceFilter);
        scanner.scan(basePackages);
		
	}

}
