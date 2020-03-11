package com.bolsadeideas.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception {
        PasswordEncoder encoder = passwordEncoder();
        User.UserBuilder userBuilder = User.builder().passwordEncoder(encoder::encode);
        builder.inMemoryAuthentication().withUser(userBuilder.username("admin").password("1234").roles("ADMIN", "USER"))
                .withUser(userBuilder.username("agustin").password("1111").roles("USER"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/css/**", "/js/**", "/images/**", "/listar").permitAll().
                antMatchers("/ver/**", "/uploads/**").hasAnyRole("USER").
                antMatchers("/form/**", "/eliminar/**", "/factura/**").hasAnyRole("ADMIN").anyRequest().authenticated().
                and().formLogin().loginPage("/login").permitAll().and().logout().permitAll();

    }
}
