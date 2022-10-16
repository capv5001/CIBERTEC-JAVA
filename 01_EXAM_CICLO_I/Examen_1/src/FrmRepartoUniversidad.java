import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class FrmRepartoUniversidad extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblMonto;
	private JTextField txtMonto;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRepartoUniversidad frame = new FrmRepartoUniversidad();
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
	public FrmRepartoUniversidad() {
		setResizable(false);
		setTitle("Christian Palacios - Repartir Dinero");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMonto = new JLabel("Monto");
		lblMonto.setBounds(10, 11, 49, 14);
		contentPane.add(lblMonto);
		
		txtMonto = new JTextField();
		txtMonto.setBounds(69, 8, 157, 20);
		contentPane.add(txtMonto);
		txtMonto.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(324, 8, 89, 23);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(423, 8, 89, 23);
		contentPane.add(btnBorrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 36, 502, 214);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(e);
		}
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	
	// Decimal Format
	DecimalFormat formato = new DecimalFormat("0.00");

	// Actions to process button
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		//Declaration variable
		double 
			ingenieriaElectronica,
			ingenieriaEconomica, 
			ingenieriaSistemas, 
			ingenieriaCivil, 
			ingenieraMinas,
			monto;
		
		// Try code if the amount is valid
		try {
			//Parsing values
			monto = Double.parseDouble(txtMonto.getText());
			if(monto <= 0) {
				JOptionPane.showMessageDialog(this, "Ingresar valores mayores a 0", "Error!!!", 0);
				
				txtMonto.setText("");
				txtS.setText("");
				txtMonto.requestFocus();
				return;
			}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(this, "Ingresar únicamente valores numéricos", "Error!!!", 0);
			
			txtMonto.setText("");
			txtS.setText("");
			txtMonto.requestFocus();
			return;
		}
		
		//Process
		ingenieriaCivil = 0.25 * monto;
		ingenieriaSistemas = 0.20 * ingenieriaCivil;
		ingenieriaEconomica = 0.45 * (ingenieriaCivil + ingenieriaSistemas);
		ingenieriaElectronica = 0.35 * ingenieriaEconomica;
		ingenieraMinas = monto - (ingenieriaCivil + ingenieriaSistemas + ingenieriaEconomica + ingenieriaElectronica);
		
		//Output
		txtS.setText("Repartición de dinero a facultades \n\n");
		txtS.append("Ingeniería Civil		: S/. " + formato.format(ingenieriaCivil) + "\n");
		txtS.append("Ingeniería de Sistemas	: S/. " + formato.format(ingenieriaSistemas) + "\n");
		txtS.append("Ingeniería Económica	: S/. " + formato.format(ingenieriaEconomica) + "\n");
		txtS.append("Ingeniería Electrónica	: S/. " + formato.format(ingenieriaElectronica) + "\n");
		txtS.append("Ingeniería Minas	: S/. " + formato.format(ingenieraMinas));
	}
	
	// Actions to Erase button
	protected void actionPerformedBtnBorrar(ActionEvent e) {
		txtMonto.setText("");
		txtS.setText("");
		txtMonto.requestFocus();
	}
}
