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
    private Intervalo intervalo;
    private String codigo;
    private Integer status;
    
    public Atividade(String codigo, Professor prof, Tecnico tec, List<Recurso> recursos, Intervalo intervalo, Status status) {
		// TODO Auto-generated constructor stub
    	this.professorResponsavel = (Professor) prof;
    	this.tecnicoResponsavel = tec;
   
    	for (Object recurso : recursos)
    		hmRecurso.put(((Recurso) recurso).recuperarPatrimonio(), (Recurso) recurso);

    	this.intervalo = intervalo;
    	this.codigo = codigo;
    	this.status = status.valor();
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
