package Arrays;
import java.util.Scanner;
public class matrix {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] matrix = 	{{1,2,3},
							 {4,5,6},
							 {7,8,9}};
		//int[][] matrix = new int[3][3];
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j< 3; j++) {
			System.out.println("Enter an element");
			matrix[i][j] = scanner.nextInt();
			}
		}
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j< 3; j++) {
			System.out.print(matrix[i][j]+" ");
			}
		System.out.println();
		}
	scanner.close();
	}
}
