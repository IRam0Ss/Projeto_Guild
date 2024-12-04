package modelos;

public class SistemaRPG {

    private Integer id_sistema;
    private String nome_sistema;
    private String tipo_dado;
    private String descricao;

    public SistemaRPG(Integer id_sistema, String nome_sistema, String tipo_dado, String descricao) {
        this.id_sistema = id_sistema;
        this.nome_sistema = nome_sistema;
        this.tipo_dado = tipo_dado;
        this.descricao = descricao;
    }

    public SistemaRPG(String nome_sistema, String tipo_dado, String descricao) {
        this.nome_sistema = nome_sistema;
        this.tipo_dado = tipo_dado;
        this.descricao = descricao;
    }

    public Integer getId_sistema() {
        return id_sistema;
    }

    public String getNome_sistema() {
        return nome_sistema;
    }

    public String getTipo_dado() {
        return tipo_dado;
    }

    public String getDescricao() {
        return descricao;
    }
}
