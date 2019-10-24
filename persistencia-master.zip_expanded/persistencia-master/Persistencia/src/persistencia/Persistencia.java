package persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Persistencia {
	private InterfaceGravacao g;
	
	public Persistencia(InterfaceGravacao g) {
		this.g = g;
	}
	
	public boolean gravar(List<Pessoa> list) throws IOException {
		return g.gravar(list);
		
	}
	public List<Pessoa> ler() throws FileNotFoundException{
		return g.ler();
	}
}

