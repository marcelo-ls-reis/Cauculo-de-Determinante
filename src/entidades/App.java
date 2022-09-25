package entidades;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Entre com o tamanho da matriz: \t");
        int n = scan.nextInt();
        int matriz[][] = new int[n][n];
        System.out.print("Entre com valores\n");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("posição->[" + i + "][" + j + "]");
                matriz[i][j] = scan.nextInt();
            }
        }
        System.out.println("Determinante: \t" + Determinante.laplace(matriz));
        System.out.println(Arrays.deepToString(matriz));
        scan.close();

    }
}
