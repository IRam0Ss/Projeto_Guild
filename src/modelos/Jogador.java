package modelos;

public class Jogador extends Usuario{

    private Integer idJogador = super.getIdUsuario();

    public Jogador(String nome, String sobrenome, String email, Integer idade, String apelido) {
        super(nome, sobrenome, email, idade, apelido);
    }

    public Jogador(Integer idUsuario, String nome, String sobrenome, String email, Integer idade, String apelido) {
        super(idUsuario, nome, sobrenome, email, idade, apelido);
    }

    public Jogador() {
    }

    public Integer getIdJogador() {
        return idJogador;
    }

}
