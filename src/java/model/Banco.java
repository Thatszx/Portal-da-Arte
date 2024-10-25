
package model; // a pasta onde fica o arquivo

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Banco {

    public static Connection conexao = null; // objeto responsável pela conexão com o banco, é static para ser 
    //único no projeto
    public PreparedStatement comando = null; // objeto que envia sql para o banco
    public ResultSet tabela = null; //objeto que armazena o resultado de consultas com tabela

    public Banco() throws Exception {
        try {
            Class.forName("org.postgresql.Driver");//registra o driver, informa que o driver será utilzado
            if ((conexao == null) || (conexao.isClosed())) {
                conexao = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/lpb", "postgres", "ifsp");
            }
        } catch (Exception ex) {
            throw new Exception("Erro de conexao:" + ex.getMessage());
        }

    }

} 

