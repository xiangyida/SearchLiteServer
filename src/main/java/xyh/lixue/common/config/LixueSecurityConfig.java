package xyh.lixue.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class LixueSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String MATCHERS_ADMIN = "/login";
    private static final String USERNAME = "xiangyida";
    private static final String PASSWORD = "{noop}123456";
    private static final String ROLE_ADMIN = "ADMIN";
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(MATCHERS_ADMIN).hasRole(ROLE_ADMIN)
                .and()
                .formLogin().and()
                .httpBasic();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser(USERNAME)
                .password(PASSWORD)
                .roles(ROLE_ADMIN);

    }

}
