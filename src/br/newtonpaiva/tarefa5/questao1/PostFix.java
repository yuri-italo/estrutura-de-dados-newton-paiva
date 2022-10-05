package br.newtonpaiva.tarefa5.questao1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostFix {
    public String infixParaPostFix(String expressao) {
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

    public double calcularExpressao(String expressaoPostFix) {
        List<String> elementosSeparados = List.of(expressaoPostFix.split(" "));
        Stack<String> operandos = new Stack<>();

        for (var elemento : elementosSeparados) {
            if (ehNumerico(elemento))
                operandos.push(elemento);
            else {
                double operando2 = Double.parseDouble(operandos.pop());
                double operando1 = Double.parseDouble(operandos.pop());

                double resultado = calcular(elemento, operando1, operando2);
                operandos.push(String.valueOf(resultado));
            }
        }

        return Double.parseDouble(operandos.pop());
    }

    private double calcular(String elemento, double operando1, double operando2) {
        double resultado;

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

    private boolean ehNumerico(String elemento) {
        return "0123456789".contains(elemento);
    }

    private boolean ehParentese(String elemento) {
        return elemento.equals("(") || elemento.equals(")");
    }

    private boolean operadorEmpilhadoTemPrecedenciaMaiorOuIgual(String elemento, String operadorEmpilhado) {
        int pesoElemento = getPrecedencia(elemento);
        int pesoOperadorEmpilhado = getPrecedencia(operadorEmpilhado);

        return pesoOperadorEmpilhado > pesoElemento || pesoOperadorEmpilhado == pesoElemento;
    }

    private int getPrecedencia(String operador) {
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

    private boolean ehOperador(String elemento) {
        return
                elemento.equals("+") ||
                        elemento.equals("-") ||
                        elemento.equals("^") ||
                        elemento.equals("*") ||
                        elemento.equals("/");
    }
}
