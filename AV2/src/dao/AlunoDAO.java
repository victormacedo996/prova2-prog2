package dao;

import java.sql.SQLException;
import java.util.List;

import model.Aluno;

public interface AlunoDAO {
	Aluno obterAluno(int IdAluno) throws SQLException;

	boolean salvarAluno(Aluno aluno) throws SQLException;

	boolean atualizarAluno(Aluno aluno) throws SQLException;

	boolean deletarAluno(int AlunoId) throws SQLException;
	
	List<Aluno> obterLstAluno(String nome) throws SQLException;
	
	List<Aluno> obterLstAluno() throws SQLException;
}
