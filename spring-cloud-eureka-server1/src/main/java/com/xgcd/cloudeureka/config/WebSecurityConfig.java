package com.xgcd.cloudeureka.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();// 关闭csrf校验
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();// 开启认证
//        super.configure(http);// 需要注释,否则Caused by: java.lang.IllegalStateException: Can't configure anyRequest after itself
    }
}
