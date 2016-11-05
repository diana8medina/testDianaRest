package example.microservice;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name="miServicio")
public class micro {
	List<String> listadoPlacas = new ArrayList<String>();
	
	@WebMethod()
	public String sayHello(@WebParam(name="nombre") String name) {
	    System.out.println("Hello: " + name);
	    return "Hello " + name + "!";
	}
	
	@WebMethod()
	public int sumar(@WebParam(name="valor1") int a,@WebParam(name="valor2") int b) {
	    System.out.println("sumar: " + (a+b));
	    return (a+b);
	}
	
	@WebMethod()
	public List<String> listPlacaRobadas() {		
		listadoPlacas.add("Placa1");
		listadoPlacas.add("Placa2");
		listadoPlacas.add("Placa3");
		return listadoPlacas;
	}
	@WebMethod()
	public Boolean isPlacaRobada(String placa) {
		Boolean result = false;
		for (String pl : listPlacaRobadas()) {
			if (pl.equals(placa)) {
				result = true;
			}			
		}		
		return result;
	}
}
