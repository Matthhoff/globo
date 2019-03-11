package br.com.selecaoglobocom;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PerfilApiTests {
	
	@LocalServerPort
    private int port;
    
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testaBuscarPerfisSemParametros() {
        String url = "http://localhost:" + port + "/perfil";
        ResponseEntity<String> resposta = restTemplate.getForEntity(url, String.class);
        assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
    }
    
    @Test
    public void testaBuscarPerfisComParametros() {
        String url = "http://localhost:" + port + "/perfil?countries=GBR";
        ResponseEntity<String> resposta = restTemplate.getForEntity(url, String.class);
        assertEquals(HttpStatus.OK, resposta.getStatusCode());
    }

}
