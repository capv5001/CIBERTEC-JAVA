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

public class FrmConfigurarPorcentajesDescuento extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblUnidades1;
	private JTextField txtPrecio;
	private JTextField txtAncho;
	private JTextField txtAlto;
	private JTextField txtFondo;
	private JButton btnCerrar;
	
	private Tienda cocina = new Tienda();
	private JLabel lblUnidades2;
	private JLabel lblUnidades3;
	private JLabel lblUnidades4;
	private JButton btnAceptar;
	private JLabel lblPercent1;
	private JLabel lblPercent2;
	private JLabel lblPercent3;
	private JLabel lblPercent4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmConfigurarPorcentajesDescuento dialog = new FrmConfigurarPorcentajesDescuento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmConfigurarPorcentajesDescuento() {
	    setTitle("Configurar Porcentajes de Descuento");
		setBounds(100, 100, 442, 186);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblUnidades1 = new JLabel("1 a 5 unidades");
		lblUnidades1.setBounds(10, 21, 113, 14);
		contentPanel.add(lblUnidades1);
		
		txtPrecio = new JTextField();
		txtPrecio.setEnabled(false);
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(133, 18, 140, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtAncho = new JTextField();
		txtAncho.setEnabled(false);
		txtAncho.setEditable(false);
		txtAncho.setColumns(10);
		txtAncho.setBounds(133, 49, 140, 20);
		contentPanel.add(txtAncho);
		
		txtAlto = new JTextField();
		txtAlto.setEnabled(false);
		txtAlto.setEditable(false);
		txtAlto.setColumns(10);
		txtAlto.setBounds(133, 80, 140, 20);
		contentPanel.add(txtAlto);
		
		txtFondo = new JTextField();
		txtFondo.setEnabled(false);
		txtFondo.setEditable(false);
		txtFondo.setColumns(10);
		txtFondo.setBounds(133, 111, 140, 20);
		contentPanel.add(txtFondo);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(318, 47, 98, 23);
		contentPanel.add(btnCerrar);
		
		lblUnidades2 = new JLabel("6 a 10 unidades");
		lblUnidades2.setBounds(10, 52, 113, 14);
		contentPanel.add(lblUnidades2);
		
		lblUnidades3 = new JLabel("11 a 15 unidades");
		lblUnidades3.setBounds(10, 83, 113, 14);
		contentPanel.add(lblUnidades3);
		
		lblUnidades4 = new JLabel("Más de 15 unidades");
		lblUnidades4.setBounds(10, 114, 113, 14);
		contentPanel.add(lblUnidades4);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(318, 18, 98, 23);
		contentPanel.add(btnAceptar);
		
		lblPercent1 = new JLabel("%");
		lblPercent1.setBounds(283, 21, 25, 14);
		contentPanel.add(lblPercent1);
		
		lblPercent2 = new JLabel("%");
		lblPercent2.setBounds(283, 52, 25, 14);
		contentPanel.add(lblPercent2);
		
		lblPercent3 = new JLabel("%");
		lblPercent3.setBounds(283, 83, 25, 14);
		contentPanel.add(lblPercent3);
		
		lblPercent4 = new JLabel("%");
		lblPercent4.setBounds(283, 114, 25, 14);
		contentPanel.add(lblPercent4);
	}
}
