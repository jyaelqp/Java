package tarea.com;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
public class Movements extends FunctionPrincipal{
    //@Override //se hereda el método para sobreescribir su constructor y generar una  nueva lógica
    public void Transactions() {
        System.out.println("----");
        System.out.println("Lista de movimientos");
        LinkedHashMap<Integer, ListObj> map = getFinalList();
        if (map.isEmpty()) {  //validamos el historial de movimientos
            System.out.println("--No existen movimientos--");
        } else {
            //creamos un ArrayList para verificar el tamaño de su contenido
            List<Map.Entry<Integer, ListObj>> entryList = new ArrayList<>(map.entrySet());
            //se crea un index y un for para mostrar los últimos movimientos, máxomo 5
            int startIndex = Math.max(0, entryList.size() - 5);
            for (int i = startIndex; i < entryList.size(); i++) {
                Map.Entry<Integer, ListObj> entry = entryList.get(i);
                ListObj value = entry.getValue();
                System.out.println(value.getDate() + " " + value.getName() + " de $" + value.getMovement());
            }
        }
        System.out.println("--");
    }
}
