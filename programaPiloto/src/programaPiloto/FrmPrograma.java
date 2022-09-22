package programaPiloto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class FrmPrograma extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNombreApellido;
	private JTextField txtNombreApellido;
	private JButton btnCerrar;
	private JLabel lblTitle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrograma frame = new FrmPrograma();
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
	public FrmPrograma() {
		setResizable(false);
		setTitle("PROGRAMA PA' LAS MASCOTAS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 204));
		contentPane.setForeground(new Color(255, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNombreApellido = new JLabel("Ingresa tu nombre y apellido, al toque pe...");
		lblNombreApellido.setBounds(12, 89, 272, 14);
		contentPane.add(lblNombreApellido);
		
		txtNombreApellido = new JTextField();
		txtNombreApellido.setToolTipText("");
		txtNombreApellido.setBounds(12, 114, 412, 20);
		contentPane.add(txtNombreApellido);
		txtNombreApellido.setColumns(10);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setForeground(new Color(255, 255, 255));
		btnCerrar.setBackground(new Color(255, 79, 79));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(335, 227, 89, 23);
		contentPane.add(btnCerrar);
		
		lblTitle = new JLabel("BIENVENIDO PE, MASCOTA");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(18, 27, 397, 38);
		contentPane.add(lblTitle);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		System.exit(0);
	}
}
