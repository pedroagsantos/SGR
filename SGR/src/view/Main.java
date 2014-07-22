package view;

import java.awt.EventQueue;

import model.Departamento;
import model.Professor;
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
					
					Tecnico tecnico1 = new Tecnico("Tecnico01", "1", "01@tecnico.com", "2121-2121", dtl);
					Professor prof1  = new Professor("Prof02", "2", "03@professor", "55555", dtl);
					
					tecnico1.insereSenha("");
					prof1.insereSenha("");
					
					TipoRecurso tp1 = new TipoRecurso("Projetor");
					TipoRecurso tp2 = new TipoRecurso("Microfone");
					
					tp1.inserirRecurso("1", "projetor01", Status.DISPONIVEL);
					tp1.inserirRecurso("2", "projetor02", Status.DISPONIVEL);
					tp2.inserirRecurso("3", "microfone01", Status.DISPONIVEL);
					
					dtl.inserirTecnico(tecnico1);
					dtl.inserirTipoRecurso(tp1);
					dtl.inserirTipoRecurso(tp2);
					dtl.inserirProfessor(prof1);
					
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
