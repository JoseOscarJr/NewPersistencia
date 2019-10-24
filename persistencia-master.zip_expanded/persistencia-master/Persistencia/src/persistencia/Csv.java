package persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Csv implements InterfaceGravacao {
	

	@Override
	public boolean gravar(List<Pessoa> listaPessoa) throws IOException {

		FileWriter arq = new FileWriter("agenda.csv");
		PrintWriter gravarArq = new PrintWriter(arq);
		
		for (Pessoa pessoa: listaPessoa) {
			Calendar calendario = Calendar.getInstance();
			calendario.setTime(pessoa.getDataNascimento());
			String data = (Integer.toString(calendario.get(Calendar.DAY_OF_MONTH)) )+"-"+(Integer.toString(calendario.get(Calendar.MONTH))+"-"+(Integer.toString(calendario.get(Calendar.YEAR))));
			gravarArq.printf("%d;%s;%s;%s;%s\n",pessoa.getCodigo(),pessoa.getNome(),pessoa.getEmail(),pessoa.getTelefone(),data);
		}
		arq.close();
		return false;
	}
	@Override
	public List<Pessoa> ler() {	
		List<Pessoa> listaPessoa = new ArrayList<Pessoa>();
		Pessoa p = new Pessoa();
	try {
		FileReader arq1 = new FileReader("agenda.csv");
		BufferedReader lerArq = new BufferedReader(arq1);
		String linha = lerArq.readLine();
		String[] data;
		Calendar calendario = Calendar.getInstance();
		while(linha != null) {
			String[] leitura = linha.split(";");
			p = new Pessoa();
			p.setCodigo(Integer.parseInt(leitura[0]));
			p.setNome(leitura[1]);
			p.setEmail(leitura[2]);
			p.setTelefone(leitura[3]);
			data = leitura[4].split("-");
			calendario.set(Calendar.DAY_OF_MONTH, Integer.valueOf(data[0]));
			calendario.set(Calendar.MONTH, Integer.valueOf(data[1]));
			calendario.set(Calendar.YEAR, Integer.valueOf(data[2]));
			Date data1 = calendario.getTime();
			p.setDataNascimento(data1);
			listaPessoa.add(p);
			linha = lerArq.readLine();
		}
		arq1.close();
	} catch (Exception e) {
		System.err.printf("erro na abertura do arquivo: %s. \n",
		e.getMessage());
	}
	return listaPessoa;
	
	}
	
}

