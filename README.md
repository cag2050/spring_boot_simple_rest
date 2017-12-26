### 项目搭建步骤
1. 使用spring initializr向导，选择web、DevTools模块
2. 运行目录src/main/java下的SpringBootSimpleRestApplication，访问http://localhost:8080/

### SpringBoot项目在IntelliJ IDEA中实现热部署
##### 要配置的内容：  
1.commnad + SHIFT + A --> 查找：make project automatically --> 选中  
2.command + SHIFT + A --> 查找Registry --> 找到并勾选：compiler.automake.allow.when.app.running  
3.pom.xml文件中加maven依赖：spring-boot-devtools 
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <!-- optional=true,依赖不会传递，该项目依赖devtools；之后依赖myboot项目的项目如果想要使用devtools，需要重新引入 -->
    <optional>true</optional>
</dependency>
``` 
4.pom.xml文件中插件spring-boot-maven-plugin，配置上  
```
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <configuration>
        <!--fork :  如果没有该项配置devtools不会起作用，即应用不会restart -->
        <fork>true</fork>
        <!--支持静态文件热部署-->
        <addResources>true</addResources>
    </configuration>
</plugin>
```
5.Chrome禁用缓存：NetWork --> Disable Cache(while DevTools is open)

### @ComponentScan
1. @SpringBootApplication，等价于以默认属性使用@Configuration，@EnableAutoConfiguration和@ComponentScan。
1. 如果启动类在根包下面，则你可以在该类上添加@ComponentScan注解而不需要添加任何参数，Spring Boot会在根包下面搜索注有@Component, @Service, @Repository, @Controller注解的所有类，并将他们注册为Spring Beans，否则，你需要在@ComponentScan注解上定义basePackages或者其他属性。