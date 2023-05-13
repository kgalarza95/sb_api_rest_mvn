/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ver.galarza.kvn.SBApiJdk8.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ver.galarza.kvn.SBApiJdk8.dto.Respuesta;
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

    public Respuesta findByIdUsuario(Long id) {
        Respuesta respuesta = new Respuesta();
        if (id != null) {
            Optional<SbUsuario> opUsuario = usRepo.findById(id);
            if (opUsuario.isPresent()) {
                respuesta.setCodRespuesta("00");
                respuesta.setMsjRespuesta("ÉXITO! REGISTRO EXISTENTE");
                respuesta.setDatos(opUsuario.get());
            } else {
                respuesta.setCodRespuesta("22");
                respuesta.setMsjRespuesta("ALERTA! REGISTRO NO EXISTE");
            }
        } else {
            respuesta.setCodRespuesta("22");
            respuesta.setMsjRespuesta("ALERTA! DEBE ENVIAR EL ID DEL REGISTRO");
        }
        return respuesta;
    }

    public Respuesta findAll() {
        Respuesta respuesta = new Respuesta();
        List<SbUsuario> list = usRepo.findAll();
        if (!list.isEmpty()) {
            respuesta.setCodRespuesta("00");
            respuesta.setMsjRespuesta("ÉXITO! REGISTROS EXISTENTES");
            respuesta.setDatos(list);
        } else {
            respuesta.setCodRespuesta("22");
            respuesta.setMsjRespuesta("ALERTA! NO HAY REGISTROS");
        }
        return respuesta;
    }

    public String saveUser(SbUsuario user) {
        String respuesta;
        SbUsuario result = usRepo.save(user);
        System.out.println("==================================================");
        System.out.println("Guardar Usuario");
        Optional<SbUsuario> userOp = Optional.ofNullable(result);
        SbUsuario userRet = null;
        if (userOp.isPresent()) {
            respuesta = "Transacción Ok.";
        } else {
            throw new RuntimeException("No se pudo encontrar al maestro con el ID: " + user);
        }
        return respuesta;
    }

    public Respuesta updateUser(SbUsuario userUp) {
        Respuesta respuesta = new Respuesta();
        if (userUp != null) {
            respuesta = findByIdUsuario(userUp.getId());
            if (respuesta.getIsExito()) {
                SbUsuario result = usRepo.save(userUp);
            }
        } else {
            respuesta.setCodRespuesta("22");
            respuesta.setMsjRespuesta("ALERTA! DEBE ENVIAR LOS DATOS A ACTUALIZAR");
        }
        return respuesta;
    }

    public Respuesta deleteUserId(Long id) {
        Respuesta respuesta = new Respuesta();
        if (id != null) {
            respuesta = findByIdUsuario(id);
            if (respuesta.getIsExito()) {
                respuesta.setCodRespuesta("00");
                usRepo.deleteById(id);
            }
        } else {
            respuesta.setCodRespuesta("22");
            respuesta.setMsjRespuesta("ALERTA! DEBE ENVIAR EL ID DLE REGISTRO");
        }
        return respuesta;
    }
}
