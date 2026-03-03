import Entity.Usuario;
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
            System.out.println("======================");
            System.out.println("=        MENU        =");
            System.out.println("=  1. Listar acervo  =");
            System.out.println("= 2. Listar usuários =");
            System.out.println("=3. Cadastrar usuario=");
            System.out.println("======================");

            System.out.println("Escolha uma opção");
            String opcao = sc.nextLine().trim();

            switch (opcao){
                case "0":
                    running = false;
                    break;
                case "1":
                    bibliotecaService.listarLivros();
                    break;
                case "2":
                    bibliotecaService.listarUsuarios();
                    break;
                case "3":
                    System.out.println("Digite o cpf do usuário (APENAS OS NÚMEROS)");
                    String userCpf = sc.nextLine();
                    System.out.println("Digite o nome do usuário");
                    String userName = sc.nextLine();
                    System.out.println("Digite o telefone do usuário");
                    String userPhone = sc.nextLine();
                    bibliotecaService.cadastrarUsuario(userName, userCpf, userPhone);
                default:
                    System.out.println("Opção invalida");
            }
        }
        
    }
}
