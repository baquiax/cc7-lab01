package edu.galileo.baquiax.perfectnumber;
import java.util.LinkedList;

public class PerfectNumberSearch extends Thread {
    private static int uids;
    private int uid;     
    private int n;
    
    public PerfectNumberSearch(int n) {
        this.uid = ++PerfectNumberSearch.uids;
        this.n = n;
    }   
    
    @Override
    public void run() {
        this.log("I'm running, I'm searching for " + this.n + " perfect numbers");
        int numbersFound = 0;
        int counter = 0;        
        while(numbersFound < this.n) {
            if (this.sumDivisors(counter) == counter) {
                this.log("El numero " + counter + " ES perfecto!");
                numbersFound++;
            } else {
                this.log("El numero " + counter + " NO es perfecto!");
            }
            counter++;
        }
        this.log("I'm stopping");      
    }
    
    public int getUID() {
        return this.uid;
    }
    
    private void log(String s) {
        System.out.println("Thread #" + this.uid + " > " + s);       
    }

    private void log(int n) {
        System.out.println("Thread #" + this.uid + " > " + n);
    }
    
    private int sumDivisors(int n) {
        int sum = (n != 0) ? 0 : -1;
        for (int i = 1; i < n; i++) {
            if (n % i == 0 ) {
                sum += i;
            }
        }
        return sum;
    }
}