package br.com.selecaoglobocom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import br.com.selecaoglobocom.facade.OfferServiceFacade;
import br.com.selecaoglobocom.facade.RandomProfileFacade;

@Service
public class PerfilService {

	private RandomProfileFacade randomProfileFacade;
	private OfferServiceFacade offerServiceFacade;

	@SuppressWarnings("unused")
	private PerfilService() {
	}

	@Autowired
	public PerfilService(RandomProfileFacade randomProfileFacade, OfferServiceFacade offerServiceFacade) {
		this();
		this.randomProfileFacade = randomProfileFacade;
		this.offerServiceFacade = offerServiceFacade;

	}

	public String buscarProfiles(String countries) throws Exception {
//		return randomProfileFacade.buscarPerfis("GBR");
		return offerServiceFacade.teste();
	}
}
