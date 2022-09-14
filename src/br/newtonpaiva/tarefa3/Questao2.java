package br.newtonpaiva.tarefa3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*
    Implemente uma estrutura de fila que corresponde a entrada de
    pessoas em um show de rock.

    • O programa deverá receber um arquivo de ingressos vendidos e
    colocá-los na fila.
    • Os 10 primeiros ingressos vendidos serão exibidos na tela para
    entrada VIP.
    • O programa também sorteará aleatoriamente uma posição da Fila
    para exibir o ingresso com a descrição "Pessoa de Sorteada para
    conhecer a banda"
 */
public class Questao2 {
    public static void main(String[] args) throws FileNotFoundException {
        Queue<String> ingressos = new LinkedList<>();
        Random random = new Random();
        Scanner scanner;

        scanner = new Scanner(new File("./ingressos.txt"));
        while (scanner.hasNextLine())
            ingressos.add(scanner.nextLine());

        if (!ingressos.isEmpty()) {
            for (int i = 0; i < 10; i++)
                System.out.println(ingressos.poll() + " - VIP");

            List<String> ingressosRestantes = new ArrayList<>(ingressos);
            System.out.println(
                    ingressosRestantes.get(random.nextInt(ingressosRestantes.size() - 1))
                            + " - Pessoa sorteada para conhecer a banda"
            );
        } else
            System.out.println("Não foram vendidos ingressos.");
    }
}
