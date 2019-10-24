package persistencia;

import java.awt.Window.Type;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Gson implements InterfaceGravacao {

	@Override
	public boolean gravar(List<Pessoa> list) throws IOException {
		FileWriter writer = new FileWriter("Agenda.json");
		
		GsonBuilder builder = new GsonBuilder();
	    com.google.gson.Gson gson = builder.create();
	    writer.write(gson.toJson(list));
	    writer.close();
		return false;
	}

	@Override
	public List<Pessoa> ler() throws FileNotFoundException {
	    GsonBuilder builder = new GsonBuilder();
	    com.google.gson.Gson gson = builder.create();
	    builder = new GsonBuilder();
	    gson = builder.create();
	    BufferedReader bufferedReader = new BufferedReader(new FileReader("Agenda.json"));

	    java.lang.reflect.Type listType = new TypeToken<ArrayList<Pessoa>>(){}.getType();

	    List lista = new ArrayList<Pessoa>();

	    lista = new com.google.gson.Gson().fromJson(bufferedReader, listType);

	    return lista;
	}

}
