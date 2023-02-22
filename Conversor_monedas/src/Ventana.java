import javax.swing.JFrame;
//Es necesario heredar de Jframe debido a que es la interfaz para generar ventanas
public class Ventana extends JFrame {

	public Ventana() {
		setSize(800, 600);//Se establece el ancho y el alto de la ventana
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Conversor de Divisas");
	}
}
