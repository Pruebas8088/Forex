/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Udec.proyectoFinal.clase;

/**
 *
 * @author David
 */
public class Divisa {
    
    private String token;
    
    private float valorInicial;
    
    private float valorFinal;
    
    private float cantidad;
    
    private int idOperacion;
    
    private float beneficio;

    public Divisa() {
    }

    public Divisa(String token, float valorInicial, float valorFinal, float cantidad, int idOperacion, float beneficio) {
        this.token = token;
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
        this.cantidad = cantidad;
        this.idOperacion = idOperacion;
        this.beneficio = beneficio;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public float getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(float valorInicial) {
        this.valorInicial = valorInicial;
    }

    public float getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(float valorFinal) {
        this.valorFinal = valorFinal;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }

    public float getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(float beneficio) {
        this.beneficio = beneficio;
    }
    
    
    
}
