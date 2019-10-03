/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

/* @author ruth.silva */

import restaurante.Interface;
import javax.swing.JFrame;

public class Main {
    
    
    public static void main(String[] args) {

      String ver = "SELECT * FROM cliente WHERE 1";
      
      Conexao conexao = new Conexao();
      conexao.ver_banco(ver);
      Interface inter = new Interface(); // create LabelFrame
      inter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fecha o Jframe
      inter.setSize(300, 600 ); // tamanho
      inter.setVisible( true ); // para visualizar
      conexao.fechaConexão(); // fecha conexao 
   } 
} 