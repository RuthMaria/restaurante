


package restaurante;

import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class cadastrar_cliente extends JDialog implements ActionListener{
    
    JTextField inserir[] = new JTextField[5];
    
    JButton salvar;
    JButton voltar;
    JButton novo, limpar;
    JFormattedTextField cpf;
    JFormattedTextField celular;
    JFormattedTextField telefone;
    GridBagConstraints j = new GridBagConstraints();
    
    public cadastrar_cliente(){
     
                this.setLayout(new GridBagLayout());
                JLabel dados[] = new JLabel[5];
                dados[0] = new JLabel("Nome: \n");
                dados[1] = new JLabel("CPF: \n");
                dados[2] = new JLabel("Telefone: \n");
                dados[3] = new JLabel("Celular: \n");
                dados[4] = new JLabel("Endereço: \n");
                
                
                cpf = new javax.swing.JFormattedTextField();
                telefone = new javax.swing.JFormattedTextField();
                celular = new javax.swing.JFormattedTextField();
                 
                try {
                     cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
                     telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
                     celular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
                } catch (java.text.ParseException ex){
                     ex.printStackTrace();
                }

                
                
                for(int i = 0; i < 5; i++)
                     inserir[i] = new JTextField(45);
                
                this.setTitle("CADASTRO DE CLIENTE");
                
                this.setLayout(new GridBagLayout());
                

                j.fill = GridBagConstraints.HORIZONTAL;
                j.weightx = 0.5;
               
                j.insets = new Insets(10,30,0,30); 
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
                cpf.setEnabled(false);
                this.add(cpf, j);
                

                j.fill = GridBagConstraints.HORIZONTAL;
                j.gridx = 0;
                j.gridy = 2;
                this.add(dados[2], j);

               
                j.fill = GridBagConstraints.HORIZONTAL;
                j.weightx = 0.5;
                j.gridwidth = 2;
                j.gridx = 1;
                j.gridy = 2;
                telefone.setEnabled(false);
                this.add(telefone, j);

        
                j.fill = GridBagConstraints.HORIZONTAL;
                j.gridx = 0;
                j.gridy = 3;
                this.add(dados[3], j);

          
                j.fill = GridBagConstraints.HORIZONTAL;
                j.weightx = 0.5;
                j.gridwidth = 2;
                j.gridx = 1;
                j.gridy = 3;
                celular.setEnabled(false);
                this.add(celular, j);

               
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
                
                voltar= new JButton("Voltar");
                j.fill = GridBagConstraints.HORIZONTAL;
                j.weightx = 0.5;
                j.gridx = 3;
                j.gridy = 3;
                voltar.addActionListener(this);
                this.add(voltar, j);

                j.fill = GridBagConstraints.HORIZONTAL;
                j.gridx = 0;
                j.gridy = 4;
                this.add(dados[4], j);

            
                j.fill = GridBagConstraints.HORIZONTAL;
                j.weightx = 0.5;
                j.gridwidth = 2;
                j.gridx = 1;
                j.gridy = 4;
                
                this.add(inserir[4], j);
                setSize(900, 300);
                
                inserir[0].setEnabled(false);
                inserir[4].setEnabled(false);
                
                
                this.setVisible(true);
                
    }
    public void salvar(){
            String a[] = new String[5];
            a[0] = inserir[0].getText();
            a[1] = cpf.getText();
            a[2] = telefone.getText();
            a[3] = celular.getText();
            a[4] = inserir[4].getText();

            String b = "insert into cliente(cpf, nome_completo, telefone, celular, endereco) "
                     + "values (\""+a[1]+"\", \""+a[0]+"\", \""+a[2]+"\", \""+a[3]+"\", \"" +a[4]+"\")";
            
            String d = "SELECT * FROM cliente WHERE 1";
            Conexao c = new Conexao();
            c.inserir_banco(b);
            
            JOptionPane.showMessageDialog(this,new JLabel("CLIENTE CADASTRADO"));
   } 
    
    
   private void novo(){
          salvar.setEnabled(true);  
          limpar.setEnabled(true);
          inserir[0].setEnabled(true);
          cpf.setEnabled(true);
          telefone.setEnabled(true);
          celular.setEnabled(true);
          inserir[4].setEnabled(true);
   }

   private void limpar(){
        cpf.setText("");
        inserir[0].setText("");
        telefone.setText("");
        celular.setText("");
        inserir[4].setText("");
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
            