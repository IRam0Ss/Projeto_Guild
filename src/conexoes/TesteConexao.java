package conexoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();

        System.out.println("conexao aberta");

        String sql = "INSERT INTO sistema_rpg (id_sistema, nome_sistema, tipo_dado, descricao) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, 1);
        stmt.setString(2, "Teste");
        stmt.setString(3, "dteste");
        stmt.setString(4, "eh um teste");

        stmt.executeUpdate();

        System.out.println("dados inseridos com sucesso");

        conexao.close();
    }
}
