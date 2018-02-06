package xyz.sydns.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import xyz.sydns.repository.MeUserRepository;

import javax.annotation.Resource;

/**
 * @author sqsgalaxys
 */
@Configuration
public class MeWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Resource
    private MeUserRepository meUserRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").access("hasRole('ONE')")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true");
    }

    @Override
    protected void configure(
            AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(username -> {
                    UserDetails userDetails = meUserRepository.findByMeName(username);
                    if (userDetails != null) {
                        return userDetails;
                    }
                    throw new UsernameNotFoundException("User '" + username + "' not found.");
                });
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //解决静态资源被拦截的问题
        web.ignoring().antMatchers("/static/**");
        web.ignoring().antMatchers("/public/**");
    }

}

