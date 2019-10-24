package persistencia;

import java.io.BufferedWriter ;
import java.io.FileOutputStream ;
import java.io.IOException ;
import java.io.OutputStreamWriter ;
import java.util.ArrayList ;
import java.util.Date ;
import java.util.Iterator ;
import java.util.List ;


public class Mainsjson {

	public static void main(String[] args) {
	/*	List < Pessoa > lista = new ArrayList < Pessoa >();
		
		Pessoa pes = new Pessoa ();
		pes . setCodigo (123);
		pes . setNome ("Rodrigo");
		pes.setEmail("jose@jose");
		pes.setTelefone("745436665");
		lista . add ( pes );
		
		pes = new Pessoa ();
		pes.setCodigo (321);
		pes.setNome ("Curvello");
		pes.setEmail("jose@jose");
		pes.setTelefone("745436665");
		lista . add ( pes );
		
		Element config = new Element ("agenda");
		Document documento = new Document ( config );
		Element titulo = new Element ("titulo");
		titulo . setText ("agenda");
		Element data = new Element ("data");
		data . setText (pes.getEmail());
		config . addContent ( titulo );
		config . addContent ( data );
	
		 for (int x = 0; x < lista . size (); x ++){
		Element pessoa = new Element ("pessoa");
		pessoa . setAttribute ("codigo", String . valueOf ( lista . get (x ). getCodigo ()));
		Element nome = new Element ("nome");
		nome . setText ( lista . get (x ). getNome ());
		Element email = new Element ("email");
		email.setText(lista.get(x).getEmail());
		Element fone = new Element ("Fone");
		fone.setText(lista.get(x).getTelefone());
		pessoa.addContent(nome);
		pessoa.addContent(email);
		pessoa.addContent(fone);
		config . addContent ( pessoa );
		}
		
		XMLOutputter xout = new XMLOutputter ();
		try {
		BufferedWriter arquivo = new BufferedWriter
		( new OutputStreamWriter (
		new FileOutputStream ("agenda.xml"),"UTF-8"));
		 xout.output(documento,arquivo );
		} catch ( IOException e ) {
		e. printStackTrace ();
		}
		
		lista = new ArrayList < Pessoa >();
		Document doc = null ;

		SAXBuilder builder = new SAXBuilder ();
		try {
		doc = builder . build ("agenda.xml");
		} catch ( Exception e) {
		e. printStackTrace ();
		}
		config = doc.getRootElement ();
		 List ls = config.getChildren ("pessoa");
		
		for ( Iterator iter = ls . iterator (); iter . hasNext ();) {
		Element element = ( Element ) iter . next ();
		pes = new Pessoa ();
		pes.setCodigo ( Integer . parseInt ( element . getAttributeValue ("codigo" )));
		pes.setNome ( element . getChildText ("nome" ));
		pes.setEmail(element.getChildText("email"));
		pes.setTelefone(element.getChildText("Fone"));
		lista.add ( pes );
		 }
		 for ( Pessoa pessoa : lista ) {
		 System . out . println ( pessoa );
		 System . out . println (" ----------------");
		}

	 }	*/
		
		ExtratorUrl extrairUrl = new ExtratorUrl();
		System.out.println(extrairUrl.extrairUrl());
		//System.out.println(extrairUrl.getJson(url));
	}

}
