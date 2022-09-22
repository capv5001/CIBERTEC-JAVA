package programaDonacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmDonacion extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblMoneda;
	private JLabel lblCantidad;
	private JButton btnDonar;
	private JButton btnBorrar;
	private JComboBox cboMoneda;
	private JTextField txtCantidad;
	private JTextArea txtS;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDonacion frame = new FrmDonacion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmDonacion() {
		setResizable(false);
		setTitle("Registro de productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMoneda = new JLabel("Moneda");
		lblMoneda.setBounds(10, 11, 67, 14);
		contentPane.add(lblMoneda);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 36, 67, 14);
		contentPane.add(lblCantidad);
		
		btnDonar = new JButton("Donar");
		btnDonar.addActionListener(this);
		btnDonar.setBounds(335, 7, 89, 23);
		contentPane.add(btnDonar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 32, 89, 23);
		contentPane.add(btnBorrar);
		
		cboMoneda = new JComboBox();
		cboMoneda.setModel(new DefaultComboBoxModel(new String[] {"Soles", "Bolívares", "Dólares"}));
		cboMoneda.setBounds(72, 7, 139, 22);
		contentPane.add(cboMoneda);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(72, 33, 139, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 61, 414, 189);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(e);
		}
		if (e.getSource() == btnDonar) {
			actionPerformedBtnDonar(e);
		}
	}
	protected void actionPerformedBtnDonar(ActionEvent e) {
		String tipoMoneda;
		double cantidadMoneda;
		
		tipoMoneda = cboMoneda.getSelectedItem().toString();
		cantidadMoneda = Double.parseDouble(txtCantidad.getText());

		txtS.setText("La donación es: " + "\n");
		txtS.append("Tipo de moneda: " + tipoMoneda + "\n");
		txtS.append("Cantidad: " + cantidadMoneda);
	}
	protected void actionPerformedBtnBorrar(ActionEvent e) {
		cboMoneda.setSelectedIndex(0);
		txtCantidad.setText("");
		txtS.setText("");
		txtCantidad.requestFocus();
	}
}