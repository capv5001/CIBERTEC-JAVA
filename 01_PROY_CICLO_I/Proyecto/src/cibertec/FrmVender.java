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
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class FrmVender extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCerrar;
	private JButton btnVender;
	private JComboBox comboBox;
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblCantidad;
	private JTextField txtField;
	private JTextField txtField_1;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmVender dialog = new FrmVender();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmVender() {
	    setTitle("Vender");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(326, 34, 98, 23);
		contentPanel.add(btnCerrar);
		
		btnVender = new JButton("Vender");
		btnVender.setBounds(326, 9, 98, 23);
		contentPanel.add(btnVender);
		
		Tienda cocina = new Tienda();

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {cocina.modelo0, cocina.modelo1, cocina.modelo2, cocina.modelo3, cocina.modelo4}));
		comboBox.setBounds(96, 11, 177, 18);
		contentPanel.add(comboBox);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 13, 76, 14);
		contentPanel.add(lblModelo);
		
		lblPrecio = new JLabel("Precio (S/.)");
		lblPrecio.setBounds(10, 38, 76, 14);
		contentPanel.add(lblPrecio);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 63, 76, 14);
		contentPanel.add(lblCantidad);
		
		txtField = new JTextField();
		txtField.setEditable(false);
		txtField.setEnabled(false);
		txtField.setBounds(96, 35, 177, 20);
		contentPanel.add(txtField);
		txtField.setColumns(10);
		
		txtField_1 = new JTextField();
		txtField_1.setColumns(10);
		txtField_1.setBounds(96, 60, 177, 20);
		contentPanel.add(txtField_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 86, 414, 164);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
	}
}
