package Service;

import Entity.Livro;
import Entity.Usuario;
import Repository.LIvroRepository;
import Repository.UserRepository;

public class BibliotecaService {
    public UserRepository userRepository = new UserRepository();
    public LIvroRepository lIvroRepository = new LIvroRepository();

    public void cadastrarUsuario(String nome, String cpf, String telefone) {
        if (userRepository.users.stream().anyMatch(u -> u.getCpf().equals(cpf)) || cpf.length() != 11 ) {
            System.out.println("Cpf invalido/já utilizado");
        } else {
            userRepository.users.add(new Usuario(nome, cpf, telefone));
        }
    }

    public void cadastrarLIvro(String titulo, String autor) {
        lIvroRepository.livros.add(new Livro(titulo, autor));
    }

    public void listarUsuarios() {
        userRepository.users.forEach(x -> System.out.println(x.getNome()));
    }

    public void listarLivros() {
        lIvroRepository.livros.forEach(x -> System.out.println(x.getTitulo() + " - " + x.getAutor()));
    }

    public Usuario buscarPorCpf(String cpf) {
        return userRepository.users.stream().filter(usuario -> usuario.getCpf().equals(cpf)).findFirst().orElse(null);
    }

    public Livro buscarPorTituloEAutor(String titulo, String autor) {
        return lIvroRepository.livros.stream().filter(x -> x.getTitulo().equals(titulo) && x.getAutor().equals(autor)).findFirst().orElse(null);
    }

    public void emprestarLivro(Usuario usuario, Livro livro) {
        if (usuario == null || livro == null){
            System.out.println("Usuário e/ou livro não encontrado");
        } else if (livro.isEmprestado()) {
            System.out.println("Livro indisponível");
        } else {
            usuario.livrosUsados.add(livro);
            livro.setEmprestado(true);
        }
    }

    public void devolverLivro(Usuario usuario, Livro livro){
        if (usuario == null || livro == null){
            System.out.println("Usuário e/ou livro não encontrado");
        } else if (!livro.isEmprestado()) {
            System.out.println("Livro não emprestado");
        } else {
            usuario.livrosUsados.remove(livro);
            livro.setEmprestado(false);
        }
    }

}
