import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

//Es necesario heredar de Jframe debido a que es la interfaz para generar frame(ventana)
public class iniciarComponentes extends JFrame {

	public JPanel panel;

	public iniciarComponentes() {
		setSize(600, 400);// Se establece el ancho y el alto del frame
		setLocationRelativeTo(null);// Centrando el frame
		setMinimumSize(new Dimension(600, 400));// establecer tamaño minimo
		setTitle("Conversor de Monedas y Temperatura");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		iniciarPanel();
		iniciarEtiquetas();
		iniciarBotones();
	}

	private void iniciarPanel() {
		panel = new JPanel(); // Creacion de un panel
		this.getContentPane().add(panel);// obtener contenido de la ventana y le agregamos el panel
		panel.setLayout(null);// se elimina toda configuracion por defecto del panel
	}

	private void iniciarEtiquetas() {

		//JLabel intro = new JLabel(new ImageIcon("intro.jpg"));
		//intro.setBounds(0, 0, 600, 400);
		//panel.add(intro);
		
		//indicaciones iniciales
		JLabel seleccion = new JLabel();		
		seleccion.setText("Escoge la aplicación que vas a utilizar");
		seleccion.setHorizontalAlignment(SwingConstants.CENTER);
		seleccion.setBounds(90, 80, 350, 20);
		seleccion.setOpaque(true);
		seleccion.setBackground(Color.black);
		seleccion.setForeground(Color.white);
		seleccion.setFont(new Font("century", 3, 15));
		panel.add(seleccion);
		
		//boton seleccion conversor de monedas
		JLabel titleBotonMoneda = new JLabel();
		titleBotonMoneda.setText("Conversor Moneda");
		titleBotonMoneda.setBounds(95, 165, 98, 20);
		titleBotonMoneda.setFont(new Font("century",0,10));
		panel.add(titleBotonMoneda);
		
		//boton seleccion conversor de temperatura
		JLabel titleBotonTemp = new JLabel();
		titleBotonTemp.setText("Conversor Temperatura");
		titleBotonTemp.setBounds(330, 165, 112, 20);
		titleBotonTemp.setFont(new Font("century", 0, 10));
		panel.add(titleBotonTemp);
		/*
		 * JLabel conversorMonedas = new JLabel(new ImageIcon("Monedas.jpg"));//creando
		 * nueva etiqueta panel.add(conversorMonedas);//agregando la etiqueta al panel
		 * conversorMonedas.setBounds(0, 0, 600, 200);//posicionando la etiqueta
		 * 
		 * JLabel conversorTemperatura = new JLabel(new ImageIcon("Temperatura.jpg"));
		 * panel.add(conversorTemperatura); conversorTemperatura.setBounds(0, 200, 600,
		 * 200);
		 */
	}

	private void iniciarBotones() {

		// boton seleccion de conversor moneda
		JButton botonMoneda = new JButton();
		botonMoneda.setBounds(120, 120, 50, 50);
		ImageIcon imgbtnMoneda = new ImageIcon("iconCoin.jpg");
		botonMoneda.setIcon(new ImageIcon(imgbtnMoneda.getImage().getScaledInstance(botonMoneda.getWidth(), botonMoneda.getHeight(),Image.SCALE_SMOOTH)));
		panel.add(botonMoneda);

		// boton seleccion de conversor temperatura
		JButton botonTemp = new JButton();
		botonTemp.setBounds(365, 120, 50, 50);
		ImageIcon imgbtnTemp = new ImageIcon("iconTemp.jpg");
		botonTemp.setIcon(new ImageIcon(imgbtnTemp.getImage().getScaledInstance(botonTemp.getWidth(),botonTemp.getHeight(), Image.SCALE_SMOOTH)));
		panel.add(botonTemp);
	}
}
