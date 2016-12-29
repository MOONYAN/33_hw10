package course.java.spring.data.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{	
	@Autowired
	DataSource dataSource;
	
	@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
    	.usersByUsernameQuery(
			"select USERNAME, PASSWORD, 'true' as enabled "
			+ " from [USER]"
			+ " where USERNAME=?")
		.authoritiesByUsernameQuery(
			"select USERNAME, ROLE"
			+ " from [USER] "
			+ "where USERNAME=?")
		.rolePrefix("ROLE_");
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http
	    	.authorizeRequests()
	    		.antMatchers("/").permitAll()
	    		.antMatchers("/regist").anonymous()
	    		.antMatchers("/login").permitAll()
		        .anyRequest().permitAll()
		        .and()
		        .formLogin()
		        .loginPage("/login").permitAll()
		        .defaultSuccessUrl("/iMovie")
		        .failureUrl("/loginError")
		        .and()
		   .exceptionHandling().accessDeniedPage("/accessError");
		        
		http.logout()
			.logoutUrl("/logout")
			.deleteCookies("JSESSIONID")
			.logoutSuccessUrl("/");
	}
}