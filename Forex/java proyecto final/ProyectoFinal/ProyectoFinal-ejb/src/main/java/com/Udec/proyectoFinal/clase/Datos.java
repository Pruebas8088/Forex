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
    
    static Connection con =null;
    static Statement stnt =null;
    static ResultSet rs=null;
    String server;
    String user;
    String pass;

    public Datos() {
        
        server = "jdbc:postgresql://localhost:5432/Proyecto_final";
        user = "postgres";
        pass = "123";
        
        Conexion c = new Conexion();
        if(c.indica_1()==1 && c.indica_2()==1){
            stnt=c.stamt();
            con =c.con();
        }
    }
    
    
     public static void envio(Usuario usuario){
            String qry = "Insert into usuario(nombre,apellido,correo,contrasena,token,dinero) values ("+"'" + usuario.getNombre()+ "'"+","+"'" + usuario.getApellido() + "'"+","+"'" + usuario.getEmail()+ "'"+","+"'" + usuario.getPass()+ "'"+","+"'" + "0" + "'"+"," + 0 +")";
            try {
                stnt.executeUpdate(qry);
            } catch (SQLException e) {
                System.out.println("fallo");
            }
        
    }
     
     
      public static void compraDivisas(Divisa divisa){
            String qry = "INSERT INTO public.accion(idoperacion, valoinicial, token, valorfinal, cantidad,beneficio,divisa) values (" + divisa.getIdOperacion()+"," + divisa.getValorInicial()+","+"'" + divisa.getToken()+ "'"+"," + divisa.getValorFinal()+"," + divisa.getCantidad() +"," + divisa.getBeneficio()+","+"'" + divisa.getDivisa()+ "'"+")";
            try {
                stnt.executeUpdate(qry);
            } catch (SQLException e) {
                System.out.println("fallo");
            }
        
    } 
     
      public static Boolean validacion(Usuario usuario){
          boolean estado;
            String qry = "SELECT * FROM public.usuario where correo="+"'" + usuario.getEmail()+ "'"+"and contrasena="+"'" + usuario.getPass()+ "'"+"";
            try {
                rs=stnt.executeQuery(qry);
                rs.first();
                if(rs.getString(4).isEmpty()){
                     estado=false;
                     return estado;
                }else{
                    estado=true;
                    return estado;
                }
                
               
            } catch (SQLException e) {
                System.out.println("fallo");
            }
        return false;
    }
    
     public static void updateToken(Usuario usuario,String jwt){
          
            String qry = "UPDATE public.usuario SET  token="+"'" + jwt+ "'"+"WHERE correo="+"'" + usuario.getEmail()+ "'"+"";
            try {
                stnt.executeUpdate(qry);
            } catch (SQLException e) {
                System.out.println("fallo");
            }
       
    }
     
     
     public static void cerradoCuenta(Usuario usuario){
          
            String qry = "UPDATE public.usuario SET  token="+"'" + 0 + "'"+"WHERE token="+"'" + usuario.getToken()+ "'"+"";
            try {
                stnt.executeUpdate(qry);
            } catch (SQLException e) {
                System.out.println("fallo");
            }
       
    } 
     
     public static void updateDinero(Usuario usuario){
          
            String qry = "UPDATE public.usuario SET  dinero="+ usuario.getDinero()+"WHERE token="+"'" + usuario.getToken() + "'"+"";
            try {
                stnt.executeUpdate(qry);
            } catch (SQLException e) {
                System.out.println("fallo");
            }
       
    }
     
    
    public static ArrayList<Usuario> traerInfo(){
            String qry = "SELECT * FROM usuario";
            ArrayList<Usuario> listauser = new ArrayList<Usuario>();
            try {
                 rs=stnt.executeQuery(qry);
                 listauser=llenado(rs);
                 
            } catch (SQLException e) {
                System.out.println("fallo");
            }
            
           return listauser;
    } 
    
    public static float traerDinero(Usuario user){
            String qry = "SELECT * FROM usuario where token = "+"'"+ user.getToken()+"'";
            float dinero=0;
            try {
                 rs=stnt.executeQuery(qry);
                 dinero=llenadodinero(rs);
                 return dinero;
            } catch (SQLException e) {
                System.out.println("fallo");
            }
            
           return dinero;
    } 
    
    public static float llenadodinero(ResultSet rs){
        float dinero =0 ;
        Usuario user = new Usuario();
        try {
            while(rs.next()){
                user.setDinero(rs.getFloat("dinero"));
                   
            }
            return user.getDinero();
        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dinero;
    }
    
    public static ArrayList<Usuario> llenado(ResultSet rs){
        ArrayList<Usuario> listauser = new ArrayList<Usuario>();
        try {
            while(rs.next()){
               
                    Usuario user = new Usuario();
                    user.setNombre(rs.getString("nombre"));
                    user.setApellido(rs.getString("apellido"));
                    user.setEmail(rs.getString("correo"));
                    user.setPass(rs.getString("contrasena"));
                    user.setToken(rs.getString("token"));
                    user.setDinero(rs.getFloat("dinero"));
                    listauser.add(user);
                   
            }
            return listauser;
        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
        listauser = null;
        return listauser;
    }
    ////////////////////////////////////////////////////////////////////////////////////
    public static ArrayList<Divisa> consultaDivisa(Divisa divisa){
            String qry = "SELECT * FROM public.accion where token = "+"'"+ divisa.getToken()+"'";
            ArrayList<Divisa> listaDivisa= new ArrayList<Divisa>();
            try {
                 rs=stnt.executeQuery(qry);
                 listaDivisa=llenadoDivisa(rs);
                 
            } catch (SQLException e) {
                System.out.println("fallo");
            }
            
           return listaDivisa;
    } 
    
    public static ArrayList<Divisa> llenadoDivisa(ResultSet rs){
        ArrayList<Divisa> listadivisa = new ArrayList<Divisa>();
        try {
            while(rs.next()){
               
                    Divisa div = new Divisa();
                    div.setCantidad(rs.getFloat("cantidad"));
                    div.setIdOperacion(rs.getInt("idoperacion"));
                    div.setToken(rs.getString("token"));
                    div.setValorInicial(rs.getFloat("valoinicial"));
                    div.setBeneficio(rs.getFloat("beneficio"));
                    div.setDivisa(rs.getString("divisa"));
                    listadivisa.add(div);
                   
            }
            return listadivisa;
        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
        listadivisa = null;
        return listadivisa;
    }
    
    
    
    public static ArrayList<Divisa> consultaDivisaHistorial(Divisa divisa){
            String qry = "SELECT * FROM public.historial where usuario = "+"'"+ divisa.getToken()+"'";
            ArrayList<Divisa> listaDivisa= new ArrayList<Divisa>();
            try {
                 rs=stnt.executeQuery(qry);
                 listaDivisa=llenadoDivisaHistorial(rs);
                 
            } catch (SQLException e) {
                System.out.println("fallo");
            }
            
           return listaDivisa;
    } 
    
    public static ArrayList<Divisa> llenadoDivisaHistorial(ResultSet rs){
        ArrayList<Divisa> listadivisa = new ArrayList<Divisa>();
        try {
            while(rs.next()){
               
                    Divisa div = new Divisa();
                    div.setToken(rs.getString("usuario"));
                    div.setValorInicial(rs.getFloat("valorinicial"));
                    div.setValorFinal(rs.getFloat("valorfinal"));
                    div.setCantidad(rs.getFloat("cantidad"));
                    div.setIdOperacion(rs.getInt("idoperacion"));
                    div.setBeneficio(rs.getFloat("beneficio"));
                    div.setDivisa(rs.getString("divisa"));
                    listadivisa.add(div);
                   
            }
            return listadivisa;
        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
        listadivisa = null;
        return listadivisa;
    }
    
    
    
     public static void updateDivisa(Divisa divisa){
          
            String qry = "UPDATE public.accion SET  beneficio="+ divisa.getBeneficio()+"WHERE token="+"'" + divisa.getToken() + "'"+"AND  CAST(valoinicial AS DECIMAL )="+divisa.getValorInicial()+"";
            try {
                stnt.executeUpdate(qry);
            } catch (SQLException e) {
                System.out.println("fallo");
            }
       
    }
     
     public static void borrarDivisa(Divisa divisa){
          
            String qry = "DELETE FROM public.accion WHERE  token="+"'"+ divisa.getToken()+"'"+"AND beneficio="+"'"+divisa.getBeneficio()+"'"+" AND idoperacion="+"'"+divisa.getIdOperacion()+"'"+"";
            try {
                stnt.executeUpdate(qry);
            } catch (SQLException e) {
                System.out.println("fallo borrar");
            }
       
    } 
     
     public static void insertarHistorial(Divisa divisa){
            String qry = "INSERT INTO public.historial(usuario, valorinicial, valorfinal, cantidad, idoperacion, beneficio, divisa) values (" +"'"+ divisa.getToken()+"'"+"," + divisa.getValorInicial()+"," + divisa.getValorFinal()+ "," + divisa.getCantidad()+"," + divisa.getIdOperacion()+"," + divisa.getBeneficio()+","+"'" + divisa.getDivisa()+ "'"+")";
            try {
                stnt.executeUpdate(qry);
            } catch (SQLException e) {
                System.out.println("fallo insertar en el historial");
            }
        
     } 
      
     
      public static void updateDineroCuenta(Usuario usuario){
          
            String qry = "UPDATE public.usuario SET  dinero="+ usuario.getDinero()+"WHERE nombre="+"'" + usuario.getNombre()+ "'"+"";
            try {
                stnt.executeUpdate(qry);
            } catch (SQLException e) {
                System.out.println("fallo");
            }
       
    }

public void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(server, user, pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("ConnectDB " + e.getMessage());
        }
    }
public void disconnet() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("ConnectDB " + ex.getMessage());
            }
        }
    }
 
    public Connection getConnect() {
        return con;
    }
}
