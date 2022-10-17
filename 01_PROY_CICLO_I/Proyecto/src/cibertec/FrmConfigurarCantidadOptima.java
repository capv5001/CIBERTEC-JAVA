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
import javax.swing.DropMode;

public class FrmConfigurarCantidadOptima extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblUnidades1;
	private JTextField txtPrecio;
	private JButton btnCerrar;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmConfigurarCantidadOptima dialog = new FrmConfigurarCantidadOptima();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmConfigurarCantidadOptima() {
	    setTitle("Configurar Cantidad Óptima");
		setBounds(100, 100, 508, 123);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblUnidades1 = new JLabel("Cantidad óptima de unidades vendidas");
		lblUnidades1.setBounds(10, 21, 200, 14);
		contentPanel.add(lblUnidades1);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(234, 18, 140, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(383, 47, 98, 23);
		contentPanel.add(btnCerrar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(383, 18, 98, 23);
		contentPanel.add(btnAceptar);
	}
}
