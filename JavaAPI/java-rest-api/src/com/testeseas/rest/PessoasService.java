package com.testeseas.rest;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.testeseas.dao.PessoaDAO;
import com.testeseas.entidade.Pessoas;

@Path("/pessoas")
public class PessoasService {
	
	private static final String CHARSET_UTF8 = ";charset=utf-8";
	private PessoaDAO pessoaDAO;
	
	@PostConstruct
	public void init() {
		pessoaDAO = new PessoaDAO();
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pessoas> listarPessoas(){
		List<Pessoas> lista = null;
		try {
			lista = pessoaDAO.listarPessoas();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	@GET
	@Path("/list/{id}")
	//@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pessoas> buscarPessoa(@PathParam("id") int idPessoa){
		List<Pessoas> lista = null;
		String msg = "";
		try {
			lista = pessoaDAO.buscarPessoaPorId(idPessoa);
		} catch (Exception e){
			e.printStackTrace();
		}
		return lista;
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public String addPessoa(Pessoas pessoa){
		String msg = "";
		System.out.println(pessoa.getNome());
		try {
			int idGerado = pessoaDAO.addPessoa(pessoa);
			msg = String.valueOf(idGerado);
		} catch (Exception e) {
			msg = "Erro ao add pessoa!";
			e.printStackTrace();
		}
		return msg;
	}
	
	@PUT
	@Path("/edit/{id}")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public String editarPessoa(Pessoas pessoa, @PathParam("id") int idPessoa){
		String msg = "";		
		System.out.println(pessoa.getNome());
		try {
			pessoaDAO.editarPessoa(pessoa, idPessoa);
			msg = "Pessoa editada com sucesso!";
		} catch (Exception e){
			msg = "Erro ao editar pessoa!";
			e.printStackTrace();
		}
		return msg;
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletarPessoa(@PathParam("id") int idPessoa){
		String msg = "";
		try {
			pessoaDAO.deletarPessoa(idPessoa);
			msg = "Pessoa removida com sucesso!";
		} catch (Exception e){
			msg = "Erro ao remover pessoa!";
			e.printStackTrace();
		}
		return msg;
	}
	
}
