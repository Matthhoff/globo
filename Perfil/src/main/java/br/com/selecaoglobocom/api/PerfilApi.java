package br.com.selecaoglobocom.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.selecaoglobocom.service.PerfilService;

@RestController
@RequestMapping("/perfil")
public class PerfilApi {

	private PerfilService perfilService;

	@Autowired
	public PerfilApi(PerfilService perfilService) {
		this.perfilService = perfilService;
	}

	@GetMapping(path = "")
	public ResponseEntity<String> buscarPerfis(@RequestParam(required=true) String countries,
			@RequestParam(required=false) String format,
			@RequestParam(required=false) String packages,
			@RequestParam(required=false) Integer fromAge,
			@RequestParam(required=false) Integer toAge,
			@RequestParam(required=false) Integer fullChildren)
			throws Exception {
		String perfis = perfilService.buscarProfiles(countries, format, packages, fromAge, toAge, fullChildren);
		return ResponseEntity.ok(perfis);
	}

}
