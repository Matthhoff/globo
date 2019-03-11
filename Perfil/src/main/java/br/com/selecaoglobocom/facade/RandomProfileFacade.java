package br.com.selecaoglobocom.facade;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "https://randomprofile.com", name = "profile")
public interface RandomProfileFacade {
	@RequestMapping(method = RequestMethod.GET, path = "/api/api.php")
	String buscarPerfis(@RequestHeader("User-Agent") String userAgent,
			@RequestParam(value = "countries", required=true) String countries, 
			@RequestParam(value = "format", required=false) String format, 
			@RequestParam(value = "packages", required=false) String packages, 
			@RequestParam(value = "fromAge", required=false) Integer fromAge,
			@RequestParam(value = "toAge", required=false) Integer toAge, 
			@RequestParam(value = "fullChildren", required=false) Integer fullChildren);
}