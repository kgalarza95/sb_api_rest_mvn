/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ver.galarza.kvn.SBApiJdk8.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ver.galarza.kvn.SBApiJdk8.entity.SbUsuario;
import ver.galarza.kvn.SBApiJdk8.services.SBUsuarioService;

/**
 * @author kgalarza
 */
@RestController
@RequestMapping("/principal")
public class ControllerPrincipal {

    @Autowired
    private SBUsuarioService usuServ;

    @GetMapping("/get_usuarios")
    public List<SbUsuario> getTodosUsuarios() {
        return usuServ.findAll();
    }

    @RequestMapping("/get_data")
    public String metodoGet() {
        return "Hola mundo";
    }
}
