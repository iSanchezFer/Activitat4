package Metodes3_IkerSanchez;

import java.util.Scanner;

/**
 * 
 * @author iker
 *
 */
public class Metodes3_3 {

	public static void main(String args[]) {

		game();
	}

	/**
	 * Método que ejecuta todos los otros métodos, comprueba si hay un ganador,
	 * tiene el tablero i define la entrada de cada jugador.
	 */
	public static void game() {
		Scanner in = new Scanner(System.in);
		String[][] board = { { " ", " ", " " }, { " ", " ", " " }, { " ", " ", " " } };
		int turns = 0;
		while (true) {
			int[] moves = info(in, board, 1);
			board[moves[0]][moves[1]] = "X";
			turns++;

			printBoard(board);

			if (turns == 9 && !checkWinner(board)) {
				System.out.println("Empate.");
				break;
			}
			if (checkWinner(board)) {
				System.out.println("Jugador1 ganÃ³!");
				break;
			}

			int[] moves2 = info(in, board, 2);
			board[moves2[0]][moves2[1]] = "O";
			turns++;

			printBoard(board);

			if (checkWinner(board)) {
				System.out.println("Jugador2 ganÃ³!");
				break;
			}

		}
		in.close();
	}

	/**
	 * Metodo para filtrar los numeros/movimientos de los dos jugadores
	 * 
	 * @param in:     Scanner
	 * @param board:  Array que representa el tablero del juego
	 * @param player: Jugador que és, para printar X o O segun el turno que sea.
	 * @return Devuelve el número de fila y columna mediante un array.
	 */
	public static int[] info(Scanner in, String[][] board, int player) {
		boolean valid = false;
		int prow = 0, pcolumn = 0;
		do {
			boolean validprow = false;
			do {
				System.out.print("Jugador" + player + ", escribe una fila entre 0 y 2: ");

				if (in.hasNextInt()) {
					prow = in.nextInt();
					if (prow >= 0 && prow <= 2) {
						validprow = true;
					} else {
						System.out.print("Movimiento invÃ¡lido, vuelve a escribir una fila entre 0 y 2: ");
					}
				} else {
					System.out.println("Entrada invÃ lida");
					in.next();
				}

			} while (!validprow);

			boolean validcolumn = false;
			do {
				System.out.print("Jugador" + player + ", escribe una columna entre 0 y 2: ");

				if (in.hasNextInt()) {
					pcolumn = in.nextInt();
					if (pcolumn >= 0 && pcolumn <= 2) {
						validcolumn = true;
					} else {
						System.out.print("Movimiento invÃ¡lido, vuelve a escribir una columna entre 0 y 2: ");
					}
				} else {
					System.out.println("Entrada invÃ lida");
					in.next();
				}

			} while (!validcolumn);

			if (board[prow][pcolumn] != " ") {
				System.out.println("El espacio ya estÃ¡ usado. Entra otro movimiento. ");
			} else {
				valid = true;
			}
		} while (!valid);

		return new int[] { prow, pcolumn };
	}

	/**
	 * Método para printar el tablero de juego del tres en raya
	 * 
	 * @param board: Array que define los datos del "tablero" i los movimientos
	 *               hechos
	 */
	public static void printBoard(String[][] board) {
		System.out.println();
		hyphen();
		System.out.println("| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " |");
		hyphen();
		System.out.println("| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " |");
		hyphen();
		System.out.println("| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " |");
		hyphen();
		System.out.println();
	}

	/**
	 * Método llamado para no repetir la división de lineas del tablero. Mirar
	 * printBoard
	 */
	public static void hyphen() {
		System.out.println("-------------");
	}

	/**
	 * Método para saber si hay un ganador o no. En el caso de que no el metodo game
	 * printara Empate.
	 * 
	 * @param board: Array que define los datos del "tablero" i los movimientos
	 *               hechos
	 * @return True o False si hay un ganador o no. En el caso de que no lo haya
	 *         será empate definido en el método game
	 */
	public static boolean checkWinner(String[][] board) {
		for (int n = 0; n < board.length; n++) {
			if ((board[n][0] == "X" && board[n][1] == "X" && board[n][2] == "X")
					|| (board[n][0] == "O" && board[n][1] == "O" && board[n][2] == "O"))
				return true;
		}
		for (int n = 0; n < board.length; n++) {
			if ((board[0][n] == "X" && board[1][n] == "X" && board[2][n] == "X")
					|| (board[0][n] == "O" && board[1][n] == "O" && board[2][n] == "O"))
				return true;
		}
		if ((board[0][0] == "X" && board[1][1] == "X" && board[2][2] == "X")
				|| (board[0][0] == "O" && board[1][1] == "O" && board[2][2] == "O"))
			return true;
		if ((board[0][2] == "X" && board[1][1] == "X" && board[2][0] == "X")
				|| (board[0][2] == "O" && board[1][1] == "O" && board[2][0] == "O"))
			return true;
		return false;
	}
}
