/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ver.galarza.kvn.SBApiJdk8;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * si accesible desde servidor
 *
 * @author kgalarza
 */
@RestController
@RequestMapping("/init")
public class Ctr {

    @RequestMapping("/data")
    public String metodoGet() {
        return "Hola mundo desde misma ubicacion";
    }
}
