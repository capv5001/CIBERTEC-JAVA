package semana03;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Empresa extends JFrame implements ActionListener {

	// Declaración de variables
	private static final long serialVersionUID = 9206324162700448001L;
	private JPanel contentPane;
	private JLabel lblMontoDinero;
	private JTextField txtMontoDinero;
	private JButton btnProcesar;
	private JScrollPane scpScroll;
	private JTextArea txtS;
	private JButton btnBorrar;

	// Lanza la aplicación
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
					Empresa frame = new Empresa();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Crea la GUI
	public Empresa() {
		setTitle("Empresa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblMontoDinero = new JLabel("Monto de dinero");
		lblMontoDinero.setBounds(10, 11, 80, 14);
		contentPane.add(lblMontoDinero);

		txtMontoDinero = new JTextField();
		txtMontoDinero.setBounds(100, 8, 100, 20);
		contentPane.add(txtMontoDinero);
		txtMontoDinero.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		contentPane.add(btnProcesar);

		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 38, 414, 213);
		contentPane.add(scpScroll);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scpScroll.setViewportView(txtS);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(236, 7, 89, 23);
		contentPane.add(btnBorrar);
	}

	// Direcciona eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(arg0);
		}
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}

	// Procesa la pulsación del botón Borrar
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtMontoDinero.setText("");
		txtS.setText("");
		txtMontoDinero.requestFocus();
	}

	// Procesa la pulsación del botón Procesar
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		
		//Declaration variable
		double contabilidad, marketing, informatica, produccion, soporte, donacion;
		
		//Parsing values
		DecimalFormat formato = new DecimalFormat("#.##");
		donacion = Double.parseDouble(txtMontoDinero.getText());
		
		//Process
		contabilidad = 0.25 * donacion;
		marketing = 0.18 * donacion;
		informatica = 0.31 * donacion;
		produccion = 0.14 * donacion;
		soporte = donacion - (contabilidad + marketing + informatica + produccion);
		
		//Output
		txtS.setText("REPARTO DEL DINERO \n\n");
		txtS.append("Contabilidad	: " + formato.format(contabilidad) + "\n");
		txtS.append("Marketing	: " + formato.format(marketing) + "\n");
		txtS.append("Informática	: " + formato.format(informatica) + "\n");
		txtS.append("Producción	: " + formato.format(produccion) + "\n");
		txtS.append("Soporte		: " + formato.format(soporte));

	}
}