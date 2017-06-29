package br.com.orcamento.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("produto-service")
public interface ProdutoClient {

	@GetMapping("/v1/api/produtos")
	public ResponseEntity<String> getProdutos();
}
