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
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class FrmListadoCocinas extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCerrar;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private JButton btnListar;
	Tienda cocina = new Tienda();

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
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(123, 227, 98, 23);
		contentPanel.add(btnCerrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 11, 414, 205);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(225, 227, 98, 23);
		contentPanel.add(btnListar);
	}
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCerrar) {
            actionPerformedBtnCerrar(e);
        }
        if (e.getSource() == btnListar) {
            actionPerformedBtnListar(e);
        }
    }
    protected void actionPerformedBtnListar(ActionEvent e) {
        
        txtS.setText("LISTADO DE COCINAS\n\n");
        
        // Model
        txtS.append("Modelo\t: " + cocina.modelo0 + "\n");
        txtS.append("Precio\t: S/." + cocina.df.format(cocina.precio0) + "\n");
        txtS.append("Profundidad\t: " + cocina.df.format(cocina.fondo0) + " cm\n");
        txtS.append("Ancho\t: " + cocina.df.format(cocina.ancho0) + " cm\n");
        txtS.append("Alto\t: " + cocina.df.format(cocina.alto0) + " cm\n");
        txtS.append("Quemadores\t: " + cocina.quemadores0 + "\n\n");
        
        // Model
        txtS.append("Modelo\t: " + cocina.modelo1 + "\n");
        txtS.append("Precio\t: S/." + cocina.df.format(cocina.precio1) + "\n");
        txtS.append("Profundidad\t: " + cocina.df.format(cocina.fondo1) + " cm\n");
        txtS.append("Ancho\t: " + cocina.df.format(cocina.ancho1) + " cm\n");
        txtS.append("Alto\t: " + cocina.df.format(cocina.alto1) + " cm\n");
        txtS.append("Quemadores\t: " + cocina.quemadores1 + "\n\n");
        
        // Model
        txtS.append("Modelo\t: " + cocina.modelo2 + "\n");
        txtS.append("Precio\t: S/." + cocina.df.format(cocina.precio2) + "\n");
        txtS.append("Profundidad\t: " + cocina.df.format(cocina.fondo2) + " cm\n");
        txtS.append("Ancho\t: " + cocina.df.format(cocina.ancho2) + " cm\n");
        txtS.append("Alto\t: " + cocina.df.format(cocina.alto2) + " cm\n");
        txtS.append("Quemadores\t: " + cocina.df.format(cocina.quemadores2) + "\n\n");
        
        // Model
        txtS.append("Modelo\t: " + cocina.modelo3 + "\n");
        txtS.append("Precio\t: S/." + cocina.df.format(cocina.precio3) + "\n");
        txtS.append("Profundidad\t: " + cocina.df.format(cocina.fondo3) + " cm\n");
        txtS.append("Ancho\t: " + cocina.df.format(cocina.ancho3) + " cm\n");
        txtS.append("Alto\t: " + cocina.df.format(cocina.alto3) + " cm\n");
        txtS.append("Quemadores\t: " + cocina.df.format(cocina.quemadores3) + "\n\n");
        
    }
    protected void actionPerformedBtnCerrar(ActionEvent e) {
        this.dispose();
    }
}
