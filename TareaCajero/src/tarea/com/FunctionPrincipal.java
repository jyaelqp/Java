package tarea.com;

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;

public abstract class FunctionPrincipal {
  // Declaracíon de variables
  protected double transactions, withdrawal, deposit;
  private static double balance;
  Scanner input = new Scanner(System.in);
  private static final LinkedHashMap<Integer, ListObj> linkedHashMap = new LinkedHashMap<>();
  static int id = 0;
  public int flagExit = 0;

  // esta clase alberga un objeto para su uso dentro LinkedHashMap
  public static class ListObj {
    private final double movement;
    private final String name;
    private final String date;

    public ListObj(double movement, String name, String date) {
      this.movement = movement;
      this.name = name;
      this.date = date;
    }

    public double getMovement() {
      return movement;
    }

    public String getName() {
      return name;
    }

    public String getDate() {
      return date;
    }
  }

  // este método tiene la interacción del menu de inicio
  public void operations() {
    int flag = 0;
    int selection;
    do {
      do {
        System.out.println("Seleccione una opción:");
        System.out.println("    1. Retirar dinero.");
        System.out.println("    2. Depósito de efectivo.");
        System.out.println("    3. Consultar saldo");
        System.out.println("    4. Quejas.");
        System.out.println("    5. Ver últimos movimientos");
        System.out.println("    9. Salir del cajero.");
        selection = input.nextInt();
        if ((selection >= 1 && selection <= 5) || selection == 9) {
          flag = 1;
          flagExit = 0;
        }flagExit++;
        if (flagExit >= 3) {
            System.out.println("-----------------------------------------------");
            System.out.println("Se alcanzó el límite de intentos, hasta luego.");
            System.out.println("-----------------------------------------------");
            flag = 2;
        } else {
            System.out.println("-----------------------------------------------");
            System.out.println("Opción no disponible, intente de nuevo");
            System.out.println("-----------------------------------------------");
        

         
        }
      } while (flag == 0);
      // este método ejecuta las opcion introducida por el usuario, llamando a otras
      // classes
      switch (selection) {
        case 1:
          FunctionPrincipal messageW = new Withdrawal();
          messageW.Transactions();
          break;
        case 2:
        FunctionPrincipal messageD = new Deposit();
          messageD.Transactions();
          break;
        case 3:
        FunctionPrincipal messageC = new ConsultFunction();
          messageC.Transactions();
          break;
        case 4:
          System.out.println("-----------------------------------------------");
          System.out.println("No disponible por el momento, intente más tarde");
          System.out.println("-----------------------------------------------");
          break;
        case 5:
        FunctionPrincipal messageM = new Movements();
          messageM.Transactions();
          break;
        case 9:
          System.out.println("--------------------------------------");
          System.out.println("Gracias, vuelva pronto");
          System.out.println("--------------------------------------");
          flag = 2;
          break;
      }
    } while (flag != 2);
  }

  // estos son los métodos setter y getter para el uso de variables encapsuladas
  public void setMovements(double movements, String name, Date date) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    String formattedDate = dateFormat.format(date);
    ListObj data = new ListObj(movements, name, formattedDate);
    linkedHashMap.put(++id, data);
  }

  public LinkedHashMap<Integer, ListObj> getFinalList() {
    return linkedHashMap;
  }

  public void Withdrawal() {
    withdrawal = input.nextDouble();
  }

  public void Donations() {
    balance = balance - 200;
  }

  public void Deposit() {
    deposit = input.nextDouble();
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
	FunctionPrincipal.balance = balance;
  }

  // al final se crea un método sin constructor para heredarla cuando sea
  // necesario
  // la razón de esto, es separar el menu general de la lógica contenida en cada
  // opción
  public abstract void Transactions();

}
