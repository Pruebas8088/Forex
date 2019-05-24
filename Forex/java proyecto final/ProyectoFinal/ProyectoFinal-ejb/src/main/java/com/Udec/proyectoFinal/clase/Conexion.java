/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Udec.proyectoFinal.clase;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLWarning;

/**
 *
 * @author David
 */
public class Conexion {
      
    //Objeto Tipo conexion que contiene todos los parametros para interactuar 
    //con la BD se crea un objeto tipo con
    public Connection con;

    //Constructor de la clase Conexion que contiene el parametro nombre que determina
    //el nombre de la base de datos que se va ha conectar con el ODBC
    public Conexion()
    {
          try
            {
              //Clase que especifica el nombre de los controladores que se van
              //ha utilizar en la carga de la BD en este caso son los de Access
              Class.forName("org.postgresql.Driver");  //loads the driver
            }
            catch(ClassNotFoundException e)
            {
                    System.out.println("No encontro driver");
            }

            try
            {
                    //url es un texto que contiene la ruta del nombre o la direccion
                    //de coneccion de la base da Datos conectada al JDBC
                    String url = "jdbc:postgresql://localhost:5432/Proyecto_final";
                   
                    //Con es el objeto creado para la coneccion donde se especifican los
                    //parametros de la ubicacion de la BD, login si la base de datos
                    //posee seguridad y por ultimo la clave
                    //DriverManager.getConnection es el servicio que permite establecer
                    //la conexion ABRIR CONEXION!!!
                    con = DriverManager.getConnection(url, "postgres", "123");
                   
                    
                    //checkForWarning es una funcion que recibe como parametro
                    //el listado de los errores generados en la conexion
                    checkForWarning (con.getWarnings ());		
                    
                    //Es un drvie que permite cargar las configuraciones del proveedor
                    //de la BD en este caso las reglas de configuraciones de pOSTgRESS
                    DatabaseMetaData dma = con.getMetaData ();
//
//                    System.out.println("\nConectado a: " + dma.getURL());
//                    //System.out.println("Rurta de la base de datos: "+con."");
//                    System.out.println("Driver       " + 
//                            dma.getDriverName());
//                    System.out.println("Version      " +
//                            dma.getDriverVersion());
//                    System.out.println("");

            }
            catch (SQLException ex) 
            {
                System.out.println ("\n*** SQLException caught ***\n");

                while (ex != null) 
                {
                    System.out.println ("SQLState: " +
                                    ex.getSQLState ());
                    System.out.println ("Message:  " + ex.getMessage ());
                    System.out.println ("Vendor:   " +
                                    ex.getErrorCode ());
                    ex = ex.getNextException ();
                    System.out.println ("");
                }
        }
        catch (java.lang.Exception ex) 
        {
            ex.printStackTrace ();
        }		
    }

    private static boolean checkForWarning (SQLWarning warn) throws SQLException  
    {
        boolean rc = false;

        if (warn != null) 
        {
            System.out.println ("\n *** Warning ***\n");
            rc = true;
            while (warn != null) 
            {
                System.out.println ("SQLState: " +warn.getSQLState ());
                System.out.println ("Message:  " +warn.getMessage ());
                System.out.println ("Vendor:   " +warn.getErrorCode ());
                System.out.println ("");
                warn = warn.getNextWarning ();
            }
        }
        return rc;
    }

    public void cerrarConexion()
    {
        try
        {
            //Cierra la conexion de la Base de Datos
            con.close();
            //System.out.println("Cerrada la conexion con la Base de Datos");
        }
        catch(SQLException e)
        {
            System.out.println("Error al cerrar la conexion con la Base de datos. \n"+e);
        }
    }
   
}