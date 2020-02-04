# Spring Boot 注解

## Spring 模式注解装配 

### 模式注解
```
模式注解是一种用于声明在应用中扮演“组件”角色的注解。如 Spring Framework 中的 @Repository 标注在任何类上 ，用
于扮演仓储角色的模式注解。
```

```
@Component 作为一种由 Spring 容器托管的通用模式组件，任何被 @Component 标准的组件均为组件扫描的候选对象。类
似地，凡是被 @Component 元标注（meta-annotated）的注解，如 @Service ，当任何组件标注它时，也被视作组件扫
描的候选对象
```

|Spring Framework注解     | 场景说明        |     起始版本|
|--------------------     | ----------------|      ----- |
|@Repository             |数据仓储模式注解           |2.0|
|@Component              |通用组件模式注解           |2.5|
|@Service                |服务模式注解               |2.5|
|@Controller             |Web控制器模式注解          |2.5|
|@Configuration          |配置类模式注解             |3.0|



Spring Boot 自动装配
---
在 Spring Boot 场景下，基于约定大于配置的原则，实现 Spring 组件自动装配的目的。其中使用了底层装配技术
- Spring 模式注解装配
- Spring @Enable 模块装配
- Spring 条件装配装配
- Spring 工厂加载机制
实现类： SpringFactoriesLoader
配置资源： META-INF/spring.factories

---

自动装配举例
---
参考 META-INF/spring.factories
* @return the class names that must be present.
*/
String[] name() default {};
}
实现方法
1. 激活自动装配 - @EnableAutoConfiguration
2. 实现自动装配 - XXXAutoConfiguration
3. 配置自动装配实现 - META-INF/spring.factories


自定义自动装配
HelloWorldAutoConfiguration
- 条件判断： user.name == "Mercy"
- 模式注解： @Configuration

```
@Enable 模块： @EnableHelloWorld -> HelloWorldImportSelector -> HelloWorldConfiguration - > helloWorld
```



