package persistencia;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface InterfaceGravacao {
	
	public boolean gravar(List<Pessoa> list) throws IOException;
	public List<Pessoa> ler() throws FileNotFoundException;

}
