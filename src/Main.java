import controles.*;
import modelos.*;
import relacoes.AmigoDe;
import relacoes.Participa;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        Scanner input = new Scanner(System.in);

        int opcaoUsuario=0;

        do{
            System.out.println("----- ----- ----- MENU ----- ----- -----");
            System.out.println("1. Menu de Usuario (cadastro, remocao, consultas)");
            System.out.println("2. Menu de Mesas (cadastro, remocao, consultas)");
            System.out.println("3. Menu de Sistemas (cadastro, remocao, consultas)");
            System.out.println("4. Menu de Relacoes (amizade entre usuarios, e participacao de mesas)");
            System.out.println("5. Menu de consultas do BD");
            System.out.println("");
            System.out.println("0. Sair");
            System.out.println("----- ----- ----- ----- ----- ----- -----");

            opcaoUsuario = input.nextInt();
            int escolhaInterna = 0;
            switch (opcaoUsuario){
                case 1:
                    System.out.println("----- ----- ----- MENU USUARIO ----- ----- -----");
                    System.out.println("1. Cadastrar Usuario");
                    System.out.println("2. Remover Usuario");
                    System.out.println("3. Consultar Usuario");
                    System.out.println("----- ----- ----- ----- ----- ----- ----- -----");
                    opcaoUsuario = input.nextInt();
                    switch (opcaoUsuario) {
                        case 1:
                            System.out.println("----- ----- Cadastro ----- -----");
                            System.out.print("Digite o nome do usuario: ");
                            String nome = input.next();
                            System.out.print("Digite o sobrenome do usuario: ");
                            String sobrenome = input.next();
                            System.out.print("Digite o email do usuario: ");
                            String email = input.next();
                            System.out.print("Digite a idade do usuario: ");
                            int idade = input.nextInt();
                            System.out.print("Digite um apelido de usuario: ");
                            String apelido = input.next();

                            while (escolhaInterna != 1 || escolhaInterna != 2){
                                System.out.println("Escolha o tipo de usuario: \n1.Jogador      2.Mestre");
                                escolhaInterna = input.nextInt();
                                if (escolhaInterna == 1) {
                                    Jogador novoJogador = new Jogador(nome, sobrenome, email, idade, apelido);
                                    ControleJogador.cadastrarJogador(novoJogador);
                                    break;
                                } else if (escolhaInterna == 2) {
                                    Mestre novoMestre = new Mestre(nome, sobrenome, email, idade, apelido);
                                    ControleMestre.cadastrarMestre(novoMestre);
                                    break;
                                } else {
                                    System.out.println("Opcao invalida tente novamente! \n");
                                }
                            }
                            break;
                        case 2:
                            System.out.println("----- ----- Remocao ----- -----");

                            while (escolhaInterna != 1 || escolhaInterna != 2){
                                System.out.println("Escolha a opcao de remocao: \n1.Remocao pelo id_usuario:      2.Remocao pelo apelido do usuario");
                                escolhaInterna = input.nextInt();
                                if (escolhaInterna == 1) {
                                    System.out.print("Digite o id do usuario: ");
                                    int idEscolhido = input.nextInt();
                                    Usuario removido = ControleUsuario.buscarUsuarioId(idEscolhido);
                                    ControleUsuario.removerUsuario(removido);
                                    break;

                                } else if (escolhaInterna == 2) {
                                    System.out.print("Digite o apelido do usuario: ");
                                    String apelidoUsuario = input.next();
                                    Usuario removido = ControleUsuario.buscarUsuarioApelido(apelidoUsuario);
                                    ControleUsuario.removerUsuario(removido);
                                    break;
                                } else {
                                    System.out.println("Opcao invalida tente novamente! \n");
                                }
                            }
                            break;

                        default:
                            System.out.println("Opcao invalida tente novamente! \n");
                    }

            }

        }while (opcaoUsuario != 0);

    }
}
