package teste;

import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;

import dao.AlunoDAO;
import dao.AlunoDAOImpl;
import model.Aluno;

public class TesteAluno {

	public static void main(String[] args) {
		if (criarAluno()) {
			System.out.println("Criou com sucesso!");
		}

		if (deletarAluno()) {
			System.out.println("Deletou com sucesso!");
		}

		Aluno aluno = obterAluno(40);
		if (aluno != null) {
			System.out.println("Aluno obtido com sucesso!");
		}

		aluno.setNome("Diogo");
		aluno.setEndereco("Rua das mariolas, esquina com requeijão");

		if (atualizarAluno(aluno)) {
			System.out.println("Aluno atualizado com sucesso!");
		}

		List<Aluno> lstAluno = obterLstAluno("D");
		if (lstAluno.size() > 0) {
			System.out.println("Aluno atualizado com sucesso!");
		}
	
		List<Aluno> lstTodosAluno = obterLstAluno();
		if (lstTodosAluno.size() > 0) {
			System.out.println("Listar Alunos");
			
			for(Aluno item : lstTodosAluno) {
				System.out.println("ID: " + item.getId() + " NOME :" + item.getNome());
			}
		}
	}
	
	private static List<Aluno> obterLstAluno() {
		try {
			AlunoDAO alunoDAO = new AlunoDAOImpl();

			return alunoDAO.obterLstAluno();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private static List<Aluno> obterLstAluno(String nome) {
		try {
			AlunoDAO alunoDAO = new AlunoDAOImpl();

			return alunoDAO.obterLstAluno(nome);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static boolean deletarAluno() {
		try {
			AlunoDAO alunoDAO = new AlunoDAOImpl();

			return alunoDAO.deletarAluno(29);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public static boolean criarAluno() {
		try {
			Aluno aluno = new Aluno();

			aluno.setNome("Mario");
			aluno.setCPF("123.123.123-22");
			aluno.setDataNascimento(new GregorianCalendar(2013, 11, 31));
			aluno.setNaturalidade("Rio de Janeiro");
			aluno.setEndereco("Rua da esquinaa");

			AlunoDAO alunoDAO = new AlunoDAOImpl();

			return alunoDAO.salvarAluno(aluno);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static Aluno obterAluno(int IdAluno) {
		try {
			AlunoDAO alunoDAO = new AlunoDAOImpl();

			return alunoDAO.obterAluno(IdAluno);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean atualizarAluno(Aluno aluno) {
		try {
			AlunoDAO alunoDAO = new AlunoDAOImpl();

			return alunoDAO.atualizarAluno(aluno);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
