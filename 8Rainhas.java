public class Main {
	



	boolean[] diagonalEsquerda=new boolean[30];
	boolean[] diagonalDireita=new boolean[30];
	boolean[] coluna=new boolean[30];
	//funcition pra printar



	void print(int board[][]){
	    for(int i=0;i<8;i++){
	        for(int j=0;j<8;j++){
	            System.out.print(board[i][j]+" ");
	        }
	       System.out.print("\n");
	    }
	    //System.out.println();
	    System.out.print("-----------------\n");
	}



	//Function pra ver se a posição é valida ou n 
	boolean valido(int board[][],int lin,int col){
	     if(diagonalEsquerda[lin-col+7]==false&&diagonalDireita[lin+col]==false&&coluna[lin]==false)
	    return true;
	    return false;
	}



	    
	    //function para todas as soluções
	    void Solucao(int board[][],int currentColumn){
	     if(currentColumn>=8)
	    return;
	    //loop para cobrir colunas
	    for(int i=0;i<8;i++){
	        if(valido(board,i,currentColumn)){
	            board[i][currentColumn]=1;
	            diagonalEsquerda[i-currentColumn+7]=diagonalDireita[i+currentColumn]=coluna[i]=true;
	            if(currentColumn==7){
	                print(board);
	                //break;
	                
	            }
	            //Chamada recurciva
	            Solucao(board,currentColumn+1);
	            //backtracking
	            board[i][currentColumn]=0;
	            diagonalEsquerda[i-currentColumn+7]=diagonalDireita[i+currentColumn]=coluna[i]=false;
	        }
	   
	    }
	}



	    void solve(){
	    //Tabuleiro inicial
	    int tabuleiro[][]={{0,0,0,0,0,0,0,0},
	                    {0,0,0,0,0,0,0,0},
	                    {0,0,0,0,0,0,0,0},
	                    {0,0,0,0,0,0,0,0},
	                    {0,0,0,0,0,0,0,0},
	                    {0,0,0,0,0,0,0,0},
	                    {0,0,0,0,0,0,0,0},
	                    {0,0,0,0,0,0,0,0}};
	    Solucao(tabuleiro,0);
	    
	    return;
	    }
	    public static void main(String[] args) {
	        Main solution=new Main();
	        solution.solve();
	    }
}
