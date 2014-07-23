package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import model.Professor;
import model.Tecnico;
import model.Usuario;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("unused")
public class TelaPrincipal extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ViewProfessor viewProfessor;
	private ViewAtividade viewAtividade;
	private ViewBuscarAtividades viewBuscarAtividades;
	private ViewTecnico viewTecnico;
	private ViewTipoRecurso viewTipoRecurso;
	private ViewAvaliarAtividadesPendentes viewAtividadesPendentes; 
	private ViewCancelarAtividade viewCancelarAtividade;
	private ViewRecurso viewRecurso;
	private ViewDesalocarRecurso viewDesalocarRecurso;
	private ViewFinalizarAtividade viewFinalizarAtividade;
	private JMenuBar menuBar;
	private JMenu mnCadastro;
	private JMenu mnSolicitao;
	private JMenu mnGerenciarAtividades;
	private JMenu mnSair;
	private JMenuItem mntmCancelarAtividade;
	private JMenuItem mntmAvaliarAtividadePendente;
	private JMenuItem mntmProfessor;
	private JMenuItem mntmTecnico;
	private JMenuItem mntmTipoDeRecurso;
	private JMenuItem mntmRecurso;
	private JMenuItem mntmNovaSolicitao;
	private JMenuItem mntmBuscarAtividade;
	private JMenuItem mntmDesalocarRecurso;
	private JMenuItem mntmFinalizarAtividade;
	

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
		
		ActionListener abrirViewRecurso = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewRecurso = new ViewRecurso();
			}
		};
		
		ActionListener abrirCancelarAtividade = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				viewCancelarAtividade = new ViewCancelarAtividade();			
			}
		};
		
		ActionListener abrirDesalocarRecurso = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				viewDesalocarRecurso = new ViewDesalocarRecurso();			
			}
		};
		
		ActionListener abrirFinalizarAtividade = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				viewFinalizarAtividade = new ViewFinalizarAtividade();		
			}
		};
		
		MenuListener efetuarLogout = new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {
				// TODO Auto-generated method stub
				Main.main(null);				
				dispose();
			}

			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
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
		mntmRecurso.addActionListener(abrirViewRecurso);
		
		mnSolicitao = new JMenu("Solicita\u00E7\u00E3o");
		menuBar.add(mnSolicitao);
		
		mntmNovaSolicitao = new JMenuItem("Nova Solicita\u00E7\u00E3o");
		mnSolicitao.add(mntmNovaSolicitao);
		mntmNovaSolicitao.addActionListener(abrirCadAtividade);
		
		mnGerenciarAtividades = new JMenu("Gerenciar Atividade");
		menuBar.add(mnGerenciarAtividades);
		
		mntmBuscarAtividade = new JMenuItem("Buscar Atividade");
		mnGerenciarAtividades.add(mntmBuscarAtividade);
		mntmBuscarAtividade.addActionListener(abrirBuscarAtividade);
		
		mntmCancelarAtividade = new JMenuItem("Cancelar atividade");
		mnGerenciarAtividades.add(mntmCancelarAtividade);
		mntmCancelarAtividade.addActionListener(abrirCancelarAtividade);
		
		mntmAvaliarAtividadePendente = new JMenuItem("Avaliar Atividades Pendentes");
		mnGerenciarAtividades.add(mntmAvaliarAtividadePendente);
		mntmAvaliarAtividadePendente.addActionListener(abrirAvaliarAtividadesPendentes);
		
		mntmDesalocarRecurso = new JMenuItem("Desalocar Recurso");
		mnGerenciarAtividades.add(mntmDesalocarRecurso);
		mntmDesalocarRecurso.addActionListener(abrirDesalocarRecurso);
		
		mntmFinalizarAtividade = new JMenuItem("Finalizar Atividade");
		mnGerenciarAtividades.add(mntmFinalizarAtividade);
		mntmFinalizarAtividade.addActionListener(abrirFinalizarAtividade);
		
		mnSair = new JMenu("Sair");		
		mnSair.addMenuListener(efetuarLogout);
		menuBar.add(mnSair);
		
	}
	
	private void inicializeProfessor() {
		
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
		
		ActionListener abrirCancelarAtividade = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewAtividadesPendentes = new ViewAvaliarAtividadesPendentes();
				
			}
		};
		
		MenuListener efetuarLogout = new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {
				// TODO Auto-generated method stub
				Main.main(null);				
				dispose();
			}

			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
						
		};
		
		setSize(800,600);
		getContentPane().setLayout(new MigLayout("", "[]", "[]"));
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
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
		
		mnSair = new JMenu("Sair");		
		mnSair.addMenuListener(efetuarLogout);
		menuBar.add(mnSair);		
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
