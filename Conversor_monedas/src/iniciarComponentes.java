


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//Es necesario heredar de Jframe debido a que es la interfaz para generar frame(ventana)
public class iniciarComponentes extends JFrame {

	private JPanel panel;	
	private JComboBox listaDeOpciones;
	private JTextField qtyMonedas;	
	
	
	public iniciarComponentes() {
		setSize(700, 400);// Se establece el ancho y el alto del frame
		setLocationRelativeTo(null);// Centrando el frame
		setMinimumSize(new Dimension(700, 400));// establecer tamaño minimo
		setTitle("Conversor de Monedas y Temperatura");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//saludo inicial 
		//JOptionPane.showMessageDialog(null, "+´>Bienvenid@, disfruta tu estancia<´+");				
			
		iniciarPanel();
		iniciarEtiquetas();
		iniciarBotones();		
		cambiarMoneda();
		
	}

	private void iniciarPanel() {
		panel = new JPanel(); // Creacion de un panel
		this.getContentPane().add(panel);// obtener contenido de la ventana y le agregamos el panel
		panel.setLayout(null);// se elimina toda configuracion por defecto del panel
		/*JLabel intro = new JLabel(new ImageIcon("intro.jpg"));
		intro.setBounds(0, 0, 600, 400);		
		panel.add(intro);*/
	}

	private void iniciarEtiquetas() {	
		
		//indicaciones iniciales
		JTextArea seleccion = new JTextArea();		
		seleccion.setText("Selecciona la aplicación de conversión que usarás");
		seleccion.setBounds(20, 20, 150, 100);
	    seleccion.setWrapStyleWord(true);//Ajustar el texto al tamaño establecido
	    seleccion.setLineWrap(true);//justificar texto
	    seleccion.setEditable(false);
		seleccion.setOpaque(false);
		seleccion.setForeground(Color.black);
		seleccion.setFont(new Font("century", 3, 20));
		panel.add(seleccion);
		
		
		//texto de boton seleccion conversor de monedas
		JLabel titleBotonMoneda = new JLabel();
		titleBotonMoneda.setText("Conversor Moneda");		
		titleBotonMoneda.setBounds(52, 215, 98, 20);
		titleBotonMoneda.setFont(new Font("century",0,10));
		panel.add(titleBotonMoneda);
		
		
		//texto de boton seleccion conversor de temperatura
		JLabel titleBotonTemp = new JLabel();
		titleBotonTemp.setText("Conversor Temperatura");
		titleBotonTemp.setBounds(38,315, 112, 20);
		titleBotonTemp.setFont(new Font("century", 0, 10));
		panel.add(titleBotonTemp);
		
		//texto de ingreso cantidad de dinero
		JTextArea titleMontoIngresar = new JTextArea();		
		titleMontoIngresar.setText("Cantidad de dinero que deseas convertir:");
		titleMontoIngresar.setBounds(285, 75, 290, 20);		
		titleMontoIngresar.setOpaque(false);		
		titleMontoIngresar.setForeground(Color.black);
		titleMontoIngresar.setFont(new Font("century", 3, 14));
		panel.add(titleMontoIngresar);		
		
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
	

	
	private void cambiarMoneda() {
		String [] divisas = {"Seleccione una opción","Soles a Dolares", "Soles a Euros", "Soles a Libras Esterlinas", "Soles a Yen", "Soles a Won Coreano",
				"Dolares a Soles", "Euros a Soles","Libras Esterlinas a Soles","Yen a Soles","Won Coreano a Soles"};
		listaDeOpciones = new JComboBox(divisas);
		listaDeOpciones.setBounds(340, 160, 180, 20);
		
		if (qtyMonedas.getText()=="") {
			listaDeOpciones.setVisible(false);
		}else {
			listaDeOpciones.setVisible(true);
		}
			
		panel.add(listaDeOpciones);
		
	}

	private void iniciarBotones() {
		
		qtyMonedas = new JTextField();		
		qtyMonedas.setBounds(340, 100, 180, 20);		
		panel.add(qtyMonedas);
		
		// boton seleccion de conversor moneda
		JButton botonMoneda = new JButton();
		botonMoneda.setBounds(55, 140, 80, 80);
		ImageIcon imgbtnMoneda = new ImageIcon("iconCoin.jpg");
		botonMoneda.setIcon(new ImageIcon(imgbtnMoneda.getImage().getScaledInstance(botonMoneda.getWidth(), botonMoneda.getHeight(),Image.SCALE_SMOOTH)));
		panel.add(botonMoneda);

		// boton seleccion de conversor temperatura
		JButton botonTemp = new JButton();
		botonTemp.setBounds(55, 240, 80, 80);
		ImageIcon imgbtnTemp = new ImageIcon("iconTemp.jpg");
		botonTemp.setIcon(new ImageIcon(imgbtnTemp.getImage().getScaledInstance(botonTemp.getWidth(),botonTemp.getHeight(), Image.SCALE_SMOOTH)));
		panel.add(botonTemp);
		
		// boton aceptar
		JButton botonAceptar1 = new JButton();
		botonAceptar1.setBounds(385, 130, 90, 20);
		botonAceptar1.setText("Aceptar");		
		panel.add(botonAceptar1);
		
		//accionamiento de boton
		ActionListener accionbtnconvertir = new ActionListener() {	
			
			@Override
			public void actionPerformed(ActionEvent e) {
				double cantidadConvertida;			
				double cantidadMonedas = Double.parseDouble(qtyMonedas.getText());
				if(listaDeOpciones.getSelectedItem().toString() == "Soles a Dolares") {					
					cantidadConvertida = cantidadMonedas/3.82;
					JOptionPane.showMessageDialog(null,"La cantidad que obtendrás es:  " + String.format("%.2f",cantidadConvertida)+ " $USD");					
				}
			}
		};
		botonAceptar1.addActionListener(accionbtnconvertir);
		
	}
		
	
	
	
	
}
