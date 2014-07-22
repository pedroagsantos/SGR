package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JButton;

import control.ControleAtividade;
import model.Atividade;
import model.Professor;
import model.Recurso;
import model.Status;
import model.Tecnico;
import model.Usuario;


public class ViewCancelarAtividade {
	
	/*************************************/
	//Caso de Uso: Avaliar Atividades Pendentes
	/************************************/

	private JFrame frame;
	private JList<Atividade> list;
	private ViewDecisaoCancelarAtividade viewDecisaoCancelarAtividade; 
	private JButton btnFechar;
	private ControleAtividade controleAtividade;
	private Atividade[] atividadesArray;
	private Usuario usuario;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCancelarAtividade window = new ViewCancelarAtividade();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	public ViewCancelarAtividade() {
		// TODO Auto-generated constructor stub
		usuario = Usuario.recuperaUsuarioLogado();
		
		if (usuario instanceof Tecnico) {
			initializeTecnico();
		}
		else if (usuario instanceof Professor) {
			initializeProfessor();
		}
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initializeTecnico() {
		
		controleAtividade =  new ControleAtividade();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
		);
		
		//TODO Popular a lista dinamicamente;
		
		list = new JList<Atividade>();
		
		List<Atividade> atividades = controleAtividade.recuperarAtividades(Status.PENDENTE);		
		atividadesArray = new Atividade[atividades.size()];
		
		
		for(int i = 0; i < atividadesArray.length; i++)
			atividadesArray[i] = (Atividade) atividades.get(i);

		
		list.setListData(atividadesArray);
		
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//TODO Seria interessante passar o controle como parametro, afim de usa-lo no listener dos botoes;
				if(atividadesArray.length > 0) {
					
					Atividade atividade = (Atividade) list.getSelectedValue();
					
					viewDecisaoCancelarAtividade = new ViewDecisaoCancelarAtividade(atividade);
				}
			}
		});
		
		JLabel lblAtividades = new JLabel("Cancelamento de Atividades:");
		
		btnFechar = new JButton("Fechar");
		
		btnFechar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				frame.dispose();
			}
		});
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(list, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
						.addComponent(lblAtividades)
						.addComponent(btnFechar, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addComponent(lblAtividades)
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnFechar)
					.addGap(7))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	private void initializeProfessor() {
		
		controleAtividade =  new ControleAtividade();
		
		Professor professorResponsavel = (Professor) usuario;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
		);
	
		
		list = new JList<Atividade>();
		
		List<Atividade> atividades = controleAtividade.recuperarAtividades(Status.PENDENTE, professorResponsavel);
		atividades.addAll(controleAtividade.recuperarAtividades(Status.APROVADA, professorResponsavel));
	
		atividadesArray = new Atividade[atividades.size()];
		
		for(int i = 0; i < atividadesArray.length; i++)
			atividadesArray[i] = (Atividade) atividades.get(i);

		list.setListData(atividadesArray);
		
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(atividadesArray.length > 0) {
					
					Atividade atividade = (Atividade) list.getSelectedValue();
					
					viewDecisaoCancelarAtividade = new ViewDecisaoCancelarAtividade(atividade);
				}
			}
		});
		
		JLabel lblAtividadesPendendentes = new JLabel("Cancelamento de Atividades:");
		
		btnFechar = new JButton("Fechar");
		
		btnFechar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				frame.dispose();
			}
		});
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(list, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
						.addComponent(lblAtividadesPendendentes)
						.addComponent(btnFechar, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addComponent(lblAtividadesPendendentes)
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnFechar)
					.addGap(7))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
}
