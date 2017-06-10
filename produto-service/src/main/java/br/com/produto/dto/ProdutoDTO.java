package br.com.produto.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProdutoDTO implements Serializable {

	private static final long serialVersionUID = 9150167602150172218L;
	
	private Long id;
	private String descricao;
	private BigDecimal preco;
	
	public ProdutoDTO() {}

	public ProdutoDTO(Long id, String descricao, BigDecimal preco) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}
}
