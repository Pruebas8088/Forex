/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Udec.proyectoFinal.clase;

/**
 *clase que contiene los atributos de una divisa
 * @author David
 */
public class Divisa {
    /**
     * atributo que contiene el token del usuario
     */
    private String token;
    /**
     * atributo que contiene el valor inicial de la divisa
     */
    private float valorInicial;
    /**
     * atributo que contine el valor final de la divisa
     */
    private float valorFinal;
    /**
     * atributo que contiene la cantidad de dinero invertida en la divisa
     */
    private float cantidad;
    /**
     * atributo que contiene el identificador de la operacion
     */
    private int idOperacion;
    /**
     * aributo que contiene le beneficio obtenido por la divisa
     */
    private float beneficio;
    /**
     * atributo que contiene el nombre de la divisa
     */
    private String divisa;
    /**
     * atributo que contiene el correo del usuario que opera la divisa
     */
    private String correo;
    /**
     * constructor de la clase
     */
    public Divisa() {
    }//constructor
    /**
     * constructor de la clase que inicializa las variables
     * @param token atributo que contiene el token del usuario
     * @param valorInicial atributo que contiene el valir incial de la divisa
     * @param valorFinal atributo que contiene el valor final de la divisa
     * @param cantidad atribut que contiene la cantidad de dinero invertido en la divisa
     * @param idOperacion atributo que contiene el identificador de la operacion
     * @param beneficio atributo que contiene el beneficio obtenido por la divisa
     * @param divisa  parametro que contine el nombre de la divisa
     */
    public Divisa(String token, float valorInicial, float valorFinal, float cantidad, int idOperacion, float beneficio, String divisa) {
        this.token = token;
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
        this.cantidad = cantidad;
        this.idOperacion = idOperacion;
        this.beneficio = beneficio;
        this.divisa = divisa;
    }//constructor
    /**
     * retorna el valor del toke
     * @return token
     */
    public String getToken() {
        return token;
    }//getToken
    /**
     * modifica el valor del token
     * @param token 
     */
    public void setToken(String token) {
        this.token = token;
    }//setToken
    /**
     * retorna el valor del valorInicial
     * @return  valorInicial
     */
    public float getValorInicial() {
        return valorInicial;
    }//getValorInicial
    /**
     * modifica el valor inicial
     * @param valorInicial 
     */
    public void setValorInicial(float valorInicial) {
        this.valorInicial = valorInicial;
    }//setVlorIncial
    /**
     * retorna el valor de valorFinal
     * @return valorFinal
     */
    public float getValorFinal() {
        return valorFinal;
    }//getValorFinal
    /**
     * modifica el valor del valorFinal
     * @param valorFinal 
     */
    public void setValorFinal(float valorFinal) {
        this.valorFinal = valorFinal;
    }//setValorFinal
    /**
     * retorna el valor de la cantidad
     * @return cantidad
     */
    public float getCantidad() {
        return cantidad;
    }//getCantidad
    /**
     * modifica la cantidad de dinero
     * @param cantidad 
     */
    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }//setCantidad
    /**
     * retorna el id de la operacion
     * @return getIdOperacion
     */
    public int getIdOperacion() {
        return idOperacion;
    }//getIdOperacion
    /**
     * modifica el idOperacion
     * @param idOperacion 
     */
    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }//setIdOperacion
    /**
     * retorna el beneficio de la divisa
     * @return beneficio
     */
    public float getBeneficio() {
        return beneficio;
    }//getBeneficio
    /**
     * modifica el beneficio de la divisa
     * @param beneficio 
     */
    public void setBeneficio(float beneficio) {
        this.beneficio = beneficio;
    }//setBeneficio
    /**
     * retorna el nombre de la divisa
     * @return divisa
     */
    public String getDivisa() {
        return divisa;
    }//getDivisa
    /**
     * modifica el nombre de la divisa
     * @param divisa 
     */
    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }//setDivisa
    /**
     * retorna el correo
     * @return correo
     */
    public String getCorreo() {
        return correo;
    }//getCorreo
    /**
     * modifica el correo
     * @param correo 
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }//setCorreo    
}//Divisa
