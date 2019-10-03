



package restaurante;

import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class reserva extends JDialog implements ActionListener{
    
         JTextField inserir[] = new JTextField[3];
         private final int mesas = 50;
         int l ;
         JButton salvar;
         JButton voltar;
         JButton novo, limpar;
         JFormattedTextField cpf;
         JFormattedTextField data_reserva;
         
         public reserva(){
                
                   this.setLayout(new GridBagLayout());
                
                    JLabel dados[] = new JLabel[3];
                
                
                    dados[0] = new JLabel("Numero: \n");
                    dados[1] = new JLabel("Data da reserva: \n");
                    dados[2] = new JLabel("CPF do cliente: \n");
                    
                    cpf = new javax.swing.JFormattedTextField();
                    data_reserva = new javax.swing.JFormattedTextField();
                    
                     
                    try {
                         cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
                         data_reserva.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
                   
                   } catch (java.text.ParseException ex){
                        ex.printStackTrace();
                   }

                   for(int i = 0; i < 3; i++)
                             inserir[i] = new JTextField(45);

                    this.setTitle("RESERVA");
                    
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
                    data_reserva.setEnabled(false);
                    this.add(data_reserva, j);

                    j.fill = GridBagConstraints.HORIZONTAL;
                    j.gridx = 0;
                    j.gridy = 2;
                    this.add(dados[2], j);


                    j.fill = GridBagConstraints.HORIZONTAL;
                    j.weightx = 0.5;
                    j.gridwidth = 2;
                    j.gridx = 1;
                    j.gridy = 2;
                    cpf.setEnabled(false);
                    this.add(cpf, j);

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
                    
                    this.setVisible(true);
 
      }
         
      public void salvar(){
            String s = "select count(*) from reserva where limite = true";
            Conexao c = new Conexao();
            
            int i = 0;
            try{
                c.ver_banco(s);
                c.resultSet.next();
                i = c.resultSet.getInt(1);
                System.out.println(c.resultSet.getInt(1));

            }catch(SQLException e){
                e.printStackTrace();
            }
            finally{
                c.fechaConexão();
            }

            if(i < mesas){
                String a[] = new String[3];
                a[0] = inserir[0].getText();
                a[1] = data_reserva.getText();
                a[2] = cpf.getText();


                String b = "insert into reserva(cpf_cliente, numero_mesa, data_reserva, limite)"
                        + "values (\""+a[2]+"\", "+Integer.parseInt(a[0])+", \""+a[1]+"\", true)";

                c = new Conexao();
                c.inserir_banco(b);

                JOptionPane.showMessageDialog(this,new JLabel("RESERVA REALIZADA COM SUCESSO"));
            
            }
                
                else{
                     JOptionPane.showMessageDialog(this,new JLabel("NÃO HÁ MAIS MESAS PARA RESERVAS"));
                }
     } 
      
     private void novo(){
          salvar.setEnabled(true); 
          limpar.setEnabled(true);
          inserir[0].setEnabled(true);
          data_reserva.setEnabled(true);
          cpf.setEnabled(true);
     }
     
      private void limpar(){
        inserir[0].setText("");
        cpf.setText("");
        data_reserva.setText("");
     }
      
    @Override
    public void actionPerformed(ActionEvent event) {
       if(event.getActionCommand().equals("Salvar"))
              salvar();
            
       if(event.getActionCommand().equals("Voltar"))
               this.setVisible(false);  
       
       if(event.getActionCommand().equals("Habilitar"))
               novo();
        if(event.getActionCommand().equals("Limpar")){
              limpar();
        }
    }
}
