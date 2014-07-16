package view;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;


public class ViewAtividadeDesalocarRecurso {

	/*************************************/
	//Caso de Uso: Desalocar Recurso
	/************************************/
	
	
	private JFrame frmAtividades;
	private JList list;
	private ViewDesalocarRecurso janelaDeRecursos;
	private JButton btnFechar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAtividadeDesalocarRecurso window = new ViewAtividadeDesalocarRecurso();
					window.frmAtividades.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewAtividadeDesalocarRecurso() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmAtividades = new JFrame();
		frmAtividades.setTitle("Atividades");
		frmAtividades.setBounds(100, 100, 640, 480);
		frmAtividades.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmAtividades.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
		);
		
		//TODO Popular a lista dinamicamente;
		
		list = new JList();
		
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Clique 1", "Clique 2"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//TODO Seria interessante passar o controle como parametro, afim de usa-lo no listener dos botoes;
				janelaDeRecursos = new ViewDesalocarRecurso();
		
			}
		});
		
		JLabel lblAtividadesPendendentes = new JLabel("Atividades Alocadas:");
		
		btnFechar = new JButton("Fechar");
		btnFechar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				frmAtividades.dispose();
				
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(list, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
						.addComponent(btnFechar, Alignment.TRAILING)
						.addComponent(lblAtividadesPendendentes))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(38, Short.MAX_VALUE)
					.addComponent(lblAtividadesPendendentes)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnFechar)
					.addGap(7))
		);
		panel.setLayout(gl_panel);
		frmAtividades.getContentPane().setLayout(groupLayout);
	}
}
