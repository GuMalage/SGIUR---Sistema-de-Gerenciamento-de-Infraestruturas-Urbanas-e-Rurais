#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "Grafo.h"

int main() {
    int op;
    char continuar;

    do {
        printf("Escolha o nivel de dificuldade: ");
        printf(GREEN "\n[1]-Facil" RESET);
        printf(YELLOW "\n[2]-Normal" RESET);
        printf(RED "\n[3]-Dificil" RESET);
        printf("\n---> ");
        scanf("%d", &op);
        setbuf(stdin, NULL);
        printf("\n\n");

        int eh_digrafo, num_vertices = 20, grau_max = 5;
        Grafo* gr = NULL;
        Info* dados = NULL;

        switch (op) {
            case 1:
                eh_digrafo = 1;

                gr = cria_Grafo(num_vertices, grau_max, 1);
                dados = insereNomeVertice();

                insereAresta(gr, 0, 1, eh_digrafo, 0);
                insereAresta(gr, 0, 2, eh_digrafo, 1);
                insereAresta(gr, 1, 3, eh_digrafo, 2);
                insereAresta(gr, 1, 4, eh_digrafo, 0);
                insereAresta(gr, 2, 5, eh_digrafo, 0);
                insereAresta(gr, 3, 6, eh_digrafo, 1);
                insereAresta(gr, 4, 7, eh_digrafo, 0);
                insereAresta(gr, 4, 5, eh_digrafo, 0);
                insereAresta(gr, 5, 8, eh_digrafo, 1);
                insereAresta(gr, 6, 9, eh_digrafo, 0);
                insereAresta(gr, 6, 10, eh_digrafo, 0);
                insereAresta(gr, 7, 10, eh_digrafo, 0);
                insereAresta(gr, 7, 9, eh_digrafo, 0);
                insereAresta(gr, 8, 11, eh_digrafo, 3);
                insereAresta(gr, 9, 12, eh_digrafo, 0);
                insereAresta(gr, 10, 13, eh_digrafo, 2);
                insereAresta(gr, 11, 14, eh_digrafo, 0);
                insereAresta(gr, 12, 15, eh_digrafo, 1);
                insereAresta(gr, 12, 13, eh_digrafo, 0);
                insereAresta(gr, 13, 16, eh_digrafo, 0);
                insereAresta(gr, 14, 17, eh_digrafo, 2);
                insereAresta(gr, 15, 18, eh_digrafo, 0);
                insereAresta(gr, 16, 19, eh_digrafo, 0);
                insereAresta(gr, 17, 19, eh_digrafo, 1);
                insereAresta(gr, 18, 19, eh_digrafo, 0);
                jogar(gr, dados, 0, 30);
                break;

            case 2:
                eh_digrafo = 1;

                gr = cria_Grafo(num_vertices, grau_max, 1);
                dados = insereNomeVertice();

                insereAresta(gr, 0, 1, eh_digrafo, 1);
                insereAresta(gr, 0, 2, eh_digrafo, 2);
                insereAresta(gr, 1, 3, eh_digrafo, 2);
                insereAresta(gr, 1, 4, eh_digrafo, 0);
                insereAresta(gr, 2, 5, eh_digrafo, 0);
                insereAresta(gr, 3, 6, eh_digrafo, 1);
                insereAresta(gr, 4, 7, eh_digrafo, 0);
                insereAresta(gr, 4, 5, eh_digrafo, 0);
                insereAresta(gr, 5, 8, eh_digrafo, 2);
                insereAresta(gr, 6, 9, eh_digrafo, 0);
                insereAresta(gr, 6, 10, eh_digrafo, 1);
                insereAresta(gr, 7, 10, eh_digrafo, 1);
                insereAresta(gr, 7, 9, eh_digrafo, 0);
                insereAresta(gr, 8, 11, eh_digrafo, 4);
                insereAresta(gr, 9, 12, eh_digrafo, 0);
                insereAresta(gr, 10, 13, eh_digrafo, 2);
                insereAresta(gr, 11, 14, eh_digrafo, 0);
                insereAresta(gr, 12, 15, eh_digrafo, 1);
                insereAresta(gr, 12, 13, eh_digrafo, 0);
                insereAresta(gr, 13, 16, eh_digrafo, 0);
                insereAresta(gr, 14, 17, eh_digrafo, 3);
                insereAresta(gr, 15, 18, eh_digrafo, 0);
                insereAresta(gr, 16, 19, eh_digrafo, 1);
                insereAresta(gr, 17, 19, eh_digrafo, 2);
                insereAresta(gr, 18, 19, eh_digrafo, 0);
                jogar(gr, dados, 0, 20);
                break;

            case 3:
                eh_digrafo = 0;

                gr = cria_Grafo(num_vertices, grau_max, 1);
                dados = insereNomeVertice();

                insereAresta(gr, 0, 1, eh_digrafo, 0);
                insereAresta(gr, 0, 2, eh_digrafo, 1);
                insereAresta(gr, 1, 3, eh_digrafo, 2);
                insereAresta(gr, 1, 4, eh_digrafo, 0);
                insereAresta(gr, 2, 5, eh_digrafo, 0);
                insereAresta(gr, 3, 6, eh_digrafo, 1);
                insereAresta(gr, 4, 7, eh_digrafo, 0);
                insereAresta(gr, 4, 5, eh_digrafo, 0);
                insereAresta(gr, 5, 8, eh_digrafo, 1);
                insereAresta(gr, 6, 9, eh_digrafo, 0);
                insereAresta(gr, 6, 10, eh_digrafo, 0);
                insereAresta(gr, 7, 10, eh_digrafo, 0);
                insereAresta(gr, 7, 9, eh_digrafo, 0);
                insereAresta(gr, 8, 11, eh_digrafo, 3);
                insereAresta(gr, 9, 12, eh_digrafo, 0);
                insereAresta(gr, 10, 13, eh_digrafo, 2);
                insereAresta(gr, 11, 14, eh_digrafo, 0);
                insereAresta(gr, 12, 15, eh_digrafo, 1);
                insereAresta(gr, 12, 13, eh_digrafo, 0);
                insereAresta(gr, 13, 16, eh_digrafo, 0);
                insereAresta(gr, 14, 17, eh_digrafo, 2);
                insereAresta(gr, 15, 18, eh_digrafo, 0);
                insereAresta(gr, 16, 19, eh_digrafo, 0);
                insereAresta(gr, 17, 19, eh_digrafo, 1);
                insereAresta(gr, 18, 19, eh_digrafo, 0);
                jogar(gr, dados, 0, 30);
                break;

            default:
                printf(RED "Opcao invalida!\n" RESET);
                break;
        }

        if (gr != NULL) {
            libera_Grafo(gr);
        }
        if (dados != NULL) {
            free(dados);
        }

        printf("Deseja jogar novamente? (S/s): ");
        setbuf(stdin, NULL);
        scanf("%c", &continuar);
        printf("\n");

    } while (continuar == 'S' || continuar == 's');

    return 0;
}
