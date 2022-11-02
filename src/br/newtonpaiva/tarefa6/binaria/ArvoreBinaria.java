package br.newtonpaiva.tarefa6.binaria;
//baseado em https://gist.github.com/divanibarbosa/819e7cfcf1b9bae48c4e0f5bd74fb658
//baseado em https://gist.github.com/tahaphuong/025f5e0c165fbc3500a20baca03c7b80

import java.util.Scanner;

public class ArvoreBinaria {

	 public static void main(String[] args) {
		    Scanner le = new Scanner(System.in);
			BinarySearchTree<Integer> treeVisualization = new BinarySearchTree<>();
		    Tree arv = new Tree();
		    int opcao;
		    long x;
		    System.out.print("\n Programa Arvore binaria de long");
		    do {
		        System.out.print("\n***********************************");
		        System.out.print("\nEntre com a opcao:");
			System.out.print("\n ----1: Inserir");
			System.out.print("\n ----2: Excluir");
			System.out.print("\n ----3: Pesquisar");
			System.out.print("\n ----4: Exibir");
			System.out.print("\n ----5: Desenhar árvore");
			System.out.print("\n ----6: Sair do programa");
			System.out.print("\n***********************************");
			System.out.print("\n-> ");
			opcao = le.nextInt();
			switch(opcao) {
			 	case 1: {
				       System.out.print("\n Informe o valor (int) -> ");
				       x = le.nextLong();
				       arv.inserir(x);
					   treeVisualization.add((int) x);
				       break;
				}
				case 2: {
				       System.out.print("\n Informe o valor (int) -> ");
				       x = le.nextLong();
				       if ( !arv.remover(x) )
		                          System.out.print("\n Valor nao encontrado!");;
				       break;
				}
				case 3: {
				       System.out.print("\n Informe o valor (int) -> ");
		                       x = le.nextLong();
			      	       if( arv.buscar(x) != null )
				          System.out.print("\n Valor Encontrado");
				       else 
				          System.out.print("\n Valor nao encontrado!");
				       break;
				}	 
				case 4: {
				      arv.caminhar();
				      break; 
				}
				case 5: {
					DrawBinaryTreeDiagram.startDrawing(treeVisualization);
					break;
				}
		        } // fim switch
		    } while(opcao != 6);

		  }
		}
