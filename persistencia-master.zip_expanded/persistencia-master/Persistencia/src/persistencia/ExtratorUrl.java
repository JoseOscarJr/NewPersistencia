package persistencia;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ExtratorUrl {
	
	private static final String URL_API = "http://www.curvello.com/gerador/pessoa/3";
	
	public List<Pessoa> extrairUrl() {
		List<Pessoa> pessoaLista = new ArrayList<Pessoa>();
		HttpURLConnection con = null;
		try {
			System.out.println("teste");
			URL url = new URL(URL_API);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.connect();

			switch (con.getResponseCode()) {
			case 200:

				System.out.println("JSON recebido!");
				String json = getJson(url);
				String[] pessoa = json.split("}");
				
				for (int i = 0; i < pessoa.length-1; i++) {
					Pessoa pessoaP = new Pessoa();
					pessoa[i] = pessoa[i].substring(1, pessoa[i].length());
					String[] atributosPessoa = pessoa[i].split(",");
					for (int j = 0; j < atributosPessoa.length; j++) {
						atributosPessoa[j]=atributosPessoa[j].replace("\"", "");
						atributosPessoa[j]=atributosPessoa[j].replace("{", "");
						atributosPessoa[j]=atributosPessoa[j].replace("\\", "");
						atributosPessoa[j]=atributosPessoa[j].replace("/", "-");
	
					}

					String[] pessoaS = atributosPessoa[0].split(":");
					pessoaP.setCodigo(Integer.parseInt(pessoaS[1]));
					pessoaS= atributosPessoa[1].split(":");
					pessoaP.setNome(pessoaS[1]);
					pessoaS= atributosPessoa[2].split(":");
					pessoaP.setEmail(pessoaS[1]);
					pessoaS= atributosPessoa[3].split(":");
					pessoaP.setTelefone(pessoaS[1]);
					pessoaS= atributosPessoa[4].split(":");
					pessoaS = pessoaS[1].split("-");
					Calendar calendario = Calendar.getInstance();
					calendario.set(Calendar.DAY_OF_MONTH, Integer.parseInt(pessoaS[0]));
					calendario.set(Calendar.MONTH, Integer.parseInt(pessoaS[1])-1);
					calendario.set(Calendar.YEAR, Integer.parseInt(pessoaS[2]));
					Date data = calendario.getTime();
					pessoaP.setDataNascimento(data);
					pessoaLista.add(pessoaP);
					
				}

				break;
			case 500:
				System.out.println("Status 500");
				break;
			default:
				System.out.println("teste1");
				break;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.disconnect();
		}
		return pessoaLista;
	}

	public static String getJson(URL url) {
		if (url == null)
			throw new RuntimeException("URL é null");

		String html = null;
		StringBuilder sB = new StringBuilder();
		try (BufferedReader bR = new BufferedReader(new InputStreamReader(url.openStream()))) {
			while ((html = bR.readLine()) != null)
				sB.append(html);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sB.toString();
		
	}
}
