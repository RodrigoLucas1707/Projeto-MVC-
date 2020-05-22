package org.libertas.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.libertas.model.dao.ProdutoDao;
import org.libertas.model.pojo.Estoque;

public class InserirProduto implements Modelo{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		if(request.getParameter("idproduto") == null) {
			return "Descrição Obrigatória!";
		}
		
		if(request.getParameter("marca") == null) {
			return "Marca Obrigatória!";
		}
		
		if(request.getParameter("pvenda") == null) {
			return "Preço de venda Obrigatória!";
		}
		
		if(request.getParameter("pcusto") == null) {
			return "Preço de venda Obrigatória!";
		}
		
		try {
			Estoque e = new Estoque();
			e.setDescricao(request.getParameter("descricao"));
			e.setMarca(request.getParameter("marca"));
			e.setIdproduto(Integer.parseInt(request.getParameter("idproduto")));
			e.setPrecoCusto(Double.parseDouble(request.getParameter("pcusto")));
			e.setPrecoVenda(Double.parseDouble(request.getParameter("pvenda")));
			e.setSaldo(Double.parseDouble(request.getParameter("saldo")));
			
			ProdutoDao p = new ProdutoDao();
			p.inserir(e);
			
			return "Inserido com sucesso!";
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
