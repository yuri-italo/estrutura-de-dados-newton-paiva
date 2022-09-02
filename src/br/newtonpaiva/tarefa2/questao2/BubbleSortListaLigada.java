package br.newtonpaiva.tarefa2.questao2;

public class BubbleSortListaLigada {
    public void sort(ListaLigada lista) {
        for (int i = 0; i < lista.getTamanho(); i++)
            for (int j = 0; j < lista.getTamanho() -1; j++)
                if (lista.get(j).getValor().compareTo(lista.get(j+1).getValor()) > 0)
                    swap(lista, j);
    }

    private static void swap(ListaLigada lista, int j) {
        var aux = lista.get(j).getValor();
        lista.get(j).setValor(lista.get(j +1).getValor());
        lista.get(j + 1).setValor(aux);
    }
}
