package ver.galarza.kvn.SBApiJdk8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ver.galarza.kvn.SBApiJdk8.security.JWTAuthorizationFilter;

@SpringBootApplication
public class SbApiJdk8Application {

    public static void main(String[] args) {
        SpringApplication.run(SbApiJdk8Application.class, args);
    }

    @EnableWebSecurity
    @Configuration
    class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
//            http.csrf().disable()
//                    .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
//                    .authorizeRequests()
//                    .antMatchers(HttpMethod.POST, "/SBApiJdk8-0.1/login/**").permitAll()
//                    .antMatchers(HttpMethod.GET, "/SBApiJdk8-0.1/login/**").permitAll()
//                    .anyRequest().authenticated();

//            http.csrf().disable()
//                    .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
//                    .authorizeRequests()
//                    .antMatchers("/login/**").permitAll()
//                    .antMatchers("/SBApiJdk8-0.1/login/**").permitAll()
//                    .antMatchers("/**").permitAll()
//                    //                    .antMatchers(HttpMethod.POST, "/login").permitAll()
//                    //                    .antMatchers(HttpMethod.POST, "/SBApiJdk8-0.1/login/**").permitAll()
//                    //                    .antMatchers(HttpMethod.POST, "/SBApiJdk8-0.1/login").permitAll()
//
//                    .anyRequest().authenticated();
            //full acceso 
//            http.csrf().disable()
//                    .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
//                    .authorizeRequests()
//                    .anyRequest().permitAll(); // Permitir acceso a cualquier ruta sin autenticación

            http
                    .csrf().disable() // Deshabilitar CSRF ya que no estás utilizando formularios
                    .authorizeRequests()
                    .antMatchers("/login/**").permitAll() // Rutas públicas
                    .antMatchers("/login").permitAll() // Rutas públicas
                    .anyRequest().authenticated() // Resto de las rutas requieren autenticación
                    .and()
                    .addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        }
    }

}
