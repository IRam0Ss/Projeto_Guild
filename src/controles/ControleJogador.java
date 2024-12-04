package controles;

import conexoes.ConnectionFactory;
import modelos.Jogador;

import java.sql.*;

public class ControleJogador {

    public static void cadastrarJogador(Jogador jogador) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();

        String inserirUsuario = "INSERT INTO usuario (nome_user, sobrenome, email_user, idade, apelido_no_sistema) VALUES(?,?,?,?,?)";
        String inserirJogador = "INSERT INTO jogador(id_jogador) VALUES(?)";

        PreparedStatement pstm = conexao.prepareStatement(inserirUsuario, Statement.RETURN_GENERATED_KEYS);

        pstm.setString(1, jogador.getNome());
        pstm.setString(2, jogador.getSobrenome());
        pstm.setString(3, jogador.getEmail());
        pstm.setInt(4, jogador.getIdade());
        pstm.setString(5, jogador.getApelido());

        pstm.executeUpdate();

        ResultSet idGerado = pstm.getGeneratedKeys();

        if (idGerado.next()) {

            int idJogador = idGerado.getInt(1);

            pstm = conexao.prepareStatement(inserirJogador);
            pstm.setInt(1,idJogador);
            pstm.executeUpdate();

            System.out.println("novo jogador inserido com sucesso!");
        }


        pstm.close();
        conexao.close();
    }

    public static Jogador buscarJogadorId(int id) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();

        String comandSelect = "SELECT * FROM jogador,usuario WHERE id_jogador = ? AND id_user = id_jogador";

        PreparedStatement pstm = conexao.prepareStatement(comandSelect);

        pstm.setInt(1, id);

        ResultSet resultado = pstm.executeQuery();

        Jogador jogador;

        if (resultado.next()) {
            Integer id_user = resultado.getInt("id_jogador");
            String username = resultado.getString("nome_user");
            String sobrenome = resultado.getString("sobrenome");
            String email_user = resultado.getString("email_user");
            Integer idade = resultado.getInt("idade");
            String apelido_no_sistema = resultado.getString("apelido_no_sistema");

            jogador = new Jogador(id_user, username, sobrenome, email_user, idade, apelido_no_sistema);
        }else{
            System.out.println("id nao encontrado!");
            conexao.close();
            return null;
        }

        conexao.close();

        return jogador;
    }

    public static Jogador buscarJogadorApelido(String apelido) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();

        String buscarJogador = "SELECT * FROM jogador, usuario WHERE id_jogador = id_user AND apelido_no_sistema = ?";

        PreparedStatement stmt = conexao.prepareStatement(buscarJogador);
        stmt.setString(1, apelido);

        ResultSet resultado = stmt.executeQuery();
        Jogador novoJogador;
        if (resultado.next()) {
            Integer id_user = resultado.getInt("id_jogador");
            String username = resultado.getString("nome_user");
            String sobrenome = resultado.getString("sobrenome");
            String email_user = resultado.getString("email_user");
            Integer idade = resultado.getInt("idade");

            novoJogador = new Jogador(id_user, username, sobrenome, email_user, idade, apelido);

            stmt.close();
            conexao.close();
            return novoJogador;
        } else {
            System.out.println("mestre nao encontrado");
            stmt.close();
            conexao.close();
            return null;
        }
    }

    public static void removerJogador(Jogador jogador) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();

        String comandRemove = "DELETE FROM jogador WHERE id_jogador = ?";

        PreparedStatement pstm = conexao.prepareStatement(comandRemove);
        pstm.setInt(1, jogador.getIdJogador());

        int rowsDeleted = pstm.executeUpdate();

        System.out.println("Linhas deletadas " + rowsDeleted);

        pstm.close();
        conexao.close();

    }

}
