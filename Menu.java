import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        

        while (true){
            
            System.out.println("## Escolha uma das opções abaixo ##");
            System.out.println("Opção 1 - Cadastra aluno");
            System.out.println("Opção 2 - Imprime alunos cadastradas");
            System.out.println("Opção 3 - Atualiza um cadastro");
            System.out.println("Opção 3 - Deleta um cadastro");
            System.out.println("Opção 0 - Sair do programa");
            System.out.println("_______________________");
            System.out.print("Digite aqui sua opção: ");

            int input = 0;

            try {
                input = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("O input deve ser um número inteiro");
                break;
            }
            

            if (input == 0){
                System.out.println("Obrigado por usar o programa");
                break;
            }

            switch (input) {
                case 1:
                    // Cadastra aluno
                    System.out.println("Opção 1");
                    break;
                case 2:
                    // Imprime alunos cadastrados
                    System.out.println("Opção 2");
                    break;
                
                case 3:
                    // Atualiza um cadastro
                    System.out.println("Opção 3");
                    break;
                case 4:
                    // Deleta um cadastro
                    System.out.println("Opção 4");
                    break;
            
                default:
                    System.out.println("\n *** Opção inválida ***");
                    System.out.println("_______________________");
                    break;
            }
            
        }

        sc.close();
        
        
    }
}
