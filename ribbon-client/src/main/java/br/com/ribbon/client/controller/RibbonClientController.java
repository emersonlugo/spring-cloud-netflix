package br.com.ribbon.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value= "/v1/api/client", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
public class RibbonClientController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/message/big")
	public String showBigMessage() {
		String smallMessage = "";
		try {
			smallMessage = restTemplate.getForObject("http://ribbon-client/message/small", String.class);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return smallMessage.concat(" How are you?");
	}
	
	@GetMapping("/message/small")
	public String showSmallMessage() {
		return "Hello!";
	}
}
