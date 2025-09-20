import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int n;
        String nombre;
        
        System.out.print("Ingresar nombre de consecionaria:");
        nombre = teclado.nextLine();
        
        System.out.print("Ingresar cant. de autos");
        n = teclado.nextInt();
        teclado.nextLine();
        
        
        Consecionaria c = new Consecionaria(nombre);

        for(int i = 1; i<=n; i++){
            String color, patente;
            System.out.println("Auto N: "+i);
            System.out.print("* Ing. patente: ");        
            patente = teclado.nextLine();
            
            System.out.print("* Ing. color: ");        
            color = teclado.nextLine();
            c.agregarAuto(new Auto(patente, color));
        }
       
        System.out.println("================== =================");
        for(Auto a: c.getAutos()){
            System.out.println(a);
        }
       
    }

}
