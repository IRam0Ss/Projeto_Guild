import controles.*;
import modelos.*;
import relacoes.AmigoDe;
import relacoes.Participa;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        Scanner input = new Scanner(System.in);

        int userChoice;

        //ControleJogador.removerJogador(ControleJogador.buscarJogadorId(7));
        //ControleUsuario.removerUsuario(ControleUsuario.buscarUsuarioId(6));

        //ControleJogador.cadastrarJogador(new Jogador("Iury", "Ramos", "tesste@teste", 20,"cenouraGam"));

       // ControleMestre.cadastrarMestre(new Mestre("Patrique", "Rodrigues", "rodrigues@teste.com", 19, "mestreArrombado"));
       // ControleMestre.cadastrarMestre(new Mestre("Lucas", "Chaves", "chaves@teste.com", 19, "ehMestre?"));
       // ControleMestre.cadastrarMestre(new Mestre("Rafa", "Pinto", "pinto@teste.com", 19, "cadeMnM"));

        //System.out.println(ControleMestre.buscarMestreApelido("mestreArrombado"));

        //ControleMestre.removerMestre(ControleMestre.buscarMestreId(10));
        //ControleUsuario.removerUsuario(ControleUsuario.buscarUsuarioNome("Lucas").getFirst());

        //ControleSistemaRPG.cadastrarSistema(new SistemaRPG("D&D", "d20", "Sistema de alta fantasia medieval"));
        //ControleSistemaRPG.cadastrarSistema(new SistemaRPG("Ordem Paranormal", "d20", "Sistema de fantasia moderno, com ambientacao de terror"));

        //ControleSistemaRPG.removerSistema(ControleSistemaRPG.buscarSistemaNome("Ordem Paranormal"));

        //Mestre mestre = ControleMestre.buscarMestreApelido("mestreArrombado");
        //SistemaRPG sistema = ControleSistemaRPG.buscarSistemaNome("Ordem Paranormal");
        //Mesa mesa = new Mesa("Iter", "outro teste ", mestre.getId_mestre(), sistema.getId_sistema());

        //ControleMesa.cadastrarMesa(mesa);
        Mesa mesa = ControleMesa.buscarMesaId(2);
        //ControleMesa.removerMesa(mesa);

        //AmigoDe.criarAmizade(ControleUsuario.buscarUsuarioApelido("mestreArrombado"), ControleUsuario.buscarUsuarioApelido("ehMestre?"));

        //Usuario testeUser1 = ControleUsuario.buscarUsuarioApelido("cenouraG");
        //Usuario testeUser2 = ControleUsuario.buscarUsuarioApelido("mestreArrombado");
        //AmigoDe.removerAmizade(testeUser2,testeUser1);

        //Jogador novoJogador = new Jogador("Luan", "Alves", "luanzin@gmail.com", 21, "LuanGamePlays");
        //ControleJogador.cadastrarJogador(novoJogador);
        Jogador jogador = ControleJogador.buscarJogadorApelido("LuanGamePlays");
        //Participa.participar(jogador, mesa);

        //Participa.removerParticipacao(ControleJogador.buscarJogadorApelido("cenouraG"),mesa);

        System.out.println(Participa.mesasQueParticipa(jogador));
    }
}
