package modelos;

public class Mesa {
    private Integer id_mesa;
    private String nome_mesa;
    private String descricao_mesa;
    private Integer id_mestre_mesa;
    private Integer id_sistema_mesa;

    public Mesa(Integer id_mesa, String nome_mesa, String descricao_mesa, Integer id_mestre_mesa, Integer id_sistema_mesa) {
        this.id_mesa = id_mesa;
        this.nome_mesa = nome_mesa;
        this.descricao_mesa = descricao_mesa;
        this.id_mestre_mesa = id_mestre_mesa;
        this.id_sistema_mesa = id_sistema_mesa;
    }

    public Mesa(String nome_mesa, String descricao_mesa, Integer id_mestre_mesa, Integer id_sistema_mesa) {
        this.nome_mesa = nome_mesa;
        this.descricao_mesa = descricao_mesa;
        this.id_mestre_mesa = id_mestre_mesa;
        this.id_sistema_mesa = id_sistema_mesa;
    }

    public Integer getId_mesa() {
        return id_mesa;
    }

    public String getNome_mesa() {
        return nome_mesa;
    }

    public String getDescricao_mesa() {
        return descricao_mesa;
    }

    public Integer getId_mestre_mesa() {
        return id_mestre_mesa;
    }

    public Integer getId_sistema_mesa() {
        return id_sistema_mesa;
    }

    @Override
    public String toString() {
        String mensagem = """
                id_mesa: %d
                nome_mesa: %s
                descricao_mesa: %s
                id_mestre_da_mesa: %d
                id_sistema_da_mesa: %d
                """.formatted(getId_mesa(), getNome_mesa(), getDescricao_mesa(), getId_mestre_mesa(), getId_sistema_mesa());
        return mensagem;
    }
}
