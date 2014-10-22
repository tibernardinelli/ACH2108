import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	static int n;
	static int tabuleiro[][];
        
        
        
	public static void main (String[] args){
		Scanner scan = new Scanner (System.in);
		n = scan.nextInt();
		char[] caracteres;
		while (n != 0 && scan.hasNext()){
			tabuleiro = new int[n][n];
			for (int i=0;i<n;i++){
				caracteres = scan.next().toCharArray();
				for (int j=0;j<n;j++){
					if (caracteres[j] == 'X') tabuleiro[i][j] = 1;
				}
			}
			executar();
			if (scan.hasNextInt()) n = scan.nextInt();
		}
	}
        
        static int max = 0;
        static int x;
        static int y;
        
        
        static int qtdTorres    = 0;
        static int tempTorres   = 0;
        
	private static void executar() {
            rec(0, 0);
            System.out.println(qtdTorres);
            qtdTorres   = 0;
            tempTorres  = 0;
	}
        

        static void rec(int i, int j){
            
            if(j == n) {
                i = i+1;
                j = 0;
            }
            
            if(i == n){
                return;
            }
            
            if(tabuleiro[i][j]==1){
                rec(i, j+1);
            }
            else {
                
                if(podeColocar(i, j)){

                    tabuleiro[i][j] = 2;
                    tempTorres++;
                    
                    if(tempTorres>qtdTorres) qtdTorres = tempTorres;
                    
                    rec(i, j+1);
                    
                    tabuleiro[i][j] = 0;
                    tempTorres--;
                      
                }
                
                rec(i, j+1);
                
            }
            
        }
        
        private static boolean podeColocar(int i, int j) {

            for(int l = i;l>=0;l--) {
                if(tabuleiro[l][j]==2) return false;
                if(tabuleiro[l][j]==1) break;
            }
            for(int c = j;c>=0;c--) {
                if(tabuleiro[i][c]==2) return false;
                if(tabuleiro[i][c]==1) break;
            }

            return true;
        
        }
        
        /*
        private static int rec(int i, int j, int colocados, char direcao){
            
            if(i >= n || j >= n) return colocados;
            
            if (tabuleiro[j][i] == 1){
                int linha   = rec   (i+1, j     , colocados, 'i');
                int coluna  = rec   (i  , j+1   , colocados, 'j');
                return Math.max(Math.max(linha, coluna), colocados);
            } 
            else{
                if (podecolocar(i, j)){
                    
                    int linha;
                    int coluna;
                    
                    tabuleiro[j][i] = 2;
                    colocados ++;
                    
                    linha   = rec(i+1, j, colocados, 'i');
                    coluna  = rec(i, j+1, colocados, 'j');
                    
                    int maxColocadosTrue = Math.max(linha, coluna);
                    
                    tabuleiro[j][i] = 0;
                    colocados--;

                    linha   = rec(i+1, j, colocados, 'i');
                    coluna  = rec(i, j+1, colocados, 'j');
                    
                    int maxColocadosFalse = Math.max(linha, coluna);
                    
                    if(maxColocadosFalse>maxColocadosTrue) return maxColocadosFalse;
                    
                    tabuleiro[j][i] = 2;
                    return maxColocadosTrue;
                    
                }
                else {
                    
                    int linha;
                    int coluna;
                    
                    linha = rec(i+1, j, colocados, 'i');
                    coluna  = rec(i, j+1, colocados, 'j');

                    return Math.max(Math.max(linha, coluna), colocados);
                    
                }
            }
        }
        
        /*
        
        private static int rec(int i, int j, int colocados, boolean podecolocar, char direcao){
            
            if(i >= n || j >= n) return colocados;
            
            if (tabuleiro[j][i] == 1){
                int linha   = rec   (i+1, j     , colocados, true, 'i');
                int coluna  = rec   (i  , j+1   , colocados, true, 'j');
                return Math.max(Math.max(linha, coluna), colocados);
            } 
            else{
                if (podecolocar){
                    
                    int linha;
                    int coluna;
                    
                    colocados ++;
                    
                            if(direcao=='i')    linha = rec(i+1, j, colocados, false, 'i');
                    else    if(direcao=='j')    linha = rec(i+1, j, colocados, true , 'i');
                    else                        linha = rec(i+1, j, colocados, false , 'i');
                    
                            if(direcao=='j')    coluna  = rec(i, j+1, colocados, false  , 'j');
                    else    if(direcao=='i')    coluna  = rec(i, j+1, colocados, true   , 'j'); 
                    else                        coluna  = rec(i, j+1, colocados, false  , 'j'); 
                          
                    int maxColocadosTrue = Math.max(linha, coluna);
                    maxColocadosTrue = Math.max(colocados, maxColocadosTrue);
                    
                    colocados--;

                    linha   = rec(i+1, j, colocados, true, 'i');
                    coluna  = rec(i, j+1, colocados, true, 'j');
                    
                    int maxColocadosFalse = Math.max(linha, coluna);
                    maxColocadosFalse = Math.max(colocados, maxColocadosFalse);
                    
                    if(maxColocadosFalse>maxColocadosTrue) return maxColocadosFalse;
                    
                    return maxColocadosTrue;
                    
                }
                else {
                    
                    int linha;
                    int coluna;
                    
                            if(direcao=='i')    linha = rec(i+1, j, colocados, false, 'i');
                    else    if(direcao=='j')    linha = rec(i+1, j, colocados, true , 'i');
                    else                        linha = rec(i+1, j, colocados, true , 'i');
                    
                            if(direcao=='j')    coluna  = rec(i, j+1, colocados, false  , 'j');
                    else    if(direcao=='i')    coluna  = rec(i, j+1, colocados, true   , 'j'); 
                    else                        coluna  = rec(i, j+1, colocados, true   , 'j'); 

                    return Math.max(Math.max(linha, coluna), colocados);
                    
                }
            }
        }

        
        

    
        
        */
        
}
