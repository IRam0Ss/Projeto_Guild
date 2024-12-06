package controles;

import conexoes.ConnectionFactory;
import modelos.SistemaRPG;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControleSistemaRPG {

    public static void cadastrarSistema(SistemaRPG sistema) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();

        String inserirSistema = "INSERT INTO sistema_rpg(nome_sistema, tipo_dado, descricao) VALUES (?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(inserirSistema);

        stmt.setString(1, sistema.getNome_sistema());
        stmt.setString(2, sistema.getTipo_dado());
        stmt.setString(3, sistema.getDescricao());

        stmt.executeUpdate();

        System.out.println("Sistema cadastrado com sucesso!");

        stmt.close();
        conexao.close();
    }

    public static SistemaRPG buscarSistemaNome(String nome_sistema) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();

        String buscarSistema = "SELECT * FROM sistema_rpg WHERE nome_sistema = ?";

        PreparedStatement stmt = conexao.prepareStatement(buscarSistema);
        stmt.setString(1, nome_sistema);

        ResultSet resultado = stmt.executeQuery();

        SistemaRPG sistemaEncontrado;

        if (resultado.next()) {
            Integer id_sistema = resultado.getInt("id_sistema");
            String tipo_dado = resultado.getString("tipo_dado");
            String descricao = resultado.getString("descricao");

            sistemaEncontrado = new SistemaRPG(id_sistema, nome_sistema,tipo_dado,descricao);

            stmt.close();
            conexao.close();

            return sistemaEncontrado;
        }else{
            System.out.println("sistema nao encontrado");
            stmt.close();
            conexao.close();
            return null;
        }

    }

    public static SistemaRPG buscarSistemaID(Integer id_sistema) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();
        String buscarSistema = "SELECT * FROM sistema_rpg WHERE id_sistema = ?";

        PreparedStatement stmt = conexao.prepareStatement(buscarSistema);
        stmt.setInt(1, id_sistema);

        ResultSet resultado = stmt.executeQuery();

        SistemaRPG sistemaEncontrado;

        if (resultado.next()) {
            String nome_sistema = resultado.getString("nome_sistema");
            String tipo_dado = resultado.getString("tipo_dado");
            String descricao = resultado.getString("descricao");

            sistemaEncontrado = new SistemaRPG(id_sistema, nome_sistema,tipo_dado,descricao);

            stmt.close();
            conexao.close();

            return sistemaEncontrado;
        }else{
            System.out.println("sistema nao encontrado");
            stmt.close();
            conexao.close();
            return null;
        }
    }

    public static void removerSistema(SistemaRPG sistema) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();

        String remover = "DELETE FROM sistema_rpg WHERE id_sistema = ?";
        PreparedStatement stmt = conexao.prepareStatement(remover);

        stmt.setInt(1, sistema.getId_sistema());

        int linhasDeletadas = stmt.executeUpdate();

        System.out.println("linhas deletadas: " + linhasDeletadas);

        stmt.close();
        conexao.close();
    }
}
