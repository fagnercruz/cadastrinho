package br.anisoft.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.anisoft.dao.GenericDAO;
import br.anisoft.model.PessoaModel;

@ViewScoped
@ManagedBean(name = "pessoaBean")
public class PessoaBean {

	PessoaModel pessoa = new PessoaModel();
	GenericDAO<PessoaModel> dao = new GenericDAO<PessoaModel>();
	List<PessoaModel> listaPessoas = new ArrayList<PessoaModel>();

	// método que chama o dao para obter um select de pessoas
	// @postConstruct - o método é executado quando o managebean é instanciado (
	// similar ao static {} )
	@PostConstruct
	public void obterLista() {
		listaPessoas = dao.listar(pessoa);
	}

	public String salvar() {
		// atualizar() caso nao exista, salva!
		pessoa = dao.atualizar(pessoa); 							
		obterLista(); // quando há alteração no banco, atualiza a lista
		novo();
		return "";
	}

	// limpa campos do formulario
	public String novo() {
		pessoa = new PessoaModel();
		return "";
	}

	public String deletar() {
		dao.excluirPorID(pessoa);
		pessoa = new PessoaModel();
		obterLista(); // quando há alteração no banco, atualiza a lista
		return "";
	}

	/*=============================================================================*/
	
	public List<PessoaModel> getListaPessoas() {
		return listaPessoas;
	}

	public void setListaPessoas(List<PessoaModel> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}

	public PessoaModel getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaModel pessoa) {
		this.pessoa = pessoa;
	}

	public GenericDAO<PessoaModel> getDao() {
		return dao;
	}

	public void setDao(GenericDAO<PessoaModel> dao) {
		this.dao = dao;
	}

}
