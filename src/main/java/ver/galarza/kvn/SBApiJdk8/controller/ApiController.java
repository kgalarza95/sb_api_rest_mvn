/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ver.galarza.kvn.SBApiJdk8.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ver.galarza.kvn.SBApiJdk8.dto.Respuesta;
import ver.galarza.kvn.SBApiJdk8.entity.SbUsuario;
import ver.galarza.kvn.SBApiJdk8.services.SBUsuarioService;

/**
 * @author kgalarza
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private SBUsuarioService usuServ;

    @GetMapping("/get_usuario/{id}")
    public Respuesta getUsuarioId(@PathVariable Long id) {
        return usuServ.findByIdUsuario(id);
    }

    @GetMapping("/get_usuarios")
    public Respuesta getTodosUsuarios() {
        return usuServ.findAll();
    }

    @RequestMapping("/get_data")
    public String metodoGet() {
        return "Hola mundo";
    }

    @PostMapping("/guardar_usuario")
    public Respuesta guardarUsuario(@RequestBody SbUsuario usu) {
        return usuServ.saveUser(usu);
    }

    @PutMapping("/update_usuario")
    public Respuesta updateUsuario(@RequestBody SbUsuario usu) {
        return usuServ.updateUser(usu);
    }

    @DeleteMapping("/eliminar_usuario/{id}")
    public Respuesta eliminarUsuarioId(@PathVariable Long id) {
        return usuServ.deleteUserId(id);
    }

    @DeleteMapping("/eliminar_usuario")
    public Respuesta eliminarUsuario() {
        return usuServ.deleteUserId(Long.valueOf(12));
    }

}
