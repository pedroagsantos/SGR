package model;
import java.util.HashMap;

/**
 * Created by stark on 06/06/14.
 */
public class Universidade {

    private HashMap<String, Departamento> hmDepartamento;
    
    public void inserirDepartamento(Departamento depto) {
    	if(hmDepartamento == null) {
    		hmDepartamento = new HashMap<>();
    	}
    	hmDepartamento.put(depto.recuperarCodigo(), depto);
    }

	public HashMap<String, Departamento> recuperaMapaDepartamento() {
		return hmDepartamento;
	}

	public void modificaMapaDepartamento(HashMap<String, Departamento> hmDepartamento) {
		this.hmDepartamento = hmDepartamento;
	}
    
    
}
