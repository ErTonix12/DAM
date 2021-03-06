package p2;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.sun.xml.bind.v2.runtime.JAXBContextImpl.JAXBContextBuilder;

public class Ejecutable {
	
	static Set<Persona> lista = new HashSet<>();
	
	public static void main(String[] args) {
		
		
		aprovisionar(lista);
		imprime1(lista);
		validar(lista);
		imprime1(lista);
		
		guardaXML(new WrapperForXML(lista));
	}
	public static void aprovisionar(Collection<Persona> c) {
		Persona p1=new Persona("30303030H","Juan");
		Persona p2=new Persona("80808080J","Maria");
		Persona p3=new Persona("X0523821F","Pedro");
		Persona p4=new Persona("30303030H","Pepe");
		Persona p5=new Persona("8080X","Hacker");
		c.add(p1);
		c.add(p2);
		c.add(p3);
		c.add(p4);
		c.add(p5);
	}
	/**
	 * 
	 * @param p Colección de Persona cuyo identificador se quiere validar. 
	 * Recorre con un iterador la colección y va comprobando que el identificador
	 * de las personas cumple el siguiente formato:
	 *  DNI: 8 dígitos y una letra
	 *  NIE: letra, 7 dígitos y letra
	 *  Si no cumple ninguna de los formatos (mediante expresiones regulares) debe eliminar 
	 *  el elemento.
	 */
	public static void validar(Collection<Persona> c) {
	  
	  Iterator<Persona> it = c.iterator();
	  while (it.hasNext()) {
      Persona persona = (Persona) it.next();
      if(persona.getId().matches("[0-9]{8}[a-zA-Z]") || persona.getId().matches("[a-zA-Z][0-9]{7}[a-zA-Z]")) {
        //dni o nie valido
      }else {
        it.remove();
      }
    }
		
	}
	
	public static void imprime1(Collection<Persona> c) {
		System.out.println("-----------------");
		for(Persona p: c) {
			System.out.println("- "+p.getId()+" : "+p.getName());
		}
		System.out.println("-----------------");
	}
	
	
	public static void guardaXML(WrapperForXML c) {
	  try {
      JAXBContext jc = JAXBContext.newInstance(WrapperForXML.class);
      Marshaller m = jc.createMarshaller();
      m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      m.marshal(c,  new File("examen.xml"));
    } catch (JAXBException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } 
		
	}
}
