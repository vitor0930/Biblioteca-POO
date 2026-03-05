package Entity;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String cpf;
    private String  telefone;
    public List<Livro> livrosUsados;

    public Usuario(String nome, String cpf, String telefone){
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.livrosUsados = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }
}
