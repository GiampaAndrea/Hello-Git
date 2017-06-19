package it.uniroma3.siw.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.provisioning.InMemoryUserDetailsManager;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
   
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
        .authorizeRequests().antMatchers("/index").permitAll()
            .antMatchers("/profiloAmministratore","inserisciAutore","inserisciOpera").hasAuthority("ROLE_ADMIN")
            .and()
        .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/profiloAmministratore", true)
            .permitAll()
            .and()
        .logout()
           .permitAll();
        http.exceptionHandling().accessDeniedPage("/403");
    }
    @Bean
    public UserDetailsService adminDetailsService() {
    	InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    	manager.createUser(User.withUsername("admin").password("pass").roles("USER","ADMIN").build());
    	return manager;
    	
    }
}