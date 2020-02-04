-- springboot核心注解学习笔记

1.@SpringBootApplication*
Spring Boot的项目一般都会有*Application的入口类，入口类中会有main方法，这是一个标准的Java应用程序的入口方法。
@SpringBootApplication注解是Spring Boot的核心注解，它其实是一个组合注解， 源码如下：
@SpringBootConfiguration：表示Application作为配置文件存在
@EnableAutoConfiguration：表示启用SpringBoot内置的自动配置功能
@ComponentScan : 扫描bean，路径为Application类所在package以及package下的子路径，在spring boot中bean都放置在该路径以及子路径下。

2.@RestController
@RestController 和 @ RequestMapping 是 SpringMVC 的注解，不是 SpringBoot 特有的
@RestController = @Controller +@ResponseBody
@Controller 处理 HTTP 请求

3.@GetMapping 
@GetMapping 组合注解 相当于 @RequestMapping(method = RequestMethod.GET)
@PostMapping 组合注解 相当于 @RequestMapping(method = RequestMethod.POST)

4.@ExceptionHandler
@ExceptionHandler(value = Exception.class) 捕获异常 （用于统一异常处理）

5.@Configuration
 这是 Spring 3.0 添加的一个注解，用来代替 applicationContext.xml 配置文件，所有这个配置文件里面能做到的事情都可以通过这个注解所在类来进行完成。

6.@Conditional
Spring 4.0添加的一个注解，用来标识一个Spring Bean或者Configuration配置文件，当满足指定条件才开启配置

7.@ConditionalOnBean
组合@Conditional注解，当容器中有指定Bean才开启配置。

8.@ConditionalOnMissingBean
组合@Conditional注解，当容器中没有值当Bean才可开启配置。

9.@ConditionalOnClass
组合@Conditional注解，当容器中有指定Class才可开启配置。

10.@ConditionalOnMissingClass
组合@Conditional注解，当容器中没有指定Class才可开启配置。

11.@ConditionOnWebApplication
组合@Conditional注解，当前项目类型是WEB项目才可开启配置。
项目有以下三种类型：
① ANY：任意一个Web项目
② SERVLET： Servlet的Web项目
③ REACTIVE ：基于reactive-base的Web项目

12. @ConditionOnNotWebApplication
组合@Conditional注解，当前项目类型不是WEB项目才可开启配置。

13.@ConditionalOnProperty
组合@Conditional注解，当指定的属性有指定的值时才可开启配置。

14.@ConditionalOnExpression
组合@Conditional注解，当SpEl表达式为true时才可开启配置。

15.@ConditionOnJava
组合@Conditional注解，当运行的Java JVM在指定的版本范围时才开启配置。

16.@ConditionalResource
组合@Conditional注解，当类路径下有指定的资源才开启配置。

17.@ConditionOnJndi
组合@Conditional注解，当指定的JNDI存在时才开启配置。

18.@ConditionalOnCloudPlatform
组合@Conditional注解，当指定的云平台激活时才可开启配置。

19.@ConditiomalOnSingleCandidate
组合@Conditional注解，当制定的Class在容器中只有一个Bean，或者同时有多个但为首选时才开启配置。

20.@ConfigurationProperties
用来加载额外的配置(如.properties文件)，可用在@Configuration注解类或者@Bean注解方法上面。可看一看Spring Boot读取配置文件的几种方式。

21.@EnableConfigurationProperties
一般要配合@ConfigurationProperties注解使用，用来开启@ConfigurationProperties注解配置Bean的支持。

22.@AntoConfigureAfter
用在自动配置类上面，便是该自动配置类需要在另外指定的自动配置类配置完之后。如Mybatis的自动配置类，需要在数据源自动配置类之后。

23.@AutoConfigureBefore
用在自动配置类上面，便是该自动配置类需要在另外指定的自动配置类配置完之前。

24.@Import
Spring 3.0添加注解，用来导入一个或者多个@Configuration注解修饰的配置类。

25.@IMportReSource
Spring 3.0添加注解，用来导入一个或者多个Spring配置文件，这对Spring Boot兼容老项目非常有用，一位内有些配置文件无法通过java config的形式来配置
