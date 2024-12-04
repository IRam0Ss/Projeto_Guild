package modelos;

public class Usuario {

    private Integer idUsuario;
    private String nome;
    private String sobrenome;
    private String email;
    private Integer idade;
    private String apelido;

    public Usuario() {
    }

    public Usuario(String nome, String sobrenome, String email, Integer idade, String apelido) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.idade = idade;
        this.apelido = apelido;
    }

    public Usuario(Integer idUsuario, String nome, String sobrenome, String email, Integer idade, String apelido) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.idade = idade;
        this.apelido = apelido;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public int getIdade() {
        return idade;
    }

    public String getApelido() {
        return apelido;
    }

    @Override
    public String toString() {
        String mensage = """
                Id_user: %d
                Nome: %s
                Sobrenome: %s
                Email: %s
                Apelido_no_sistema: %s
                Idade: %d
                """.formatted(getIdUsuario(), getNome(), getSobrenome(), getEmail(), getApelido(), getIdade());

        return mensage;
    }

}// end class
