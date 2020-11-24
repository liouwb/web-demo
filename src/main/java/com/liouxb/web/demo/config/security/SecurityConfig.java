package com.liouxb.web.demo.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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
    private CustomAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private CustomAuthenticationFailureHandler failureHandler;
    @Autowired
    private CustomAuthenticationSuccessHandler successHandler;
    @Autowired
    private CustomAccessDeniedHandler accessDeniedHandler;
    @Autowired
    private CustomLogoutSuccessHandler logoutSuccessHandler;
    @Autowired
    private JwtAuthenticationTokenFilter tokenFilter;


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

                // 不需要权限就可以访问
                .antMatchers("/login/doLogin")
                .permitAll()

                // login/** 路径，需要拥有admin权限才可以访问
//                .antMatchers("/login/**")
//                .hasRole("ADMIN")

                .antMatchers("/test/**")
                .permitAll()
//                .access("hasAnyRole('ADMIN','DB')")

                // 表示除了前面定义的url,后面的都得认证（登录）后访问
                .anyRequest()
                .authenticated()
                .and()

                // 开启表单登录
                .formLogin()
                // 登录成功处理
                .successHandler(successHandler)
                // 登录失败处理
                .failureHandler(failureHandler)
                .permitAll()
                .and()

                // 未登录处理
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .and()

                .logout()
                .logoutSuccessHandler(logoutSuccessHandler)
                .permitAll()
                .and()

                // 关闭CSRF跨站伪造请求
                .csrf()
                .disable()
                // 关闭session
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                // 添加JWT过滤器 除已配置的其它请求都需经过此过滤器
                .and()
                .addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);
    }


    /**
     * 静态资源不拦截
     *
     * @param web
     */
    @Override
    public void configure(WebSecurity web) {
        // 设置拦截忽略文件夹，可以对静态资源放行
        web.ignoring().antMatchers("/v2/api-docs",
                "/swagger-resources/configuration/ui",
                "/webjars/**",
                "/swagger-resources",
                "/swagger-resources/configuration/security",
                "/swagger-ui.html",
                "/doc.html"
        );
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
