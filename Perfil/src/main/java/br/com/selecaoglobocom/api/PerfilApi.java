package br.com.selecaoglobocom.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.selecaoglobocom.service.PerfilService;

@RestController
@RequestMapping("/perfil")
public class PerfilApi {

	private Logger log = LoggerFactory.getLogger(PerfilApi.class);

	private PerfilService perfilService;

	@Autowired
	public PerfilApi(PerfilService perfilService) {
		this.perfilService = perfilService;
	}

	@GetMapping(path = "")
	public ResponseEntity<String> getOriginationStatus(@RequestParam String countries)
			throws Exception {
		log.info("Get profiles from input data");
		String perfis = perfilService.buscarProfiles(countries);
		return ResponseEntity.ok(perfis);
	}

}
