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

public class FrmConfigurarObsequios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPrecio;
	private JTextField txtAncho;
	private JTextField txtAlto;
	private JButton btnCerrar;
	private JLabel lblUnidades1;
	private JLabel lblUnidades2;
	private JLabel lblUnidades3;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmConfigurarObsequios dialog = new FrmConfigurarObsequios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmConfigurarObsequios() {
	    setTitle("Configurar Obsequios");
		setBounds(100, 100, 442, 155);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblUnidades1 = new JLabel("1 unidad");
		lblUnidades1.setBounds(10, 21, 113, 14);
		contentPanel.add(lblUnidades1);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(133, 18, 140, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtAncho = new JTextField();
		txtAncho.setColumns(10);
		txtAncho.setBounds(133, 49, 140, 20);
		contentPanel.add(txtAncho);
		
		txtAlto = new JTextField();
		txtAlto.setColumns(10);
		txtAlto.setBounds(133, 80, 140, 20);
		contentPanel.add(txtAlto);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(318, 47, 98, 23);
		contentPanel.add(btnCerrar);
		
		lblUnidades2 = new JLabel("2 a 5 unidades");
		lblUnidades2.setBounds(10, 52, 113, 14);
		contentPanel.add(lblUnidades2);
		
		lblUnidades3 = new JLabel("6 a más unidades");
		lblUnidades3.setBounds(10, 83, 113, 14);
		contentPanel.add(lblUnidades3);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(318, 18, 98, 23);
		contentPanel.add(btnAceptar);
	}
}
