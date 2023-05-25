/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ver.galarza.kvn.SBApiJdk8.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ver.galarza.kvn.SBApiJdk8.security.JWTAuthorizationFilter;

/**
 *
 * @author kgalarza
 */
public class WebSecurityConfig {

//@EnableWebSecurity
//@Configuration
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    //ojo con el acceso a las seguridades
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http.csrf().disable()
////                .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
////                .authorizeRequests()
////                .antMatchers(HttpMethod.POST, "/user").permitAll()
////                .anyRequest().authenticated();
//
//        /*httpBasic() habilita la autenticación HTTP básica y 
//        formLogin().disable() deshabilita la autenticación basada en formularios. 
//        El método csrf().disable() desactiva la protección CSRF, lo cual es opcional pero puede ser necesario dependiendo de tu aplicación.*/
//        //en caso de emergencia
//        http
//                .httpBasic()
//                .and()
//                .formLogin()
//                .disable()
//                .csrf()
//                .disable();
//    }
}
