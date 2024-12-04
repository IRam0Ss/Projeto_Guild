package relacoes;

import conexoes.ConnectionFactory;
import modelos.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AmigoDe {

    public static void criarAmizade(Usuario usuario1, Usuario usuario2) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();

        String fazerAmizade = "INSERT INTO amigo_de(id_user, id_amigo) VALUES (?, ?)";

        PreparedStatement stmt = conexao.prepareStatement(fazerAmizade);
        stmt.setInt(1,usuario1.getIdUsuario());
        stmt.setInt(2,usuario2.getIdUsuario());

        stmt.executeUpdate();
        stmt.close();
        conexao.close();

        System.out.println("amizade entre " + usuario1.getApelido() + " e " + usuario2.getApelido() + " feita");

    }

    public static ArrayList<Usuario> mostrarAmizade(Usuario usuario) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();
        ArrayList<Usuario> amizades = new ArrayList<>();
        Usuario novoUsuario;

        String buscarAmizades = "SELECT * FROM amigo_de, usuario u where amigo_de.id_user = ? AND id_amigo = u.id_user";

        PreparedStatement stmt = conexao.prepareStatement(buscarAmizades);
        stmt.setInt(1, usuario.getIdUsuario());

        ResultSet resultado = stmt.executeQuery();

        while (resultado.next()) {
            Integer id_user = resultado.getInt("id_user");
            String username = resultado.getString("nome_user");
            String sobrenome = resultado.getString("sobrenome");
            String email_user = resultado.getString("email_user");
            Integer idade = resultado.getInt("idade");
            String apelido_no_sistema = resultado.getString("apelido_no_sistema");

            novoUsuario = new Usuario(id_user, username, sobrenome, email_user, idade, apelido_no_sistema);
            amizades.add(novoUsuario);
        }
        stmt.close();
        conexao.close();
        return amizades;
    }

    public static boolean conferirAmizade(Usuario usuario1, Usuario usuario2) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();

        String confirmarAmizade = "SELECT * FROM amigo_de WHERE id_user = ? AND id_amigo = ?";
        PreparedStatement stmt = conexao.prepareStatement(confirmarAmizade);
        stmt.setInt(1, usuario1.getIdUsuario());
        stmt.setInt(2, usuario2.getIdUsuario());

        stmt.executeQuery();

        ResultSet resultado = stmt.executeQuery();

        if (resultado.next()) {
            return true;
        }else{
            return false;
        }

    }

    public static void removerAmizade(Usuario usuario1, Usuario usuario2) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();

        if(conferirAmizade(usuario1, usuario2)) {
            String removerAmizade = "DELETE FROM amigo_de WHERE id_user = ? AND id_amigo = ?";
            PreparedStatement stmt = conexao.prepareStatement(removerAmizade);
            stmt.setInt(1, usuario1.getIdUsuario());
            stmt.setInt(2, usuario2.getIdUsuario());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            System.out.println("amizade removido com sucesso");
        }else {
            System.out.println("amizade nao existe");
        }

    }
}
