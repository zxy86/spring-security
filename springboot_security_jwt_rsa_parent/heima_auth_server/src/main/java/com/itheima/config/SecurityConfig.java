package com.itheima.config;

import com.itheima.filter.JwtTokenFilter;
import com.itheima.filter.JwtVerifyFilter;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Classname SecurityConfig
 * @Date 2021/7/16 13:14
 * @Created by GAEA
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private RsaKeyProperties prop;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //认证用户的来源(内存或数据库)
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password("{noop}123")
//                .roles("USER");
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    //配置spring security相关信息
    @Override
    public void configure(HttpSecurity http) throws Exception {
        //释放静态资源，指定资源拦截规则，指定自定义认证页面，指定退出认证配置，csrf配置
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/product").hasAnyRole("USER")
                .anyRequest()
                .authenticated()
                .and()
                .addFilter(new JwtTokenFilter(super.authenticationManager(), prop))
                .addFilter(new JwtVerifyFilter(super.authenticationManager(), prop))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
