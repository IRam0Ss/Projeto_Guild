package interfaceControle;

import controles.ControleJogador;
import controles.ControleMesa;
import controles.ControleMestre;
import controles.ControleSistemaRPG;
import modelos.Jogador;
import modelos.Mesa;
import modelos.Mestre;
import modelos.SistemaRPG;

import java.sql.SQLException;

public class ControleInteface {

    public boolean registrarUsuario(String nome, String sobrenome, String email, String idadeStr, String apelido, String tipo) throws SQLException {

        int idade = Integer.parseInt(idadeStr);

        if(tipo.toLowerCase().replace(" ", "").equals("jogador")){ //  opcao jogador
            Jogador novoJogador = new Jogador(nome, sobrenome, email, idade, apelido);
            ControleJogador.cadastrarJogador(novoJogador);
            return true;
        }else if(tipo.toLowerCase().replace(" ","").equals("mestre")){ //  opcao mestre
            Mestre novoMestre = new Mestre(nome, sobrenome, email, idade, apelido);
            ControleMestre.cadastrarMestre(novoMestre);
            return true;
        }else{
            System.out.println("opcao invalida");
            return false;
        }
    }

    public void registrarSistema(String nome, String tipoDado, String descricao) throws SQLException {
        SistemaRPG novoSistema = new SistemaRPG(nome, tipoDado, descricao);
        ControleSistemaRPG.cadastrarSistema(novoSistema);

    }

    public void registrarMesa(String nome, String descricao, String apelidoMestre, String nomeSistema) throws SQLException {
        Mestre mestreMesa = ControleMestre.buscarMestreApelido(apelidoMestre);
        SistemaRPG sistemaMesa = ControleSistemaRPG.buscarSistemaNome(nomeSistema);

        if (sistemaMesa == null) {
            System.out.println("Sistema nao encontrado");
        }if (mestreMesa == null) {
            System.out.println("Mesa nao encontrado");
        }else {
            Mesa novaMesa = new Mesa(nome, descricao, mestreMesa.getId_mestre(), sistemaMesa.getId_sistema());
            ControleMesa.cadastrarMesa(novaMesa);
        }
    }

}
