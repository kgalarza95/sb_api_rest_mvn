
package ver.galarza.kvn.SBApiJdk8.controller;


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
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private SBUsuarioService usuServ;

    @GetMapping("/{id}")
    public Respuesta getUsuarioId(@PathVariable Long id) {
        return usuServ.findByIdUsuario(id);
    }

    @GetMapping
    public Respuesta getTodosUsuarios() {
        return usuServ.findAll();
    }


    @PostMapping
    public Respuesta guardarUsuario(@RequestBody SbUsuario usu) {
        return usuServ.saveUser(usu);
    }

    @PutMapping
    public Respuesta updateUsuario(@RequestBody SbUsuario usu) {
        return usuServ.updateUser(usu);
    }

    @DeleteMapping("/{id}")
    public Respuesta eliminarUsuarioId(@PathVariable Long id) {
        return usuServ.deleteUserId(id);
    }

}
