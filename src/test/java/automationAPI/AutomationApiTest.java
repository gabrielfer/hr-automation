package automationAPI;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.equalTo;

public class AutomationApiTest {

    private String validCep = "91225-150";
    private String validLogradouro = "Rua Doutor Derly Monteiro";
    private String validBairro = "Jardim Itu";
    private String validLocalidade = "Porto Alegre";
    private String validUf = "RS";
    private String validIbge = "4314902";

    private String wrongCep = "91225999";

    private String incompleteCep = "9122515";

    private String exceedNumbersCep = "912251500";

    private String cepWithChars = "91225ABC";

    @Test
    public void testValidCep() {
        expect().body("cep", equalTo(validCep))
                .body("logradouro", equalTo(validLogradouro))
                .body("bairro", equalTo(validBairro))
                .body("localidade", equalTo(validLocalidade))
                .body("uf", equalTo(validUf))
                .body("ibge", equalTo(validIbge))
                .when().get("https://viacep.com.br/ws/" + validCep + "/json/");
        expect().statusCode(200);
    }

    @Test
    public void testWrongCep() {
        expect().body("erro", equalTo(true)).statusCode(200).when().get("https://viacep.com.br/ws/" + wrongCep + "/json/");
    }

    @Test
    public void testIncompleteCep(){
        expect().statusCode(404).when().get("https://viacep.com.br/ws/" + incompleteCep + "/json/");
    }

    @Test
    public void testExceedNumbersCep(){
        expect().statusCode(404).when().get("https://viacep.com.br/ws/" + exceedNumbersCep + "/json/");
    }

    @Test
    public void testCepWithChars(){
        expect().statusCode(404).when().get("https://viacep.com.br/ws/" + cepWithChars + "/json/");
    }
}
