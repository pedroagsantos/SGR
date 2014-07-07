package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Tecnico;
import model.TipoRecurso;
import net.miginfocom.swing.MigLayout;
import control.ControleInstitucional;

public class ViewTipoRecurso {

	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JTextField tipo;
	private JTextField tipoBusca;
	private JTable tabela;
	private JPanel panel;
	
	private ControleInstitucional controleInstitucional;
	private TipoRecurso tipoRecurso;
	
	private JButton btnBuscar;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewProf window = new ViewProf();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public ViewTipoRecurso() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		controleInstitucional = new ControleInstitucional();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[grow]"));
		frame.setVisible(true);
		frame.setSize(800,600);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, "cell 0 0,grow");
		
		panel = new JPanel();
		tabbedPane.addTab("Formul\u00E1rio", null, panel, null);
		panel.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][]"));
		
		JLabel lblTipo = new JLabel("Tipo de Recurso");
		panel.add(lblTipo, "cell 0 0,alignx trailing");
		
		tipo = new JTextField();
		panel.add(tipo, "cell 1 0,growx");
		tipo.setColumns(10);
		
		
		
		/*****************************************************************/
		ActionListener salvarTipoRecurso = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controleInstitucional = new ControleInstitucional();
				tipoRecurso = new TipoRecurso(tipo.getText());
				controleInstitucional.inserir(tipoRecurso);
				
			}
		};
		
		ActionListener limparTipoRecurso = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controleInstitucional = new ControleInstitucional();
				//professor = new Professor(nome.getText(), siape.getText(), email.getText(), telefone.getText(), departamento.getSelectedIndex());
				//controleInstitucional.inserir(professor);
				tipo.setText(null);
				
				tabela.setValueAt(null, 0, 0);
				
			}
		};
		
		ActionListener buscarTipoRecurso = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controleInstitucional = new ControleInstitucional();
				tipoRecurso = controleInstitucional.buscarTipoRecurso(tipoBusca.getText());
				tabela.setValueAt(tipoRecurso, 0, 0);
				
			}
		};
		
		ActionListener alterarTipoRecurso = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controleInstitucional = new ControleInstitucional();
				tipoRecurso.modificarTipo(tipo.getText());
				//professor.modificarSiape(siape.getText());
				controleInstitucional.alterar(tipoRecurso);
				
			}
		};
		
		MouseListener recuperaTipoRecurso = new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				tipoRecurso = (TipoRecurso) tabela.getValueAt(0, 0);
				tipo.setText(tipoRecurso.recuperarTipo());
				
				
				tabbedPane.setSelectedComponent(panel);
				
				
				
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
				
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
		
		
		/*****************************************************************/
		
		
		
		JButton btnCancelar = new JButton("Cancelar");
		panel.add(btnCancelar, "flowx,cell 1 7");
		btnCancelar.addActionListener(limparTipoRecurso);
		
		JButton btnAlterar = new JButton("Alterar");
		panel.add(btnAlterar, "cell 1 7");
		btnAlterar.addActionListener(alterarTipoRecurso);
		
		JButton btnSalvar = new JButton("Salvar");
		panel.add(btnSalvar, "cell 1 7");
		btnSalvar.addActionListener(salvarTipoRecurso);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Consulta", null, panel_1, null);
		panel_1.setLayout(new MigLayout("", "[][grow]", "[][][grow]"));
		
		JLabel lblTipo_1 = new JLabel("Tipo de Recurso: ");
		panel_1.add(lblTipo_1, "cell 0 0,alignx trailing");
		
		tipoBusca = new JTextField();
		panel_1.add(tipoBusca, "cell 1 0,growx");
		tipoBusca.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		panel_1.add(btnBuscar, "cell 1 1");
		btnBuscar.addActionListener(buscarTipoRecurso);
		
		tabela = new JTable();
		tabela.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
			},
			new String[] {
				"Professor"
			}
		));
		tabela.getColumnModel().getColumn(0).setPreferredWidth(150);
		panel_1.add(tabela, "cell 1 2,grow");
		tabela.addMouseListener(recuperaTipoRecurso);
	}

}
