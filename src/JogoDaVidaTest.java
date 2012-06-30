import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;


public class JogoDaVidaTest extends TestCase {
	
	public void testRecuperaEstadoInicialDe0x0() {
		JogoDaVida jogo = new JogoDaVida(1, 1);
		assertFalse(jogo.getEstado(0, 0));
	}
	
	public void testRecuperaEstadoDe0x0DepoisDeAvivar() {
		JogoDaVida jogo = new JogoDaVida(1, 1);
		jogo.avivar(0, 0);
		assertTrue(jogo.getEstado(0,0));
	}
	
	public void testRecuperaEstadoDe0x0DepoisDeMatar(){
		JogoDaVida jogo = new JogoDaVida(1, 1);
		jogo.avivar(0, 0);
		jogo.matar(0, 0);
		assertFalse(jogo.getEstado(0, 0));
	}
	
	public void testLancaExcecaoAoRetornarCelulaForaDoTabuleiro(){
		JogoDaVida jogo = new JogoDaVida(1, 1);
		try {
			jogo.getEstado(1, 1);
			fail("exceção não lançada");
		} catch (Exception ex) {
			assertTrue(true);
		}
	}
	
	public void testGetEnderecoVizinho1paraCentroDe3x3() {
		JogoDaVida jogo = new JogoDaVida(3, 3);
		List <Integer> vizinho  = jogo.getEnderecoVizinho1(1, 1);
		List <Integer> esperado = new ArrayList<Integer>();
		esperado.add(0);
		esperado.add(0);
		assertEquals(esperado, vizinho);
	}
	
	public void testGetEnderecoVizinho1paraCentroDe0x0() {
		JogoDaVida jogo = new JogoDaVida(3, 3);
		List <Integer> vizinho  = jogo.getEnderecoVizinho1(0, 0);
		assertEquals(null, vizinho);
	}
	
	public void testGetEnderecoVizinho2paraCentroDe3x3() {
		JogoDaVida jogo = new JogoDaVida(3, 3);
		List <Integer> vizinho  = jogo.getEnderecoVizinho2(1, 1);
		List <Integer> esperado = new ArrayList<Integer>();
		esperado.add(0);
		esperado.add(1);
		assertEquals(esperado, vizinho);
	}
	
	public void testGetEnderecoVizinho2paraCentroDe0x0() {
		JogoDaVida jogo = new JogoDaVida(3, 3);
		List <Integer> vizinho  = jogo.getEnderecoVizinho2(0, 0);
		assertEquals(null, vizinho);
	}
	
	public void testGetEnderecoVizinho3paraCentroDe3x3() {
		JogoDaVida jogo = new JogoDaVida(3, 3);
		List <Integer> vizinho  = jogo.getEnderecoVizinho3(1, 1);
		List <Integer> esperado = new ArrayList<Integer>();
		esperado.add(0);
		esperado.add(2);
		assertEquals(esperado, vizinho);
	}	
	public void testGetEnderecoVizinho4paraCentroDe3x3() {
		JogoDaVida jogo = new JogoDaVida(3, 3);
		List <Integer> vizinho  = jogo.getEnderecoVizinho4(1, 1);
		List <Integer> esperado = new ArrayList<Integer>();
		esperado.add(1);
		esperado.add(0);
		assertEquals(esperado, vizinho);
	}	
	public void testGetEnderecoVizinho5paraCentroDe3x3() {
		JogoDaVida jogo = new JogoDaVida(3, 3);
		List <Integer> vizinho  = jogo.getEnderecoVizinho5(1, 1);
		List <Integer> esperado = new ArrayList<Integer>();
		esperado.add(1);
		esperado.add(2);
		assertEquals(esperado, vizinho);
	}	
	public void testGetEnderecoVizinho6paraCentroDe3x3() {
		JogoDaVida jogo = new JogoDaVida(3, 3);
		List <Integer> vizinho  = jogo.getEnderecoVizinho6(1, 1);
		List <Integer> esperado = new ArrayList<Integer>();
		esperado.add(2);
		esperado.add(0);
		assertEquals(esperado, vizinho);
	}		
	public void testGetEnderecoVizinho7paraCentroDe3x3() {
		JogoDaVida jogo = new JogoDaVida(3, 3);
		List <Integer> vizinho  = jogo.getEnderecoVizinho7(1, 1);
		List <Integer> esperado = new ArrayList<Integer>();
		esperado.add(2);
		esperado.add(1);
		assertEquals(esperado, vizinho);
	}		
	public void testGetEnderecoVizinho8paraCentroDe3x3() {
		JogoDaVida jogo = new JogoDaVida(3, 3);
		List <Integer> vizinho  = jogo.getEnderecoVizinho8(1, 1);
		List <Integer> esperado = new ArrayList<Integer>();
		esperado.add(2);
		esperado.add(2);
		assertEquals(esperado, vizinho);
	}		
	
	public void testGetVizinhosVivosDeveSer0ComTabuleiroVazio(){
		JogoDaVida jogo = new JogoDaVida(3, 3);
		assertEquals(0, jogo.vizinhosVivos(0,0));
	}
	
	public void testVizinhosVivosDeveConta1VizinhoVivo(){
		JogoDaVida jogo = new JogoDaVida(3, 3);
		jogo.avivar(0,1);
		assertEquals(1, jogo.vizinhosVivos(0,0));
	}
	
	public void testVizinhosVivosDeveConta8VizinhoVivo(){
		JogoDaVida jogo = new JogoDaVida(3, 3);
		jogo.avivar(0,0);
		jogo.avivar(0,1);
		jogo.avivar(0,2);
		jogo.avivar(1,0);
		jogo.avivar(1,1);
		jogo.avivar(1,2);
		jogo.avivar(2,0);
		jogo.avivar(2,1);
		jogo.avivar(2,2);
		assertEquals(8, jogo.vizinhosVivos(1,1));
	}
	
	
	
	public void testCelula1x3DeveNascerNaGeracao1(){
		JogoDaVida jogo = new JogoDaVida(4, 8);
		jogo.avivar(1,4);
		jogo.avivar(2,3);
		jogo.avivar(2,4);
		jogo.proximaGeracao();
		assertTrue(jogo.getEstado(1,3));
	}
	
	
	public void testCelula2x4DeveMorrerNaGeracao1(){
		JogoDaVida jogo = new JogoDaVida(4, 8);
		jogo.avivar(2,4);
		jogo.proximaGeracao();
		assertFalse(jogo.getEstado(2, 4));
		
	}
	
}
