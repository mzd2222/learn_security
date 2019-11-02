package security.Config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);

        //定制请求授权规则
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");

        //开启登录功能 没有权限就会自动进入自动生成的登陆页面
        http.formLogin().loginPage("/userlogin");
        //默认发post就为登录

        //开启自动注销
        //访问/logout  注销成功返回 /login?logout 页面
        //logoutSuccessUrl()注销成功之后的地址
        http.logout().logoutSuccessUrl("/");

        //开启记住我功能，下次无需登录
        //登录成功之后创建一个15天的cookie
        http.rememberMe().rememberMeParameter("reme");
    }


    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder();
        String password = passwordEncoder.encode("123456");

        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder)
                .withUser("asd1").password(password).roles("VIP1","VIP2")
                .and()
                .withUser("asd2").password(password).roles("VIP3");
    }
}
