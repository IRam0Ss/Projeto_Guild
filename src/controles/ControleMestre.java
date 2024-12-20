package controles;

import conexoes.ConnectionFactory;
import modelos.Mestre;

import java.sql.*;

public class ControleMestre {


    public static void cadastrarMestre(Mestre mestre) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();

        String inserirUsuario = "INSERT INTO usuario (nome_user, sobrenome, email_user, idade, apelido_no_sistema) VALUES(?,?,?,?,?)";
        String inserirMestre = "INSERT INTO mestre(id_mestre) VALUES(?)";

        PreparedStatement stmt = conexao.prepareStatement(inserirUsuario, Statement.RETURN_GENERATED_KEYS);

        stmt.setString(1, mestre.getNome());
        stmt.setString(2, mestre.getSobrenome());
        stmt.setString(3, mestre.getEmail());
        stmt.setInt(4, mestre.getIdade());
        stmt.setString(5, mestre.getApelido());

        stmt.executeUpdate();

        ResultSet idGerado = stmt.getGeneratedKeys();

        if(idGerado.next()){
            int id_mestre = idGerado.getInt(1);

            stmt = conexao.prepareStatement(inserirMestre);
            stmt.setInt(1, id_mestre);

            stmt.executeUpdate();

            System.out.println("Mestre cadastrado com sucesso!");
        }

        stmt.close();
        conexao.close();
    }

    public static Mestre buscarMestreId(int idMestre) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();

        String buscarMestre = "SELECT * FROM usuario,mestre WHERE id_mestre = ? AND id_mestre = id_user";

        PreparedStatement stmt = conexao.prepareStatement(buscarMestre);
        stmt.setInt(1, idMestre);

        ResultSet resultado = stmt.executeQuery();

        Mestre novoMestre;
        if(resultado.next()){
            Integer id_user = resultado.getInt("id_mestre");
            String username = resultado.getString("nome_user");
            String sobrenome = resultado.getString("sobrenome");
            String email_user = resultado.getString("email_user");
            Integer idade = resultado.getInt("idade");
            String apelido_no_sistema = resultado.getString("apelido_no_sistema");

            novoMestre = new Mestre(id_user, username, sobrenome, email_user, idade, apelido_no_sistema);
        }else {
            System.out.println("id nao encontrado");
            stmt.close();
            conexao.close();
            return null;
        }

        stmt.close();
        conexao.close();

        return novoMestre;

    }

    public static Mestre buscarMestreApelido(String apelido) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();

        String buscarMestre = "SELECT * FROM mestre, usuario WHERE id_mestre = id_user AND apelido_no_sistema = ?";

        PreparedStatement stmt = conexao.prepareStatement(buscarMestre);
        stmt.setString(1, apelido);

        ResultSet resultado = stmt.executeQuery();
        Mestre novoMestre;
        if(resultado.next()){
            Integer id_user = resultado.getInt("id_mestre");
            String username = resultado.getString("nome_user");
            String sobrenome = resultado.getString("sobrenome");
            String email_user = resultado.getString("email_user");
            Integer idade = resultado.getInt("idade");

            novoMestre = new Mestre(id_user,username,sobrenome,email_user,idade,apelido);

            stmt.close();
            conexao.close();
            return novoMestre;
        }else {
            System.out.println("mestre nao encontrado");
            stmt.close();
            conexao.close();
            return null;
        }
    }

    public static void removerMestre(Mestre mestre) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();

        String removerMestre = "DELETE FROM mestre WHERE id_mestre = ?";

        PreparedStatement stmt = conexao.prepareStatement(removerMestre);
        stmt.setInt(1, mestre.getId_mestre());

        int linhasRemovidas = stmt.executeUpdate();
        System.out.println("linhas removidas = " + linhasRemovidas);

        stmt.close();
        conexao.close();
    }

}
