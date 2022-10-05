package br.newtonpaiva.tarefa5.questao1;

/*
    Notação Polonesa
*/

public class Questao1 {
    public static void main(String[] args) {
        PostFix postFix = new PostFix();
        String expressao = "6 + 7 / 2 + 2";

        String expressaoConvertida = postFix.infixParaPostFix(expressao);
        double resultado = postFix.calcularExpressao(expressaoConvertida);
        System.out.println(resultado);
    }
}
