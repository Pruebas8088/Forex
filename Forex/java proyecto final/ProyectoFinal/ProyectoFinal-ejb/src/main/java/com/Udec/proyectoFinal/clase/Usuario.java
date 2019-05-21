/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Udec.proyectoFinal.clase;

/**
 *clase que contiene los atributos del usuario
 * @author Jonathan
 */
public class Usuario {
    /**
     * atributo que contiene el nombre del usuario
     */
    private String nombre;
    /**
     * atributo que contiene el apellido del usuario
     */
    private String apellido;
    /**
     * atributo que contiene el correo del usuario
     */
    private String email;
    /**
     * atributo que contiene la contarseña de la contraseña
     */
    private String pass;
    /**
     * atributo que contiene el token del usuario
     */
    private String token;
    /**
     * atributo que contiene el dinero del usuario
     */
    private float dinero;
    /**
     * constructor de la clase
     */
    public Usuario() {
    }
    /**
     * constructor de la clase que incializa las variables
     * @param nombre
     * @param apellido
     * @param email
     * @param pass
     * @param token
     * @param dinero 
     */
    public Usuario(String nombre, String apellido, String email, String pass, String token,float dinero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.pass = pass;
        this.token = token;
        this.dinero = dinero;
    }
    /**
     * retorna el valor del dinero
     * @return dinero
     */
    public float getDinero() {
        return dinero;
    }
    /**
     * modifica el dinero
     * @param dinero 
     */
    public void setDinero(float dinero) {
        this.dinero = dinero;
    }
    /**
     * retorna el nombre del usuario
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * modifica el nombr del usuario
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * retorna el apellido dle usuario
     * @return apellido
     */
    public String getApellido() {
        return apellido;
    }
    /**
     * modifica el apellido del usuario
     * @param apellido 
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    /**
     * retorna el correo del usuario
     * @return email
     */
    public String getEmail() {
        return email;
    }
    /**
     * modifica el correo 
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * retorna la contraseña 
     * @return pass
     */
    public String getPass() {
        return pass;
    }
    /**
     * modifica la contraseña
     * @param pass 
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
    /**
     * retorna el token del usuario
     * @return token
     */
    public String getToken() {
        return token;
    }
    /**
     * modifica el token del usuario
     * @param token 
     */
    public void setToken(String token) {
        this.token = token;
    }
    
    
    
}
