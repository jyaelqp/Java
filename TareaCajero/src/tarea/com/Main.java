package tarea.com;

public class Main {
    /*  -Se contemplan que los cajeros solo tienen un pad numérico,
         por lo cual no se hicieron validaciones para inputs alfabéticos y/o especiales
    */

	    public static void main(String[] args) {
	        ConsultFunction message = new ConsultFunction(); // Crea una instancia de ConsultFunction
	        message.setBalance(10000); // Establece el saldo inicial
	        message.operations(); // Inicia la interacción
	    }
	}


