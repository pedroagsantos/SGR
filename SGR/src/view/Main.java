package view;

import java.awt.EventQueue;

import model.Departamento;
import model.Professor;
import model.Recurso;
import model.Tecnico;
import model.TipoRecurso;
import model.Universidade;
import model.Usuario;

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
					
					Usuario tecnico1 = new Tecnico("Tecnico01", "2", "01@tecnico.com", "2121-2121", dtl);
					Usuario prof1 = new Professor("Professor01", "1", "01@professor.com", "2222-2222", dtl);
					tecnico1.insereSenha("foca");
					prof1.insereSenha("foca");
					TipoRecurso tp1 = new TipoRecurso("Projetor");
					TipoRecurso tp2 = new TipoRecurso("Microfone");
					
					Recurso recurso1 = new Recurso("1", "projetor01", 2);
					Recurso recurso2 = new Recurso("2", "projetor02", 2);
					Recurso recurso3 = new Recurso("3", "microfone01", 2);
					
					tp1.inserir(recurso1);
					tp1.inserir(recurso2);
					tp2.inserir(recurso3);
					
					dtl.inserir(prof1);
					dtl.inserir(tecnico1);
					dtl.inserir(tp1);
					dtl.inserir(tp2);
					
					
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
