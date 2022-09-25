package entidades;

public class Determinante {

    public static int laplace(int[][] matriz) {
        //parte-se do pressuposto que a matriz seja válida
        int determinante = 0;//valor do determinante que vai ser retornado
        if (matriz.length == 1) {
            //calcula o determinante de matriz de ordem um
            determinante = matriz[0][0];
        } else if (matriz.length == 2) {
            //calcula o determinante de matriz de ordem dois
            determinante = matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
        } else if (matriz.length == 3) {
            //calcula o determinante de matriz de ordem três usando regra de Sarrus
            determinante = matriz[0][0] * matriz[1][1] * matriz[2][2]
                    + matriz[0][1] * matriz[1][2] * matriz[2][0]
                    + matriz[0][2] * matriz[1][0] * matriz[2][1]
                    - matriz[0][2] * matriz[1][1] * matriz[2][0]
                    - matriz[0][0] * matriz[1][2] * matriz[2][1]
                    - matriz[0][1] * matriz[1][0] * matriz[2][2];
        } else {
            
            int[][] aux;
            int i_aux, j_aux, linha, coluna, i;

                for (i = 0; i < matriz.length; i++) {
                if (matriz[0][i] != 0) {
                    aux = new int[matriz.length - 1][matriz.length - 1];
                    i_aux = 0;
                    j_aux = 0;
                    
                    for (linha = 1; linha < matriz.length; linha++) {
                        for (coluna = 0; coluna < matriz.length; coluna++) {
                           
                            if (coluna != i) {
                                aux[i_aux][j_aux] = matriz[linha][coluna];
                                j_aux++;
                            }
                        }
                       
                        i_aux++;
                        j_aux = 0;
                    }
                   
                    determinante += Math.pow(-1, i) * matriz[0][i] * laplace(aux);
                }

            }
        }
        return determinante;
    }
}