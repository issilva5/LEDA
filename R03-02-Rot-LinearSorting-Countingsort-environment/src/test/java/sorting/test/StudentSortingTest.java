package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
//import sorting.linearSorting.CountingSort;
import sorting.linearSorting.ExtendedCountingSort;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 0, 4, 1, 5, 0, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {

		this.implementation = new ExtendedCountingSort();

	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	public void genericTestPartial(Integer[] array, int leftIndex, int rigthIndex) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array, leftIndex, rigthIndex);

		if (leftIndex >=0 && rigthIndex < array.length && rigthIndex >= leftIndex) Arrays.sort(copy1, leftIndex, rigthIndex+1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	@Test
	public void testSort06() {
		genericTest(new Integer[]{30, 25, 20, 15, 10, 5, 1});
	}

	@Test
	public void testSort07() {
		genericTestPartial(new Integer[]{30, 25, 20, 15, 10, 5, 1}, 2, 6);
	}

	@Test
	public void testSort08() {
		genericTestPartial(new Integer[]{30, 25, 20, 15, 10, 5, 1}, 0, 6);
	}

	@Test
	public void testSort09() {
		genericTestPartial(new Integer[]{5, 9, 3, 15, 27, 98, 1, 6}, 3, 5);
	}

	@Test
	public void testSort10() {
		genericTestPartial(new Integer[]{5, 9, 3, 15, 27, 98, 1, 6}, 0, 7);
	}

	@Test
	public void testSort11() {
		//Out of bounds
		genericTestPartial(new Integer[]{5, 9, 3, 15, 27, 98, 1, 6}, -1, 7);
		genericTestPartial(new Integer[]{5, 9, 3, 15, 27, 98, 1, 6}, 0, 8);
		genericTestPartial(new Integer[]{5, 9, 3, 15, 27, 98, 1, 6}, -1, 8);
		genericTestPartial(new Integer[]{5, 9, 3, 15, 27, 98, 1, 6}, 6, 4);
		genericTestPartial(new Integer[]{5, 9, 3, 15, 27, 98, 1, 6}, 7, 0);
	}

	@Test
	public void testSort12() {
		genericTest(new Integer[] {3, 6, 3, 5, 4, 2, 3, 1, 1, 3});
	}

	@Test
	public void testSort13() {
		genericTest(new Integer[] {3});
	}

	@Test
	public void testSort14() {
		genericTest(new Integer[]{30, -25, 20, 15, -10, 5, 1});
	}

	@Test
	public void testSort15() {
		genericTestPartial(new Integer[]{30, -25, -20, -15, 10, -5, 1}, 2, 6);
	}

	@Test
	public void testSort16() {
		genericTestPartial(new Integer[]{-30, 0, -20, -15, 0, 5, -1}, 0, 6);
	}

	@Test
	public void testSort17() {
		genericTestPartial(new Integer[]{5, 9, 3, 15, -27, 98, 1, 6}, 3, 5);
	}

	@Test
	public void testSort18() {
		genericTestPartial(new Integer[]{5, -9, -3, 15, 27, -98, 1, 6}, 0, 7);
	}

	@Test
	public void testSort19() {
		genericTest(new Integer[] {-3, 6, 3, -5, -4, 2, 3, -1, -1, 3});
	}

	@Test
	public void testSort20() {
		genericTest(new Integer[] {0});
	}

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */
}