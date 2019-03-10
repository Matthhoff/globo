package br.com.selecaoglobocom.facade;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://randomprofile.com", name = "profile")
public interface RandomProfileFacade {
    @RequestMapping(method = RequestMethod.GET,
            path = "/api/api.php")
    String buscarPerfis(@RequestParam(value="countries") String countries);
}