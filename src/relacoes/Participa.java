package relacoes;

import conexoes.ConnectionFactory;
import modelos.Jogador;
import modelos.Mesa;
import modelos.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Participa {

    public static void participar(Jogador jogador, Mesa mesa) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();

        String inserirParticipante = "INSERT INTO participa(id_mesa, id_jogador) VALUES(?,?)";
        PreparedStatement stmt = conexao.prepareStatement(inserirParticipante);

        stmt.setInt(1,mesa.getId_mesa());
        stmt.setInt(2,jogador.getIdJogador());

        stmt.executeUpdate();
        stmt.close();
        conexao.close();

        System.out.println("Jogador "+ jogador.getApelido() + " adicionado a mesa " + mesa.getNome_mesa());
    }

    public static boolean conferirParticipacao(Jogador jogador, Mesa mesa) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();

        String conferirParticipacao = "SELECT * FROM participa WHERE id_jogador = ? AND id_mesa = ?";
        PreparedStatement stmt = conexao.prepareStatement(conferirParticipacao);
        stmt.setInt(1, jogador.getIdUsuario());
        stmt.setInt(2, mesa.getId_mesa());

        stmt.executeQuery();

        ResultSet resultado = stmt.executeQuery();

        if (resultado.next()) {
            return true;
        }else{
            return false;
        }

    }

    public static void removerParticipacao(Jogador jogador, Mesa mesa) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();

        if (conferirParticipacao(jogador, mesa)) {
            String removerAmizade = "DELETE FROM participa WHERE id_jogador = ? AND id_mesa = ?";
            PreparedStatement stmt = conexao.prepareStatement(removerAmizade);
            stmt.setInt(1,jogador.getIdJogador());
            stmt.setInt(2,mesa.getId_mesa());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();

            System.out.println("participacao removida com sucesso");
        }else{
            System.out.println("participacao nao existente");
        }

    }

    public static ArrayList<Mesa> mesasQueParticipa(Jogador jogador) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();

        ArrayList<Mesa> mesas  = new ArrayList<>();
        Mesa mesaParticipa;

        String consultaMesas = "SELECT * FROM participa, mesa WHERE participa.id_jogador = ? AND participa.id_mesa = mesa.id_mesa";
        PreparedStatement stmt = conexao.prepareStatement(consultaMesas);
        stmt.setInt(1,jogador.getIdJogador());

        stmt.executeQuery();
        ResultSet resultado = stmt.executeQuery();
        while (resultado.next()) {
            Integer id_mesa = resultado.getInt("id_mesa");
            String nome_mesa = resultado.getString("nome_mesa");
            String descricao_mesa = resultado.getString("descricao_mesa");
            Integer id_mestre_mesa = resultado.getInt("id_mestre_mesa");
            Integer id_sistema_mesa = resultado.getInt("id_sistema_mesa");

            Mesa nova_mesa = new Mesa(id_mesa, nome_mesa, descricao_mesa, id_mestre_mesa, id_sistema_mesa);
            mesas.add(nova_mesa);

        }

        return mesas;
    }
}
