package co.com.barona.microservice.resolveEnigmaApi.api;

import co.com.barona.microservice.resolveEnigmaApi.model.GetEnigmaRequest;
import co.com.barona.microservice.resolveEnigmaApi.model.GetEnigmaStepResponse;
import co.com.barona.microservice.resolveEnigmaApi.model.Header;
import co.com.barona.microservice.resolveEnigmaApi.model.JsonApiBodyRequest;
import co.com.barona.microservice.resolveEnigmaApi.model.JsonApiBodyResponseSuccess;
import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-02-27T21:16:02.967-05:00[America/Bogota]")
@Controller
public class GetStepApiController implements GetStepApi {
	private RestTemplate restTemplate;
	private final String getStep1Url = "http://localhost:8081/v1/getOneEnigma/get";
	private final String getStep2Url = "http://localhost:8082/v1/getOneEnigma/get";
	private final String getStep3Url = "http://localhost:8083/v1/getOneEnigma/get";
	
	 public GetStepApiController(RestTemplate restTemplate) {
	        this.restTemplate = restTemplate;
	    }
	
	//@EndpointInject(uri = "direct:get-step-one")
	//private FluentProducerTemplate fluentProducerTemplate;

public ResponseEntity<JsonApiBodyResponseSuccess> getStep(@ApiParam(value = "request body get enigma Step", required = true) @Valid @RequestBody JsonApiBodyRequest body) {
    	
    	
    	/*String accept = request.getHeader("Accept");
    	enigma.setAnswer("Step1: Open the regrigerator");
    	enigmas.add(enigma);
    	
    	response.setData(enigmas);
    	listResponse.add(response);
    	
    	return new ResponseEntity<>(listResponse, HttpStatus.NOT_IMPLEMENTED);*/
    	
	//fluentProducerTemplate.request();
    	GetEnigmaRequest enigmaRequest = body.getData().get(0);
        Header header = enigmaRequest.getHeader();
        String id = header.getId();
        String type = header.getType();
        String enigma = enigmaRequest.getEnigma();

        String solution = answerEnigma(enigma);

        GetEnigmaStepResponse response = new GetEnigmaStepResponse();
        response.setId(id);
        response.setType(type);
        response.setSolution(solution);

        JsonApiBodyResponseSuccess responseBody = new JsonApiBodyResponseSuccess();
        responseBody.addDataItem(response);

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    	
    }

    private String answerEnigma(String enigmaQuestion) {
        return "How to put a giraffe into a refrigerator?";
    }
    
    
	 
	 @GetMapping("/llamarservicio")
	 public ResponseEntity<String> llamarServicio() {
		 GetEnigmaRequest requestBody = new GetEnigmaRequest();
		 
		 ResponseEntity<String> responseEntity = restTemplate.getForEntity(getStep1Url, String.class);
		 ResponseEntity<String> responseEntity1 = restTemplate.getForEntity(getStep2Url, String.class);
		 ResponseEntity<String> responseEntity2 = restTemplate.getForEntity(getStep3Url, String.class);
		 //if (responseEntity != null && responseEntity.getStatusCode().is2xxSuccessful()) {
		      //  return responseEntity.getBody();
		    //}

		 
		 return new ResponseEntity<String>(responseEntity.getBody().concat(responseEntity1.getBody()).concat(responseEntity2.getBody()), HttpStatus.OK);
	 }

}