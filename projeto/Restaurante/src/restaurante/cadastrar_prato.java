


package restaurante;

import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class cadastrar_prato extends JDialog implements ActionListener{
    
    JTextField inserir[] = new JTextField[2];
    JButton salvar;
    JButton voltar, limpar;
    JButton novo;
    
     public cadastrar_prato(){
     
                this.setLayout(new GridBagLayout());
                
                JLabel dados[] = new JLabel[2];
                dados[0] = new JLabel("Nome: \n");
                dados[1] = new JLabel("Valor: \n");

                
                for(int i = 0; i < 2; i++)
                     inserir[i] = new JTextField(45);
               
                this.setTitle("CADASTRO DE PRATOS");
                
                this.setLayout(new GridBagLayout());
                
                GridBagConstraints j = new GridBagConstraints();

                j.fill = GridBagConstraints.HORIZONTAL;
                j.weightx = 0.5;
               
                j.insets = new Insets(10, 30, 0, 30); 
                j.fill = GridBagConstraints.HORIZONTAL;
                j.gridx = 0;
                j.gridy = 0;
                this.add(dados[0], j);

            
                j.fill = GridBagConstraints.HORIZONTAL;
                j.weightx = 0.5;
                j.gridwidth = 2;
                j.gridx = 1;
                j.gridy = 0;
                this.add(inserir[0], j);

                
                salvar = new JButton("Salvar");
                salvar.setEnabled(false);
                j.fill = GridBagConstraints.HORIZONTAL;
                j.weightx = 0.5;
                j.gridx = 3;
                j.gridy = 0;
                salvar.addActionListener(this);
                this.add(salvar, j);

                
                j.fill = GridBagConstraints.HORIZONTAL;
                j.gridx = 0;
                j.gridy = 1;
                this.add(dados[1], j);

            
                j.fill = GridBagConstraints.HORIZONTAL;
                j.weightx = 0.5;
                j.gridwidth = 2;
                j.gridx = 1;
                j.gridy = 1;
                this.add(inserir[1], j);
 
                novo = new JButton("Habilitar");
                j.fill = GridBagConstraints.HORIZONTAL;
                j.weightx = 0.5;
                j.gridx = 3;
                j.gridy = 1;
                novo.addActionListener(this);
                this.add(novo, j);
                
                limpar = new JButton("Limpar");
                limpar.setEnabled(false);
                j.fill = GridBagConstraints.HORIZONTAL;
                j.weightx = 0.5;
                j.gridx = 3;
                j.gridy = 2;
                limpar.addActionListener(this);
                this.add(limpar, j);
                
                voltar = new JButton("Voltar");
                j.fill = GridBagConstraints.HORIZONTAL;
                j.weightx = 0.5;
                j.gridx = 3;
                j.gridy = 3;
                voltar.addActionListener(this);
                this.add(voltar, j);

                setSize(900, 200);
                
                inserir[0].setEnabled(false);
                inserir[1].setEnabled(false);
                      
                this.setVisible(true);
              
                
      }
    
    public void salvar(){
            String a[] = new String[2];
            a[0] = inserir[0].getText();
            a[1] = inserir[1].getText();
  

            String b = "insert into pratos(nome, valor)"
                    + "values (\""+a[0]+"\", "+Double.parseDouble(a[1])+")";

            Conexao c = new Conexao();
            c.inserir_banco(b);
            
            JOptionPane.showMessageDialog(this,new JLabel("PRATO CADASTRADO"));
   } 

    private void novo(){
           salvar.setEnabled(true);  
           limpar.setEnabled(true);
           inserir[0].setEnabled(true);
           inserir[1].setEnabled(true);
    }
    
    private void limpar(){
        inserir[0].setText("");
        inserir[1].setText("");
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getActionCommand().equals("Salvar"))
             salvar();
            
        if(event.getActionCommand().equals("Voltar"))
             this.setVisible(false);    
        
        if(event.getActionCommand().equals("Habilitar"))
             novo();
        
        if(event.getActionCommand().equals("Limpar"))
              limpar();
                 
    }
}
       
    

