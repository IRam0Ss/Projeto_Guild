package controles;

import conexoes.ConnectionFactory;
import modelos.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControleUsuario {


    public static void cadastrarUsuario(Usuario usuario) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();

        String comandInsert = "INSERT INTO usuario (nome_user, sobrenome, email_user, idade, apelido_no_sistema) VALUES(?,?,?,?,?)";

        PreparedStatement pstm = conexao.prepareStatement(comandInsert);

        pstm.setString(1, usuario.getNome());
        pstm.setString(2, usuario.getSobrenome());
        pstm.setString(3, usuario.getEmail());
        pstm.setInt(4, usuario.getIdade());
        pstm.setString(5, usuario.getApelido());

        pstm.executeUpdate();

        System.out.println("novo usuario inserido com sucesso!");

        pstm.close();
        conexao.close();

    }

    public static ArrayList<Usuario> buscarUsuarioNome(String nome_user) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();

        String comandSelect = "SELECT * FROM usuario WHERE nome_user = ?";

        PreparedStatement pstm = connection.prepareStatement(comandSelect);

        pstm.setString(1, nome_user);

        ResultSet resultSearch = pstm.executeQuery();

        ArrayList<Usuario> usuarios = new ArrayList<>();

        while (resultSearch.next()){
            Integer id_user = resultSearch.getInt("id_user");
            String username = resultSearch.getString("nome_user");
            String sobrenome = resultSearch.getString("sobrenome");
            String email_user = resultSearch.getString("email_user");
            Integer idade = resultSearch.getInt("idade");
            String apelido_no_sistema = resultSearch.getString("apelido_no_sistema");

            Usuario usuario = new Usuario(id_user, username, sobrenome, email_user, idade, apelido_no_sistema);

            usuarios.add(usuario);
        }

        connection.close();

        return usuarios;
    }// search for name

    public static Usuario buscarUsuarioApelido(String nickname) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();

        String comandSelect = "SELECT * FROM usuario WHERE apelido_no_sistema = ?";

        PreparedStatement pstm = conexao.prepareStatement(comandSelect);

        pstm.setString(1, nickname);

        ResultSet resultSearch = pstm.executeQuery();

        Usuario novoUsuario = new Usuario();

        while (resultSearch.next()){
            Integer id_user = resultSearch.getInt("id_user");
            String username = resultSearch.getString("nome_user");
            String sobrenome = resultSearch.getString("sobrenome");
            String email_user = resultSearch.getString("email_user");
            Integer idade = resultSearch.getInt("idade");
            String apelido_no_sistema = resultSearch.getString("apelido_no_sistema");

            novoUsuario = new Usuario(id_user, username, sobrenome, email_user, idade, apelido_no_sistema);
        }

        pstm.close();
        conexao.close();

        return novoUsuario;
    } // search for nickname

    public static Usuario buscarUsuarioId(int id) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();

        String comandSelect = "SELECT * FROM usuario WHERE id_user = ?";

        PreparedStatement pstm = conexao.prepareStatement(comandSelect);
        pstm.setInt(1, id);

        ResultSet resultSearch = pstm.executeQuery();

        Usuario usuario;

        if (resultSearch.next()){
            Integer id_user = resultSearch.getInt("id_user");
            String username = resultSearch.getString("nome_user");
            String sobrenome = resultSearch.getString("sobrenome");
            String email_user = resultSearch.getString("email_user");
            Integer idade = resultSearch.getInt("idade");
            String apelido_no_sistema = resultSearch.getString("apelido_no_sistema");

            usuario = new Usuario(id_user, username, sobrenome, email_user, idade, apelido_no_sistema);
        }else{
            System.out.println("id nao encontrado!");
            conexao.close();
            return null;
        }

        pstm.close();
        conexao.close();

        return usuario;
    }

    public static void removerUsuario(Usuario usuario) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();

        String comandRemove = "DELETE FROM usuario WHERE id_user = ?";

        PreparedStatement pstm = conexao.prepareStatement(comandRemove);
        pstm.setInt(1, usuario.getIdUsuario());

        int rowsDeleted = pstm.executeUpdate();

        System.out.println("Linhas deletadas " + rowsDeleted);

        pstm.close();
        conexao.close();

    }

}
