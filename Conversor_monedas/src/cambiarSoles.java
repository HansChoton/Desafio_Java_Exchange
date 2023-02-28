

public class cambiarSoles {
	
	double valorIngresado;	
	
	public cambiarSoles(double valorIngresado,String divisa) {
		if (divisa == "Dolar") {
			double x = 3.82;
			System.out.println(valorIngresado/x+" Dolar");
		}else if(divisa == "Euro") {
			double x = 4.03;
			System.out.println(valorIngresado/x+" Euro");
		}else if(divisa == "Libras Esterlinas") {
			double x = 4.56;
			System.out.println(valorIngresado/x+" Libras Esterlinas");
		}else if(divisa == "Yen") {
			double x = 0.03;
			System.out.println(valorIngresado/x+" Yen");
		}else if(divisa == "Won Coreano") {
			double x = 0.00291;
			System.out.println(valorIngresado/x + " Won Coreano");
		}
	}

}
