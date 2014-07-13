package model;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stark on 06/06/14.
 */
public class Universidade {
	
    protected Universidade() {
    	
    }
	private List<Departamento> departamentos;
    private static Universidade univerSingleton = null;
    
    public static Universidade recuperaInstancia(){
    	if(univerSingleton == null){
    		univerSingleton = new Universidade();
    	}
    		return univerSingleton;
    }
    
    public void inserirDepartamento(Departamento depto) {
    	if(univerSingleton.departamentos == null) {
    		univerSingleton.departamentos = new ArrayList<Departamento>();
    	}
    	univerSingleton.departamentos.add(depto);
    }

	public List<Departamento> recuperaDepartamentos(){
		return univerSingleton.departamentos;
	}
	
}
