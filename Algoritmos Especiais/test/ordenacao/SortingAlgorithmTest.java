package ordenacao;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.Timeout;

import ordenacao.nlogarithmic.DualPivotQuickSort;
import ordenacao.quadratic.SortingAlgorithm;

class SortingAlgorithmTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public SortingAlgorithm<Integer> implementation;
	
	@Rule
    public Timeout globalTimeout = Timeout.seconds(10);
	
	@BeforeEach
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		this.implementation = new DualPivotQuickSort<>();
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
		genericTest(new Integer[]{30, 25, 20, 15, 10, 5, 0});
	}
	
	@Test
	public void testSort07() {
		genericTest(new Integer[]{-8, -12, -4, 2, -6, -17, -6, -1});
	}
	
	@Test
	public void testSort08() {
		genericTest(new Integer[]{-8});
	}
	
	@Test
	public void testSort09() {
		genericTest(new Integer[]{6, -3, 6, 7, 6, -2, 6, 15, 6, 3});
	}
	
	@Test
	public void testSort10() {
		genericTest(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
	}

}

/*
 Bubble -> Ok 0,025
Cocktail -> Ok 0,025
Insertion -> Ok 0,027
Merge -> Ok 0,028
OddEven -> Not implemented
QuickSortHoare -> Not implemented
QuickSortLomuto -> Ok 0,030
RandomizedQuickSort -> Ok 0,024
RecursiveBubble -> Ok 0,032
RecursiveInsertion -> Ok 0,026
RecursiveSelection -> Ok 0,013
ThreeWayQuickSort -> Ok 0,030
*/
