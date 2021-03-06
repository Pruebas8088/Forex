/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.clase;

import com.udec.utilitarios.Datos;
import com.udec.utilitarios.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.Stateless;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author David
 */
@Stateless
public class Iseguridad implements IseguridadLocal {

    @Override
    public String JwtConvert(String usuario, String contraseña) {
           Key key = traerKey();
        Datos datos = new  Datos();
        ArrayList<Usuario> listauser = new ArrayList<Usuario>();
        listauser = datos.traerInfo();
        if(listauser.isEmpty()){
            String jwt = "no hay datos";
            return jwt;
        }else{
            for (Usuario userL : listauser) {
                    if(userL.getEmail().equals(usuario) && userL.getPass().equals(contraseña)){
                        Datos datosupdate = new  Datos();
                        String jwt = Jwts.builder()
                                        .signWith(key, SignatureAlgorithm.HS256)
                                        .setSubject(userL.getNombre())
                                        .setIssuedAt(creacion())
                                        .setExpiration(expiracion())
                                        .claim("Correo", userL.getEmail())
                                        .compact();
                        datosupdate.updateToken(userL,jwt);
                        return jwt;
                    }
                }
        }
        String jwt = "Datos no coinciden";
        return jwt;}

    @Override
    public boolean validacion(Usuario user) {
        boolean estado;
        Datos dat = new Datos();
        estado=dat.validacion(user);
        return estado;
    }

    @Override
    public ArrayList<Usuario> traerdata() {
        ArrayList<Usuario> listauser = new ArrayList<Usuario>();
         Datos dat = new Datos();
         listauser=dat.traerInfo();
         return listauser;
    }
    
    private static Key traerKey(){
        SignatureAlgorithm signatureAlgorithm= SignatureAlgorithm.HS256;
       byte[] encodedKey = DatatypeConverter.parseBase64Binary("9l*6HVedSlgXYd5E^!@i$Dt@sp!QTTA2R*tc5$V7cFYbvIYiuHWYFBt@LzCdLLZu@TM4EC");
        Key key = new SecretKeySpec(encodedKey,signatureAlgorithm.getJcaName());
        return key;
    }
    
    private  static Date expiracion(){
        long tiempo = System.currentTimeMillis();
        long expiraTiempo = TimeUnit.MINUTES.toMillis(30);
        return new Date(tiempo+expiraTiempo);
    }
    
    private static Date creacion(){
        long tiempo = System.currentTimeMillis();
        return new Date(tiempo);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
