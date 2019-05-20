/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Udec.proyectoFinal.clase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Jonathan
 */
public class Datos {
    

    

    public Datos() {

    }
    
    
     public void envio(Usuario usuario){
        String url= "jdbc:postgresql://localhost:5432/Proyecto_final";
        String driver = "org.postgresql.Driver";
        Connection con=null;
	String contrase ="123";
        String us = "postgres";
           try {
                Class.forName(driver).newInstance();
                con=DriverManager.getConnection(url,us,contrase);
                Statement stntenvio = con.createStatement();
                String qry = "Insert into usuario(nombre,apellido,correo,contrasena,token,dinero) values ("+"'" + usuario.getNombre()+ "'"+","+"'" + usuario.getApellido() + "'"+","+"'" + usuario.getEmail()+ "'"+","+"'" + usuario.getPass()+ "'"+","+"'" + "0" + "'"+"," + 0 +")";
                 
                    ResultSet rs = stntenvio.executeQuery(qry);
                    rs.close();
                    stntenvio.close();
                    con.close();
                    
               
            } catch (Exception e) {
             System.out.println("fallo funcion envio");
            }
          
    }
     
     
      public void compraDivisas(Divisa divisa){
        String url= "jdbc:postgresql://localhost:5432/Proyecto_final";
        String driver = "org.postgresql.Driver";
        Connection con=null;
	String contrase ="123";
        String us = "postgres";
           try {
                 Class.forName(driver).newInstance();
                 con=DriverManager.getConnection(url,us,contrase);
                 Statement stntCompraDivisa = con.createStatement();
                 String qry = "INSERT INTO public.accion(idoperacion, valoinicial, token, valorfinal, cantidad,beneficio,divisa) values (" + divisa.getIdOperacion()+"," + divisa.getValorInicial()+","+"'" + divisa.getToken()+ "'"+"," + divisa.getValorFinal()+"," + divisa.getCantidad() +"," + divisa.getBeneficio()+","+"'" + divisa.getDivisa()+ "'"+")";
             
                    ResultSet rs =stntCompraDivisa.executeQuery(qry);
                    rs.close();
                    stntCompraDivisa.close();
                    con.close();
                    
         } catch (SQLException ex) {
            System.out.println("fallo funcion compraDivisas");
         } catch (Exception e) {
             System.out.println("fallo funcion compraDivisas");
         }
            
        
    } 
     
      public  Boolean validacion(Usuario usuario){
        boolean estado;
        String url= "jdbc:postgresql://localhost:5432/Proyecto_final";
        String driver = "org.postgresql.Driver";
        Connection con=null;
	String contrase ="123";
        String us = "postgres";
           try {
                 Class.forName(driver).newInstance();
                 con=DriverManager.getConnection(url,us,contrase);
                 Statement stntvalidacion = con.createStatement();
                 String qry = "SELECT * FROM public.usuario where correo="+"'" + usuario.getEmail()+ "'"+"and contrasena="+"'" + usuario.getPass()+ "'"+"";
                 ResultSet rsValidacion=stntvalidacion.executeQuery(qry);
             while(rsValidacion.next()){
                Usuario user = new Usuario();
                user.setToken(rsValidacion.getString("token")); 
                if(user.getToken().isEmpty()){
                     estado=false;
                     rsValidacion.close();
                     stntvalidacion.close();
                      con.close();
                     return estado;
                }else{
                    estado=true;
                    rsValidacion.close();
                    stntvalidacion.close();
                     con.close();
                    return estado;
                }
                   
            }
        } catch (SQLException ex) {
             System.out.println("fallo funcion validacion");
        } catch (Exception ex) {
             System.out.println("fallo funcion validacion");
        }
        return false;
    }
    
     public  void updateToken(Usuario usuario,String jwt){
        String url= "jdbc:postgresql://localhost:5432/Proyecto_final";
        String driver = "org.postgresql.Driver";
        Connection con=null;
	String contrase ="123";
        String us = "postgres";
           try {
                 Class.forName(driver).newInstance();
                 con=DriverManager.getConnection(url,us,contrase);
                 Statement stntupdateTok =  con.createStatement();
                 String qry = "UPDATE public.usuario SET  token="+"'" + jwt+ "'"+"WHERE correo="+"'" + usuario.getEmail()+ "'"+"";
                 ResultSet rs = stntupdateTok.executeQuery(qry);
                 rs.close();
                 stntupdateTok.close();
                 con.close();
                   
         } catch (SQLException ex) {
               System.out.println("fallo updatetoken"+ex);
         }catch (Exception ex) {
               System.out.println("fallo updatetoken"+ex);
         }
           
       
    }
     
     
     public  void cerradoCuenta(Usuario usuario){
        String url= "jdbc:postgresql://localhost:5432/Proyecto_final";
        String driver = "org.postgresql.Driver";
        Connection con=null;
	String contrase ="123";
        String us = "postgres";
           try {
                 Class.forName(driver).newInstance();
                 con=DriverManager.getConnection(url,us,contrase);
             Statement stntcerradoCuenta = con.createStatement();
             String qry = "UPDATE public.usuario SET  token="+"'" + 0 + "'"+"WHERE token="+"'" + usuario.getToken()+ "'"+"";
              
                    ResultSet rs = stntcerradoCuenta.executeQuery(qry);
                    rs.close();
                    stntcerradoCuenta.close();
                    con.close();
              
         } catch (SQLException ex) {
              System.out.println("fallo  cerradoCuenta ");
         } catch (Exception ex) {
              System.out.println("fallo  cerradoCuenta ");
         }
            
       
    } 
     
     public  void updateDinero(Usuario usuario){
        String url= "jdbc:postgresql://localhost:5432/Proyecto_final";
        String driver = "org.postgresql.Driver";
        Connection con=null;
	String contrase ="123";
        String us = "postgres";
           try {
                 Class.forName(driver).newInstance();
                 con=DriverManager.getConnection(url,us,contrase);
             Statement stntupdateDinero = con.createStatement();
             String qry = "UPDATE public.usuario SET  dinero="+ usuario.getDinero()+"WHERE token="+"'" + usuario.getToken() + "'"+"";
              
                     ResultSet rs =  stntupdateDinero.executeQuery(qry);
                     rs.close();
                     stntupdateDinero.close();
                     con.close();
                
         } catch (SQLException ex) {
            System.out.println("fallo updateDinero ");
         } catch (Exception ex) {
            System.out.println("fallo updateDinero ");
         }
           
       
    }
     
    
    public  ArrayList<Usuario> traerInfo(){
         ArrayList<Usuario> listauser = new ArrayList<Usuario>();
          String url= "jdbc:postgresql://localhost:5432/Proyecto_final";
        String driver = "org.postgresql.Driver";
        Connection con=null;
	String contrase ="123";
        String us = "postgres";
           try {
                 Class.forName(driver).newInstance();
                 con=DriverManager.getConnection(url,us,contrase);
             Statement stnttraerInfo = con.createStatement();
             String qry = "SELECT * FROM usuario";
              
                ResultSet rsTraerinfo = stnttraerInfo.executeQuery(qry);
                
                 while(rsTraerinfo.next()){
               
                    Usuario user = new Usuario();
                    user.setNombre(rsTraerinfo.getString("nombre"));
                    user.setApellido(rsTraerinfo.getString("apellido"));
                    user.setEmail(rsTraerinfo.getString("correo"));
                    user.setPass(rsTraerinfo.getString("contrasena"));
                    user.setToken(rsTraerinfo.getString("token"));
                    user.setDinero(rsTraerinfo.getFloat("dinero"));
                    listauser.add(user);
                   
                }
               
                 stnttraerInfo.close();
                 rsTraerinfo.close();
                  con.close();
                return listauser;
            
         } catch (SQLException ex) {
             System.out.println("fallo traerinfo");
         } catch (Exception ex) {
             System.out.println("fallo traerinfo");
         }
        return listauser;
    } 
    
    
    
    
    public float traerDinero(Usuario user){
         float dinero=0;
        String url= "jdbc:postgresql://localhost:5432/Proyecto_final";
        String driver = "org.postgresql.Driver";
        Connection con=null;
	String contrase ="123";
        String us = "postgres";
           try {
                 Class.forName(driver).newInstance();
                 con=DriverManager.getConnection(url,us,contrase);
             Statement stnttraerDinero = con.createStatement();
             String qry = "SELECT * FROM usuario where token = "+"'"+ user.getToken()+"'";
              
                    ResultSet rstraerdinero=stnttraerDinero.executeQuery(qry);
                    while(rstraerdinero.next()){
                      user.setDinero(rstraerdinero.getFloat("dinero"));
                   
                     }
                    dinero = user.getDinero();
                    
                    stnttraerDinero.close();
                    rstraerdinero.close();
                     con.close();
                    return dinero;
             
         } catch (SQLException ex) {
             System.out.println("fallo traerdinero");
         } catch (Exception ex) {
             System.out.println("fallo traerdinero");
         }
         return dinero;
    } 
    

    
   
    ////////////////////////////////////////////////////////////////////////////////////
    public  ArrayList<Divisa> consultaDivisa(Divisa divisa){
            ArrayList<Divisa> listaDivisa= new ArrayList<Divisa>();
        String url= "jdbc:postgresql://localhost:5432/Proyecto_final";
        String driver = "org.postgresql.Driver";
        Connection con=null;
	String contrase ="123";
        String us = "postgres";
           try {
                 Class.forName(driver).newInstance();
                 con=DriverManager.getConnection(url,us,contrase);
             Statement stntconsultaDivisa = con.createStatement();
             String qry = "SELECT * FROM public.accion where token = "+"'"+ divisa.getToken()+"'";
                ResultSet rsconsultaDivisa=stntconsultaDivisa.executeQuery(qry);
                while(rsconsultaDivisa.next()){
               
                    Divisa div = new Divisa();
                    div.setCantidad(rsconsultaDivisa.getFloat("cantidad"));
                    div.setIdOperacion(rsconsultaDivisa.getInt("idoperacion"));
                    div.setToken(rsconsultaDivisa.getString("token"));
                    div.setValorInicial(rsconsultaDivisa.getFloat("valoinicial"));
                    div.setBeneficio(rsconsultaDivisa.getFloat("beneficio"));
                    div.setDivisa(rsconsultaDivisa.getString("divisa"));
                    listaDivisa.add(div);
                   
                }
                 stntconsultaDivisa.close();
                 rsconsultaDivisa.close();
                 con.close();
                 
         
            
         } catch (SQLException ex) {
             System.out.println("fallo  consultaDivisa");
         } catch (Exception ex) {
             System.out.println("fallo  consultaDivisa");
         }
            
          
            
           return listaDivisa;
    } 

    
    
    public  ArrayList<Divisa> consultaDivisaHistorial(Divisa divisa){
         ArrayList<Divisa> listaDivisa= new ArrayList<Divisa>();
         String url= "jdbc:postgresql://localhost:5432/Proyecto_final";
        String driver = "org.postgresql.Driver";
        Connection con=null;
	String contrase ="123";
        String us = "postgres";
           try {
                 Class.forName(driver).newInstance();
                 con=DriverManager.getConnection(url,us,contrase);
             Statement stntconsultaDivisaHistorial = con.createStatement();
             String qry = "SELECT * FROM public.historial where usuario = "+"'"+ divisa.getToken()+"'";
             
                   ResultSet rsconsultaDivisaHistorial=stntconsultaDivisaHistorial.executeQuery(qry);
                  while(rsconsultaDivisaHistorial.next()){
               
                    Divisa div = new Divisa();
                    div.setToken(rsconsultaDivisaHistorial.getString("usuario"));
                    div.setValorInicial(rsconsultaDivisaHistorial.getFloat("valorinicial"));
                    div.setValorFinal(rsconsultaDivisaHistorial.getFloat("valorfinal"));
                    div.setCantidad(rsconsultaDivisaHistorial.getFloat("cantidad"));
                    div.setIdOperacion(rsconsultaDivisaHistorial.getInt("idoperacion"));
                    div.setBeneficio(rsconsultaDivisaHistorial.getFloat("beneficio"));
                    div.setDivisa(rsconsultaDivisaHistorial.getString("divisa"));
                    listaDivisa.add(div);
                   
                    }
                   stntconsultaDivisaHistorial.close();
                   rsconsultaDivisaHistorial.close();
                   con.close();
         } catch (SQLException ex) {
              System.out.println("fallo  consultaDivisaHistorial");
         } catch (Exception ex) {
              System.out.println("fallo  consultaDivisaHistorial");
         }
         return listaDivisa;
    } 
    
 
    
    
    
     public void updateDivisa(Divisa divisa){
        String url= "jdbc:postgresql://localhost:5432/Proyecto_final";
        String driver = "org.postgresql.Driver";
        Connection con=null;
	String contrase ="123";
        String us = "postgres";
           try {
                 Class.forName(driver).newInstance();
                 con=DriverManager.getConnection(url,us,contrase);
             Statement stntupdateDivisa = con.createStatement();
             String qry = "UPDATE public.accion SET  beneficio="+ divisa.getBeneficio()+"WHERE token="+"'" + divisa.getToken() + "'"+"AND  CAST(valoinicial AS DECIMAL )="+divisa.getValorInicial()+"";
               
                   ResultSet rs = stntupdateDivisa.executeQuery(qry);
                   rs.close();
                   stntupdateDivisa.close();
                    con.close();
              
         } catch (SQLException ex) {
             System.out.println("fallo  updateDivisa");
         } catch (Exception ex) {
             System.out.println("fallo  updateDivisa");
         }
           
       
    }
     
     public void borrarDivisa(Divisa divisa){
        String url= "jdbc:postgresql://localhost:5432/Proyecto_final";
        String driver = "org.postgresql.Driver";
        Connection con=null;
	String contrase ="123";
        String us = "postgres";
           try {
                 Class.forName(driver).newInstance();
                 con=DriverManager.getConnection(url,us,contrase);
             Statement stntborrarDivisa = con.createStatement();
              String qry = "DELETE FROM public.accion WHERE  token="+"'"+ divisa.getToken()+"'"+"AND beneficio="+"'"+divisa.getBeneficio()+"'"+" AND idoperacion="+"'"+divisa.getIdOperacion()+"'"+"";
                
                     ResultSet rs = stntborrarDivisa.executeQuery(qry);
                     rs.close();
                     stntborrarDivisa.close();
                     con.close();
                     
                 
         } catch (SQLException ex) {
             System.out.println("fallo borrarDivisa");
         } catch (Exception ex) {
             System.out.println("fallo borrarDivisa");
         }
            
       
    } 
     
     public void insertarHistorial(Divisa divisa){
       String url= "jdbc:postgresql://localhost:5432/Proyecto_final";
        String driver = "org.postgresql.Driver";
        Connection con=null;
	String contrase ="123";
        String us = "postgres";
           try {
                 Class.forName(driver).newInstance();
                 con=DriverManager.getConnection(url,us,contrase);
             Statement stntinsertarHistorial = con.createStatement();
             String qry = "INSERT INTO public.historial(usuario, valorinicial, valorfinal, cantidad, idoperacion, beneficio, divisa) values (" +"'"+ divisa.getToken()+"'"+"," + divisa.getValorInicial()+"," + divisa.getValorFinal()+ "," + divisa.getCantidad()+"," + divisa.getIdOperacion()+"," + divisa.getBeneficio()+","+"'" + divisa.getDivisa()+ "'"+")";
               
                    ResultSet rs = stntinsertarHistorial.executeQuery(qry);
                    rs.close();
                    stntinsertarHistorial.close();
                     con.close();
                
        
         } catch (SQLException ex) {
             System.out.println("fallo insertarHistorial");
         } catch (Exception ex) {
             System.out.println("fallo insertarHistorial");
         }
           
     } 
      
     
      public void updateDineroCuenta(Usuario usuario){
         String url= "jdbc:postgresql://localhost:5432/Proyecto_final";
        String driver = "org.postgresql.Driver";
        Connection con=null;
	String contrase ="123";
        String us = "postgres";
           try {
                 Class.forName(driver).newInstance();
                 con=DriverManager.getConnection(url,us,contrase);
             Statement stntupdateDineroCuenta = con.createStatement();
             String qry = "UPDATE public.usuario SET  dinero="+ usuario.getDinero()+"WHERE nombre="+"'" + usuario.getNombre()+ "'"+"";
             ResultSet rs =  stntupdateDineroCuenta.executeQuery(qry);
                    rs.close();
                    stntupdateDineroCuenta.close();
                    con.close();
              
                    
         } catch (SQLException ex) {
             System.out.println("fallo updateDineroCuenta");
         } catch (Exception ex) {
             System.out.println("fallo updateDineroCuenta");
         }
            
       
    }


}
