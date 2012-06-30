import java.util.ArrayList;
import java.util.List;


public class JogoDaVida {

	private boolean [][] tabuleiro;
	
	public JogoDaVida(int lines, int cols) {
		tabuleiro = new boolean[lines][cols];
	}
	
	public boolean getEstado(int x, int y) {
		return this.tabuleiro[x][y];
	}
	
	public void avivar(int x, int y){
		this.tabuleiro[x][y] = true;
	}
	
	public void matar (int x, int y){
		this.tabuleiro[x][y] = false;
	}
	
	public void proximaGeracao(){
		this.avivar(1, 3);
	}
	
	
	
	public int vizinhosVivos(int x, int y){
		
		int vizinhosVivos = 0;
		List<Integer> enderecoVizinho;
		
		enderecoVizinho = this.getEnderecoVizinho1(x, y);
		if(enderecoVizinho!=null && this.getEstado(enderecoVizinho)){
			vizinhosVivos++;
		}
		enderecoVizinho = this.getEnderecoVizinho2(x, y);
		if(enderecoVizinho!=null && this.getEstado(enderecoVizinho)){
			vizinhosVivos++;
		}
		enderecoVizinho = this.getEnderecoVizinho3(x, y);
		if(enderecoVizinho!=null && this.getEstado(enderecoVizinho)){
			vizinhosVivos++;
		}
		enderecoVizinho = this.getEnderecoVizinho4(x, y);
		if(enderecoVizinho!=null && this.getEstado(enderecoVizinho)){
			vizinhosVivos++;
		}
		enderecoVizinho = this.getEnderecoVizinho5(x, y);
		if(enderecoVizinho!=null && this.getEstado(enderecoVizinho)){
			vizinhosVivos++;
		}
		enderecoVizinho = this.getEnderecoVizinho6(x, y);
		if(enderecoVizinho!=null && this.getEstado(enderecoVizinho)){
			vizinhosVivos++;
		}
		enderecoVizinho = this.getEnderecoVizinho7(x, y);
		if(enderecoVizinho!=null && this.getEstado(enderecoVizinho)){
			vizinhosVivos++;
		}
		enderecoVizinho = this.getEnderecoVizinho8(x, y);
		if(enderecoVizinho!=null && this.getEstado(enderecoVizinho)){
			vizinhosVivos++;
		}
		
		return vizinhosVivos;
	}
	
	private boolean getEstado(List <Integer> coordenada){
		
		return this.getEstado(coordenada.get(0), coordenada.get(1));
	}
	

	public List<Integer> getEnderecoVizinho1(int x, int y) {
		return getEnderecoVizinhoN(x, y, -1, -1);
	}
	
	public List<Integer> getEnderecoVizinho2(int x, int y) {
		return getEnderecoVizinhoN(x, y, -1, 0);
	}
	
	private List<Integer> getEnderecoVizinhoN(int x, int y, int deltaX, int deltaY) {
	
		List<Integer> vizinho= null;
		
		
			
		if(this.existiPosicao(x+deltaX, y+deltaY)) {
			vizinho= new ArrayList<Integer>();
			vizinho.add(x+deltaX);
			vizinho.add(y+deltaY);
		}
		
		return vizinho; 
		
	
	}
    private boolean existiPosicao(int x, int y){
    	boolean existePosicao;
    	
    	try{
    		boolean posicao = this.tabuleiro[x][y];
    		
			existePosicao = true; 
			
			
		}catch(Exception e){existePosicao= false;}
    	
    	return existePosicao;
    }
    
	public List<Integer> getEnderecoVizinho3(int x, int y) {
		return getEnderecoVizinhoN(x, y, -1, 1);
	}

	public List<Integer> getEnderecoVizinho4(int x, int y) {
		return getEnderecoVizinhoN(x, y, 0, -1);
	}

	public List<Integer> getEnderecoVizinho5(int x, int y) {
		return getEnderecoVizinhoN(x, y, 0, 1);
	}

	public List<Integer> getEnderecoVizinho6(int x, int y) {
		return getEnderecoVizinhoN(x, y, 1, -1);
	}

	public List<Integer> getEnderecoVizinho7(int x, int y) {
		return getEnderecoVizinhoN(x, y, 1, 0);
	}

	public List<Integer> getEnderecoVizinho8(int x, int y) {
		return getEnderecoVizinhoN(x, y, 1, 1);
	}
	
	
}
    
