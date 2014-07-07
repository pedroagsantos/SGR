package view;

import java.awt.EventQueue;

import model.Departamento;
import model.Professor;
import model.Recurso;
import model.Tecnico;
import model.TipoRecurso;
import model.Universidade;
import control.ControleInstitucional;

public class Main {
	
	public static Universidade ufrrj;
	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					
					ufrrj = new Universidade();
					ControleInstitucional c = new ControleInstitucional();
					
					ufrrj.inserirDepartamento(ControleInstitucional.depto);
					
					Professor prof1 = new Professor("Professor01", "1", "01@professor.com", "2222-2222", 0);
					
					TipoRecurso tp1 = new TipoRecurso("Projetor");
					TipoRecurso tp2 = new TipoRecurso("Microfone");
					
					Recurso recurso1 = new Recurso("1", "projetor01", 2);
					Recurso recurso2 = new Recurso("2", "projetor02", 2);
					Recurso recurso3 = new Recurso("3", "microfone01", 2);
					
					Tecnico tecnico1 = new Tecnico("Tecnico01", "2", "01@tecnico.com", "2121-2121", 0);
					
					
					//c.inserir(ControleInstitucional.depto);
					c.inserir(prof1);
					c.inserir(tp1);
					c.inserir(tp2);
					c.inserir(tecnico1);
					
					tp1.inserir(recurso1);
					tp1.inserir(recurso2);
					tp2.inserir(recurso3);
					
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
