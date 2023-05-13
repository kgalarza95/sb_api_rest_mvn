/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ver.galarza.kvn.SBApiJdk8.dto;

/**
 *
 * @author kgalarza
 */
public class Respuesta {

    private String codRespuesta;
    private String msjRespuesta;
    private Object datos;
    private boolean isExito;

    public boolean getIsExito() {
        return codRespuesta.equals("00");
    }

    public String getCodRespuesta() {
        return codRespuesta;
    }

    public void setCodRespuesta(String codRespuesta) {
        this.codRespuesta = codRespuesta;
    }

    public String getMsjRespuesta() {
        return msjRespuesta;
    }

    public void setMsjRespuesta(String msjRespuesta) {
        this.msjRespuesta = msjRespuesta;
    }

    public Object getDatos() {
        return datos;
    }

    public void setDatos(Object datos) {
        this.datos = datos;
    }

}
