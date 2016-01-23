import edu.galileo.baquiax.perfectnumber.PerfectNumberSearch;
import edu.galileo.baquiax.perfectnumber.PerfectNumberSearchR;
import java.util.Scanner;
public class LabOne {
    public static void main(String args[]) {
        System.out.println("Galileo University, [CC7-2016]");
        System.out.println("LAB01 - Perfect Numbers\n");    
        Scanner s = new Scanner(System.in);
        int firstN = 0;
        int secondN = 0;
        
        System.out.println("-- Se procederan a crear dos hilos, usted debe indicar que cantidad de numeros perfectos se deben hallar.\n");                    

        while (firstN < 1){
            System.out.println("Para el Thread 1, Cuantos numeros perfectos desea calcular?");
            try {
                firstN = s.nextInt();
            } catch (Exception e) {
                System.out.println("Valor invalido.\n");
                s = new Scanner(System.in);            
            }
        }
        
        while (secondN < 1){
            System.out.println("Para el Thread 2, Cuantos numeros perfectos desea calcular?");            
            try {
                secondN = s.nextInt();
            } catch (Exception e) {
                System.out.println("Valor invalido.\n");
                s = new Scanner(System.in);            
            }
        }
        
        if (args.length > 0 && args[0].equals("--with-runnable")) {
            //Extra work, but...
            System.out.println("-- Usando interfaz Runnable --");
            Thread r1 = new Thread(new PerfectNumberSearchR(firstN));
            Thread r2 = new Thread(new PerfectNumberSearchR(secondN));
            r1.start();
            r2.start();        
        } else {
            PerfectNumberSearch t1 = new PerfectNumberSearch(firstN);
            PerfectNumberSearch t2 = new PerfectNumberSearch(secondN);
            t1.start();
            t2.start();                    
        }
    }
}