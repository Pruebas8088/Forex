/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Udec.proyectoFinal.interfaces;

import com.Udec.proyectoFinal.clase.Datos;
import com.Udec.proyectoFinal.clase.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Jonathan
 */
@Stateless
public class Iseguridad implements IseguridadLocal {
    @EJB
    IdatosLocal datos;
    
    @Override
    public String JwtConvert(String usuario, String contraseña) {
        Key key = traerKey();
        
        ArrayList<Usuario> listauser = new ArrayList<Usuario>();
        listauser = datos.traerInfo();
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
                        datos.updateToken(userL,jwt);
                        return jwt;
                    }
                }
        }
        String jwt = "Datos no coinciden";
        return jwt;
    }

     private static Date creacion(){
        long tiempo = System.currentTimeMillis();
        return new Date(tiempo);
    }
    
    private  static Date expiracion(){
        long tiempo = System.currentTimeMillis();
        long expiraTiempo = TimeUnit.MINUTES.toMillis(30);
        return new Date(tiempo+expiraTiempo);
    }
    
    private static Key traerKey(){
        SignatureAlgorithm signatureAlgorithm= SignatureAlgorithm.HS256;
       byte[] encodedKey = DatatypeConverter.parseBase64Binary("9l*6HVedSlgXYd5E^!@i$Dt@sp!QTTA2R*tc5$V7cFYbvIYiuHWYFBt@LzCdLLZu@TM4EC");
        Key key = new SecretKeySpec(encodedKey,signatureAlgorithm.getJcaName());
        return key;
    }
}
