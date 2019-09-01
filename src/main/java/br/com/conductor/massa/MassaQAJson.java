package br.com.conductor.massa;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MassaQAJson {
	
	public String login;
	public String senha;
	public String senhaDivergente;
	public String loginInvalido;
	public String loginValido2;
	
	public MassaQAJson() {
		massaTestJson();
	}

	public void massaTestJson() {

		JSONParser parser = new JSONParser();

		try {

			Object obj = parser
					.parse(new FileReader(System.getProperty("user.dir") + "/src/main/resources/massa.json"));

			JSONObject jsonObject = (JSONObject) obj;

			login = (String) jsonObject.get("login");
			senha = (String) jsonObject.get("senha");
			senhaDivergente = (String) jsonObject.get("senha_divergente");
			loginInvalido = (String) jsonObject.get("login_invalido");
			loginValido2 = (String) jsonObject.get("login2");
			
//			System.out.println("Login: " + login);
//			System.out.println("Senha: " + senha);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
