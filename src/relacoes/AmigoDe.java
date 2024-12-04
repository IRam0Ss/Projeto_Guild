package relacoes;

import conexoes.ConnectionFactory;
import modelos.Usuario;

import java.sql.Connection;
import java.sql.SQLException;

public class AmigoDe {

    public static void criarAmizade(Usuario usuario1, Usuario usuario2) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();
    }

}
