/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ver.galarza.kvn.SBApiJdk8.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ver.galarza.kvn.SBApiJdk8.entity.SbUsuario;
import ver.galarza.kvn.SBApiJdk8.repository.SBUsuarioRepository;

/**
 *
 * @author kgalarza
 */
@Service
public class SBUsuarioService {

    @Autowired
    private SBUsuarioRepository usRepo;

    public List<SbUsuario> findAll() {
        return usRepo.findAll();
    }
}
