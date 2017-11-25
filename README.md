### 项目搭建步骤
1. 使用spring initializr向导，选择web、DevTools模块
2. 运行目录src/main/java下的SpringBootSimpleRestApplication，访问http://localhost:8080/

### SpringBoot项目在IntelliJ IDEA中实现热部署
##### 要配置的内容：  
1.commnad + SHIFT + A --> 查找make project automatically --> 选中  
2.command + SHIFT + A --> 查找Registry --> 找到并勾选compiler.automake.allow.when.app.running  
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
        <addResources>true</addResources><!--支持静态文件热部署-->
    </configuration>
</plugin>
```
5.Chrome禁用缓存：NetWork --> Disable Cache(while DevTools is open)