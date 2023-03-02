


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//Es necesario heredar de Jframe debido a que es la interfaz para generar frame(ventana)
public class aplicativoConversion extends JFrame {

	private JPanel panel;	
	private JComboBox listaDeOpciones;
	private JTextField valorDeConversion;
	private JTextArea titleMontoIngresar;
	private JButton botonAceptarMonedas;
	private JButton botonAceptarTemp;
	private JButton botonTemp;
	private JButton botonMoneda;
	private JLabel intro;
	
	
	public aplicativoConversion() {
		
		setSize(700, 400);// Se establece el ancho y el alto del frame
		setLocationRelativeTo(null);// Centrando el frame
		setMinimumSize(new Dimension(700, 400));// establecer tamaño minimo
		setTitle("Conversor de Monedas y Temperatura");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
				
		condicionesIniciales();		
		conversorMonedas();
		conversorTemp();
		
	}

	private void condicionesIniciales() {
		//Creacion de panel
		panel = new JPanel();
		this.getContentPane().add(panel);// obtener contenido de la ventana y le agregamos el panel
		panel.setLayout(null);// se elimina toda configuracion por defecto del panel
		
		//se agrega imagen de inicio a panel
		intro = new JLabel(new ImageIcon("intro.jpg"));		
		intro.setBounds(184, 10, 490, 340);	
		panel.add(intro);		
		
		// indicaciones iniciales
		JTextArea seleccion = new JTextArea();
		seleccion.setText("Selecciona la aplicación de conversión que usarás");
		seleccion.setBounds(20, 20, 150, 100);
		seleccion.setWrapStyleWord(true);// Ajustar el texto al tamaño establecido
		seleccion.setLineWrap(true);// justificar texto
		seleccion.setEditable(false);
		seleccion.setOpaque(false);
		seleccion.setForeground(Color.black);
		seleccion.setFont(new Font("century", 3, 20));
		panel.add(seleccion);		
	}
	
	private void conversorMonedas() {
		
		//boton seleccion de conversor moneda
		botonMoneda = new JButton();
		botonMoneda.setBounds(55, 140, 80, 80);
		ImageIcon imgbtnMoneda = new ImageIcon("iconCoin.jpg");
		botonMoneda.setIcon(new ImageIcon(imgbtnMoneda.getImage().getScaledInstance(botonMoneda.getWidth(),botonMoneda.getHeight(), Image.SCALE_SMOOTH)));
		panel.add(botonMoneda);
		
		//texto de boton seleccion conversor de monedas
		JLabel titleBotonMoneda = new JLabel();
		titleBotonMoneda.setText("Conversor Moneda");
		titleBotonMoneda.setBounds(52, 215, 98, 20);
		titleBotonMoneda.setFont(new Font("century", 0, 10));
		panel.add(titleBotonMoneda);
		
		// Evento seleccionar conversor de monedas
		ActionListener conversorMoneda = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				valorDeConversion.setVisible(true);
				botonAceptarMonedas.setVisible(true);				
				listaDeOpciones.setVisible(true);
				titleMontoIngresar.setText("Cantidad de dinero que deseas convertir");
				titleMontoIngresar.setForeground(Color.white);
				intro.setVisible(false);
				botonTemp.setEnabled(false);
				//creacion de fondo de pantalla para conversor
				JLabel conversorMonedas = new JLabel(new ImageIcon("Monedas.jpg"));
				conversorMonedas.setBounds(184, 10, 490, 340);
				panel.add(conversorMonedas);

			}
		};
		botonMoneda.addActionListener(conversorMoneda);
		
		// titulo dentro del conversor
		titleMontoIngresar = new JTextArea();
		titleMontoIngresar.setText(" ");
		titleMontoIngresar.setEditable(false);
		titleMontoIngresar.setBounds(285, 75, 300, 20);
		titleMontoIngresar.setOpaque(false);		
		titleMontoIngresar.setFont(new Font("century", 3, 14));
		panel.add(titleMontoIngresar);
		
		//campo de texto de ingreso de monedas
		valorDeConversion = new JTextField();
		valorDeConversion.setBounds(340, 100, 180, 20);
		valorDeConversion.setVisible(false);
		panel.add(valorDeConversion);
		
		// boton aceptar para convertir
		botonAceptarMonedas = new JButton();
		botonAceptarMonedas.setBounds(385, 130, 90, 20);
		botonAceptarMonedas.setVisible(false);
		botonAceptarMonedas.setText("Aceptar");
		panel.add(botonAceptarMonedas);
		
		//lista desplegable de conversor de monedas
		String[] divisas = { "Soles a Dolares", "Soles a Euros", "Soles a Libras Esterlinas",
				"Soles a Yen", "Soles a Won Coreano", "Dolares a Soles", "Euros a Soles", "Libras Esterlinas a Soles",
				"Yen a Soles", "Won Coreano a Soles" };		
		listaDeOpciones = new JComboBox(divisas);
		listaDeOpciones.setBounds(340, 160, 180, 20);
		listaDeOpciones.setVisible(false);
		panel.add(listaDeOpciones);

		// evento boton aceptar para convertir
		ActionListener accionbtnconvertir = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//se agrega error por caja de texto vacia
				try {
					if (listaDeOpciones.getSelectedItem().toString() == "Soles a Dolares") {
						JOptionPane.showMessageDialog(null, "La cantidad que obtendrás es:  "
								+ String.format("%.2f", Double.parseDouble(valorDeConversion.getText()) / 3.82) + " $ USD");						
					} else if (listaDeOpciones.getSelectedItem().toString() == "Soles a Euros") {
						JOptionPane.showMessageDialog(null, "La cantidad que obtendrás es:  "
								+ String.format("%.2f", Double.parseDouble(valorDeConversion.getText()) / 4.03) + " € Euros");
					} else if (listaDeOpciones.getSelectedItem().toString() == "Soles a Libras Esterlinas") {
						JOptionPane.showMessageDialog(null, "La cantidad que obtendrás es:  "
								+ String.format("%.2f", Double.parseDouble(valorDeConversion.getText()) / 4.56) + " £ Libras");
					} else if (listaDeOpciones.getSelectedItem().toString() == "Soles a Yen") {
						JOptionPane.showMessageDialog(null, "La cantidad que obtendrás es:  "
								+ String.format("%.2f", Double.parseDouble(valorDeConversion.getText()) / 0.03) + " ¥ Yenes");
					} else if (listaDeOpciones.getSelectedItem().toString() == "Soles a Won Coreano") {
						JOptionPane.showMessageDialog(null, "La cantidad que obtendrás es:  "
								+ String.format("%.2f", Double.parseDouble(valorDeConversion.getText()) / 0.00291) + " Wones");
					} else if (listaDeOpciones.getSelectedItem().toString() == "Dolares a Soles") {
						JOptionPane.showMessageDialog(null, "La cantidad que obtendrás es:  "
								+ String.format("%.2f", Double.parseDouble(valorDeConversion.getText()) * 3.82) + " Soles");
					} else if (listaDeOpciones.getSelectedItem().toString() == "Euros a Soles") {
						JOptionPane.showMessageDialog(null, "La cantidad que obtendrás es:  "
								+ String.format("%.2f", Double.parseDouble(valorDeConversion.getText()) * 4.03) + " Soles");
					} else if (listaDeOpciones.getSelectedItem().toString() == "Libras Esterlinas a Soles") {
						JOptionPane.showMessageDialog(null, "La cantidad que obtendrás es:  "
								+ String.format("%.2f", Double.parseDouble(valorDeConversion.getText()) * 4.56) + " Soles");
					} else if (listaDeOpciones.getSelectedItem().toString() == "Yen a Soles") {
						JOptionPane.showMessageDialog(null, "La cantidad que obtendrás es:  "
								+ String.format("%.2f", Double.parseDouble(valorDeConversion.getText()) * 0.03) + " Soles");
					} else if (listaDeOpciones.getSelectedItem().toString() == "Won Coreano a Soles") {
						JOptionPane.showMessageDialog(null, "La cantidad que obtendrás es:  "
								+ String.format("%.2f", Double.parseDouble(valorDeConversion.getText()) * 0.00291) + " Soles");
						
					}
					int select = JOptionPane.showConfirmDialog(null, "¿Desea realizar otra operación?",
							"Selecciona una opción...", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
					switch (select) {
					case 0:
						valorDeConversion.setText("");
						break;
					case 1:
						JOptionPane.showMessageDialog(null, "Gracias por utilizar el programa, hasta la próxima");
						dispose();
						break;
					case 2:
						JOptionPane.showMessageDialog(null, "Gracias por utilizar el programa, hasta la próxima");
						dispose();
						break;
					default:
						JOptionPane.showMessageDialog(null, "El programa se cerro por no elegir una opción");
						dispose();
						break;
					}
										
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Ingrese un valor para convertir");
					
					
				}
				
			}
		};
		botonAceptarMonedas.addActionListener(accionbtnconvertir);
				
		
	}
	
	private void conversorTemp() {
		
		// boton seleccion de conversor temperatura
		botonTemp = new JButton();
		botonTemp.setBounds(55, 240, 80, 80);
		ImageIcon imgbtnTemp = new ImageIcon("iconTemp.jpg");
		botonTemp.setIcon(new ImageIcon(imgbtnTemp.getImage().getScaledInstance(botonTemp.getWidth(),botonTemp.getHeight(), Image.SCALE_SMOOTH)));
		panel.add(botonTemp);
		
		// texto de boton seleccion conversor de temperatura
		JLabel titleBotonTemp = new JLabel();
		titleBotonTemp.setText("Conversor Temperatura");
		titleBotonTemp.setBounds(38, 315, 112, 20);
		titleBotonTemp.setFont(new Font("century", 0, 10));
		panel.add(titleBotonTemp);
		
		// boton aceptar para convertir
		botonAceptarTemp = new JButton();
		botonAceptarTemp.setBounds(385, 130, 90, 20);
		botonAceptarTemp.setVisible(false);
		botonAceptarTemp.setText("Aceptar");
		panel.add(botonAceptarTemp);
		
		//lista desplegable temperatura
		String[] grados = { "Celsius a Farenheit", "Celsius a Kelvin", "Celsius a Reaumur", "Farenheit a Celsius", "Kelvin a Celsius", "Reaumur a Celsius"};
		JComboBox listaDeOpciones2 = new JComboBox(grados);
		listaDeOpciones2.setBounds(340, 160, 180, 20);
		listaDeOpciones2.setVisible(false);
		panel.add(listaDeOpciones2);
		
		// Evento seleccionar conversor de temperatura
		ActionListener conversorTemp = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				valorDeConversion.setVisible(true);
				botonAceptarTemp.setVisible(true);				
				listaDeOpciones2.setVisible(true);
				titleMontoIngresar.setText("Valor de temperatura que deseas convertir");
				titleMontoIngresar.setForeground(Color.black);
				intro.setVisible(false);
				botonMoneda.setEnabled(false);
				// creacion de fondo de pantalla para conversor
				JLabel conversorTemperatura = new JLabel(new ImageIcon("Temperatura.jpg"));
				 conversorTemperatura.setBounds(184, 10, 490, 340);
				 panel.add(conversorTemperatura);

			}
		};
		botonTemp.addActionListener(conversorTemp);
		
		// evento boton aceptar para convertir
		ActionListener accionbtnconvertir2 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// se agrega error por caja de t exto vacia
				try {
					if (listaDeOpciones2.getSelectedItem().toString() == "Celsius a Farenheit") {
						JOptionPane.showMessageDialog(null,"La cantidad que obtendrás es:  "+ String.format("%.2f", Double.parseDouble(valorDeConversion.getText())*9/5+32)+" °F");
					} else if (listaDeOpciones2.getSelectedItem().toString() == "Celsius a Kelvin") {
						JOptionPane.showMessageDialog(null,"La cantidad que obtendrás es:  "+ String.format("%.2f", Double.parseDouble(valorDeConversion.getText())+273.15)+ " K");
					} else if (listaDeOpciones2.getSelectedItem().toString() == "Celsius a Reaumur") {
						JOptionPane.showMessageDialog(null,"La cantidad que obtendrás es:  "+ String.format("%.2f", Double.parseDouble(valorDeConversion.getText())*4/5)+ " Re");
					} else if (listaDeOpciones2.getSelectedItem().toString() == "Farenheit a Celsius") {
						double faren = Double.parseDouble(valorDeConversion.getText());
						faren = faren -32;
						faren = faren *5/9;
						JOptionPane.showMessageDialog(null, "La cantidad que obtendrás es:  "+ String.format("%.2f",faren)+ " °C");
					} else if (listaDeOpciones2.getSelectedItem().toString() == "Kelvin a Celsius") {
						JOptionPane.showMessageDialog(null,"La cantidad que obtendrás es:  "+ String.format("%.2f", Double.parseDouble(valorDeConversion.getText()) * 3.82)+ " °C");
					} else if (listaDeOpciones2.getSelectedItem().toString() == "Reaumur a Celsius") {
						JOptionPane.showMessageDialog(null,"La cantidad que obtendrás es:  "+ String.format("%.2f", Double.parseDouble(valorDeConversion.getText()) * 4.03)+ " °C");
					} 
					int select = JOptionPane.showConfirmDialog(null, "¿Desea realizar otra operación?",
							"Selecciona una opción...", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
					switch (select) {
					case 0:
						valorDeConversion.setText("");
						break;
					case 1:
						JOptionPane.showMessageDialog(null, "Gracias por utilizar el programa, hasta la próxima");
						dispose();
						break;
					case 2:
						JOptionPane.showMessageDialog(null, "Gracias por utilizar el programa, hasta la próxima");
						dispose();
						break;
					default:
						JOptionPane.showMessageDialog(null, "El programa se cerro por no elegir una opción");
						dispose();
						break;
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Ingrese un valor para convertir");

				}

			}
		};
		botonAceptarTemp.addActionListener(accionbtnconvertir2);
	}
	
}
