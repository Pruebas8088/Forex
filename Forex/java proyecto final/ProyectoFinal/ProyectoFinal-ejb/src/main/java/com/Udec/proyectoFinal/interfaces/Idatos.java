/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Udec.proyectoFinal.interfaces;

import com.Udec.proyectoFinal.clase.Conexion;
import com.Udec.proyectoFinal.clase.Datos;
import static com.Udec.proyectoFinal.clase.Datos.llenado;
import static com.Udec.proyectoFinal.clase.Datos.llenadodinero;
import com.Udec.proyectoFinal.clase.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author Jonathan
 */
@Stateless
public class Idatos implements IdatosLocal {

    static Connection con =null;
    static Statement stnt =null;
    static ResultSet rs=null;
    String server;
    String user;
    String pass;
    
    public Idatos() {
        
        server = "jdbc:postgresql://localhost:5432/Proyecto_final";
        user = "postgres";
        pass = "123";
        
        Conexion c = new Conexion();
        if(c.indica_1()==1 && c.indica_2()==1){
            stnt=c.stamt();
            con =c.con();
        }
    }
    
    @Override
    public void envio(Usuario usuario) {
        String qry = "Insert into usuario(nombre,apellido,correo,contrasena,token,dinero) values ("+"'" + usuario.getNombre()+ "'"+","+"'" + usuario.getApellido() + "'"+","+"'" + usuario.getEmail()+ "'"+","+"'" + usuario.getPass()+ "'"+","+"'" + "0" + "'"+"," + 0 +")";
            try {
                stnt.executeUpdate(qry);
            } catch (SQLException e) {
                System.out.println("fallo");
            }
    }

    @Override
    public Boolean validacion(Usuario usuario) {
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

    @Override
    public void updateToken(Usuario usuario, String jwt) {
        String qry = "UPDATE public.usuario SET  token="+"'" + jwt+ "'"+"WHERE correo="+"'" + usuario.getEmail()+ "'"+"";
            try {
                stnt.executeUpdate(qry);
            } catch (SQLException e) {
                System.out.println("fallo");
            }
    }

    @Override
    public void updateDinero(Usuario usuario) {
        String qry = "UPDATE public.usuario SET  dinero="+ usuario.getDinero()+"WHERE token="+"'" + usuario.getToken() + "'"+"";
            try {
                stnt.executeUpdate(qry);
            } catch (SQLException e) {
                System.out.println("fallo");
            }
    }

    @Override
    public ArrayList<Usuario> traerInfo() {
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

    @Override
    public float traerDinero(Usuario user) {
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

    @Override
    public float llenadodinero(ResultSet rs) {
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

    @Override
    public ArrayList<Usuario> llenado(ResultSet rs) {
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

    @Override
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

    @Override
    public void disconnet() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("ConnectDB " + ex.getMessage());
            }
        }
    }

    
}
