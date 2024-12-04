package modelos;

public class Mestre extends Usuario{

    Integer id_mestre = super.getIdUsuario();

    public Mestre() {
    }

    public Mestre(String nome, String sobrenome, String email, Integer idade, String apelido) {
        super(nome, sobrenome, email, idade, apelido);
    }

    public Mestre(Integer idUsuario, String nome, String sobrenome, String email, Integer idade, String apelido) {
        super(idUsuario, nome, sobrenome, email, idade, apelido);
    }

    public Integer getId_mestre() {
        return id_mestre;
    }

}// end class
