package security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1.引入spring security模块
 * 2.编写spring-security的配置，，，配置类
 *   @EnableWebSecurity  public class SecurityConfig extends WebSecurityConfigurerAdapter配置类
 * 3.控制请求的访问权限
 * 4.thymeleaf配置spring security 只能是pom依赖为 thymeleaf-extras-springsecurity5
 *                                 html头部依赖为 xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4">
 *                   pom内4和5两个都导入，4用于补全，5用于使用
 *                          <dependency>
                 *             <groupId>org.thymeleaf.extras</groupId>
                 *             <artifactId>thymeleaf-extras-springsecurity4</artifactId>
                 *             <version>3.0.4.RELEASE</version>
                 *         </dependency>
 *
 */


@SpringBootApplication
public class LearnSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnSecurityApplication.class, args);
    }

}
