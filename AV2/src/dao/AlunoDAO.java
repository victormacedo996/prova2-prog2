package dao;

import model.Aluno;

public interface AlunoDAO {
	Aluno obterAluno(int IdAluno);

	void salvarAluno(Aluno aluno);

	void atualizarAluno(Aluno aluno);

	void deletarAluno(int AlunoId);
}
