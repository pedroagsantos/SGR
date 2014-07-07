package model;
import java.util.HashMap;
import java.util.List;

/**
 * Created by stark on 06/06/14.
 */
public class Atividade {

    private Professor professorResponsavel;
    private Tecnico tecnicoResponsavel;
    private HashMap<String, Recurso> hmRecurso = new HashMap<>();
    private int intervalo;
    private String codigo;
    private Integer status;
    
    public Atividade(String codigo, Object prof, Tecnico tec, List<Object> recursos, int intervalo, int status) {
		// TODO Auto-generated constructor stub
    	this.professorResponsavel = (Professor) prof;
    	this.tecnicoResponsavel = tec;
   
    	for (Object recurso : recursos)
    		hmRecurso.put(((Recurso) recurso).recuperarPatrimonio(), (Recurso) recurso);

    	this.intervalo = intervalo;
    	this.codigo = codigo;
    	this.status = status;
	}

    public int recuperarStatus() {
        return status;
    }

    public void modificarStatus(int status) {
        this.status = status;
    }

    public String recuperarCodigo() {
        return codigo;
    }

    public void modificarCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "Codigo: "+codigo + "\n" +
    			professorResponsavel + "\n" +
    			tecnicoResponsavel +  "\n" +
    			hmRecurso.values()	+ "\n" +
    			intervalo;
    }
}
