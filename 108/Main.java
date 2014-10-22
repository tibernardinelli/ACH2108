//package br.com.problema108;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Main
{
    public static void main (String args[])
    {
    	int m[][];
    	Scanner scan = null;


		try {
    	if (args.length > 0){
    		scan = new Scanner(new File(args[0]));
    	
    	} else {			
	    	scan = new Scanner (System.in);
	    }

    	int n = scan.nextInt();
    	m = new int[n][n];
    	int i = 0;
    	int j = 0;
    	while (scan.hasNext()){	
    	  	m[i][j] = scan.nextInt();
    	  	j = (j + 1) % n;
    	  	if (j==0) i++;
    	  	if (i==n) break;
    	}

	  	executarN3(m,n);
	  } catch (FileNotFoundException e)
	  {
	  	System.out.println("FileNotFoundException");
	  }
    }      
    
    static void executarN6(int m[][], int n){
    	//ElemVetor [] aux = new ElemVetor[n*n];    	
    	int max = 0;
    	int soma = 0;
    	//exibeMatriz(m, n);
    	//System.out.println();    	
    	for (int i = 0; i < n; i++)
    		for (int j = 0; j < n; j++){
    			for (int k = 0; k < n; k++)
    				for (int l = 0; l< n; l++){
    					soma = calculaSubMatriz(m, k, l, i, j);
    					if (soma > max)
    						max = soma;
    					//System.out.println("[" + i+ "]" + "[" + j + "]  a [" + k+ "]" + "[" + l + "] = " + soma);
    				}    			
    		}    		
    	//System.out.println();
    	System.out.println(max);
    }
    
    static void executarN4(int m[][], int n){
    	int [][] aux = calculaMatrizAuxiliar(m, n,n, 0, 0);
    	//exibeMatriz(m, n);    	
    	//exibeMatriz(aux, n);
    	
    	int max = 0;
    	int soma = 0;
    	
    	for (int i1 = 0; i1 < n; i1++)
    		for (int j1 = 0; j1 < n; j1++){
    			for (int i2 = i1; i2 < aux.length; i2++) {
					for (int j2 = j1; j2 < aux.length; j2++) {			
						soma = 0;
						soma = aux[i2][j2] -     	
				    	((i1-1 >= 0) ? aux[i1-1][j2] : 0) -     		    	
				    	((j1-1 >= 0) ? aux[i2][j1-1] : 0) +
				    	((j1-1 >= 0 && i1 - 1 >= 0) ? aux[i1-1][j1-1] : 0);
						
						//System.out.println("[" + i1+ "]" + "[" + j1 + "]  a [" + i2+ "]" + "[" + j2 + "] = " + soma);
						if (soma>max) max = soma;
					}
				}		
    		}
    	System.out.println(max);
    }

    static void executarN3(int m[][], int n){ 
    	exibeMatriz(m, n);
    	int global = 0;
    	for (int i = 0; i < n; i++){
    		for (int j = i; j < n; j++){
    			int maxLinha = 0;
    			for (int k = 0; k < n; k++){
    				int resultadoColuna = calculaSubMatriz(m, j, k, i, k);
    				if (resultadoColuna > 0) {
    					maxLinha += resultadoColuna;
    					if (maxLinha > global)
    						global = maxLinha;
    				}
    				else 
    					maxLinha = 0;    				
    				//System.out.println("		i " + i + " j " + j + " k " + k + " resultadoColuna " + resultadoColuna);
    			}
    			//System.out.println("	maxLinha " + maxLinha);
    		}
    	}
    	
    			//System.out.println("global " + global);
    	System.out.println(global);
    }
    
    static void exibeMatriz (int m[][], int n) {
    	for (int i=0;i<n;i++){
    		for (int j=0;j<n;j++){
    			System.out.print(m[i][j] + " ");
    		}
    		System.out.println();
    	}
    }
    
    static int calculaSubMatriz(int[][] m, int x2, int y2, int x1, int y1){
    	int soma = 0;
    	for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				soma += m[i][j];
			}
		}
    	return soma;
    }
    
    static int[][] calculaMatrizAuxiliar(int[][] m, int x2, int y2, int x1 , int y1){
    	int soma = 0;
    	int aux = 0;
    	int aux2 = 0;
    	int aux3 = 0;
    	int[][] retorno = new int[m.length][m.length];
    	
    	for (int i = x1; i < x2; i++) {
			for (int j = y1; j < y2; j++) {
				if (i != 0) 
					aux = retorno[i-1][j];
				if (j != 0)
					aux2 = retorno[i][j-1];
				if (i != 0 && j != 0)
					aux3 = retorno[i-1][j-1];
				soma = m[i][j] + aux + aux2 - aux3;
				retorno[i][j] = soma;
			}
			soma = 0;
			aux  = 0;
			aux2 = 0;
			aux3 = 0;
		}
    	return retorno;
    }    
}
