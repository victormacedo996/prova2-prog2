package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import factory.ConnectionFactory;
import model.Aluno;

public class AlunoDAOImpl implements AlunoDAO {

	private final Connection con;

	public AlunoDAOImpl() throws SQLException {
		this.con = ConnectionFactory.getConnection();
	}

	@Override
	public Aluno obterAluno(int IdAluno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void salvarAluno(Aluno aluno) throws SQLException {
		String query = "INSERT INTO alunos (NOME, CPF, DATA_NASCIMENTO, NATURALIDADE, ENDERECO) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement(query);
		
		stmt.setString(1, aluno.getNome());
		stmt.setString(2, aluno.getCPF());
		stmt.setString(3, aluno.getDataNascimento());
		stmt.setString(4, aluno.getNaturalidade());
		stmt.setString(5, aluno.getEndereco());
		
		stmt.execute();
		
		stmt.close();
		con.close();
	}

	@Override
	public void atualizarAluno(Aluno aluno) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletarAluno(int AlunoId) throws SQLException {
		// TODO Auto-generated method stub
		String query = "DELETE FROM alunos WHERE id = ?";
		PreparedStatement stmt = con.prepareStatement(query);
		
		stmt.setInt(1, AlunoId);
		
		stmt.execute();
		stmt.close();
		con.close();
	}

}
