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

public class FrmLibreria extends JFrame implements ActionListener {

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
					FrmLibreria frame = new FrmLibreria();
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
	public FrmLibreria() {
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
			categoriaMotivacion,
			categoriaProgramacion, 
			categoriaDisenio3D, 
			categoriaRevistas, 
			categoriaClasicos,
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
		categoriaMotivacion = 0.1838 * monto;
		categoriaClasicos = 0.1518 * monto;
		categoriaProgramacion = 0.2512 * categoriaClasicos;
		categoriaDisenio3D = 0.1058 * (categoriaMotivacion + categoriaProgramacion);
		categoriaRevistas = monto - (categoriaMotivacion + categoriaClasicos + categoriaProgramacion + categoriaDisenio3D);
		
		//Output
		txtS.setText("Repartición de dinero a categorías \n\n");
		txtS.append("Categoría Motivación	: S/. " + formato.format(categoriaMotivacion) + "\n");
		txtS.append("Categoría Clásicos	: S/. " + formato.format(categoriaClasicos) + "\n");
		txtS.append("Categoría Programación	: S/. " + formato.format(categoriaProgramacion) + "\n");
		txtS.append("Categoría Diseño 3D	: S/. " + formato.format(categoriaDisenio3D) + "\n");
		txtS.append("Categoría Revistas	: S/. " + formato.format(categoriaRevistas));
	}
	
	// Actions to Erase button
	protected void actionPerformedBtnBorrar(ActionEvent e) {
		txtMonto.setText("");
		txtS.setText("");
		txtMonto.requestFocus();
	}
}
