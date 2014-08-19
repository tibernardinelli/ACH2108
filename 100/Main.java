import java.util.Scanner;

public class Main
{
    public static void main (String args[])  // entry point from OS
    {
    	int x1,x2, maior;
    	Scanner scan = new Scanner (System.in);  
    	
    	while (scan.hasNext()){
    		x1 = scan.nextInt();
    	  	x2 = scan.nextInt();
    	  	scan.nextLine();

    	  	maior = (x1<x2)?returnBigger(x1, x2):returnBigger(x2, x1);

    	  	System.out.print(x1 + " ");
    	  	System.out.print(x2 + " ");
    	  	System.out.println(maior);   	  	
		}
	}		

    public static int returnBigger(int x, int y){
	  	int xa=0;
	  	int maior = 0;
    	for (int i = x; i<= y; i++){
  			xa = alg(i);
  			if (maior<xa)
  				maior = xa;
    	}    	
    	return maior;
    }
    
    public static int alg(int n){
    	int x = 1;    	
    	while (n != 1){
    		if (isOdd(n)){
    			n = (3 * n) + 1;
    		} else {
    			n = n/2;
    		}
    		x++;
    	}  	
    	return x;
    }

    public static boolean isOdd(int num){
    	return !(num%2 == 0);
    }
    
}
