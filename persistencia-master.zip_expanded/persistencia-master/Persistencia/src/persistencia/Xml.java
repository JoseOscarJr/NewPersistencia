package persistencia;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class Xml implements InterfaceGravacao {
/*
	@Override
	public boolean gravar(List<Pessoa> list) throws IOException {
		
		Element config = new Element ("agenda");
		Document documento = new Document ( config );
		Element titulo = new Element ("titulo");
		titulo . setText ("agenda");
		Element data = new Element ("data");
		//data . setText ();
		config . addContent ( titulo );
		config . addContent ( data );
	
		 for (int x = 0; x < list . size (); x ++){
		Element pessoa = new Element ("pessoa");
		pessoa . setAttribute ("codigo", String . valueOf ( list . get (x ). getCodigo ()));
		Element nome = new Element ("nome");
		nome . setText ( list . get (x ). getNome ());
		Element email = new Element ("email");
		email.setText(list.get(x).getEmail());
		Element fone = new Element ("Fone");
		fone.setText(list.get(x).getTelefone());
		pessoa.addContent(nome);
		pessoa.addContent(email);
		pessoa.addContent(fone);
		config . addContent ( pessoa );
		}
		return false;
	}

	@Override
	public List<Pessoa> ler() throws FileNotFoundException {
		List list = new ArrayList<Pessoa>();
		Element config = new Element ("agenda");
		Document documento = new Document (config);
		Pessoa pes = new Pessoa();
		
		XMLOutputter xout = new XMLOutputter ();
		try {
		BufferedWriter arquivo = new BufferedWriter
		( new OutputStreamWriter (
		new FileOutputStream ("agenda.xml"),"UTF-8"));
		 xout.output(documento,arquivo );
		} catch ( IOException e ) {
		e. printStackTrace ();
		}
		
		list = new ArrayList < Pessoa >();
		Document doc = null ;

		SAXBuilder builder = new SAXBuilder ();
		try {
		doc = builder . build ("agenda.xml");
		} catch ( Exception e) {
		e. printStackTrace ();
		}
		config = doc . getRootElement ();
		 List ls = config . getChildren ("pessoa");
		
		for ( Iterator iter = ls . iterator (); iter . hasNext ();) {
			Element element = ( Element ) iter . next ();
			pes = new Pessoa ();
			pes . setCodigo ( Integer . parseInt ( element . getAttributeValue ("codigo" )));
			pes . setNome ( element . getChildText ("nome" ));
			pes.setEmail(element.getChildText("email"));
			pes.setTelefone(element.getChildText("Fone"));
			list.add(pes);
		 }
		return null;
	}*/
	}
}
