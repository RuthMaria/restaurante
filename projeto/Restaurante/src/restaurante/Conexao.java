/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package restaurante;

import java.awt.ScrollPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/* @author ruth.silva */

public class Conexao{
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ResultSetMetaData metadados;
        int numeroColunas;
        
        public Conexao(){   
           try{
               Class.forName("com.mysql.jdbc.Driver");
               connection = DriverManager.getConnection("jdbc:mysql://localhost/ruth","root", "");
               statement = connection.createStatement();
           }
                   
                   
           catch(SQLException r){
               r.printStackTrace();
               System.exit(1); 
           }
                   
           catch(ClassNotFoundException t){
               t.printStackTrace();
               System.exit(1);

           }
        }

        public void inserir_banco(String inserir){
           try{
                statement.executeUpdate(inserir);
           }
                   
           catch(SQLException t){
               t.printStackTrace();
               System.exit(1);
           }
        }

        public void ver_banco(String resulta){
         
           try{
                resultSet = statement.executeQuery(resulta);
                metadados = resultSet.getMetaData();
                numeroColunas = metadados.getColumnCount();
                
           }          
           catch(SQLException t){
                t.printStackTrace();
                System.exit(1);
       }
    }
        
        public void fechaConexão(){
                   try{
                       statement.close();
                       connection.close();
                       resultSet.close();
                   }
                           
                   catch(Exception h){
                        h.printStackTrace();
                        System.exit(1);
                   }
        }
    
    
    
           
}


    