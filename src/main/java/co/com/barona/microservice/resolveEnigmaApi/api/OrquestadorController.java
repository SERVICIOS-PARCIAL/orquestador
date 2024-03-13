package co.com.barona.microservice.resolveEnigmaApi.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import co.com.barona.microservice.resolveEnigmaApi.model.GetEnigmaRequest;

public class OrquestadorController {
	
	private RestTemplate restTemplate;
	private final String getStep1Url = "http://localhost:8081/resolveEnigmaApi/getStep";
	private final String getStep2Url = "http://localhost:8082/resolveEnigmaApi/getStep";
	private final String getStep3Url = "http://localhost:8083/resolveEnigmaApi/getStep";
	
	 public OrquestadorController(RestTemplate restTemplate) {
	        this.restTemplate = restTemplate;
	    }
	 
	 public String llamarServiciosExteriores(){
		 
		 String resultadoFinal = "";
		 
		 String resultadoServicio1 = llamarServicio(getStep1Url);
		 resultadoFinal += resultadoServicio1;
		 
		 String resultadoServicio2 = llamarServicio(getStep2Url);
		 resultadoFinal += resultadoServicio2;
		 
		 String resultadoServicio3 = llamarServicio(getStep3Url);
		 resultadoFinal += resultadoServicio3;
		 
		 return resultadoFinal;
		 
	 }
	 
	 @GetMapping("/llamarservicio")
	 private String llamarServicio(String Url) {
		 GetEnigmaRequest requestBody = new GetEnigmaRequest();
		 
		 ResponseEntity<String> responseEntity = restTemplate.postForEntity(getStep1Url, requestBody, String.class);
		 ResponseEntity<String> responseEntity1 = restTemplate.postForEntity(getStep2Url, requestBody, String.class);
		 ResponseEntity<String> responseEntity2 = restTemplate.postForEntity(getStep3Url, requestBody, String.class);
		 //if (responseEntity != null && responseEntity.getStatusCode().is2xxSuccessful()) {
		      //  return responseEntity.getBody();
		    //}

		 
		 return llamarServiciosExteriores();
	 }
	 

}
