package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import model.Professor;
import model.Tecnico;
import model.Usuario;
import net.miginfocom.swing.MigLayout;

import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Component;

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
	/*private JButton btnTcnico;
	private JButton btnProfessor;
	private JButton btnTipoDeRecurso;
	private JButton btnRecurso;
	private JButton btnNovaSolicitao;
	private JButton btnBuscarAtividade;
	private JButton btnCancelarAtividade;
	private JButton btnAvaliarPendncias;
	private JButton btnDesalocarRecurso;
	private JButton btnFinalizarAtividade;
	private JButton btnNovaSolicitao_1;
	private JButton btnBuscarSolicitao;
	private JButton btnCancelarAtividades;*/
	

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
		
		MouseListener efetuarLogout = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Main.main(null);				
				dispose();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
						
		};
		
		criarTelaTecnico();
		
		/*btnTcnico.addActionListener(abrirCadTecnico);
		btnProfessor.addActionListener(abrirCadProfessor);
		btnTipoDeRecurso.addActionListener(abrirCadTipoRecurso);
		btnRecurso.addActionListener(abrirViewRecurso);
		
		btnNovaSolicitao.addActionListener(abrirCadAtividade);
		
		btnBuscarAtividade.addActionListener(abrirBuscarAtividade);
		btnCancelarAtividade.addActionListener(abrirCancelarAtividade);
		btnAvaliarPendncias.addActionListener(abrirAvaliarAtividadesPendentes);
		btnDesalocarRecurso.addActionListener(abrirDesalocarRecurso);
		btnFinalizarAtividade.addActionListener(abrirFinalizarAtividade);
		*/
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
		mnSair.addMouseListener(efetuarLogout);
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
		
		MouseListener efetuarLogout = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Main.main(null);				
				dispose();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			

						
		};
		
		criarTelaProfessor();
		
		/*btnNovaSolicitao_1.addActionListener(abrirCadAtividade);
		btnBuscarSolicitao.addActionListener(abrirBuscarAtividade);
		btnCancelarAtividades.addActionListener(abrirCancelarAtividade);*/
		
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
		mnSair.addMouseListener(efetuarLogout);
		menuBar.add(mnSair);		
	}
	
	private void criarTelaTecnico() {
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 96, 193, 209);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		/*JLabel lblCadastro = new JLabel("Cadastro");
		lblCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastro.setBounds(10, 11, 173, 14);
		panel.add(lblCadastro);*/
		
		/*btnTcnico = new JButton("T\u00E9cnico");
		btnTcnico.setBounds(20, 36, 148, 23);
		panel.add(btnTcnico);
		
		btnProfessor = new JButton("Professor");
		btnProfessor.setBounds(20, 70, 148, 23);
		panel.add(btnProfessor);
		
		btnTipoDeRecurso = new JButton("Tipo de recurso");
		btnTipoDeRecurso.setBounds(20, 104, 148, 23);
		panel.add(btnTipoDeRecurso);
		
		btnRecurso = new JButton("Recurso");
		btnRecurso.setBounds(20, 138, 148, 23);
		panel.add(btnRecurso);*/
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(204, 96, 193, 209);
		getContentPane().add(panel1);
		panel1.setLayout(null);
		
		/*JLabel lblSolicitao = new JLabel("Solicita\u00E7\u00E3o");
		lblSolicitao.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolicitao.setBounds(10, 11, 173, 14);
		panel1.add(lblSolicitao);*/
		
		/*btnNovaSolicitao = new JButton("Nova solicita\u00E7\u00E3o");
		btnNovaSolicitao.setBounds(10, 36, 173, 23);
		panel1.add(btnNovaSolicitao);*/
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(398, 96, 193, 209);
		getContentPane().add(panel2);
		panel2.setLayout(null);
		
		/*JLabel lblGerenciarAtividades = new JLabel("Gerenciar Atividades");
		lblGerenciarAtividades.setHorizontalAlignment(SwingConstants.CENTER);
		lblGerenciarAtividades.setBounds(10, 11, 173, 14);
		panel2.add(lblGerenciarAtividades);*/
		
		/*btnBuscarAtividade = new JButton("Buscar atividade");
		btnBuscarAtividade.setBounds(10, 36, 173, 23);
		panel2.add(btnBuscarAtividade);
		
		btnCancelarAtividade = new JButton("Cancelar atividade");
		btnCancelarAtividade.setBounds(10, 70, 173, 23);
		panel2.add(btnCancelarAtividade);
		
		btnAvaliarPendncias = new JButton("Avaliar pend\u00EAncias");
		btnAvaliarPendncias.setBounds(10, 104, 173, 23);
		panel2.add(btnAvaliarPendncias);
		
		btnDesalocarRecurso = new JButton("Desalocar recurso");
		btnDesalocarRecurso.setBounds(10, 138, 173, 23);
		panel2.add(btnDesalocarRecurso);
		
		btnFinalizarAtividade = new JButton("Finalizar atividade");
		btnFinalizarAtividade.setBounds(10, 172, 173, 23);
		panel2.add(btnFinalizarAtividade);*/
	}
	
	private void criarTelaProfessor() {
		JPanel panel = new JPanel();
		panel.setBounds(61, 96, 217, 242);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		/*JLabel lblSolicitao_1 = new JLabel("Solicita\u00E7\u00E3o");
		lblSolicitao_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolicitao_1.setBounds(10, 11, 197, 30);
		panel.add(lblSolicitao_1);*/
		
		/*btnNovaSolicitao_1 = new JButton("Nova solicita\u00E7\u00E3o");
		btnNovaSolicitao_1.setBounds(10, 52, 197, 30);
		panel.add(btnNovaSolicitao_1);
		
		btnBuscarSolicitao = new JButton("Buscar solicita\u00E7\u00E3o");
		btnBuscarSolicitao.setBounds(10, 93, 197, 30);
		panel.add(btnBuscarSolicitao);*/
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(335, 96, 217, 242);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		/*JLabel lblGerenciarAtividades_1 = new JLabel("Gerenciar atividades");
		lblGerenciarAtividades_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblGerenciarAtividades_1.setBounds(10, 11, 197, 30);
		panel_1.add(lblGerenciarAtividades_1);
		*/
		/*btnCancelarAtividades = new JButton("Cancelar atividades");
		btnCancelarAtividades.setBounds(10, 52, 197, 30);
		panel_1.add(btnCancelarAtividades);*/
	}
	
	public TelaPrincipal() {
		
		
		
		setSize(620,400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setResizable(false);
		setTitle("Sistema de Gereciamento de Recursos - SGR");
		
		JLabel lblSgr = new JLabel("SGR");
		lblSgr.setHorizontalAlignment(SwingConstants.CENTER);
		lblSgr.setFont(new Font("Arial", Font.PLAIN, 70));
		lblSgr.setBounds(225, 120, 152, 74);
		getContentPane().add(lblSgr);
		
		Usuario usuario = Usuario.recuperaUsuarioLogado();
		
		if (usuario instanceof Tecnico) {
			inicializeTecnico();
		}
		else if (usuario instanceof Professor) {
			inicializeProfessor();
		}
	}
}
