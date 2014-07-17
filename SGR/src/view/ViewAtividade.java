package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
	private JList<Recurso> recursoEscolhido;
	
	private ControleInstitucional controleInstitucional;
	private ControleAtividade controleAtividade;
	private Tecnico tecnicoResponsavel;
	private Professor professorResponsavel;
	private TipoRecurso tipoRec;
	private Intervalo intervalos;
	private Atividade atividade;
	private HashMap<String, Recurso> recursosSelecionados;
	private String codAtividade;

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
		recursosSelecionados = new HashMap<>();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][]"));
		frame.setVisible(true);
		frame.setSize(640,480);
		
		JLabel lblCdigo = new JLabel("Codigo:");
		frame.getContentPane().add(lblCdigo, "cell 0 0,alignx trailing");
		
		codigo = new JTextField();
		codigo.setEditable(false);
		frame.getContentPane().add(codigo, "cell 1 0,growx");
		codigo.setColumns(10);
		
		codAtividade = controleAtividade.recuperaCodigoAtivdade();
		
		codigo.setText(codAtividade);
		
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
		recursoJlist = new JList<Recurso>();
		recursoJlist.setListData(recursoArray);
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
				controleAtividade.inserir(codigo.getText(), (Professor)professorCombo.getSelectedItem() , tec, recursosSelecionados.values(), (Intervalo)intervaloCombo.getSelectedItem() , Status.PENDENTE);
				
			}
		};
		
		/*********************************************************/
		
		recursoEscolhido = new JList<Recurso>();
		//recursoEscolhido.setListData(recursoArray);
		frame.getContentPane().add(recursoEscolhido, "cell 1 8,growx");
		
		JButton btnAdicionarRecurso = new JButton("Adicionar Recurso");
		frame.getContentPane().add(btnAdicionarRecurso, "cell 1 3,alignx trailing");
		
		btnAdicionarRecurso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				for (Recurso recurso : recursoJlist.getSelectedValuesList())
					recursosSelecionados.put(recurso.recuperarPatrimonio(), recurso);
				
				Recurso[] recursoArray = new Recurso[recursosSelecionados.size()];
				
				Iterator<Entry<String, Recurso>> it = recursosSelecionados.entrySet().iterator();
				
				int i = 0;
				
				while(it.hasNext()) {
					Map.Entry par = (Map.Entry)it.next(); 
					recursoArray[i++] = (Recurso) par.getValue();
				}
				
				recursoEscolhido.setListData(recursoArray);
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		
		frame.getContentPane().add(btnCancelar, "flowx,cell 1 9");
		
		JButton btnLimpar = new JButton("Limpar");
		
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Recurso[] recursoArray = new Recurso[0];
				recursoEscolhido.setListData(recursoArray);
				recursosSelecionados.clear();
			}
		});
		
		frame.getContentPane().add(btnLimpar, "cell 1 9");
		
		JButton btnSalvar = new JButton("Salvar");
		frame.getContentPane().add(btnSalvar, "cell 1 9");
		btnSalvar.addActionListener(salvarAtividade);
	}

}
