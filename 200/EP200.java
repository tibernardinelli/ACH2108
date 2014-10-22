//200
import java.util.ArrayList;
import java.util.Scanner;

class No{
	char valor;
	No prox;

	No(char valor, No prox){
		this.valor = valor;
		this.prox = prox;
	}

	No(char valor){
		this.valor = valor;
		this.prox = null;
	}

	public No get(char c) {
		No atual = this;
		while(atual!=null){
			if(atual.valor==c){
				return atual;
			}else atual = atual.prox;
		}
		return null;
	}
}

public class EP200 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			ArrayList<String> palavras = new ArrayList<String>();
		
			int index = 0;
			while(true){
				palavras.add(sc.nextLine());
				if(!Character.isUpperCase(palavras.get(index).charAt(0))) {
					palavras.remove(index);
					break;
				}
				else index++;
			}
			char[][] matriz = new char[index][1];
			for(int i = 0;i<index;i++){
				matriz[i] = palavras.get(i).toCharArray();
			}
			//inicializa a lista com as primeiras letras das palavras
			No ordem = new No(matriz[0][0]);
			No ultimo = ordem;
			for(int i = 1;i<matriz.length;i++){
				if(ultimo.valor!=matriz[i][0]){
					ultimo.prox = new No(matriz[i][0]);
					ultimo = ultimo.prox;
				}
			}
			//busca prefixos iguais para comparar
			for(int i = 0;i<matriz.length-1;i++){
				//achando os prefixos iguais, adiciona eles na lista ligada
				if(matriz[i][0]==matriz[i+1][0]){
					int j = 1;
					while(j<matriz[i].length && j<matriz[i+1].length){
						if(matriz[i][j]!=matriz[i+1][j]){
							organizaNos(ordem, matriz[i][j],matriz[i+1][j]);
							break;
						}
						j++;
					}
				}
			}
			No atual = ordem;
			while(atual!=null){
				System.out.print(atual.valor);
				atual = atual.prox;
			}System.out.println();
		}
	}

	public static void organizaNos(No ordem, char c1, char c2){
		No aux = ordem.get(c1);
		No aux2 = ordem.get(c2);
		//se o primeiro estiver na lista e o segundo não
		if(aux!=null && aux2==null){
			aux2 = new No(c2);
			aux2.prox = aux.prox;
			aux.prox = aux2;
		}//se nenhum estiver na lista (talvez dê errado)
		else if(aux==null && aux2==null){
			aux2 = new No(c2);
			aux = new No(c1,aux2);
			No ultimo = ordem;
			while(ultimo !=null){
				ultimo = ultimo.prox;
			}
			ultimo.prox = aux;
		}
	}
}

/*
ENTRADA
 
XWY
ZX
ZXY
ZXW
YWWX
#
*/