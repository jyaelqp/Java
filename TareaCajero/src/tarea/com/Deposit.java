package tarea.com;

import java.util.Date;
public class Deposit extends FunctionPrincipal{
    //@Override //se hereda el método para sobreescribir su constructor y generar una  nueva lógica
    public void Transactions() {
        int flag = 0, optionInput, flag2 = 0, numCelphone;
        do{
            System.out.println("-----------------------------------------------");
            System.out.println("Eliga la trasacción que desee ");
            System.out.println("  1: Cuenta a cheques");
            System.out.println("  2: Depósito a tarjeta de crédito");
            System.out.println("-----------------------------------------------");
            //Withdrawal();
            optionInput = input.nextInt();
            if(optionInput == 1){
                do{
                    System.out.print("Ingrese la cantidad a depositar: ");
                    Deposit();
                    if(deposit%50 == 0 && deposit>0){
                        transactions = getBalance();
                        setBalance(transactions + deposit);
                        System.out.println("Depositaste: $" + deposit);
                        System.out.println("Tu saldo es: $" + getBalance());
                        System.out.println("-----------------------------------------------");
                        setMovements(deposit,"Depósito",new Date());
                        flag2 =1;
                        flag = 1;
                    } else {
                        System.out.println("Solo se pueden retirar múltiplos de 50 mayores a 0");
                        System.out.println("-----------------------------------------------");
                    }
                } while (flag2==0);
            }else if(optionInput == 2){
                System.out.print("ingrese la referencia asociada a la tarjeta (8 dígitos): ");
                numCelphone = input.nextInt();
                do {
                    System.out.print("ingrese la cantidad a transferir: ");
                    Deposit();
                    if(deposit > 0){
                        flag2=1;
                    } else{
                        System.out.println("Solo se pueden retirar múltiplos de 50 mayores a 0");
                    }
                } while (flag2==0);
                transactions = getBalance();
                setBalance(transactions - deposit);
                System.out.println("Depositaste: $" + deposit +" a tu tarjeta asociada al número: " + numCelphone);
                System.out.println("Tu saldo es: $" + getBalance());
                System.out.println("-----------------------------------------------");
                setMovements(deposit,"Depósito a TC",new Date());
                flag = 1;
            } else{
                System.out.println("Ingrese una opción correcta");
            }
        } while (flag == 0);
    }
}
	


