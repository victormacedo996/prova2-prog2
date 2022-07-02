package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Aluno {
	private int Id;
	private String Nome;
	private String CPF;
	private Calendar DataNascimento;
	private String Naturalidade;
	private String Endereco;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public Calendar getDataNascimento() {
		return DataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		DataNascimento = dataNascimento;
	}

	public String getNaturalidade() {
		return Naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		Naturalidade = naturalidade;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	public String toString() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		
		return String.format("Id: %d, Nome: %s, CPF: %s, Data de nascimento: %s, Naturalidade: %s, Endereço: %s", this.getId(), this.getNome(), this.getCPF(), format1.format(this.getDataNascimento().getTime()),
				this.getNaturalidade(), this.getEndereco());
	}
}
