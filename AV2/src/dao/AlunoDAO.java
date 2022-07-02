package dao;

import java.sql.SQLException;

import model.Aluno;

public interface AlunoDAO {
	Aluno obterAluno(int IdAluno) throws SQLException;

	boolean salvarAluno(Aluno aluno) throws SQLException;

	boolean atualizarAluno(Aluno aluno) throws SQLException;

	boolean deletarAluno(int AlunoId) throws SQLException;
}
