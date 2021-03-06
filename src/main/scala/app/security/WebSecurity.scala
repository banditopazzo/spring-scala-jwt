package app.security

import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.{EnableWebSecurity, WebSecurityConfigurerAdapter}
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

import SecurityConstants._

@EnableWebSecurity
class WebSecurity(
                   userDetailsService: UserDetailsService,
                   bCryptPasswordEncoder: BCryptPasswordEncoder
                 ) extends WebSecurityConfigurerAdapter {

  @throws(classOf[Exception])
  override def configure(http: HttpSecurity): Unit = {
    http.csrf().disable().authorizeRequests()
          .antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()
          .anyRequest().authenticated()
          .and()
          .addFilter(JWTAuthenticationFilter(authenticationManager(), LOGIN_URL))
          .addFilter(new JWTAuthorizationFilter(authenticationManager()))
  }


  @throws(classOf[Exception])
  override def configure(auth: AuthenticationManagerBuilder): Unit = {
    auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder)
  }

}
