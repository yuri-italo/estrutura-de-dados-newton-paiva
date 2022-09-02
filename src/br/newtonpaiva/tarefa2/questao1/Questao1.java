package br.newtonpaiva.tarefa2.questao1;
/*
    Uma agência bancária necessita organizar a fila para atendimento do
    Auxílio Brasil. Cada usuário receberá uma senha numérica, serão
    atendidas 200 pessoas por dia.
    Percebeu-se que as pessoas que possuem senha impar até o número
    100 são consideradas prioridade, por isso, devem ficar em outra fila
    separada.

    Fazer um programa usando lista que gere a entrada de dados de 200
    pessoas, separe as pessoas com a senha impar até o número 100,
    criando a lista de prioridades. Ao final deverão ser impressos a lista de
    prioridade e a lista ordenada das pessoas que estão na fila comum.
*/
public class Questao1 {
    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();
        ListaLigada listaPrioritaria = new ListaLigada();

        for (int i = 1; i <= 200 ; i++) {
            lista.inserirFinal(i);
            if (ehMenorQue100EImpar(i)) {
                listaPrioritaria.inserirFinal(i);
                lista.remover(i);
            }
        }
        System.out.println("Lista:");
        lista.mostrarLista();
        System.out.println("------------------------------");
        System.out.println("Lista prioritária:");
        listaPrioritaria.mostrarLista();
    }

    private static boolean ehMenorQue100EImpar(int i) {
        return i <= 100 && i % 2 != 0;
    }
}
