package arrays;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class OneDArray {

	public static boolean canWin(int leap, int[] game) {
		boolean directionFwd = true;
		/*
		 * for (int j = 0; j < game.length; j++){ System.out.print(game[j] + " "); }
		 * System.out.println("leap = "+leap);
		 */
		for (int i = 0; i < game.length; i++) {
			// System.out.println("At Position "+i+" value ="+game[i]);
			if (game[i] != 0)
				return false;
			if (i + 1 < game.length) {
				// System.out.println("Next position "+(i+1)+" exists, value ="+game[i]);
				if (game[i + 1] == 0 && directionFwd) {
					// System.out.println("Next position is 0 and game is fwd");
					// System.out.println("> MOVE FWD");
					i += 1 - 1;// -1 because at next iter it will i++
				} else {
					// System.out.println("Next position is 0"+(game[i+1]==0) +", direction is "+
					// (directionFwd?"fwd":"back"));
					if (i + leap < game.length) {
						// System.out.println("Leap to position "+(i+leap)+" exists");
						if (game[i + leap] == 0) {
							// System.out.println("Leap position value is ="+game[i+leap]);
							i += leap - 1; // -1 because at next iter it will++
							// System.out.println(">> LEAP");
						} else {
							// System.out.println("Leap position is not 0, value is ="+game[i+leap]);
							if (i - 1 >= 0) {
								// System.out.println("Back position exists");
								if (game[i - 1] == 0) {
									// System.out.println("Back position is 0");
									// System.out.println("< MOVE BACK");
									directionFwd = false;
									i -= 2;
								} else {
									// System.out.println("Back position is not 0");
									return false;
								}
							} else {
								// System.out.println("Back position does not exist");
								return false;
							}
						}
					} else {
						// System.out.println("Leap to position "+leap+" does not exist");
						// System.out.println("CAN WIN");
						return true;
					}
				}

			} else {
				// System.out.println("Next position does not exist");
				// System.out.println("CAN WIN");
				return true;
			}
		}
		// System.out.println("---------------------------------------");
		return false;
	}

	/*
	 * public static boolean canWin(int leap, int[] game) { int nonZeroSeqLength =
	 * 0; for (int i = game.length-1; i >=0; i--){ if (game[i] != 0){
	 * nonZeroSeqLength++; if(nonZeroSeqLength >= leap){ return false; } } else {
	 * nonZeroSeqLength = 0; } } return true; }
	 */

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	
		int q = scan.nextInt();
		while (q-- > 0 ) {
			int n = scan.nextInt();
			int leap = scan.nextInt();

			int[] game = new int[n];
			for (int i = 0; i < n; i++) {
				game[i] = scan.nextInt();
			}
			System.out.println((canWin(leap, game)) ? "YES" : "NO");
/*
			ExecutorService executor = Executors.newSingleThreadExecutor();
	        Future<?> future = executor.submit(() -> System.out.println((canWin(leap, game)) ? "YES" : "NO"));

	        try {
	            future.get(5, TimeUnit.SECONDS); // Set the timeout value in seconds
	        } catch (InterruptedException | ExecutionException | TimeoutException e) {
	            // Handle the timeout exception
	            System.out.println("Method execution took too long and was interrupted.");
	        } finally {
	            executor.shutdownNow(); // Stop the executor service
	        }
			*/
			
			
		}
		
		scan.close();
	}
}