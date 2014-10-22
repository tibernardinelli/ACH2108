import java.io.IOException;
import java.util.StringTokenizer;

public class Main {


	static int[][] planos;
	static int[][] planetas;

	public static void main(String[] args){
		int numPlanos;
		int numPlanetas;
		int v[];
		while ((v = ReadLn(255,2)) != null){
			numPlanos = v[0];
			numPlanetas =  v[1];
			planos = new int[numPlanos][4];
			planetas = new int[numPlanetas][3];
			for (int i=0;i<numPlanos;i++){
				planos[i] = ReadLn(255,4);
			}
			for (int i=0;i<numPlanetas;i++){
				planetas[i] = ReadLn(255,3);
			}
			executar(numPlanos,numPlanetas);
		}
	}


	private static void executar(int numPlanos, int numPlanetas) 	{

		//TODO completar
		
	}
		


	static int[] ReadLn (int maxLg,int quantidadeDeNumeros) {
		byte lin[] = new byte [maxLg];
		int lg = 0, car = -1;
		try
		{
			while (lg < maxLg)
			{
				car = System.in.read();
				if ((car < 0) || (car == '\n')) break;
				lin [lg++] += car;
			}
		}
		catch (IOException e)

		{
			return (null);
		}

		if ((car < 0) && (lg == 0)) return (null);  // eof
		String temp = new String (lin, 0, lg);
		int res[] = new int[quantidadeDeNumeros];
		StringTokenizer idata;
		idata = new StringTokenizer (temp);
		for (int i=0;i<quantidadeDeNumeros;i++){
			res[i] = Integer.parseInt (idata.nextToken());
		}
		return res;
	}

}

/*

Exemplo de Entrada
2 5
1 0 0 1
2 0 0 8
0 1 0
2 2 2
3 3 3
5 5 5
2 18 4
4 8
0 0 1 1
1 0 1 2
-1 1 1 3
-1 -1 1 3
0 0 5
0 0 4
0 0 -2
1 0 5
40 19 104
13 26 84
89 -45 18
3 1 0

Exemplo de Saida
3
5
 */