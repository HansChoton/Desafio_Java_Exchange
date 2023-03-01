


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
	private JTextArea titleMontoIngresar;
	
	
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
		
	}

	private void iniciarEtiquetas() {	
		
		// indicaciones iniciales
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
		
		
		// texto de boton seleccion conversor de monedas
		JLabel titleBotonMoneda = new JLabel();
		titleBotonMoneda.setText("Conversor Moneda");		
		titleBotonMoneda.setBounds(52, 215, 98, 20);
		titleBotonMoneda.setFont(new Font("century",0,10));
		panel.add(titleBotonMoneda);
		
		
		// texto de boton seleccion conversor de temperatura
		JLabel titleBotonTemp = new JLabel();
		titleBotonTemp.setText("Conversor Temperatura");
		titleBotonTemp.setBounds(38,315, 112, 20);
		titleBotonTemp.setFont(new Font("century", 0, 10));
		panel.add(titleBotonTemp);
		
		// texto de ingreso cantidad de dinero
		titleMontoIngresar = new JTextArea();		
		titleMontoIngresar.setText(" ");
		titleMontoIngresar.setEditable(false);
		titleMontoIngresar.setBounds(285, 75, 290, 20);		
		titleMontoIngresar.setOpaque(false);		
		titleMontoIngresar.setForeground(Color.white);
		titleMontoIngresar.setFont(new Font("century", 3, 14));
		panel.add(titleMontoIngresar);		
		
		/*
		 * 
		 * 
		 * JLabel conversorTemperatura = new JLabel(new ImageIcon("Temperatura.jpg"));
		 * panel.add(conversorTemperatura); conversorTemperatura.setBounds(184, 10, 490, 340);
		 */
	}
	

	
	private void cambiarMoneda() {
		String [] divisas = {"Seleccione una opción","Soles a Dolares", "Soles a Euros", "Soles a Libras Esterlinas", "Soles a Yen", "Soles a Won Coreano",
				"Dolares a Soles", "Euros a Soles","Libras Esterlinas a Soles","Yen a Soles","Won Coreano a Soles"};
		listaDeOpciones = new JComboBox(divisas);
		listaDeOpciones.setBounds(340, 160, 180, 20);
		listaDeOpciones.setVisible(false);
		panel.add(listaDeOpciones);
		
	}

	private void iniciarBotones() {
		
		qtyMonedas = new JTextField();		
		qtyMonedas.setBounds(340, 100, 180, 20);	
		qtyMonedas.setVisible(false);
		panel.add(qtyMonedas);
		
		JLabel intro = new JLabel(new ImageIcon("intro.jpg"));		
		intro.setBounds(184, 10, 490, 340);
		panel.add(intro);
		
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
		botonAceptar1.setVisible(false);
		botonAceptar1.setText("Aceptar");		
		panel.add(botonAceptar1);		
		
		// Eventos de botones
		
		//Evento seleccionar conversor de monedas
		ActionListener conversorMoneda = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				qtyMonedas.setVisible(true);
				botonAceptar1.setVisible(true);
				listaDeOpciones.setVisible(true);
				titleMontoIngresar.setText("Cantidad de dinero que deseas convertir");
				intro.setVisible(false);
				JLabel conversorMonedas = new JLabel(new ImageIcon("Monedas.jpg"));
				conversorMonedas.setBounds(184, 10, 490, 340);//posicionando la etiqueta
				panel.add(conversorMonedas);//agregando la etiqueta al panel				
				
			}
		};
		botonMoneda.addActionListener(conversorMoneda);
		
		
		//evento boton aceptar para convertir
		ActionListener accionbtnconvertir = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				if(listaDeOpciones.getSelectedItem().toString() == "Soles a Dolares") {					
					JOptionPane.showMessageDialog(null,"La cantidad que obtendrás es:  " + String.format("%.2f",Double.parseDouble(qtyMonedas.getText())/3.82)+ " $ USD");					
				}
				else if(listaDeOpciones.getSelectedItem().toString() == "Soles a Euros") {					
					JOptionPane.showMessageDialog(null,"La cantidad que obtendrás es:  " + String.format("%.2f",Double.parseDouble(qtyMonedas.getText())/4.03)+ " € Euros");					
				}
				else if(listaDeOpciones.getSelectedItem().toString() == "Soles a Libras Esterlinas") {					
					JOptionPane.showMessageDialog(null,"La cantidad que obtendrás es:  " + String.format("%.2f",Double.parseDouble(qtyMonedas.getText())/4.56)+ " £ Libras");					
				}
				else if(listaDeOpciones.getSelectedItem().toString() == "Soles a Yen") {					
					JOptionPane.showMessageDialog(null,"La cantidad que obtendrás es:  " + String.format("%.2f",Double.parseDouble(qtyMonedas.getText())/0.03)+ " ¥ Yenes");					
				}
				else if(listaDeOpciones.getSelectedItem().toString() == "Soles a Won Coreano") {					
					JOptionPane.showMessageDialog(null,"La cantidad que obtendrás es:  " + String.format("%.2f",Double.parseDouble(qtyMonedas.getText())/0.00291)+ " Wones");					
				}
				else if(listaDeOpciones.getSelectedItem().toString() == "Dolares a Soles") {					
					JOptionPane.showMessageDialog(null,"La cantidad que obtendrás es:  " + String.format("%.2f",Double.parseDouble(qtyMonedas.getText())*3.82)+ " Soles");					
				}
				else if(listaDeOpciones.getSelectedItem().toString() == "Euros a Soles") {					
					JOptionPane.showMessageDialog(null,"La cantidad que obtendrás es:  " + String.format("%.2f",Double.parseDouble(qtyMonedas.getText())*4.03)+ " Soles");					
				}
				else if(listaDeOpciones.getSelectedItem().toString() == "Libras Esterlinas a Soles") {					
					JOptionPane.showMessageDialog(null,"La cantidad que obtendrás es:  " + String.format("%.2f",Double.parseDouble(qtyMonedas.getText())*4.56)+ " Soles");					
				}
				else if(listaDeOpciones.getSelectedItem().toString() == "Yen a Soles") {					
					JOptionPane.showMessageDialog(null,"La cantidad que obtendrás es:  " + String.format("%.2f",Double.parseDouble(qtyMonedas.getText())*0.03)+ " Soles");					
				}
				else if(listaDeOpciones.getSelectedItem().toString() == "Won Coreano a Soles") {					
					JOptionPane.showMessageDialog(null,"La cantidad que obtendrás es:  " + String.format("%.2f",Double.parseDouble(qtyMonedas.getText())*0.00291)+ " Soles");					
				}		
			}
		};
		botonAceptar1.addActionListener(accionbtnconvertir);	
	}
		
	
	
	
	
}
