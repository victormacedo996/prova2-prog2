package view;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import dao.AlunoDAO;
import dao.AlunoDAOImpl;
import model.Aluno;

public class Menu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("## Escolha uma das opções abaixo ##");
			System.out.println("Opção 1 - Cadastra aluno");
			System.out.println("Opção 2 - Atualiza um cadastro");
			System.out.println("Opção 3 - Deleta um cadastro");
			System.out.println("Opção 4 - Imprime registro de um aluno");
			System.out.println("Opção 5 - Imprime registro de um aluno por nome");
			System.out.println("Opção 6 - Exibir todos os registros dos alunos");
			System.out.println("Opção 0 - Sair do programa");
			System.out.println("_______________________");
			System.out.print("Digite aqui sua opção: ");

			int input = 0;
			try {
				AlunoDAO alunoDAO = new AlunoDAOImpl();
				Aluno aluno = new Aluno();
				int idAluno = -1;
				String nomeAluno = "";
				int dia, mes, ano;

				try {
					input = sc.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("O input deve ser um número inteiro");
					break;
				}

				if (input == 0) {
					System.out.println("Obrigado por usar o programa");
					break;
				}

				switch (input) {
				case 1:
					aluno = new Aluno();

					System.out.println("Informe o nome:");
					aluno.setNome(sc.nextLine());

					System.out.println("Informe o CPF:");
					aluno.setCPF(sc.nextLine());

					System.out.println("Informe o Endere�o:");
					aluno.setEndereco(sc.nextLine());

					System.out.println("Informe o Naturalidade:");
					aluno.setNaturalidade(sc.nextLine());

					System.out.println("#### Informe a data de nascimento");

					System.out.println("Informe o dia: ");
					dia = sc.nextInt();

					System.out.println("Informe o m�s: ");
					mes = sc.nextInt();

					System.out.println("Informe o ano: ");
					ano = sc.nextInt();

					aluno.setDataNascimento(new GregorianCalendar(ano, mes - 1, dia));

					if (!alunoDAO.salvarAluno(aluno)) {
						System.out.println("Erro ao salvar aluno!");
						continue;
					}

					System.out.println("Aluno salvo com sucesso!");
					break;
				case 2:
					aluno = new Aluno();
					idAluno = -1;

					while (idAluno < 0) {
						System.out.println("Informe o Id do aluno:");
						idAluno = sc.nextInt();
					}

					aluno = alunoDAO.obterAluno(idAluno);

					System.out.println("Informe o nome:");
					aluno.setNome(sc.nextLine());

					System.out.println("Informe o CPF:");
					aluno.setCPF(sc.nextLine());

					System.out.println("Informe o Endere�o:");
					aluno.setEndereco(sc.nextLine());

					System.out.println("Informe o Naturalidade:");
					aluno.setNaturalidade(sc.nextLine());

					System.out.println("#### Informe a data de nascimento");

					System.out.println("Informe o dia: ");
					dia = sc.nextInt();

					System.out.println("Informe o m�s: ");
					mes = sc.nextInt();

					System.out.println("Informe o ano: ");
					ano = sc.nextInt();

					aluno.setDataNascimento(new GregorianCalendar(ano, mes - 1, dia));

					if (!alunoDAO.atualizarAluno(aluno)) {
						System.out.println("Erro ao salvar aluno!");
						continue;
					}

					System.out.println("Aluno atualizado com sucesso!");

					break;
				case 3:
					System.out.println("Informe o Id do a ser deletado Aluno:");
					idAluno = sc.nextInt();

					if (!alunoDAO.deletarAluno(idAluno)) {
						System.out.println("Erro ao deletar aluno");
					}

					System.out.println("Aluno deletado com sucesso!");

					break;
				case 4:
					System.out.println("Informe o id do aluno:");
					idAluno = sc.nextInt();
					aluno = alunoDAO.obterAluno(idAluno);

					if (aluno == null) {
						System.out.println("Erro ao recuperar aluno");
						continue;
					}

					System.out.println(aluno.toString());

					break;
				case 5:
					System.out.println("Informe o nome a ser encontrado:");
					nomeAluno = sc.nextLine();
					List<Aluno> lstAlunoFiltrado = alunoDAO.obterLstAluno(nomeAluno);

					if (lstAlunoFiltrado == null) {
						System.out.println("Erro ao recuperar aluno");
						continue;
					}

					if (lstAlunoFiltrado.size() == 0) {
						System.out.println("Nenhum aluno com este nome foi encontrado!");
						continue;
					}

					for (Aluno item : lstAlunoFiltrado) {
						System.out.println(item.toString());
					}

					break;

				case 6:
					System.out.println("Informe o nome a ser encontrado:");
					nomeAluno = sc.nextLine();
					List<Aluno> lstAluno = alunoDAO.obterLstAluno();

					if (lstAluno == null) {
						System.out.println("Erro ao recuperar aluno");
						continue;
					}

					if (lstAluno.size() == 0) {
						System.out.println("Nenhum aluno com este nome foi encontrado!");
						continue;
					}

					System.out.println();
					System.out.println();

					for (Aluno item : lstAluno) {
						System.out.println(item.toString());
					}

					break;
				default:
					System.out.println("\n *** Opção inválida ***");
					System.out.println("_______________________");
					break;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		sc.close();

	}
}
