package br.com.selecaoglobocom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.selecaoglobocom.facade.RandomProfileFacade;

@Service
public class PerfilService {

	private static final String USER_AGENT = "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2";
	private RandomProfileFacade randomProfileFacade;

	@SuppressWarnings("unused")
	private PerfilService() {
	}

	@Autowired
	public PerfilService(RandomProfileFacade randomProfileFacade) {
		this();
		this.randomProfileFacade = randomProfileFacade;

	}

	public String buscarProfiles(String countries, String format, String packages, Integer fromAge, Integer toAge,
			Integer fullChildren) throws Exception {
		return randomProfileFacade.buscarPerfis(USER_AGENT, countries, format, packages, fromAge, toAge, fullChildren);
	}
}
