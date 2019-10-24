package persistencia;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Agenda {
	List<Pessoa> listaPessoa = new ArrayList<Pessoa>();
	
	public void incluir(Pessoa pessoa) {
		listaPessoa.add(pessoa);
	}
	
	public boolean excluir(Pessoa pessoa) {
		for (Pessoa pessoalista : listaPessoa) {
			if(pessoalista.getCodigo() == pessoa.getCodigo() ) {
				System.out.println(pessoalista);
				listaPessoa.remove(pessoalista);
				return true;
			}
		}
		return false;
	}
	public Pessoa consulta(String nome) {
		Pessoa pessoa = new Pessoa();
		for (Pessoa pessoaLista : listaPessoa) {
			if(nome.contains((pessoaLista.getNome()))) {
				pessoa = pessoaLista;
			}
		}
		return pessoa;
	}
	public List<Pessoa> listaPessoaAniversariantes(int mes){
		List<Pessoa> aniversariantesMes = new ArrayList<Pessoa>();
		Calendar calendario = Calendar.getInstance();
		for (Pessoa pessoa2 : listaPessoa) {
			calendario.setTime(pessoa2.getDataNascimento());
			if((calendario.get(Calendar.MONTH)) == mes) {
				aniversariantesMes.add(pessoa2);
			}
		}
		return aniversariantesMes;
	}
	public List<Pessoa> listaPessoaDominio(String dominioString){
		List<Pessoa> dominioEmail = new ArrayList<Pessoa>();
		for (Pessoa pessoa2 : listaPessoa) {
			String dominio[] = pessoa2.getEmail().split("@");
			if(dominio[1].equalsIgnoreCase(dominioString)) {
				dominioEmail.add(pessoa2);
			}
		}
		return dominioEmail;
	}
	public void atualizarLista (List<Pessoa> lista) {
		listaPessoa = lista;
	}
	public Pessoa localizarPessoa(int codigo) {
		Pessoa pessoa = new Pessoa();
		for (Pessoa pessoaLista : listaPessoa) {
			if(codigo == pessoaLista.getCodigo()) {
				pessoa = pessoaLista;
			}
		}
		return pessoa;
	}
	public List<Pessoa> consultaNome(String nome){
		List<Pessoa> nomeLista = new ArrayList<Pessoa>();
		for (Pessoa pessoa : listaPessoa) {
			if(pessoa.getNome().startsWith(nome)) {
				nomeLista.add(pessoa);
			}
		}
		return nomeLista;
	}
}



