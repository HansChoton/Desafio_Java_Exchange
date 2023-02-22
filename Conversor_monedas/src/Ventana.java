import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
//Es necesario heredar de Jframe debido a que es la interfaz para generar frame(ventana)
public class Ventana extends JFrame {

	public Ventana() {
		setSize(800, 600);//Se establece el ancho y el alto del frame
		setLocationRelativeTo(null);//Centrando el frame
		setMinimumSize(new Dimension (800,600));//establecer tamaño minimo
		setTitle("Conversor de Divisas");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		iniciarPanel();
	}
	
	private void iniciarPanel() {
		JPanel panel = new JPanel(); //Creacion de un panel
		this.getContentPane().add(panel);//obtener contenido de la ventana y le agregamos el panel
		panel.setBackground(Color.cyan);
		
	}
}
