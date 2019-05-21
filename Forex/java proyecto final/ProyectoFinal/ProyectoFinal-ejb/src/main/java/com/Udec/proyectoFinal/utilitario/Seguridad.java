/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Udec.proyectoFinal.utilitario;

import com.Udec.proyectoFinal.clase.Datos;
import com.Udec.proyectoFinal.clase.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 *clase que contiene seguridad del proyecto
 * @author David
 */
public class Seguridad {
     
    /**
     * funcion que genera el token con los datos del usuario
     * @param usuario objeto que contiene los datos del usuario
     * @param contraseña atributo que contiene la contraseña del usuaeio
     * @return jwt
     */
       public static String JwtConvert(String usuario, String contraseña){
        //Key KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        Key key = traerKey();
        Datos dat = new Datos();
        ArrayList<Usuario> listauser = new ArrayList<Usuario>();
        listauser = dat.traerInfo();
        if(listauser.isEmpty()){
            String jwt = "no hay datos";
            return jwt;
        }else{
            for (Usuario userL : listauser) {
                    if(userL.getEmail().equals(usuario) && userL.getPass().equals(contraseña)){
                        String jwt = Jwts.builder()
                                        .signWith(key, SignatureAlgorithm.HS256)
                                        .setSubject(userL.getNombre())
                                        .setIssuedAt(creacion())
                                        .setExpiration(expiracion())
                                        .claim("Correo", userL.getEmail())
                                        .compact();
                        dat.updateToken(userL,jwt);
                        return jwt;
                    }
                }
        }
        String jwt = "Datos no coinciden";
        return jwt;
    }
    /**
     * funcion que genera fecha del token
     * @return date
     */
     private static Date creacion(){
        long tiempo = System.currentTimeMillis();
        return new Date(tiempo);
    }
    /**
     * funcion que asigna expiracion al token
     * @return date
     */
    private  static Date expiracion(){
        long tiempo = System.currentTimeMillis();
        long expiraTiempo = TimeUnit.MINUTES.toMillis(30);
        return new Date(tiempo+expiraTiempo);
    }
    /**
     * funcio que asigna una llave al token
     * @return key
     */
    private static Key traerKey(){
        SignatureAlgorithm signatureAlgorithm= SignatureAlgorithm.HS256;
       byte[] encodedKey = DatatypeConverter.parseBase64Binary("9l*6HVedSlgXYd5E^!@i$Dt@sp!QTTA2R*tc5$V7cFYbvIYiuHWYFBt@LzCdLLZu@TM4EC");
        Key key = new SecretKeySpec(encodedKey,signatureAlgorithm.getJcaName());
        return key;
    }
    
}
    

