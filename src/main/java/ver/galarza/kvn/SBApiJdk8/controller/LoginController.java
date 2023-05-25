/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ver.galarza.kvn.SBApiJdk8.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ver.galarza.kvn.SBApiJdk8.dto.Respuesta;
import ver.galarza.kvn.SBApiJdk8.dto.User;
import ver.galarza.kvn.SBApiJdk8.services.SBUsuarioService;

/**
 *
 * @author kgalarza
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private SBUsuarioService usuServ;

    @PostMapping
    public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
        User user = new User();
        Respuesta respuesta = usuServ.buscarUsuario(username, pwd);

        if (respuesta.getIsExito()) {
            user.setCod(respuesta.getCodRespuesta());
            user.setSms(respuesta.getMsjRespuesta());
            String token = getJWTToken(username);
            user.setUser(username);
            user.setToken(token);
        } else {
            user.setCod(respuesta.getCodRespuesta());
            user.setSms(respuesta.getMsjRespuesta());
            user.setUser(username);
        }

        return user;
    }

    @GetMapping
    public User loginGet(@RequestParam("user") String username, @RequestParam("password") String pwd) {

        String token = getJWTToken(username);
        User user = new User();
        user.setUser(username);
        user.setToken(token);
        return user;
    }

    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
