/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

/* @author ruth.silva */


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel; 
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.BorderLayout; 
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Interface extends JFrame implements ActionListener{
      private JLabel nome_restaurante;
      private JButton cad_cliente, cad_produto, cad_prato, cad_garçom, serf_service; 
      private JButton gerenciamento_produtos, reserva, delivery, la_carte;
      private JButton gerenciamento_despesas,creditos, rodizio;
      private JButton relatório_Mensal;
      private JPanel  panel1;

      
      public Interface(){
          
      super( "..." );  // inicializa o construtor de JFrame
      
        try {
                  UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Erro Gráfico.");
           
        }
        
      setLayout(new BorderLayout()); // define o layout de JFrame
     
      panel1 = new JPanel();
      panel1.setLayout(new GridBagLayout());
     
      
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.fill = GridBagConstraints.BOTH;  //Redimensiona o componente para ambas as direções.

      nome_restaurante = new JLabel("Restaurante JABA");
      panel1.add(nome_restaurante, gbc);
      add(panel1, BorderLayout.CENTER);
          
      JLabel bug = new JLabel(new ImageIcon(getClass().getResource("images.jpg")));
      panel1.add(bug, gbc);
      add(panel1, BorderLayout.CENTER);
      
      
      cad_cliente = new JButton("Cadastrar clientes");
      panel1.add(cad_cliente, gbc);
      add(panel1, BorderLayout.CENTER);

      
      cad_garçom = new JButton("Cadastrar Garçom");
      panel1.add(cad_garçom, gbc);
      add(panel1, BorderLayout.CENTER);
      
      cad_produto = new JButton("Cadastrar produtos");
      panel1.add(cad_produto, gbc);
      add(panel1, BorderLayout.CENTER);

      cad_prato = new JButton("Cadastrar pratos");
      panel1.add(cad_prato, gbc);
      add(panel1, BorderLayout.CENTER);
      
      serf_service = new JButton("Self service");
      panel1.add(serf_service,gbc);
      add(panel1, BorderLayout.CENTER);
      
      delivery = new JButton("Delivery");
      panel1.add(delivery, gbc);
      add(panel1, BorderLayout.CENTER);
      
      la_carte = new JButton("La carte");
      panel1.add(la_carte, gbc);
      add(panel1, BorderLayout.CENTER);
      
      rodizio = new JButton("Rodízio");
      panel1.add(rodizio, gbc);
      add(panel1, BorderLayout.CENTER);
      
      
      reserva = new JButton("Fazer reserva");
      panel1.add(reserva,gbc);
      add(panel1, BorderLayout.CENTER);
      
      gerenciamento_produtos = new JButton("Gerenciamento de Produtos");
      panel1.add(gerenciamento_produtos,  gbc);
      add(panel1, BorderLayout.CENTER);
      
      gerenciamento_despesas = new JButton("Gerenciamento de despesas");
      panel1.add(gerenciamento_despesas,gbc);
      add(panel1, BorderLayout.CENTER);
      
      relatório_Mensal = new JButton("Relatório mensal das despesas");
      panel1.add(relatório_Mensal,gbc);
      add(panel1, BorderLayout.CENTER);
      
      creditos = new JButton("Créditos");
      panel1.add(creditos,gbc);
      add(panel1, BorderLayout.CENTER);
      
      
      cad_produto.addActionListener(this);
      creditos.addActionListener(this);
      cad_prato.addActionListener(this);
      cad_garçom.addActionListener(this); 
      cad_cliente.addActionListener(this);
      rodizio.addActionListener(this);
      gerenciamento_produtos.addActionListener(this);
      gerenciamento_despesas.addActionListener(this);
      relatório_Mensal.addActionListener(this);
      reserva.addActionListener(this);
      serf_service.addActionListener(this);
      la_carte.addActionListener(this);
      delivery.addActionListener(this);
   }

    @Override
    public void actionPerformed(ActionEvent event) {
              if(event.getActionCommand().equals("Cadastrar clientes")){ // ver a origem de evento
                      cadastrar_cliente c = new cadastrar_cliente();  
              }
        
              if(event.getActionCommand().equals("Cadastrar Garçom")){
                      cadastrar_garcom g = new cadastrar_garcom();  
              }
              
              if(event.getActionCommand().equals("Cadastrar produtos")){
                      cadastrar_produto p = new cadastrar_produto(); 
              }
              
              if(event.getActionCommand().equals("Cadastrar pratos")){
                      cadastrar_prato f = new cadastrar_prato(); 
              }
              
              if(event.getActionCommand().equals("Fazer reserva")){
                      reserva d = new reserva(); 
              }
              
             if(event.getActionCommand().equals("Delivery")){     
                     delivery s = new delivery();
             }
             
             if(event.getActionCommand().equals("Self service")){   
                     self_service f = new self_service();
             }
             
             if(event.getActionCommand().equals("Rodízio")){   
                     rodizio r = new rodizio();
             }
             
              if(event.getActionCommand().equals("La carte")){   
                     la_carte l = new la_carte();
             }
             
             if(event.getActionCommand().equals("Gerenciamento de Produtos")){ 
                  JOptionPane.showMessageDialog(this, new JLabel("ÁREA NÃO DESENVOLVIDA"));
             }
            
             if(event.getActionCommand().equals("Gerenciamento de despesas")){ 
                  JOptionPane.showMessageDialog(this, new JLabel("ÁREA NÃO DESENVOLVIDA"));
             }
                  
             if(event.getActionCommand().equals("Relatório mensal das despesas")){ 
                   JOptionPane.showMessageDialog(this, new JLabel("ÁREA NÃO DESENVOLVIDA"));
             }
          
             if(event.getActionCommand().equals("Créditos")){ 
                  JLabel j = new JLabel("RUTH MARIA E LARISSA THAÍS");
                  JOptionPane.showMessageDialog(null, j.getText(), "Desenvolvedores", WIDTH);
                   
             }
    }
      
}