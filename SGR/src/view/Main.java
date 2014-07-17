package view;

import java.awt.EventQueue;

import model.Departamento;
import model.Professor;
import model.Recurso;
import model.Status;
import model.Tecnico;
import model.TipoRecurso;
import model.Universidade;

public class Main {
	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLogin window = new ViewLogin();
					
					Departamento dtl = new Departamento("DTL", "Departamento de Tecnologias e Linguagens");
					Departamento dat = new Departamento("DAT", "Departamento de Administracao e Turismo");
					
					Universidade.recuperaInstancia().inserirDepartamento(dat);
					Universidade.recuperaInstancia().inserirDepartamento(dtl);
					
					Tecnico tecnico1 = new Tecnico("Tecnico01", "2", "01@tecnico.com", "2121-2121", dtl);
					Professor prof1 = new Professor("Professor01", "", "01@professor.com", "2222-2222", dtl);
					tecnico1.insereSenha("2");
					prof1.insereSenha("");
					TipoRecurso tp1 = new TipoRecurso("Projetor");
					TipoRecurso tp2 = new TipoRecurso("Microfone");
					
					Recurso recurso1 = new Recurso("1", "projetor01", Status.DISPONIVEL);
					Recurso recurso2 = new Recurso("2", "projetor02", Status.DISPONIVEL);
					Recurso recurso3 = new Recurso("3", "microfone01", Status.DISPONIVEL);
					
					tp1.inserir(recurso1);
					tp1.inserir(recurso2);
					tp2.inserir(recurso3);
					
					dtl.inserirProfessor(prof1);
					dtl.inserirTecnico(tecnico1);
					dtl.inserirTipoRecurso(tp1);
					dtl.inserirTipoRecurso(tp2);
					
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
