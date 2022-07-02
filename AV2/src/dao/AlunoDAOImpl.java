package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import factory.ConnectionFactory;
import model.Aluno;

public class AlunoDAOImpl implements AlunoDAO {

	private final Connection con;

	public AlunoDAOImpl() throws SQLException {
		this.con = ConnectionFactory.getConnection();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Aluno obterAluno(int IdAluno) throws SQLException {
		// TODO Auto-generated method stub
		String query = "SELECT id, nome, cpf, data_nascimento, naturalidade, endereco FROM alunos";
		PreparedStatement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();

		Aluno aluno = null;

		while (rs.next()) {
			if (rs.getInt(1) == IdAluno) {
				aluno = new Aluno();
				aluno.setId(rs.getInt("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setCPF(rs.getString("cpf"));

				Date data = rs.getDate("data_nascimento");
				Calendar dataNascimento = new GregorianCalendar();
				dataNascimento.setTime(data);
				aluno.setDataNascimento(dataNascimento);
				aluno.setNaturalidade(rs.getString("naturalidade"));
				aluno.setEndereco(rs.getString("endereco"));
			}
			;
		}

		rs.close();
		stmt.close();
		con.close();

		return aluno;
	}

	@Override
	public boolean salvarAluno(Aluno aluno) throws SQLException {
		boolean result = false;
		String query = "INSERT INTO alunos (NOME, CPF, DATA_NASCIMENTO, NATURALIDADE, ENDERECO) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement(query);

		Calendar data = aluno.getDataNascimento();
		Date dataFinal = new Date(data.getTimeInMillis());

		stmt.setString(1, aluno.getNome());
		stmt.setString(2, aluno.getCPF());
		stmt.setDate(3, dataFinal);
		stmt.setString(4, aluno.getNaturalidade());
		stmt.setString(5, aluno.getEndereco());

		result = stmt.executeUpdate() > 0;

		stmt.close();
		con.close();

		return result;
	}

	@Override
	public boolean atualizarAluno(Aluno aluno) throws SQLException {
		// TODO Auto-generated method stub
		boolean result = false;

		String query = "UPDATE alunos SET NOME = ?, CPF = ?, DATA_NASCIMENTO = ?, NATURALIDADE = ?, ENDERECO = ? WHERE id = ?";
		PreparedStatement stmt = con.prepareStatement(query);

		Calendar data = aluno.getDataNascimento();
		Date dataFinal = new Date(data.getTimeInMillis());

		stmt.setString(1, aluno.getNome());
		stmt.setString(2, aluno.getCPF());
		stmt.setDate(3, dataFinal);
		stmt.setString(4, aluno.getNaturalidade());
		stmt.setString(5, aluno.getEndereco());
		stmt.setInt(6, aluno.getId());

		result = stmt.executeUpdate() > 0;

		stmt.close();
		con.close();

		return result;
	}

	@Override
	public boolean deletarAluno(int AlunoId) throws SQLException {
		// TODO Auto-generated method stub
		boolean result = false;
		String query = "DELETE FROM alunos WHERE id = ?";
		PreparedStatement stmt = con.prepareStatement(query);

		stmt.setInt(1, AlunoId);

		result = stmt.executeUpdate() > 0;
		stmt.close();
		con.close();

		return result;
	}

	
	public List<Aluno> obterLstAluno(String nome) throws SQLException {
		String query = "SELECT id, nome, cpf, data_nascimento, naturalidade, endereco FROM alunos WHERE nome like ?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, nome + "%");
		ResultSet rs = stmt.executeQuery();

		List<Aluno> lstAluno = new ArrayList<Aluno>();

		while (rs.next()) {
			Aluno aluno = new Aluno();
			
			aluno.setId(rs.getInt("id"));
			aluno.setNome(rs.getString("nome"));
			aluno.setCPF(rs.getString("cpf"));
			Date data = rs.getDate("data_nascimento");
			Calendar dataNascimento = new GregorianCalendar();
			dataNascimento.setTime(data);
			aluno.setDataNascimento(dataNascimento);
			aluno.setNaturalidade(rs.getString("naturalidade"));
			aluno.setEndereco(rs.getString("endereco"));
			
			lstAluno.add(aluno);
		}

		rs.close();
		stmt.close();
		con.close();

		return lstAluno;
	}

}
