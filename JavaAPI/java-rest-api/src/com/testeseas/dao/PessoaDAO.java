package com.testeseas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.testeseas.entidade.Pessoas;
import com.testeseas.config.BDConfig;

public class PessoaDAO {
	
	public List<Pessoas> listarPessoas() throws Exception {
		List<Pessoas> lista = new ArrayList<>();
		Connection conexao = BDConfig.getConnection();	
		
		String sql = "SELECT * FROM tb_pessoas";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		
		while (rs.next()) {
			Pessoas pessoas = new Pessoas();
			pessoas.setId(rs.getInt("id_pessoa"));
			pessoas.setCnh(rs.getString("cnh"));
			pessoas.setCpf(rs.getString("cpf"));
			pessoas.setNome(rs.getString("nome"));
			lista.add(pessoas);
		}
		return lista;
	}
	
	public List<Pessoas> buscarPessoaPorId(int idPessoa) throws Exception {
		List<Pessoas> lista = new ArrayList<>();
		Connection conexao = BDConfig.getConnection();	
		
		String sql = "SELECT * FROM TB_PESSOAS WHERE id_pessoa = ?";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, idPessoa);
		ResultSet rs = statement.executeQuery();
		
		while (rs.next()) {
			Pessoas pessoas = new Pessoas();
			pessoas.setId(rs.getInt("id_pessoa"));
			pessoas.setCnh(rs.getString("cnh"));
			pessoas.setCpf(rs.getString("cpf"));
			pessoas.setNome(rs.getString("nome"));
			lista.add(pessoas);
		}
		return lista;
	}
	
	public int addPessoa(Pessoas pessoa) throws Exception {
		int idGerado = 0;
		Connection conexao = BDConfig.getConnection();
		
		String sql = "INSERT INTO tb_pessoas(nome, cpf, cnh) VALUES(?, ?, ?)";
		
		PreparedStatement statement = conexao.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, pessoa.getNome());
		statement.setString(2, pessoa.getCpf());
		statement.setString(3, pessoa.getCnh());
		statement.execute();
		
		ResultSet rs = statement.getGeneratedKeys();
		if (rs.next()) {
			idGerado = rs.getInt(1);
		}
		return idGerado;
	}
	
	public void editarPessoa(Pessoas pessoa, int idPessoa) throws Exception {
		Connection conexao = BDConfig.getConnection();
		
		String sql = "UPDATE tb_pessoas SET nome = ?, cpf = ?, cnh = ? WHERE id_pessoa = ?";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setString(1, pessoa.getNome());
		statement.setString(2, pessoa.getCpf());
		statement.setString(3, pessoa.getCnh());
		statement.setInt(4, idPessoa);
		statement.execute();
	}
	
	public void deletarPessoa(int idPessoa) throws Exception {
		Connection conexao = BDConfig.getConnection();
		
		String sql = "DELETE FROM tb_pessoas WHERE id_pessoa = ?";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, idPessoa);
		statement.execute();
	}
}
