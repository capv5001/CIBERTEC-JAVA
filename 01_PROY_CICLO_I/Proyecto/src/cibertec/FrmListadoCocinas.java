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

public class FrmListadoCocinas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCerrar;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private JButton btnListar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmListadoCocinas dialog = new FrmListadoCocinas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmListadoCocinas() {
	    setTitle("Listado de Cocinas");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		Tienda cocina = new Tienda();
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(326, 227, 98, 23);
		contentPanel.add(btnCerrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 11, 414, 205);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(218, 227, 98, 23);
		contentPanel.add(btnListar);
	}
}
