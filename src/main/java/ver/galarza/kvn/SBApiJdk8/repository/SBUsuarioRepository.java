/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ver.galarza.kvn.SBApiJdk8.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ver.galarza.kvn.SBApiJdk8.entity.SbUsuario;

/**
 *
 * @author kgalarza
 */
@Repository
public interface SBUsuarioRepository extends JpaRepository<SbUsuario, Long> {

    Optional<SbUsuario> findByUsuarioAndPass(String usuario, String pass);
}
