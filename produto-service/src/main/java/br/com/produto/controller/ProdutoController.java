package br.com.produto.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.produto.clients.OrcamentoClient;
import br.com.produto.dto.ProdutoDTO;

@RefreshScope
@RestController
@RequestMapping(value= "/v1/api/produtos", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
public class ProdutoController {
 
	private List<ProdutoDTO> produtos;
	
	@Autowired
	private OrcamentoClient orcamentoClient;
	
	@Value("${app.title}")
	private String title;
	
	@PostConstruct
	public void init() {
		produtos = new ArrayList<>();
		produtos.add(new ProdutoDTO(1L, "Mesa", new BigDecimal("130.52")));
		produtos.add(new ProdutoDTO(2L, "Cadeira", new BigDecimal("10.20")));
		produtos.add(new ProdutoDTO(3L, "TV LCD", new BigDecimal("4526.99")));
		produtos.add(new ProdutoDTO(4L, "Cama box", new BigDecimal("250")));
		produtos.add(new ProdutoDTO(5L, "Geladeira", new BigDecimal("800")));
	}
	
	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> findAll() {
		System.out.println(title);
		return new ResponseEntity<>(produtos, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> findById(@PathVariable Long id) {
		return orcamentoClient.getOrcamentosByProduto(id);
	}
}
