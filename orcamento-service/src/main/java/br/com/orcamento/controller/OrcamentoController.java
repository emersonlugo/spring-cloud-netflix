package br.com.orcamento.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orcamento.service.OrcamentoService;

@RestController
@RequestMapping(value= "/v1/api/orcamentos", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
public class OrcamentoController {

	@Autowired
	private OrcamentoService orcamentoService;
	
	@GetMapping
	public List<String> getAll() {
		ResponseEntity<String> produtos = orcamentoService.getProdutos();
		System.out.println(produtos.getBody());
		return Arrays.asList("Orçamento 1", "Orçamento 2");
	}
	
	@GetMapping("/produto/{id}")
	public ResponseEntity<String> getOrcamentosByProduto(@PathVariable Long id) {
		System.out.println(String.format("Obtendo orçamentos para o produto: %s", id) );
		return new ResponseEntity<>("Orçamentos: 1,2", HttpStatus.OK);
	}
}
