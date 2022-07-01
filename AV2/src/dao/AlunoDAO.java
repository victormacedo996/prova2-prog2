package dao;

import java.sql.SQLException;

import model.Aluno;

public interface AlunoDAO {
	Aluno obterAluno(int IdAluno) throws SQLException;

	void salvarAluno(Aluno aluno) throws SQLException;

	void atualizarAluno(Aluno aluno) throws SQLException;

	void deletarAluno(int AlunoId) throws SQLException;
}
