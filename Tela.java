import javax.swing.*;
import java.util.*;
import javax.swing.table.*;
public class Tela{
   
   public static void main(String []args){
      String[] colunas={"nome","idade","sexo","endereco","vegetariano(a)","esporte"};
      ArrayList<Pessoas> pessoas;
      
      FactoryPessoas fp= new FactoryPessoas();
      
      pessoas = fp.completaTabela();
      
      TableModel modelo = new TableModel(pessoas,colunas);
      
      JTable tabela = new JTable(modelo);
      JScrollPane scroll = new JScrollPane(tabela);
      JFrame frame = new JFrame(); 
      frame.getContentPane().add(scroll);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null);
      frame.pack();
      frame.setVisible(true);
   }
}