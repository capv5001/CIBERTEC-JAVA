package cibertec;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrmModificarCocina extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblModelo;
	private JComboBox comboBox;
	private JLabel lblPrecio;
	private JLabel lblModelo_2;
	private JLabel lblModelo_3;
	private JLabel lblModelo_4;
	private JLabel lblModelo_5;
	private JTextField txtPrecio;
	private JTextField txtAncho;
	private JTextField txtAlto;
	private JTextField txtFondo;
	private JTextField txtQuemadores;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmModificarCocina dialog = new FrmModificarCocina();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmModificarCocina() {
	    setTitle("Consultar Cocina");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 25, 76, 14);
		contentPanel.add(lblModelo);
		
		Tienda cocina = new Tienda();
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {cocina.modelo0, cocina.modelo1, cocina.modelo2, cocina.modelo3, cocina.modelo4}));
		comboBox.setBounds(96, 23, 177, 18);
		contentPanel.add(comboBox);
		
		lblPrecio = new JLabel("Precio (S/.)");
		lblPrecio.setBounds(10, 64, 76, 14);
		contentPanel.add(lblPrecio);
		
		lblModelo_2 = new JLabel("Ancho (cm)");
		lblModelo_2.setBounds(10, 103, 76, 14);
		contentPanel.add(lblModelo_2);
		
		lblModelo_3 = new JLabel("Alto (cm)");
		lblModelo_3.setBounds(10, 142, 76, 14);
		contentPanel.add(lblModelo_3);
		
		lblModelo_4 = new JLabel("Fondo (cm)");
		lblModelo_4.setBounds(10, 181, 76, 14);
		contentPanel.add(lblModelo_4);
		
		lblModelo_5 = new JLabel("Quemadores");
		lblModelo_5.setBounds(10, 220, 76, 14);
		contentPanel.add(lblModelo_5);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(96, 61, 177, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtAncho = new JTextField();
		txtAncho.setColumns(10);
		txtAncho.setBounds(96, 100, 177, 20);
		contentPanel.add(txtAncho);
		
		txtAlto = new JTextField();
		txtAlto.setColumns(10);
		txtAlto.setBounds(96, 139, 177, 20);
		contentPanel.add(txtAlto);
		
		txtFondo = new JTextField();
		txtFondo.setColumns(10);
		txtFondo.setBounds(96, 178, 177, 20);
		contentPanel.add(txtFondo);
		
		txtQuemadores = new JTextField();
		txtQuemadores.setColumns(10);
		txtQuemadores.setBounds(96, 217, 177, 20);
		contentPanel.add(txtQuemadores);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(315, 21, 98, 23);
		contentPanel.add(btnCerrar);
	}
}
