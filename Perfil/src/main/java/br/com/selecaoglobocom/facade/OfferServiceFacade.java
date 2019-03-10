package br.com.selecaoglobocom.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class OfferServiceFacade {

	private Logger logger = LoggerFactory.getLogger(OfferServiceFacade.class);

	@Nullable
	public String teste() throws Exception {
		try {
			RestTemplate restTemplate = new RestTemplate();
			
			String url = "http://randomprofile.com/api/api.php?countries=GBR";
			ResponseEntity<String> postForEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
			return postForEntity.getBody();
		} catch (HttpClientErrorException ex) {
			ex.printStackTrace();
			logger.error("Error retrieving complete offer from offer-service");
		}
		return null;
	}
}
