package br.com.produto.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "orcamento-service", fallback = OrcamentoClientFallback.class)
public interface OrcamentoClient {

	@GetMapping("/v1/api/orcamentos/produto/{id}")
	public ResponseEntity<String> getOrcamentosByProduto(@PathVariable("id") Long id);
}
