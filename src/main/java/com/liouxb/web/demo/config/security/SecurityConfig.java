package com.liouxb.web.demo.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * spring-security配置
 *
 * @author liouwb
 */
@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserDetailsService userDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(new PasswordEncoder() {
                    @Override
                    public String encode(CharSequence charSequence) {
                        return charSequence.toString();
                    }

                    @Override
                    public boolean matches(CharSequence charSequence, String s) {
                        return s.equals(charSequence.toString());
                    }
                });
    }

    /**
     * 路径访问权限
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 请求验证规则
        http.authorizeRequests()

                // login/** 路径，需要拥有admin权限才可以访问
                .antMatchers("/login/**")
                .hasRole("ADMIN")

//                .antMatchers("/test/**")
//                .access("hasAnyRole('ADMIN','DB')")

                // 不需要权限就可以访问
                .antMatchers("/login/success")
                .permitAll()

                // 表示除了前面定义的url,后面的都得认证（登录）后访问
                .anyRequest()
                .authenticated()
                .and()

                // 表单登录
                .formLogin()
                // 登录页
//                .loginPage("/index")
                // 登录表单处理请求
                .loginProcessingUrl("/login")
                // 登录成功页
                .loginProcessingUrl("/success")
                .permitAll()
                .and()

                .logout()
                .permitAll()
                .and()

                // 关闭CSRF跨站伪造请求
                .csrf()
                .disable();
    }


    /**
     * 静态资源不拦截
     *
     * @param web
     */
    @Override
    public void configure(WebSecurity web) {
        // 设置拦截忽略文件夹，可以对静态资源放行
        web.ignoring().antMatchers("/css/**", "/js/**");
    }
}
