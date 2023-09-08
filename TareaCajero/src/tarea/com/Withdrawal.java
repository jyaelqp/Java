package tarea.com;

import java.util.Date;
public class Withdrawal extends FunctionPrincipal{

    //@Override //se hereda el método para sobreescribir su constructor y generar una  nueva lógica
    public void Transactions() {
    	int flag = 0, flag2 = 0, donationsInput;
        do{
            System.out.println("-----------------------------------------------");
            System.out.print("¿Cuánto desea retirar? ");
            Withdrawal();
            if(withdrawal%50 == 0 && withdrawal>0){
                if(withdrawal >= 6_000){
                    System.out.println();
                    System.out.println("No se pueden hacer retiros  iguales");
                    System.out.println("o mayores a $6000");
                } else if(withdrawal < getBalance() ){
                    transactions = getBalance();
                    setBalance(transactions-withdrawal);
                    System.out.println("Retiraste: $" + withdrawal);
                    System.out.println("Tu saldo actual es: $" + getBalance());
                    System.out.println("-----------------------------------------------");
                    setMovements(withdrawal,"Retiro",new Date());
                    do {
                        System.out.println("¿Desea donar $200 para la graduacón");
                        System.out.println("de la Cohorte de ch30?");
                        System.out.println("  1: Si");
                        System.out.println("  2: No");
                        System.out.println("-----------------------------------------------");
                        setMovements(200,"Donación",new Date());
                        donationsInput = input.nextInt();
                        if(donationsInput == 1){
                            System.out.println("¡Gracias por donar!");
                            Donations();
                            System.out.println("Tu saldo actual es: $" + getBalance());
                            System.out.println("-----------------------------------------------");
                            flag2 = 1;
                        } else if (donationsInput == 2) {
                            System.out.println("Esperamos que la próxima puedas ayudar >:(");
                            System.out.println("-----------------------------------------------");
                            flag2 = 1;
                        } else {
                            System.out.println("Opción no válida");
                            System.out.println("-----------------------------------------------");
                        }
                    } while (flag2 == 0);
                    flag =1;
                } else  {
                    System.out.println("-----------------------------------------------");
                    System.out.println("Saldo insuficiente");
                }
            }else{
                System.out.println("Solo se pueden retirar múltiplos de 50 mayores a 0");
            }
        } while(flag == 0);
    }
}