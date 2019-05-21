/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Udec.proyectoFinal.interfaces;

import com.Udec.proyectoFinal.clase.Datos;
import com.Udec.proyectoFinal.clase.Divisa;
import com.Udec.proyectoFinal.clase.ErrorMsg;
import com.Udec.proyectoFinal.clase.Usuario;
import java.util.ArrayList;
import java.util.Properties;
import javax.ejb.Stateless;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *clase que contiene funciones de usuario
 * @author Jonathan
 */
@Stateless
public class Iusuario implements IusuarioLocal {
    /**
     * funcion que agrega un usuario
     * @param user objeto que contiene los datos de usuario
     * @return er
     */
    @Override
    public ErrorMsg anadirUser(Usuario user) {
         ErrorMsg er = new ErrorMsg();
            if(user.getNombre().isEmpty() || user.getApellido().isEmpty() || user.getEmail().isEmpty() || user.getPass().isEmpty()){
               er.setErrormsg("no se aceptan campos vacios");
               return er;
            }else{
              Datos dat =  new Datos();
              dat.envio(user);
             er.setErrormsg("Registro exitoso");
               return er;
         }  
    }
    /**
     * funcion que recarga el dinero de la cuenta
     * @param user objeto que contiene los datos de usuario
     * @return dinero
     */
    @Override
    public float recargaDinero(Usuario user) {
        //enviarCorreo(user.getEmail(), user.getDinero());
        float dinero = user.getDinero();
        float dinero1 = consultarDinero(user);
        dinero = (dinero1+user.getDinero());
        user.setDinero(dinero);
        Datos dat =  new Datos();
        dat.updateDinero(user);
        dinero=user.getDinero();
        return dinero;
    }
    /**
     * funcion que consulta el dinero del usuario
     * @param user objeto que contiene los datos del usuario
     * @return dinero
     */
    @Override
    public float consultarDinero(Usuario user) {
        float dinero;
         Datos dat =  new Datos();
        
        dinero=dat.traerDinero(user);
        return dinero;
    }
    /**
     * funcion que cierra sesion
     * @param user objeto que contiene los datos del usuario
     * @return  er
     */
    @Override
    public ErrorMsg cerrarSesion(Usuario user) {
            ErrorMsg er = new ErrorMsg();
            Datos dat =  new Datos();
            dat.cerradoCuenta(user);
            er.setErrormsg("Cerrado");
            return er;
    }
    /**
     * funcion que genera la operacion con las divisas
     * @param divisa objeto que contiene los datos de la divisa a operar
     * @return er
     */
    @Override
    public ErrorMsg compraDivisa(Divisa divisa) {
            ErrorMsg er = new ErrorMsg();
            Datos dat =  new Datos();
            dat.compraDivisas(divisa);
            er.setErrormsg("Compra Exitosa, confirmacion enviada a su correo");
            return er;
    }
    /**
     * funcion que consulta las divisas activas
     * @param divisa objeto que contiene los atributos de las divisas
     * @return listaDivisa
     */
    @Override
    public ArrayList<Divisa> ConsultaDivisa(Divisa divisa) {
        ArrayList<Divisa> listaDivisa= new ArrayList<Divisa>();
           
            Datos dat =  new Datos();
            listaDivisa=dat.consultaDivisa(divisa);
           
            return listaDivisa;
    }
    /**
     * funcion que genera la operacion del beneficio qgenerado con las divisas
     * @param divisa objeto que contiene los atributos de las divisas
     * @return bene
     */
    @Override
    public float operacionBeneficio(Divisa divisa) {
        ArrayList<Divisa> listaDivisa= new ArrayList<Divisa>();
        Datos dat =  new Datos();
        float bene =0;
        listaDivisa = dat.consultaDivisa(divisa);
        for (Divisa listdivi : listaDivisa) {
             if(listdivi.getDivisa().equals(divisa.getDivisa())){
                 if(listdivi.getIdOperacion() == 1){
                     listdivi.setBeneficio((divisa.getValorFinal()-listdivi.getValorInicial())*listdivi.getCantidad());
                     Datos datupdate1 =  new Datos();
                     datupdate1.updateDivisa(listdivi);
                     bene+=listdivi.getBeneficio();
                 }else{
                     listdivi.setBeneficio((listdivi.getValorInicial()-divisa.getValorFinal())*listdivi.getCantidad());
                      Datos datupdate2 =  new Datos();
                     datupdate2.updateDivisa(listdivi);
                     bene+=listdivi.getBeneficio();
                 }
                 
             }
              
        }
       
        return bene;
    }
    /**
     * funcion que realiza la finalizacion de la operacion con la divisa
     * @param divisa objeto que contiene los atributos de la divisa
     * @return divisa.getBeneficio
     */
    @Override
    public float terminarOperacion(Divisa divisa) {
        Datos dat =  new Datos();
        Datos datinsertar =  new Datos();
        dat.borrarDivisa(divisa);
        datinsertar.insertarHistorial(divisa);
        return divisa.getBeneficio();
    }
    /**
     * funcion que descuenta el dinero deacuerdo con el beneficio obtenido
     * @param user objeto que contiene los datos del usuario
     * @return  er
     */
    @Override
    public ErrorMsg descontarDinero(Usuario user) {
        Datos dat =  new Datos();
        dat.updateDineroCuenta(user);
        ErrorMsg er = new ErrorMsg();
        er.setErrormsg("actualizado");
        return er;
    }
    /**
     * funcion que consulta el historial de las divisas
     * @param divisa objeto que contiene los atributos de la divisa
     * @return listaDivisa
     */
    @Override
    public ArrayList<Divisa> ConsultaHistorial(Divisa divisa) {
    ArrayList<Divisa> listaDivisa= new ArrayList<Divisa>();
           
            Datos dat =  new Datos();
            listaDivisa=dat.consultaDivisaHistorial(divisa);
           
            return listaDivisa;
    }
    /**
     * funcion que geera el envio del correo de la recarga del dinero
     * @param correo atributo que contiene el correo del cliente
     * @param cantidad  atributo que contiene la cantidad de dinero recargado
     */
    public void enviarCorreo(String correo, float cantidad){
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("sosa8088111@gmail.com", "JOSTICK8088");
                    }
                });

        try {

            javax.mail.Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sosa8088111@gmail.com"));
            message.setRecipients(javax.mail.Message.RecipientType.TO,
                    InternetAddress.parse(correo));
            message.setSubject("Confirmacion compra");
            message.setText("Ha realizado la compra de: $"+cantidad+" exitosamente");

            javax.mail.Transport.send(message);
            

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }//enviarCorreo

    
}
