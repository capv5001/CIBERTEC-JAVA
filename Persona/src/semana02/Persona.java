package semana02;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Persona extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNombresApellidos;
	private JLabel lblAnioNacimiento;
	private JTextField txtNombresApellidos;
	private JTextField txtAnioNacimiento;
	private JButton btnBorrar;
	private JScrollPane scp;
	private JTextArea txtS;
	private JLabel lblPesoKilogramos;
	private JTextField txtPesoKilogramos;
	private JButton btnProcesar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Persona frame = new Persona();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Persona() {
		setTitle("Persona");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(new Rectangle(100, 100, 450, 285));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNombresApellidos = new JLabel("Nombres y apellidos");
		lblNombresApellidos.setBounds(10, 11, 106, 14);
		contentPane.add(lblNombresApellidos);

		lblAnioNacimiento = new JLabel("A\u00F1o de nacimiento");
		lblAnioNacimiento.setBounds(10, 36, 106, 14);
		contentPane.add(lblAnioNacimiento);

		txtNombresApellidos = new JTextField();
		txtNombresApellidos.setBounds(126, 8, 126, 20);
		contentPane.add(txtNombresApellidos);
		txtNombresApellidos.setColumns(10);

		txtAnioNacimiento = new JTextField();
		txtAnioNacimiento.setBounds(126, 33, 126, 20);
		contentPane.add(txtAnioNacimiento);
		txtAnioNacimiento.setColumns(10);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 32, 89, 23);
		contentPane.add(btnBorrar);

		scp = new JScrollPane();
		scp.setBounds(10, 89, 414, 148);
		contentPane.add(scp);

		txtS = new JTextArea();
		scp.setViewportView(txtS);

		lblPesoKilogramos = new JLabel("Peso en kilogramos");
		lblPesoKilogramos.setBounds(10, 61, 106, 14);
		contentPane.add(lblPesoKilogramos);

		txtPesoKilogramos = new JTextField();
		txtPesoKilogramos.setBounds(126, 58, 126, 20);
		contentPane.add(txtPesoKilogramos);
		txtPesoKilogramos.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		contentPane.add(btnProcesar);
	}

	// Direcciona eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
		if (arg0.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(arg0);
		}
	}

	// Procesa la pulsaci�n del bot�n Borrar
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtNombresApellidos.setText("");
		txtAnioNacimiento.setText("");
		txtPesoKilogramos.setText("");
		txtS.setText("");
		txtNombresApellidos.requestFocus();
	}

	// Procesa la pulsaci�n del bot�n Procesar
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		String nombresApellidos;
		int anioNacimiento;
		double pesoKilogramos;
		
		nombresApellidos = txtNombresApellidos.getText();
		anioNacimiento = Integer.parseInt(txtAnioNacimiento.getText());
		pesoKilogramos = Double.parseDouble(txtPesoKilogramos.getText());
		
		txtS.setText("DATOS INGRESADOS\n");
		txtS.append("Nombres y apellidos:	" + nombresApellidos + "\n");
		txtS.append("Año de Nacimiento:	" + anioNacimiento + "\n");
		txtS.append("Peso en Kilogramos:	" + pesoKilogramos + "\n");
	}
}
