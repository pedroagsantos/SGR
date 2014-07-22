package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ViewMinhasAtividades {

	private JFrame frmMinhasAtividades;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMinhasAtividades window = new ViewMinhasAtividades();
					window.frmMinhasAtividades.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewMinhasAtividades() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMinhasAtividades = new JFrame();
		frmMinhasAtividades.setTitle("Minhas Atividades");
		frmMinhasAtividades.setBounds(100, 100, 450, 300);
		frmMinhasAtividades.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JButton btnStatus = new JButton("Status");
		btnStatus.setName("btnStatus");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setName("combo");
		GroupLayout groupLayout = new GroupLayout(frmMinhasAtividades.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(38)
					.addComponent(btnStatus)
					.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
					.addGap(33))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnStatus))
					.addContainerGap(228, Short.MAX_VALUE))
		);
		frmMinhasAtividades.getContentPane().setLayout(groupLayout);
	}
}
