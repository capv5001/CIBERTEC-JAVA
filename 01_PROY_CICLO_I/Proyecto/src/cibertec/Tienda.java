package cibertec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;

public class Tienda extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	//DecimalFormat
	DecimalFormat df = new DecimalFormat("0.0");
	
	// Datos mínimos de la primera cocina
	public static String modelo0 = "Mabe EMP6120PG0";
	public static double precio0 = 949.0;
	public static double fondo0 = 58.6;
	public static double ancho0 = 60.0;
	public static double alto0 = 91.0;
	public static int quemadores0 = 4;
	
	// Datos mínimos de la segunda cocina
	public static String modelo1 = "Indurama Parma";
	public static double precio1 = 1089.0;
	public static double ancho1 = 80.0;
	public static double alto1 = 94.0;
	public static double fondo1 = 67.5;
	public static int quemadores1 = 6;
	
	// Datos mínimos de la tercera cocina
	public static String modelo2 = "Sole COSOL027";
	public static double precio2 = 850.0;
	public static double ancho2 = 60.0;
	public static double alto2 = 90.0;
	public static double fondo2 = 50.0;
	public static int quemadores2 = 4;
	
	// Datos mínimos de la cuarta cocina
	public static String modelo3 = "Coldex CX602";
	public static double precio3 = 629.0;
	public static double ancho3 = 61.6;
	public static double alto3 = 95.0;
	public static double fondo3 = 51.5;
	public static int quemadores3 = 5;
	
	// Datos mínimos de la quinta cocina
	public static String modelo4 = "Reco Dakota";
	public static double precio4 = 849.0;
	public static double ancho4 = 75.4;
	public static double alto4 = 94.5;
	public static double fondo4 = 66.0;
	public static int quemadores4 = 5;
	
	// Porcentajes de descuento
	public static double porcentaje1 = 7.5;
	public static double porcentaje2 = 10.0;
	public static double porcentaje3 = 12.5;
	public static double porcentaje4 = 15.0;
	
	// Obsequios
	public static String obsequio1 = "Cafetera";
	public static String obsequio2 = "Licuadora";
	public static String obsequio3 = "Extractor";
	
	// Cantidad óptima de unidades vendidas
	public static int cantidadOptima = 30;
	
	// Cuota diaria
	public static double cuotaDiaria = 75000;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnVentas;
	private JMenu mnConfiguracion;
	private JMenu mnAyuda;
	private JMenuItem mntmSalir;
	private JMenuItem mntmConsultarCocina;
	private JMenuItem mntmModificarCocina;
	private JMenuItem mntmListarCocinas;
	private JMenuItem mntmVender;
	private JMenuItem mntmGenerarReportes;
	private JMenuItem mntmConfigurarDescuentos;
	private JMenuItem mntmConfigurarObsequios;
	private JMenuItem mntmConfigurarCantidadptima;
	private JMenuItem mntmConfigurarCuotaDiaria;
	private JMenuItem mntmAcercaDeTienda;
	private JButton btnNewButton;
	
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
					Tienda frame = new Tienda();
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
	public Tienda() {
		setTitle("Tienda 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 465);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmConsultarCocina = new JMenuItem("Consultar Cocina");
		mntmConsultarCocina.addActionListener(this);
		mnMantenimiento.add(mntmConsultarCocina);
		
		mntmModificarCocina = new JMenuItem("Modificar Cocina");
		mntmModificarCocina.addActionListener(this);
		mnMantenimiento.add(mntmModificarCocina);
		
		mntmListarCocinas = new JMenuItem("Listar Cocinas");
		mntmListarCocinas.addActionListener(this);
		mnMantenimiento.add(mntmListarCocinas);
		
		mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(this);
		mnVentas.add(mntmVender);
		
		mntmGenerarReportes = new JMenuItem("Generar Reportes");
		mntmGenerarReportes.addActionListener(this);
		mnVentas.add(mntmGenerarReportes);
		
		mnConfiguracion = new JMenu("Configuración");
		menuBar.add(mnConfiguracion);
		
		mntmConfigurarDescuentos = new JMenuItem("Configurar Descuentos");
		mntmConfigurarDescuentos.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarDescuentos);
		
		mntmConfigurarObsequios = new JMenuItem("Configurar Obsequios");
		mntmConfigurarObsequios.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarObsequios);
		
		mntmConfigurarCantidadptima = new JMenuItem("Configurar Cantidad Óptima");
		mntmConfigurarCantidadptima.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarCantidadptima);
		
		mntmConfigurarCuotaDiaria = new JMenuItem("Configurar Cuota Diaria");
		mntmConfigurarCuotaDiaria.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarCuotaDiaria);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mntmAcercaDeTienda = new JMenuItem("Acerca de Tienda");
		mntmAcercaDeTienda.addActionListener(this);
		mnAyuda.add(mntmAcercaDeTienda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Botón de prueba");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(250, 122, 162, 23);
		contentPane.add(btnNewButton);
	}

	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == btnNewButton) {
	        actionPerformedBtnNewButton(e);
	    }
	    if (e.getSource() == mntmAcercaDeTienda) {
	        actionPerformedMntmAcercaDeTienda(e);
	    }
	    if (e.getSource() == mntmConfigurarCuotaDiaria) {
	        actionPerformedMntmConfigurarCuotaDiaria(e);
	    }
	    if (e.getSource() == mntmConfigurarCantidadptima) {
	        actionPerformedMntmConfigurarCantidadptima(e);
	    }
	    if (e.getSource() == mntmConfigurarObsequios) {
	        actionPerformedMntmConfigurarObsequios(e);
	    }
	    if (e.getSource() == mntmConfigurarDescuentos) {
	        actionPerformedMntmConfigurarDescuentos(e);
	    }
	    if (e.getSource() == mntmGenerarReportes) {
	        actionPerformedMntmGenerarReportes(e);
	    }
	    if (e.getSource() == mntmVender) {
	        actionPerformedMntmVender(e);
	    }
	    if (e.getSource() == mntmListarCocinas) {
	        actionPerformedMntmListarCocinas(e);
	    }
	    if (e.getSource() == mntmModificarCocina) {
	        actionPerformedMntmModificarCocina(e);
	    }
	    if (e.getSource() == mntmConsultarCocina) {
	        actionPerformedMntmConsultarCocina(e);
	    }
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
		
	}
	protected void actionPerformedMntmSalir(ActionEvent e) {
		//Create function to exit
	    System.exit(0);
	}
    protected void actionPerformedMntmConsultarCocina(ActionEvent e) {
        FrmConsultarCocina consultaCocina = new FrmConsultarCocina();
        consultaCocina.setVisible(true);
    }
    protected void actionPerformedMntmModificarCocina(ActionEvent e) {
        FrmModificarCocina modificarCocina = new FrmModificarCocina();
        modificarCocina.setVisible(true);
    }
    protected void actionPerformedMntmListarCocinas(ActionEvent e) {
        FrmListadoCocinas listarCocina = new FrmListadoCocinas();
        listarCocina.setVisible(true);
    }
    protected void actionPerformedMntmVender(ActionEvent e) {
        FrmVender vender = new FrmVender();
        vender.setVisible(true);
    }
    protected void actionPerformedMntmGenerarReportes(ActionEvent e) {
        FrmListadoCocinas listarCocina = new FrmListadoCocinas();
        listarCocina.setVisible(true);
    }
    protected void actionPerformedMntmConfigurarDescuentos(ActionEvent e) {
        FrmConfigurarPorcentajesDescuento configurarDescuento = new FrmConfigurarPorcentajesDescuento();
        configurarDescuento.setVisible(true);
    }
    protected void actionPerformedMntmConfigurarObsequios(ActionEvent e) {
        FrmConfigurarObsequios configurarObsequio = new FrmConfigurarObsequios();
        configurarObsequio.setVisible(true);
    }
    protected void actionPerformedMntmConfigurarCantidadptima(ActionEvent e) {
        FrmConfigurarCantidadOptima configurarCantidadOptima = new FrmConfigurarCantidadOptima();
        configurarCantidadOptima.setVisible(true);
    }
    protected void actionPerformedMntmConfigurarCuotaDiaria(ActionEvent e) {
        FrmConfigurarCuotaDiaria configurarCuotaDiaria = new FrmConfigurarCuotaDiaria();
        configurarCuotaDiaria.setVisible(true);
    }
    protected void actionPerformedMntmAcercaDeTienda(ActionEvent e) {
    }
    protected void actionPerformedBtnNewButton(ActionEvent e) {
        System.out.println(modelo1);
        System.out.println(precio1);
        System.out.println(alto1);
        System.out.println(ancho1);
        System.out.println(fondo1);
        System.out.println(quemadores1);
        
    }
}
