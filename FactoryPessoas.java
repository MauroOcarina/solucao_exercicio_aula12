import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class FactoryPessoas{
   ConexaoBD bd =null;
   Connection conn=null;
   ResultSet rs = null;
   PreparedStatement ps=null;
   ArrayList<Pessoas> pessoas= new ArrayList<Pessoas>();
   
   String stmt= "SELECT * FROM pessoas";
   
   public ArrayList completaTabela(){
      try{
        bd = new ConexaoBD();
        int idade;
        String nome;
        String sexo;
        String endereco;
        String esporte;
        boolean vegetariano;
        conn = bd.conectar();
        ps = conn.prepareStatement(stmt);
        rs = ps.executeQuery();
        int i = 0;
        while(rs.next()){
        Pessoas pessoa = new Pessoas();
        nome = rs.getString("nome_p");
        idade = rs.getInt("idade");
        sexo = rs.getString("sexo");   
        endereco = rs.getString("endereco");
        vegetariano = rs.getBoolean("vegetarian");
        esporte = rs.getString("fk_nome_e");  
        
        pessoa.setNome(nome);
        pessoa.setIdade(idade);
        pessoa.setSexo(sexo);
        pessoa.setEndereco(endereco);
        pessoa.setVegetariano(vegetariano);
        pessoa.setEsporte(esporte);
        
        pessoas.add(pessoa);             
        }
        ps.close();
        rs.close();
        return pessoas;

      }
      catch(SQLException e){
         e.printStackTrace();
         return pessoas;
      }
      finally{
         try{
            
            if (conn != null){
               conn.close(); 
            }
            
         }catch(SQLException t){
            t.printStackTrace();
         }
      }  
   }
}