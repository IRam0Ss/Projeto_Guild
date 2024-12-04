package relacoes;

import conexoes.ConnectionFactory;
import modelos.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
