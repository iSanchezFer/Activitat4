package Metodes3_IkerSanchez;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author iker
 *
 */
public class Metodes3_2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		getInfo(in);
		in.close();
	}
	/**
	 * Filtrem els numeros per a que ens donin el rang que nosaltres volem
	 * i els posem a dintre d'un arraylist. Després els ordenarem amb un collection.sort
	 * @param in: Scanner definit al main. 
	 */
	public static void getInfo(Scanner in) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		System.out.print("Escriu números per a ordenar-los: ");
		int number;
		boolean correctnum = true;
		do {
			System.out.print("Entra un número entre el 10 i el -10: ");

			if (in.hasNextInt()) {
				number = in.nextInt();
				if (number > -10 && number < 10) {
					if (number == 0) {
						correctnum = false;
					} else {
						array.add(number);
					}

				} else {
					System.out.println("Entrada invàlida");
				}

			} else {
				System.out.println("Entrada invàlida");
				in.next();
			}

		} while (correctnum);
		System.out.println("Has entrat els següents números: " + array);
		Collections.sort(array);
		System.out.println("Els números ordenats són: " + array);
		numberType(array);
	}
	/**
	 * Dividirem els numeros agafats d'un arraylist d'una funció prèvia
	 * segons siguin parells o senars. Als senars li donarem la volta amb 
	 * un collections.reverse per a ordenar-los correctament
	 * @param array : arraylist fet al metode getInfo amb numeros entrats segons un rang 
	 */
	public static void numberType(ArrayList<Integer> array) {
		ArrayList<Integer> positive = new ArrayList<Integer>();
		ArrayList<Integer> negative = new ArrayList<Integer>();
		for (int i : array) {
			if (i > 0) {
				positive.add(i);
			} else if (i < 0) {
				negative.add(i);
			}
		}
		System.out.println("Els números positius són: " + positive);
		asterisk(positive);
		Collections.reverse(negative);
		System.out.println("Els números negatius són: " + negative);
		asterisk(negative);
	}
	/**
	 * Agafarem un arraylist de numeros i printarem tants asteriscs com digui cada nombre.
	 * @param array : Son els arrayslist amb els números dividits per positius i negatius
	 */
	public static void asterisk(ArrayList<Integer> array) {
		for (int k : array) {
			if (k>0) {
				System.out.print(" "+k + ": ");
			}else {
				System.out.print(k + ": ");
				k = Math.abs(k);
			}
			for (int l = 0; l < k; l++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
