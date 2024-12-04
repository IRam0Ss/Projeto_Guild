package controles;

import conexoes.ConnectionFactory;
import modelos.Mesa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControleMesa {

    public static void cadastrarMesa(Mesa mesa) throws SQLException {

        Connection conexao = ConnectionFactory.getConnection();

        String inserirMesa = "INSERT INTO mesa (nome_mesa, descricao_mesa, id_mestre_mesa, id_sistema_mesa) VALUES (?,?,?,?)";

        PreparedStatement stmt = conexao.prepareStatement(inserirMesa);
        stmt.setString(1, mesa.getNome_mesa());
        stmt.setString(2, mesa.getDescricao_mesa());
        stmt.setInt(3, mesa.getId_mestre_mesa());
        stmt.setInt(4, mesa.getId_sistema_mesa());

        System.out.println("nova mesa cadastrada com sucesso");

        stmt.executeUpdate();
        stmt.close();

    }

    public static void removerMesa(Mesa mesa) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();

        String removerMesa = "DELETE FROM mesa WHERE id_mesa = ?";
        PreparedStatement stmt = conexao.prepareStatement(removerMesa);
        stmt.setInt(1, mesa.getId_mesa());

        int numeroLinhas = stmt.executeUpdate();
        System.out.println("linhas afetadas = " + numeroLinhas);
        stmt.close();
        conexao.close();

    }

    public static Mesa buscarMesaId(Integer id_mesa) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();
        String buscarMesa = "SELECT * FROM mesa WHERE id_mesa = ?";
        PreparedStatement stmt = conexao.prepareStatement(buscarMesa);
        stmt.setInt(1, id_mesa);

        ResultSet resultado = stmt.executeQuery();

        Mesa mesa;
        if (resultado.next()) {
            Integer idMesa = resultado.getInt("id_mesa");
            String nomeMesa = resultado.getString("nome_mesa");
            String descricaoMesa = resultado.getString("descricao_mesa");
            Integer idMestreMesa = resultado.getInt("id_mestre_mesa");
            Integer idSistemaMesa = resultado.getInt("id_sistema_mesa");

            mesa = new Mesa(idMesa, nomeMesa, descricaoMesa, idMestreMesa, idSistemaMesa);
            stmt.close();
            conexao.close();
            return mesa;
        }else{
            System.out.println("mesa nao encontrada");
            stmt.close();
            conexao.close();
            return null;
        }
    }

}
