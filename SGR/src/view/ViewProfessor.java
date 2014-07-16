package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

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

import model.Departamento;
import model.Professor;
import model.Universidade;
import model.Usuario;
import net.miginfocom.swing.MigLayout;
import control.ControleInstitucional;

public class ViewProfessor {

	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JTextField nome;
	private JTextField siape;
	private JTextField email;
	private JTextField telefone;
	private JTextField siapeBusca;
	private JTable tabela;
	private JComboBox<Departamento> departamento;
	private JPanel panel;
	
	private ControleInstitucional controleInstitucional;
	private Professor professor;
	
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
	public ViewProfessor() {
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
		
		JLabel lblNome = new JLabel("Nome");
		panel.add(lblNome, "cell 0 0,alignx trailing");
		
		nome = new JTextField();
		panel.add(nome, "cell 1 0,growx");
		nome.setColumns(10);
		
		JLabel lblSiape = new JLabel("Siape");
		panel.add(lblSiape, "cell 0 1,alignx trailing");
		
		siape = new JTextField();
		panel.add(siape, "cell 1 1,growx");
		siape.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		panel.add(lblEmail, "cell 0 2,alignx trailing");
		
		email = new JTextField();
		panel.add(email, "cell 1 2,growx");
		email.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		panel.add(lblTelefone, "cell 0 3,alignx trailing");
		
		telefone = new JTextField();
		panel.add(telefone, "cell 1 3,growx");
		telefone.setColumns(10);
		
		JLabel lblDepartamento = new JLabel("Departamento");
		panel.add(lblDepartamento, "cell 0 4,alignx trailing");
		
		
		//Departamento[] vetorDepartamento;
		
		Departamento[] vetorDepartamento = new Departamento[Universidade.recuperaInstancia().recuperaDepartamentos().toArray().length];
		int cont = 0;
		for(Object depto : Universidade.recuperaInstancia().recuperaDepartamentos().toArray()){
			Departamento departamento = (Departamento) depto;
			vetorDepartamento[cont] = departamento;
			cont++;
		}
		
		departamento = new JComboBox<Departamento>();
		departamento.setModel(new DefaultComboBoxModel<Departamento>(vetorDepartamento));
		departamento.setEditable(true);
		panel.add(departamento, "cell 1 4,growx");
		
		/*****************************************************************/
		ActionListener salvarProfessor = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controleInstitucional = new ControleInstitucional();
				controleInstitucional.inserirProfessor(nome.getText(), siape.getText(), email.getText(), telefone.getText(), (Departamento) departamento.getSelectedItem());
				
			}
		};
		
		ActionListener limparProfessor = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controleInstitucional = new ControleInstitucional();
				//professor = new Professor(nome.getText(), siape.getText(), email.getText(), telefone.getText(), departamento.getSelectedIndex());
				//controleInstitucional.inserir(professor);
				nome.setText(null);
				siape.setText(null);
				email.setText(null);
				telefone.setText(null);
				departamento.setSelectedIndex(0);
				siapeBusca.setText(null);
				tabela.setValueAt(null, 0, 0);
				
			}
		};
		
		ActionListener buscarProfessor = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controleInstitucional = new ControleInstitucional();
				List<Usuario> listaProfessor = controleInstitucional.buscarProfessor(siape.getText());
				int cont = 0;
				for (Usuario professor : listaProfessor) {
					tabela.setValueAt(professor, cont, cont);
					cont++;
				}
				
			}
		};
		
		ActionListener alterarProfessor = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controleInstitucional = new ControleInstitucional();
				professor.modificarNome(nome.getText());
				//professor.modificarSiape(siape.getText());
				professor.modificarEmail(email.getText());
				professor.modificarTelefone(telefone.getText());
				professor.modificarDepartamento((Departamento)departamento.getSelectedItem());
				controleInstitucional.alterar(professor);
				
			}
		};
		
		MouseListener recuperaProfessor = new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				professor = (Professor) tabela.getValueAt(0, 0);
				nome.setText(professor.recuperarNome());
				siape.setText(professor.recuperarSiape());
				email.setText(professor.recuperarEmail());
				telefone.setText(professor.recuperarTelefone());
				departamento.setSelectedItem(professor.recuperarDepartamento());
				
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
		btnCancelar.addActionListener(limparProfessor);
		
		JButton btnAlterar = new JButton("Alterar");
		panel.add(btnAlterar, "cell 1 7");
		btnAlterar.addActionListener(alterarProfessor);
		
		JButton btnSalvar = new JButton("Salvar");
		panel.add(btnSalvar, "cell 1 7");
		btnSalvar.addActionListener(salvarProfessor);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Consulta", null, panel_1, null);
		panel_1.setLayout(new MigLayout("", "[][grow]", "[][][grow]"));
		
		JLabel lblSiape_1 = new JLabel("Siape");
		panel_1.add(lblSiape_1, "cell 0 0,alignx trailing");
		
		siapeBusca = new JTextField();
		panel_1.add(siapeBusca, "cell 1 0,growx");
		siapeBusca.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		panel_1.add(btnBuscar, "cell 1 1");
		btnBuscar.addActionListener(buscarProfessor);
		
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
		tabela.addMouseListener(recuperaProfessor);
	}

}
