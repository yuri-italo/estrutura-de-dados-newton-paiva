package br.newtonpaiva.av1.pergunta1;

public class Pergunta1 {
    public static void main(String[] args) {
        int[] vetor = {3,8,7,9,10,11,80,2,1,50};
        int valor;
        int j;

        for (int i = 0; i < vetor.length; i++) {
            valor = vetor[i];
            j = i - 1;
            while (j >= 0 && valor < vetor[j]) {
                var aux = vetor[j+1];
                vetor[j+1] = vetor[j];
                vetor[j] = aux;
                j = j - 1;

                if (j == -1)
                    break;
            }
        }

        for(Integer t:vetor)
            System.out.printf("%d \t",t);
    }
}
