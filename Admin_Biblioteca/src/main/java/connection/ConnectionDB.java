/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class ConnectionDB {
    
    private final static String drv = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String db;// = "jdbc:sqlserver://127.0.0.1:1433;databaseName=BIBLIOTECA";
    private final String user;// = "sa";
    private final String pass;// = "12345678";

    private final String dbName;
    private final String ip;
    private final String pto;

    private Connection ct;
    private Statement st;
	
    public  ConnectionDB(){
        dbName = "BIBLIOTECA";
        ip = "localhost";
        pto = "1433";
        db = "jdbc:sqlserver://"+ip+":"+pto+";databaseName="+dbName;
        user = "sa";                                                            
        pass = "12345678";                        
        openConnection();
    }
	
    public Statement getStatement(){
            return st;
    }

    public Connection getConnection(){
            return ct;
    }
    
    public void openConnection(){                              
        try{
            Class.forName(drv);//cargar el driver
            ct = DriverManager.getConnection(db, user, pass);
            if (ct != null) {
                st = ct.createStatement();
//                System.out.println("Conexi\u00f3n exitosa con db "+dbName);
            }           
            
        }catch (SQLException e) { 			
            JOptionPane.showMessageDialog(null, e.getMessage(),
            		"Error en base de datos", JOptionPane.ERROR_MESSAGE);
        }catch (ClassNotFoundException e) {
        	JOptionPane.showMessageDialog(null, e.getMessage(),
            		"Error en base de datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void closeConnection(){
        try {
           ct.close();
//           System.out.println("CerrÃ³ conexiÃ³n");
        } catch (SQLException e) {
           System.out.println("No se cerró la conexión "+e.getMessage());
        }
    }
//    public static void main (String[] args){
//        new ConnectionDB();
//    }

    public PreparedStatement prepareStatement(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
