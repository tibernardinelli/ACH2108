import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main (String[] args){
		Scanner scan = new Scanner (System.in);
		int n;
		int caixas;
		int volume;
		if (scan.hasNextInt()){
			n = scan.nextInt();
			for (int i=0;i<n;i++){
				caixas = scan.nextInt();
				volume = scan.nextInt();
				executar(caixas, volume);
			}
		}
	}

	private static void executar(int caixas, int volume) {
            System.out.println(recursivo(caixas, volume, 0));
		// TODO 
		
	}
        
        private static HashMap<String, Integer> hm = new HashMap<String, Integer>();

    private static int recursivo(int caixas, int volume, int inicio) {
        String key = caixas + "_" + volume + "_" + inicio;
        if (hm.containsKey(key))
            return hm.get(key);
        
        if (volume < inicio)
            return 0;
        if (caixas == 1 )
            return (inicio + volume) * (volume - inicio + 1) / 2;
        if (inicio == volume)
            return inicio;
        
        int min = Integer.MAX_VALUE;
        
        for (int i = inicio; i < volume; i ++){
            int explodio = recursivo(caixas -1, i-1, inicio);
            int nExplodio = recursivo(caixas, volume, i+1);
            int temp = Math.max(explodio, nExplodio) + i;
            if (temp < min)
                min = temp;
        }
        hm.put(key, min);
        return min;
    }

    private static int pa(int inicio, int fim) {
        return ((fim-inicio) * ((fim - inicio) +1))/2;
    }

}


/*
Sample input
4
1 10
1 100
3 73
5 100

Output for sample input
55
5050
382
495
*/