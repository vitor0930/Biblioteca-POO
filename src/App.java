import Service.BibliotecaService;

import java.util.Scanner;

public class App {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        BibliotecaService bibliotecaService = new BibliotecaService();

        boolean running = true;
        System.out.println("======================");
        System.out.println("Bem vindo á biblioteca");
        System.out.println("======================");
        while(running){
            String cpfToSearch, titleToSearch, authorToSearch;
            System.out.println("======================");
            System.out.println("=        MENU        =");
            System.out.println("=      0. Sair       =");
            System.out.println("= 1. Listar usuários =");
            System.out.println("=  2. Listar acervo  =");
            System.out.println("=3. Cadastrar usuario=");
            System.out.println("= 4. Cadastrar livro =");
            System.out.println("= 5. Emprestar livro =");
            System.out.println("=  6. Devolver livro =");
            System.out.println("======================");

            System.out.println("Escolha uma opção: ");
            String opcao = sc.nextLine().trim();

            switch (opcao){
                case "0":
                    running = false;
                    sc.close();
                    break;
                case "1":
                    bibliotecaService.listarUsuarios();
                    break;
                case "2":
                    bibliotecaService.listarLivros();
                    break;
                case "3":
                    System.out.println("Digite o nome do cliente");
                    String clientName = sc.nextLine();
                    System.out.println("Digite o cpf do cliente (APENAS OS NÚMEROS!)");
                    String clientCpf = sc.nextLine();
                    System.out.println("Digite o telefone do usuário");
                    String clientPhone = sc.nextLine();
                    bibliotecaService.cadastrarUsuario(clientName, clientCpf, clientPhone);
                    break;
                case "4":
                    System.out.println("Digite o titulo do livro");
                    String title = sc.nextLine();
                    System.out.println("Digite o autor do livro");
                    String author = sc.nextLine();
                    bibliotecaService.cadastrarLIvro(title,author);
                    break;
                case "5":
                    System.out.println("Digite o cpf do cliente");
                    cpfToSearch = sc.nextLine();
                    System.out.println("Digite o titulo do livro");
                    titleToSearch = sc.nextLine();
                    System.out.println("Digite o nome do autor do livro");
                    authorToSearch = sc.nextLine();
                    bibliotecaService.emprestarLivro(bibliotecaService.buscarPorCpf(cpfToSearch),
                    bibliotecaService.buscarPorTituloEAutor(titleToSearch,authorToSearch));
                    break;
                case "6":
                    System.out.println("Digite o cpf do cliente");
                    cpfToSearch = sc.nextLine();
                    System.out.println("Digite o titulo do livro");
                    titleToSearch = sc.nextLine();
                    System.out.println("Digite o autor do livro");
                    authorToSearch = sc.nextLine();
                    bibliotecaService.devolverLivro(bibliotecaService.buscarPorCpf(cpfToSearch),
                    bibliotecaService.buscarPorTituloEAutor(titleToSearch,authorToSearch));
                    break;
                default:
                    System.out.println("Opção invalida!");
            }
        }
        
    }
}