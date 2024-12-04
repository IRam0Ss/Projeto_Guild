import controles.*;
import modelos.Mesa;
import relacoes.AmigoDe;

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

       // Mestre mestre = ControleMestre.buscarMestreApelido("ehMestre?");
        //SistemaRPG sistema = ControleSistemaRPG.buscarSistemaNome("D&D");
        //Mesa mesa = new Mesa("mesaTeste", "mesa de teste do sistema", mestre.getId_mestre(), sistema.getId_sistema());

        //ControleMesa.cadastrarMesa(mesa);
        //Mesa mesa = ControleMesa.buscarMesaId(1);
        //ControleMesa.removerMesa(mesa);

        AmigoDe.criarAmizade(ControleUsuario.buscarUsuarioApelido("mestreArrombado"), ControleUsuario.buscarUsuarioApelido("cenouraG"));

    }
}
