package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JComboBox;

import control.ControleAtividade;

public class ViewSolicitarRecurso {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSolicitarRecurso window = new ViewSolicitarRecurso();
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
	public ViewSolicitarRecurso() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 691, 439);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][grow]", "[]"));
		
		JLabel lblTipoDeRecurso = new JLabel("Tipo de Recurso");
		frame.getContentPane().add(lblTipoDeRecurso, "cell 0 0,alignx trailing");
		
		JComboBox comboBox = new JComboBox();
		ControleAtividade actvControl = new ControleAtividade();
		actvControl.
		frame.getContentPane().add(comboBox, "cell 1 0,alignx left");
	}

}
