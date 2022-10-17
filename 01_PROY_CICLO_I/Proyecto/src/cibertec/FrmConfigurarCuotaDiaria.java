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

public class FrmConfigurarCuotaDiaria extends JDialog {

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
			FrmConfigurarCuotaDiaria dialog = new FrmConfigurarCuotaDiaria();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmConfigurarCuotaDiaria() {
	    setTitle("Configurar Cuota Diaria");
		setBounds(100, 100, 447, 123);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblUnidades1 = new JLabel("Cuota diaria esperada (S/.)");
		lblUnidades1.setBounds(10, 21, 152, 14);
		contentPanel.add(lblUnidades1);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(172, 18, 140, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(326, 47, 98, 23);
		contentPanel.add(btnCerrar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(326, 18, 98, 23);
		contentPanel.add(btnAceptar);
	}
}
