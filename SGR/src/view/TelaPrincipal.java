package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import model.Professor;
import model.Tecnico;
import model.Usuario;
import net.miginfocom.swing.MigLayout;

public class TelaPrincipal extends JFrame{
	private ViewProfessor viewProfessor;
	private ViewAtividade viewAtividade;
	private ViewBuscarAtividades viewBuscarAtividades;
	private ViewTecnico viewTecnico;
	private ViewTipoRecurso viewTipoRecurso;
	private ViewAvaliarAtividadesPendentes viewAtividadesPendentes; 
	private JMenuBar menuBar;
	private JMenu mnCadastro;
	private JMenu mnSolicitao;
	private JMenu mnGerenciarAtividades;
	//private JMenuItem mntmMinhasAtividades;
	private JMenuItem mntmCancelarAtividade;
	private JMenuItem mntmAvaliarAtividadesPendente;
	private JMenuItem mntmProfessor;
	private JMenuItem mntmTecnico;
	private JMenuItem mntmTipoDeRecurso;
	private JMenuItem mntmRecurso;
	private JMenuItem mntmNovaSolicitao;
	private JMenuItem mntmBuscarAtividade;

	private void inicializeTecnico() {
		
		
		ActionListener abrirCadProfessor = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewProfessor = new ViewProfessor();
				
			}
		};
		
		ActionListener abrirCadAtividade = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewAtividade = new ViewAtividade();
				
			}
		};
		
		ActionListener abrirBuscarAtividade = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewBuscarAtividades = new ViewBuscarAtividades();
				
			}
		};
		
		ActionListener abrirCadTecnico = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewTecnico = new ViewTecnico();
				
			}
		};
		
		ActionListener abrirCadTipoRecurso = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewTipoRecurso = new ViewTipoRecurso();
				
			}
		};
		
		ActionListener abrirAvaliarAtividadesPendentes = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewAtividadesPendentes = new ViewAvaliarAtividadesPendentes();
				
			}
		};
		
		ActionListener abrirMinhasAtividades = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewAtividadesPendentes = new ViewAvaliarAtividadesPendentes();
				
			}
		};
		
		setSize(800,600);
		getContentPane().setLayout(new MigLayout("", "[]", "[]"));
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		mntmTecnico = new JMenuItem("Tecnico");
		mnCadastro.add(mntmTecnico);
		mntmTecnico.addActionListener(abrirCadTecnico);
		
		mntmProfessor = new JMenuItem("Professor");
		mnCadastro.add(mntmProfessor);
		mntmProfessor.addActionListener(abrirCadProfessor);
		
		mntmTipoDeRecurso = new JMenuItem("Tipo de Recurso");
		mnCadastro.add(mntmTipoDeRecurso);
		mntmTipoDeRecurso.addActionListener(abrirCadTipoRecurso);
		
		mntmRecurso = new JMenuItem("Recurso");
		mnCadastro.add(mntmRecurso);
		
		mnSolicitao = new JMenu("Solicita\u00E7\u00E3o");
		menuBar.add(mnSolicitao);
		
		mntmNovaSolicitao = new JMenuItem("Nova Solicita\u00E7\u00E3o");
		mnSolicitao.add(mntmNovaSolicitao);
		mntmNovaSolicitao.addActionListener(abrirCadAtividade);
		
		mnGerenciarAtividades = new JMenu("Gerenciar Atividade");
		menuBar.add(mnGerenciarAtividades);
		
		/*mntmMinhasAtividades = new JMenuItem("Minhas Atividades");
		mnGerenciarAtividades.add(mntmMinhasAtividades);
		mntmMinhasAtividades.addActionListener(abrirAvaliarAtividadesPendentes);*/
		
		mntmBuscarAtividade = new JMenuItem("Buscar Atividade");
		mnGerenciarAtividades.add(mntmBuscarAtividade);
		mntmBuscarAtividade.addActionListener(abrirBuscarAtividade);
		
	}
	
	private void inicializeProfessor() {
		
		
		ActionListener abrirCadProfessor = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewProfessor = new ViewProfessor();
				
			}
		};
		
		ActionListener abrirCadAtividade = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewAtividade = new ViewAtividade();
				
			}
		};
		
		ActionListener abrirBuscarAtividade = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewBuscarAtividades = new ViewBuscarAtividades();
				
			}
		};
		
		ActionListener abrirCadTecnico = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewTecnico = new ViewTecnico();
				
			}
		};
		
		ActionListener abrirCadTipoRecurso = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewTipoRecurso = new ViewTipoRecurso();
				
			}
		};
		
		ActionListener abrirAvaliarAtividadesPendentes = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewAtividadesPendentes = new ViewAvaliarAtividadesPendentes();
				
			}
		};
		
		ActionListener abrirCancelarAtividade = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewAtividadesPendentes = new ViewAvaliarAtividadesPendentes();
				
			}
		};
		
		setSize(800,600);
		getContentPane().setLayout(new MigLayout("", "[]", "[]"));
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		/*mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		mntmTecnico = new JMenuItem("Tecnico");
		mnCadastro.add(mntmTecnico);
		mntmTecnico.addActionListener(abrirCadTecnico);
		
		mntmProfessor = new JMenuItem("Professor");
		mnCadastro.add(mntmProfessor);
		mntmProfessor.addActionListener(abrirCadProfessor);
		
		mntmTipoDeRecurso = new JMenuItem("Tipo de Recurso");
		mnCadastro.add(mntmTipoDeRecurso);
		mntmTipoDeRecurso.addActionListener(abrirCadTipoRecurso);
		
		mntmRecurso = new JMenuItem("Recurso");
		mnCadastro.add(mntmRecurso);*/
		
		mnSolicitao = new JMenu("Solicita\u00E7\u00E3o");
		menuBar.add(mnSolicitao);
		
		mntmNovaSolicitao = new JMenuItem("Nova Solicita\u00E7\u00E3o");
		mnSolicitao.add(mntmNovaSolicitao);
		mntmNovaSolicitao.addActionListener(abrirCadAtividade);
		
		mntmBuscarAtividade = new JMenuItem("Buscar Solicita\u00E7\u00E3o");
		mnSolicitao.add(mntmBuscarAtividade);
		mntmBuscarAtividade.addActionListener(abrirBuscarAtividade);
		
		mnGerenciarAtividades = new JMenu("Gerenciar atividades");
		menuBar.add(mnGerenciarAtividades);
		
		mntmCancelarAtividade = new JMenuItem("Cancelar atividade");
		mnGerenciarAtividades.add(mntmCancelarAtividade);
		mntmCancelarAtividade.addActionListener(abrirCancelarAtividade);
		
		/*mntmMinhasAtividades = new JMenuItem("Minhas Atividades");
		mnGerenciarAtividades.add(mntmMinhasAtividades);
		mntmMinhasAtividades.addActionListener();*/
		
	}
	
	public TelaPrincipal() {
		
		Usuario usuario = Usuario.recuperaUsuarioLogado();
		
		if (usuario instanceof Tecnico) {
			inicializeTecnico();
		}
		else if (usuario instanceof Professor) {
			inicializeProfessor();
		}

	}
	
	
}
