package model;

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
}
