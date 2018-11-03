package main;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class QuickSort {

	public static int comparacoes = 0;
	public static int trocas = 0;

	// Impressao Array Ordenado
	static void printArray(ArrayList<Character> array) {
		int tamanho = array.size();
		for (int i = 0; i < tamanho; ++i)
			System.out.print(array.get(i) + " ");
		System.out.println();
		JOptionPane.showMessageDialog(null, "numero de comparacoes: " + comparacoes + "\n numero de trocas: " + trocas);
	}


	// Particionamento
	int particao(ArrayList<Character> array, int low, int hi) {

		char pivo = array.get(hi);
		System.out.println("pivo: " + pivo);
		int i = (low - 1);
		for (int j = low; j < hi; j++) {

			// comparacao princial
			comparacoes++;
			if (array.get(j) <= pivo) {
				trocas++;
				i++;
				// troca per se
				char aux = array.get(i);
				array.set(i, array.get(j));
				array.set(j, aux);

			}
		}

		char aux = array.get(i + 1);
		array.set(i + 1, array.get(hi));
		array.set(hi, aux);
		return i + 1;

	}
	
	
    // Particionamento pivor fixo(low)
	int particaoFixo(ArrayList<Character> array, int low, int hi) {

		// System.out.println("pivo: " + pivo);
		int pivo = low;
		int i = low;
		System.out.println("pivo: " + array.get(pivo));
		
		for (int j = low + 1; j <= hi; j++) {

			// comparacao princial
			comparacoes++;
			if (array.get(j) <= array.get(pivo)) {
				trocas++;
				i++;
				// troca per se
				char aux = array.get(i);
				array.set(i, array.get(j));
				array.set(j, aux);

			}
		}

		char aux = array.get(i);
		array.set(i, array.get(low));
		array.set(low, aux);
		return i;

	}

	//Particionamento vetor aleatorio.
	int particaoAleatoria(ArrayList<Character> array, int low, int hi) {

		Random r = new Random();
		int pivo = r.nextInt(hi - low) + low;

		// int pivo = low + ((int)Math.random()*(array.size()))/(hi-low+1);

		Character aux = array.get(hi);
		array.set(hi, array.get(pivo));
		array.set(pivo, aux);

		return particao(array, low, hi);

	}

	// QuickSort
	public void sort(ArrayList<Character> array, int low, int hi, String tipo) {

		// tamanho, retorna se for maior
		if (low < hi) {

			if (tipo == "aleatorio") {

				int particao = particaoAleatoria(array, low, hi);

				// recursividade
				sort(array, low, particao - 1, "aleatorio");
				sort(array, particao + 1, hi, "aleatorio");

			} else if (tipo == "fixo") {

				int particao = particaoFixo(array, low, hi);

				// recursividade
				sort(array, low, particao - 1, "fixo");
				sort(array, particao + 1, hi, "fixo");

			} else {
				return;
			}

		}

	}

	// main method
	public static void main(String[] args) {
		
		// GABRIELTORESKDUZPMN

		String nomes = "GABRIELTOSKDUZPMN";
		ArrayList<Character> array = new ArrayList<Character>();
		for (char c : nomes.toCharArray()) {
			array.add(c);
		}

		int tamanho = array.size();

		String[] choices = { "Aleatorio", "Fixo" };
		String input = (String) JOptionPane.showInputDialog(null, "Tipo de Pivor:", "Pivor",
				JOptionPane.QUESTION_MESSAGE, null, choices, choices[1]);

		if (input == "Aleatorio") {

			QuickSort qs = new QuickSort();
			qs.sort(array, 0, tamanho - 1, "aleatorio");
			printArray(array);

		} else if (input == "Fixo") {

			QuickSort qs = new QuickSort();
			qs.sort(array, 0, tamanho - 1, "fixo");
			printArray(array);

		} else {
			return;
		}

	}

}
