package br.com.orcamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import br.com.orcamento.clients.ProdutoClient;

@Service
public class OrcamentoService {

	@Autowired
	private ProdutoClient produtoClient;
	
	@HystrixCommand(fallbackMethod="getProdutosFallback",
				commandProperties = {
					@HystrixProperty(name="execution.isolation.strategy", value="THREAD"),
				    @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="5"),
				    @HystrixProperty(name="requestCache.enabled", value="false")
				},
				threadPoolProperties = {
					@HystrixProperty(name="coreSize", value="5"),
					@HystrixProperty(name="maximumSize", value="5")	
				}
			)
	public ResponseEntity<String> getProdutos() {
		return produtoClient.getProdutos();
	}
	
	public ResponseEntity<String> getProdutosFallback() {
		return new ResponseEntity<String>("Executou o fallbackMethod", HttpStatus.OK);
	}
}
