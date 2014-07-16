package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import model.Atividade;
import model.Intervalo;
import model.Professor;
import model.Recurso;
import model.Status;
import model.Tecnico;
import model.TipoRecurso;
import model.Usuario;
import net.miginfocom.swing.MigLayout;
import control.ControleAtividade;
import control.ControleInstitucional;

public class ViewAtividade {

	private JFrame frame;
	private JTextField codigo;
	private JComboBox<Professor> professorCombo;
	private JComboBox<Intervalo> intervaloCombo;
	private JComboBox<TipoRecurso> tipoRecursoCombo;
	private JList<Recurso> recursoJlist;
	
	private ControleInstitucional controleInstitucional;
	private ControleAtividade controleAtividade;
	private Tecnico tecnicoResponsavel;
	private Professor professorResponsavel;
	private TipoRecurso tipoRec;
	private Intervalo intervalos;
	private Atividade atividade;
	private List<Recurso> recursosSelecionados;

	/**
	 * Create the application.
	 */
	public ViewAtividade() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		controleInstitucional = new ControleInstitucional();
		controleAtividade = new ControleAtividade();
		recursosSelecionados = new ArrayList<Recurso>();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][]"));
		frame.setVisible(true);
		frame.setSize(800,600);
		
		JLabel lblCdigo = new JLabel("Codigo:");
		frame.getContentPane().add(lblCdigo, "cell 0 0,alignx trailing");
		
		codigo = new JTextField();
		frame.getContentPane().add(codigo, "cell 1 0,growx");
		codigo.setColumns(10);
		
		JLabel lblProfessor = new JLabel("Professor:");
		frame.getContentPane().add(lblProfessor, "cell 0 1,alignx trailing");
		
		Object[] vetorProfessor = controleInstitucional.buscarProfessor("").toArray();
		
		professorCombo = new JComboBox<>();
		professorCombo.setModel(new DefaultComboBoxModel(vetorProfessor));
		professorCombo.setEditable(true);
		frame.getContentPane().add(professorCombo, "cell 1 1,growx");
		
		JLabel lblTipoDeRecurso = new JLabel("Tipo de Recurso:");
		frame.getContentPane().add(lblTipoDeRecurso, "cell 0 2,alignx trailing");
		
		Object[] vetorTipoRecurso;
		vetorTipoRecurso = controleInstitucional.buscarTipoRecurso("").toArray();
		tipoRecursoCombo = new JComboBox();
		tipoRecursoCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				arg0.getActionCommand();
				recursosSelecionados.addAll(recursoJlist.getSelectedValuesList());
				tipoRec = (TipoRecurso) tipoRecursoCombo.getSelectedItem(); 
				Recurso[] recursoArray = new Recurso[tipoRec.listarRecursos().size()];
				for(int i = 0; i < recursoArray.length; i++){
					recursoArray[i] = (Recurso) tipoRec.listarRecursos().toArray()[i];
				}
				recursoJlist.setListData(recursoArray);
			}
		});
		tipoRecursoCombo.setModel(new DefaultComboBoxModel(vetorTipoRecurso));
		tipoRecursoCombo.setEditable(true);
		frame.getContentPane().add(tipoRecursoCombo, "cell 1 2,growx");
		
		/***************/
		tipoRec = (TipoRecurso) tipoRecursoCombo.getSelectedItem();
		/***************/
		
		JLabel lblRecurso = new JLabel("Recurso:");
		frame.getContentPane().add(lblRecurso, "cell 0 3,alignx trailing");
		
		Recurso[] recursoArray = new Recurso[tipoRec.listarRecursos().size()];
		for(int i = 0; i < recursoArray.length; i++){
			recursoArray[i] = (Recurso) tipoRec.listarRecursos().toArray()[i];
		}
		recursoJlist = new JList<Recurso>(recursoArray);
		frame.getContentPane().add(recursoJlist, "cell 1 3,growx");
		
		JLabel lblIntervalo = new JLabel("Intervalo:");
		frame.getContentPane().add(lblIntervalo, "cell 0 4,alignx trailing");
		
		Object[] vetorIntervalo;
		vetorIntervalo = intervalos.values();
		intervaloCombo = new JComboBox<Intervalo>();
		intervaloCombo.setModel(new DefaultComboBoxModel(vetorIntervalo));
		intervaloCombo.setEditable(true);
		frame.getContentPane().add(intervaloCombo, "cell 1 4,growx");
		
		/*******************************************************/
		
		ActionListener salvarAtividade = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usr = Usuario.recuperaUsuarioLogado();
				Tecnico tec = null;
				if(usr instanceof Tecnico)
					tec = (Tecnico)usr;
				controleAtividade.inserir(codigo.getText(), (Professor)professorCombo.getSelectedItem() , tec, recursosSelecionados, (Intervalo)intervaloCombo.getSelectedItem() , Status.PENDENTE);
				
			}
		};
		
		/*********************************************************/
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnCancelar, "flowx,cell 1 8");
		
		JButton btnLimpar = new JButton("Limpar");
		frame.getContentPane().add(btnLimpar, "cell 1 8");
		
		JButton btnSalvar = new JButton("Salvar");
		frame.getContentPane().add(btnSalvar, "cell 1 8");
		btnSalvar.addActionListener(salvarAtividade);
	}

}
