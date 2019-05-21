/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Udec.proyectoFinal.clase;

/**
 * clase que contiene los atributos de los mensajes
 * @author David
 */
public class ErrorMsg {
    /**
     * atributo que contiene el mensaje de error
     */
    private String errormsg;
    /**
     * constructor de la clase que inicializa las variables
     * @param errormsg 
     */
    public ErrorMsg(String errormsg) {
        this.errormsg = errormsg;
    }
    /***
     * constructor de la clase
     */
    public ErrorMsg() {
    }
    /**
     * retorna el mensaje de eror
     * @return errormsg
     */
    public String getErrormsg() {
        return errormsg;
    }
    /**
     * modifica el mensaje de error
     * @param errormsg 
     */
    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }
}
