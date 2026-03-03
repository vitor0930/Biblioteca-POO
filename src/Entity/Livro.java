package Entity;

public class Livro {
    private String titulo;
    private String autor;
    private boolean emprestado = false;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public String getAutor() {
        return autor;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }
}
