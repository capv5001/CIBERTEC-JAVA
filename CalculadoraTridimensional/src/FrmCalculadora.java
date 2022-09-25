import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class FrmCalculadora extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCilindro;
	private JLabel lblRadioCilindro;
	private JLabel lblAlturaCilindro;
	private JLabel lblGeneratrizCono;
	private JLabel lblRadioCono;
	private JLabel lblCono;
	private JLabel lblRadioEsfera;
	private JLabel lblEsfera;
	private JButton btnCalcularCilindro;
	private JButton btnCalcularCono;
	private JButton btnCalcularEsfera;
	private JTextField txtRadioCilindro;
	private JTextField txtAlturaCilindro;
	private JTextField txtRadioCono;
	private JTextField txtGeneratrizCono;
	private JTextField txtRadioEsfera;
	private JSeparator separator;
	private JSeparator separator_1;
	private JButton btnLimpiarCilindro;
	private JButton btnLimpiarCono;
	private JButton btnLimpiarEsfera;
	private JTextArea txtSCilindro;
	private JTextArea txtSCono;
	private JTextArea txtSEsfera;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCalculadora frame = new FrmCalculadora();
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
	public FrmCalculadora() {
		setResizable(false);
		setTitle("Calculadora de Objetos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCilindro = new JLabel("Cilindro");
		lblCilindro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCilindro.setBounds(10, 11, 117, 19);
		contentPane.add(lblCilindro);
		
		lblRadioCilindro = new JLabel("Radio");
		lblRadioCilindro.setBounds(10, 41, 46, 14);
		contentPane.add(lblRadioCilindro);
		
		lblAlturaCilindro = new JLabel("Altura");
		lblAlturaCilindro.setBounds(10, 90, 46, 14);
		contentPane.add(lblAlturaCilindro);
		
		lblGeneratrizCono = new JLabel("Generatriz");
		lblGeneratrizCono.setBounds(220, 90, 70, 14);
		contentPane.add(lblGeneratrizCono);
		
		lblRadioCono = new JLabel("Radio");
		lblRadioCono.setBounds(220, 41, 46, 14);
		contentPane.add(lblRadioCono);
		
		lblCono = new JLabel("Cono");
		lblCono.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCono.setBounds(220, 11, 117, 19);
		contentPane.add(lblCono);
		
		lblRadioEsfera = new JLabel("Radio");
		lblRadioEsfera.setBounds(427, 41, 46, 14);
		contentPane.add(lblRadioEsfera);
		
		lblEsfera = new JLabel("Esfera");
		lblEsfera.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEsfera.setBounds(427, 11, 117, 19);
		contentPane.add(lblEsfera);
		
		btnCalcularCilindro = new JButton("Calcular");
		btnCalcularCilindro.addActionListener(this);
		btnCalcularCilindro.setBounds(7, 156, 89, 23);
		contentPane.add(btnCalcularCilindro);
		
		btnCalcularCono = new JButton("Calcular");
		btnCalcularCono.addActionListener(this);
		btnCalcularCono.setBounds(217, 156, 89, 23);
		contentPane.add(btnCalcularCono);
		
		btnCalcularEsfera = new JButton("Calcular");
		btnCalcularEsfera.addActionListener(this);
		btnCalcularEsfera.setBounds(427, 156, 89, 23);
		contentPane.add(btnCalcularEsfera);
		
		txtRadioCilindro = new JTextField();
		txtRadioCilindro.setBounds(10, 55, 185, 20);
		contentPane.add(txtRadioCilindro);
		txtRadioCilindro.setColumns(10);
		
		txtAlturaCilindro = new JTextField();
		txtAlturaCilindro.setColumns(10);
		txtAlturaCilindro.setBounds(10, 104, 185, 20);
		contentPane.add(txtAlturaCilindro);
		
		txtRadioCono = new JTextField();
		txtRadioCono.setColumns(10);
		txtRadioCono.setBounds(220, 55, 185, 20);
		contentPane.add(txtRadioCono);
		
		txtGeneratrizCono = new JTextField();
		txtGeneratrizCono.setColumns(10);
		txtGeneratrizCono.setBounds(220, 104, 185, 20);
		contentPane.add(txtGeneratrizCono);
		
		txtRadioEsfera = new JTextField();
		txtRadioEsfera.setColumns(10);
		txtRadioEsfera.setBounds(427, 55, 188, 20);
		contentPane.add(txtRadioEsfera);
		
		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(new Color(192, 192, 192));
		separator.setForeground(new Color(192, 192, 192));
		separator.setBounds(205, 11, 2, 383);
		contentPane.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(new Color(192, 192, 192));
		separator_1.setBackground(new Color(192, 192, 192));
		separator_1.setBounds(415, 11, 2, 383);
		contentPane.add(separator_1);
		
		btnLimpiarCilindro = new JButton("Limpiar");
		btnLimpiarCilindro.addActionListener(this);
		btnLimpiarCilindro.setBounds(106, 156, 89, 23);
		contentPane.add(btnLimpiarCilindro);
		
		btnLimpiarCono = new JButton("Limpiar");
		btnLimpiarCono.addActionListener(this);
		btnLimpiarCono.setBounds(316, 156, 89, 23);
		contentPane.add(btnLimpiarCono);
		
		btnLimpiarEsfera = new JButton("Limpiar");
		btnLimpiarEsfera.addActionListener(this);
		btnLimpiarEsfera.setBounds(526, 156, 89, 23);
		contentPane.add(btnLimpiarEsfera);
		
		txtSCilindro = new JTextArea();
		txtSCilindro.setBounds(10, 190, 185, 204);
		contentPane.add(txtSCilindro);
		
		txtSCono = new JTextArea();
		txtSCono.setBounds(217, 190, 188, 204);
		contentPane.add(txtSCono);
		
		txtSEsfera = new JTextArea();
		txtSEsfera.setBounds(427, 190, 188, 204);
		contentPane.add(txtSEsfera);
	}
	
	// Section Actions
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLimpiarEsfera) {
			actionPerformedBtnLimpiarEsfera(e);
		}
		if (e.getSource() == btnCalcularEsfera) {
			actionPerformedBtnCalcularEsfera(e);
		}
		if (e.getSource() == btnLimpiarCono) {
			actionPerformedBtnLimpiarCono(e);
		}
		if (e.getSource() == btnCalcularCono) {
			actionPerformedBtnCalcularCono(e);
		}
		if (e.getSource() == btnLimpiarCilindro) {
			actionPerformedBtnLimpiarCilindro(e);
		}
		if (e.getSource() == btnCalcularCilindro) {
			actionPerformedBtnCalcularCilindro(e);
		}
	}
	// END Section Actions
	
	//Section Calculate Cylinder
	protected void actionPerformedBtnCalcularCilindro(ActionEvent e) {
		
		//Declaration variable
		double areaLateral, areaTotal, areaBase, radio, altura;
		
		//Parsing values
		DecimalFormat formato = new DecimalFormat("#.##");
		radio = Double.parseDouble(txtRadioCilindro.getText());
		altura = Double.parseDouble(txtAlturaCilindro.getText());
		
		//Process
		areaLateral = 2 * 3.1416 * radio * altura;
		areaBase = 3.1416 * (radio * radio);
		areaTotal = (2 * areaBase) + areaLateral;
		
		//Output
		txtSCilindro.setText("Especificaciones Cilindro \n\n");
		txtSCilindro.append("Área Lateral:\n" + formato.format(areaLateral) + "\n\n");
		txtSCilindro.append("Área Base:\n" + formato.format(areaBase) + "\n\n");
		txtSCilindro.append("Área Total:\n" + formato.format(areaTotal));
		
	}
	protected void actionPerformedBtnLimpiarCilindro(ActionEvent e) {
		
		txtRadioCilindro.setText("");
		txtAlturaCilindro.setText("");
		txtSCilindro.setText("");
		txtRadioCilindro.requestFocus();
		
	}
	//END Section Calculate Cylinder
	
	//Section Calculate Cone
	protected void actionPerformedBtnCalcularCono(ActionEvent e) {
		
		//Declaration variable
		double areaBase, perimetroBase, areaLateral, radio, generatriz;
		
		//Parsing values
		DecimalFormat formato = new DecimalFormat("#.##");
		radio = Double.parseDouble(txtRadioCono.getText());
		generatriz = Double.parseDouble(txtGeneratrizCono.getText());
		
		//Process
		areaBase = 3.14 * (radio * radio);
		perimetroBase = (3.14 * 2) * radio;
		areaLateral = (perimetroBase * generatriz) / 2;
		
		//Output
		txtSCono.setText("Especificaciones Cono \n\n");
		txtSCono.append("Área Base:\n" + formato.format(areaBase) + "\n\n");
		txtSCono.append("Perímetro Base:\n" + formato.format(perimetroBase) + "\n\n");
		txtSCono.append("Área Lateral:\n" + formato.format(areaLateral));
		
	}
	protected void actionPerformedBtnLimpiarCono(ActionEvent e) {
		
		txtRadioCono.setText("");
		txtGeneratrizCono.setText("");
		txtSCono.setText("");
		txtRadioCono.requestFocus();
		
	}
	//END Section Calculate Cone
	
	//Section Calculate Sphere
	protected void actionPerformedBtnCalcularEsfera(ActionEvent e) {
		
		//Declaration variable
		double area, volumen, radio;
		
		//Parsing values
		DecimalFormat formato = new DecimalFormat("#.##");
		radio = Double.parseDouble(txtRadioEsfera.getText());
				
		//Process
		area = 12.57 * (radio * radio);
		volumen = (12.57 * (radio * radio * radio)) / 3;
		
		//Output
		txtSEsfera.setText("Especificaciones Esfera \n\n");
		txtSEsfera.append("Área:\n" + formato.format(area) + "\n\n");
		txtSEsfera.append("Volumen:\n" + formato.format(volumen));
		
	}
	protected void actionPerformedBtnLimpiarEsfera(ActionEvent e) {
		txtRadioEsfera.setText("");
		txtSEsfera.setText("");
		txtRadioEsfera.requestFocus();
	}
	// END Section Calculate Sphere
	
}
