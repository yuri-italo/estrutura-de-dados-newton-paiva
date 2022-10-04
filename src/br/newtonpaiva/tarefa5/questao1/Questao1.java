package br.newtonpaiva.tarefa5.questao1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Questao1 {
    public static void main(String[] args) {
        //String expressao = " A / B + D * E - A";
        //String expressao = "( A + B ) * C / ( E - F )";
        //String expressao = "x ^ y / ( 5 * z ) + 10";
        String expressao = "5 + 7 * 2";

        String expressaoConvertida = infixParaPostFix(expressao);
        int resultado = calcularExpressao(expressaoConvertida);
        System.out.println(resultado);
    }

    public static int calcularExpressao(String expressaoPostFix) {
        List<String> elementosSeparados = List.of(expressaoPostFix.split(" "));
        Stack<String> operandos = new Stack<>();

        for (var elemento : elementosSeparados) {
            if (ehNumerico(elemento))
                operandos.push(elemento);
            else {
                int operando2 = Integer.parseInt(operandos.pop());
                int operando1 = Integer.parseInt(operandos.pop());

                int resultado = calcular(elemento, operando1, operando2);
                operandos.push(String.valueOf(resultado));
            }
        }

        return Integer.parseInt(operandos.pop());
    }

    private static int calcular(String elemento, int operando1, int operando2) {
        int resultado;

        switch (elemento) {
            case "^":
                resultado = (int) Math.pow(operando1,operando2);
                break;

            case "*":
                resultado = operando1 * operando2;
                break;

            case "/":
                resultado = operando1 / operando2;
                break;

            case "+":
                resultado = operando1 + operando2;
                break;

            case "-":
                resultado = operando1 - operando2;
                break;

            default:
                throw new RuntimeException("Operador inválido!");
        }

        return resultado;
    }

    private static boolean ehNumerico(String elemento) {
        return "0123456789".contains(elemento);
    }

    public static String infixParaPostFix(String expressao) {
        List<String> elementosSeparados = List.of(expressao.split(" "));
        List<String> listaPostFix = new ArrayList<>();
        Stack<String> operadores = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (var elemento : elementosSeparados) {
            if (ehParentese(elemento)) {
                if (elemento.equals("("))
                    operadores.push(elemento);
                else {
                    while (!operadores.peek().equals("(")) {
                        listaPostFix.add(operadores.pop());
                    }
                    operadores.pop();
                }
            } else if (ehOperador(elemento)) {
                if (operadores.isEmpty()) {
                    operadores.push(elemento);
                } else {
                    if (operadorEmpilhadoTemPrecedenciaMaiorOuIgual(elemento, operadores.peek())) {
                        while (!operadores.isEmpty()) {
                            if (ehParentese(operadores.peek()))
                                break;

                            listaPostFix.add(operadores.pop());
                        }
                        operadores.add(elemento);
                    } else {
                        operadores.add(elemento);
                    }
                }
            } else {
                listaPostFix.add(elemento);
            }
        }

        while (!operadores.isEmpty()) {
            listaPostFix.add(operadores.pop());
        }

        for (var elemento : listaPostFix)
            sb.append(elemento).append(" ");

        return sb.toString();
    }

    private static boolean ehParentese(String elemento) {
        return elemento.equals("(") || elemento.equals(")");
    }

    private static boolean operadorEmpilhadoTemPrecedenciaMaiorOuIgual(String elemento, String operadorEmpilhado) {
        int pesoElemento = getPrecedencia(elemento);
        int pesoOperadorEmpilhado = getPrecedencia(operadorEmpilhado);

        return pesoOperadorEmpilhado > pesoElemento || pesoOperadorEmpilhado == pesoElemento;
    }

    private static int getPrecedencia(String operador) {
        int precedenciaElemento;

        switch (operador) {
            case "^":
                precedenciaElemento = 3;
            break;

            case "*": case "/":
                precedenciaElemento = 2;
            break;

            case "+": case "-":
                precedenciaElemento = 1;
            break;

            default:
                precedenciaElemento = 0;
            break;
        }
        return precedenciaElemento;
    }

    private static boolean ehOperador(String elemento) {
        return
                elemento.equals("+") ||
                elemento.equals("-") ||
                elemento.equals("^") ||
                elemento.equals("*") ||
                elemento.equals("/");
    }
}
