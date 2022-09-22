package programaPersonas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;

public class frmPersonas extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblEdad;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblPeso;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtEdad;
	private JTextField txtPeso;
	private JButton btnGuardar;
	private JButton btnNuevo;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPersonas frame = new frmPersonas();
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
	public frmPersonas() {
		setResizable(false);
		setTitle("Registro de personas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 398, 151);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 61, 59, 14);
		contentPane.add(lblEdad);
		
		lblNombre = new JLabel("Nombres");
		lblNombre.setBounds(10, 11, 59, 14);
		contentPane.add(lblNombre);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 36, 59, 14);
		contentPane.add(lblApellidos);
		
		lblPeso = new JLabel("Peso");
		lblPeso.setBounds(10, 86, 59, 14);
		contentPane.add(lblPeso);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(87, 8, 172, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(87, 33, 172, 20);
		contentPane.add(txtApellidos);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(87, 58, 172, 20);
		contentPane.add(txtEdad);
		
		txtPeso = new JTextField();
		txtPeso.setColumns(10);
		txtPeso.setBounds(87, 83, 172, 20);
		contentPane.add(txtPeso);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setBackground(new Color(255, 128, 128));
		btnGuardar.setBounds(283, 7, 89, 23);
		contentPane.add(btnGuardar);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNuevo.setForeground(new Color(255, 255, 255));
		btnNuevo.setBackground(new Color(255, 128, 128));
		btnNuevo.setBounds(283, 32, 89, 23);
		contentPane.add(btnNuevo);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCerrar.setForeground(new Color(255, 255, 255));
		btnCerrar.setBackground(new Color(255, 128, 128));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(283, 57, 89, 23);
		contentPane.add(btnCerrar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		System.out.println("xD Pa los compitas");
		System.exit(0);
	}
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		System.out.println("Guardar Data xD");
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		System.out.println("xD No admitimos gente nueva pe !!");
	}
}
