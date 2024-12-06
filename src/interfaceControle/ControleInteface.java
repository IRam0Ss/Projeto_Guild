package interfaceControle;

import controles.*;
import modelos.*;

import java.sql.SQLException;
import java.util.ArrayList;

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

    public void removerUsuario(Integer id) throws SQLException {
        Usuario usuarioRemovido = ControleUsuario.buscarUsuarioId(id);
        ControleUsuario.removerUsuario(usuarioRemovido);
        System.out.println(usuarioRemovido + " removido com sucesso");
    }

    public void removerSistema(Integer id) throws SQLException {
        SistemaRPG sistemaRemovido = ControleSistemaRPG.buscarSistemaID(id);
        ControleSistemaRPG.removerSistema(sistemaRemovido);
        System.out.println(sistemaRemovido + " removido com sucesso");
    }

    public void removerMesa(Integer id) throws SQLException {
        Mesa mesaRemovida = ControleMesa.buscarMesaId(id);
        ControleMesa.removerMesa(mesaRemovida);
        System.out.println(mesaRemovida + " removido com sucesso");
    }

    public void buscarUserNome (String nomeBusca) throws SQLException {
        ArrayList<Usuario> usuariosComNome = ControleUsuario.buscarUsuarioNome(nomeBusca);
        System.out.println(usuariosComNome);
    }

    public void buscarUserID (Integer id) throws SQLException {
        Usuario usuarioBusca = ControleUsuario.buscarUsuarioId(id);
        System.out.println(usuarioBusca);
    }

    public void buscarUserApelido (String apelido) throws SQLException {
        Usuario usuarioBusca = ControleUsuario.buscarUsuarioApelido(apelido);
        System.out.println(usuarioBusca);
    }

    public void buscarMestreId (Integer id) throws SQLException {
        Mestre mestreBusca = ControleMestre.buscarMestreId(id);
        System.out.println(mestreBusca);
    }

    public void buscarMestreApelido (String apelido) throws SQLException {
        Mestre mestreBusca = ControleMestre.buscarMestreApelido(apelido);
        System.out.println(mestreBusca);
    }

    public void buscarJogadorId (Integer id) throws SQLException {
        Jogador jogadorBusca = ControleJogador.buscarJogadorId(id);
        System.out.println(jogadorBusca);
    }

    public void buscarJogadorApelido (String apelido) throws SQLException {
        Jogador jogadorBusca = ControleJogador.buscarJogadorApelido(apelido);
        System.out.println(jogadorBusca);
    }

    public void buscarMesaId (Integer id) throws SQLException {
        Mesa mesaBusca = ControleMesa.buscarMesaId(id);
        System.out.println(mesaBusca);
    }
    public void buscarSistemaId (Integer id) throws SQLException {
        SistemaRPG sistemaBusca = ControleSistemaRPG.buscarSistemaID(id);
        System.out.println(sistemaBusca);
    }


}
