package programaInstitucion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class FormProgramaInstitucion extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblTitulo;
	private JLabel lblSubtitulo;
	private JLabel lblDonacion;
	private JSeparator separator;
	private JTextField txtDonacion;
	private JButton btnDonar;
	private JButton btnLimpiar;
	private JTextArea txtSDonacion;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormProgramaInstitucion frame = new FormProgramaInstitucion();
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
	public FormProgramaInstitucion() {
		setTitle("Programa de Donaciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitulo = new JLabel("Programa de Donaciones");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblTitulo.setBounds(10, 11, 514, 34);
		contentPane.add(lblTitulo);
		
		lblSubtitulo = new JLabel("Gracias por su donaci\u00F3n buen samaritano");
		lblSubtitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitulo.setBounds(10, 56, 514, 26);
		contentPane.add(lblSubtitulo);
		
		lblDonacion = new JLabel("Donaci\u00F3n:");
		lblDonacion.setBounds(10, 113, 61, 14);
		contentPane.add(lblDonacion);
		
		separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBackground(Color.LIGHT_GRAY);
		separator.setBounds(10, 93, 514, 2);
		contentPane.add(separator);
		
		txtDonacion = new JTextField();
		txtDonacion.setBounds(76, 110, 114, 20);
		contentPane.add(txtDonacion);
		txtDonacion.setColumns(10);
		
		btnDonar = new JButton("Donar");
		btnDonar.addActionListener(this);
		btnDonar.setBounds(200, 109, 89, 23);
		contentPane.add(btnDonar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(435, 109, 89, 23);
		contentPane.add(btnLimpiar);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 138, 514, 212);
		contentPane.add(scrollPane);
		
		txtSDonacion = new JTextArea();
		scrollPane.setViewportView(txtSDonacion);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDonar) {
			actionPerformedBtnDonar(e);
		}
	}
	protected void actionPerformedBtnDonar(ActionEvent e) {
		//Declaration variable
		double hospital, comedor, guarderia, escuela, asilo, donacion;
		
		//Parsing values
		DecimalFormat formato = new DecimalFormat("#.##");
		donacion = Double.parseDouble(txtDonacion.getText());
		
		//Process
		hospital = 0.25 * donacion;
		guarderia = 0.15 * donacion;
		escuela = 0.65 * (hospital + guarderia);
		comedor = 0.45 * escuela;
		asilo = donacion - (hospital + guarderia + escuela - comedor);
		
		//Output
		txtSDonacion.setText("¿Cómo vamos a repartir nuestros donativos? \n");
		txtSDonacion.append("De la siguiente manera: \n\n");
		txtSDonacion.append("Hospital:\n" + formato.format(hospital) + "\n\n");
		txtSDonacion.append("Comedor:\n" + formato.format(comedor) + "\n\n");
		txtSDonacion.append("Guardería:\n" + formato.format(guarderia) + "\n\n");
		txtSDonacion.append("Escuela:\n" + formato.format(escuela) + "\n\n");
		txtSDonacion.append("Asilo:\n" + formato.format(asilo) + "\n\n");
	}
}
