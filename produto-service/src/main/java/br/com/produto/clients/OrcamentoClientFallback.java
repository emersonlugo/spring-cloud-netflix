package br.com.produto.clients;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class OrcamentoClientFallback implements OrcamentoClient {

	@Override
	public ResponseEntity<String> getOrcamentosByProduto(Long id) {
		System.err.println("Executando fallback para getOrcamentosByProduto");
		return new ResponseEntity<>("Orçamentos recuperados no fallback", HttpStatus.OK);
	}

}
