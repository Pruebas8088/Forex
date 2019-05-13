/********************************************************/
package com.Udec.proyectoFinal.clase;
/**
 * @author 
 */
import java.sql.*;

public class Conexion {
	//String driver="com.mysql.jdbc.Driver";
        String driver = "org.postgresql.Driver";
	//String url="jdbc:mysql://localhost:3306/acuario"; /** este nombre es el nombre de la base de datos? */
        String url= "jdbc:postgresql://localhost:5432/Proyecto_final";
        String user,contra,aviso1,aviso2;
	public int indica1,indica2;
	Connection con=null;
	Statement stmt=null; 
        String contrase ="123";
        String usuario = "postgres";

   public Conexion() {
	
        System.out.println("Contraseña="+contrase);
        indica1=0; indica2=0;
	try {
	      Class.forName(driver).newInstance();
	      System.out.println("Se ha cargado correctamente el driver:"+driver);
	      aviso1="Se ha cargado correctamente el driver: "+driver;
	      indica1=1;
	}
	catch (Exception e){
	   System.out.println("Se ha producido el siguiente error al cargar el driver:\n"+e.getMessage());
	}
	try{
	     con=DriverManager.getConnection(url,usuario,contrase);
	     System.out.println("Se ha conectado correctamente a la base de datos");
	     System.out.println("Conection ==>"+(Object)con);
	     aviso1="Se ha conectado correctamente a la base de datos";
	     indica2=1;
	}
	catch(Exception e){
	    System.out.println("Se ha producido un error al momento de conectar la base de datos: \n"+e.getMessage());
	}
        if (indica2==1){
           try {
                 stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
           }catch (SQLException e) {
                   System.out.println ("Error Creando el Statement= "+ e.getMessage());
            }
      }else{
               System.out.println("Invalida usuario o contraseña");
           }
    }

    public Connection con(){ return con;  }

    public Statement stamt(){ return stmt; }

    public String rAviso1(){ return aviso1; }

    public String rAviso2(){ return aviso2; }

    public int indica_1(){ return indica1; }

    public int indica_2(){ return indica2; }
}
