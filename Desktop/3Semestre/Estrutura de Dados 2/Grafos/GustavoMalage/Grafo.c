#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include "Grafo.h"

typedef struct info {
    int chave;
    char conteudo[50];
    int numEvento;
    char nomeJogador[100];
};

Info *insereNomeVertice() {
    Info *dados = malloc(20 * sizeof(Info));

    dados[0].chave = 0;
    strcpy(dados[0].conteudo, "Vila Inicial");
    dados[0].numEvento = 0;

    dados[1].chave = 1;
    strcpy(dados[1].conteudo, "Floresta Sombria");
    dados[1].numEvento = 1;

    dados[2].chave = 2;
    strcpy(dados[2].conteudo, "Ponte Quebrada");
    dados[2].numEvento = 2;

    dados[3].chave = 3;
    strcpy(dados[3].conteudo, "Torre do Mago");
    dados[3].numEvento = 3;

    dados[4].chave = 4;
    strcpy(dados[4].conteudo, "Caverna Misteriosa");
    dados[4].numEvento = 4;

    dados[5].chave = 5;
    strcpy(dados[5].conteudo, "Lago das Serpentes");
    dados[5].numEvento = 5;

    dados[6].chave = 6;
    strcpy(dados[6].conteudo, "Castelo Abandonado");
    dados[6].numEvento = 6;

    dados[7].chave = 7;
    strcpy(dados[7].conteudo, "Montanha Gelida");
    dados[7].numEvento = 7;

    dados[8].chave = 8;
    strcpy(dados[8].conteudo, "Vila dos Ancioes");
    dados[8].numEvento = 8;

    dados[9].chave = 9;
    strcpy(dados[9].conteudo, "Ruinas Antigas");
    dados[9].numEvento = 9;

    dados[10].chave = 10;
    strcpy(dados[10].conteudo, "Jardim Encantado");
    dados[10].numEvento = 10;

    dados[11].chave = 11;
    strcpy(dados[11].conteudo, "Torre de Vigia");
    dados[11].numEvento = 11;

    dados[12].chave = 12;
    strcpy(dados[12].conteudo, "Mercado Secreto");
    dados[12].numEvento = 12;

    dados[13].chave = 13;
    strcpy(dados[13].conteudo, "Deserto Ardente");
    dados[13].numEvento = 13;

    dados[14].chave = 14;
    strcpy(dados[14].conteudo, "Porto dos Piratas");
    dados[14].numEvento = 14;

    dados[15].chave = 15;
    strcpy(dados[15].conteudo, "Ilha Flutuante");
    dados[15].numEvento = 15;

    dados[16].chave = 16;
    strcpy(dados[16].conteudo, "Templo Perdido");
    dados[16].numEvento = 16;

    dados[17].chave = 17;
    strcpy(dados[17].conteudo, "Santuario da Lua");
    dados[17].numEvento = 17;

    dados[18].chave = 18;
    strcpy(dados[18].conteudo, "Vale Proibido");
    dados[18].numEvento = 18;

    dados[19].chave = 19;
    strcpy(dados[19].conteudo, "Cristal Roxinho");
    dados[19].numEvento = 19;

    return dados;
}


struct grafo {
    int eh_ponderado;
    int nro_vertices;
    int grau_max;
    int** arestas;
    float** pesos;
    int* grau;
};

Grafo* cria_Grafo(int nro_vertices, int grau_max, int eh_ponderado) {
    Grafo *gr = (Grafo*) malloc(sizeof(struct grafo));
    if(gr != NULL) {
        int i;
        gr->nro_vertices = nro_vertices;
        gr->grau_max = grau_max;
        gr->eh_ponderado = (eh_ponderado != 0) ? 1 : 0;
        gr->grau = (int*) calloc(nro_vertices, sizeof(int));

        gr->arestas = (int**) malloc(nro_vertices * sizeof(int*));
        for(i = 0; i < nro_vertices; i++) {
            gr->arestas[i] = (int*) malloc(grau_max * sizeof(int));
        }

        if(gr->eh_ponderado) {
            gr->pesos = (float**) malloc(nro_vertices * sizeof(float*));
            for(i = 0; i < nro_vertices; i++) {
                gr->pesos[i] = (float*) malloc(grau_max * sizeof(float));
            }
        }
    }
    return gr;
}

void libera_Grafo(Grafo* gr) {
    if(gr != NULL) {
        int i;
        for(i = 0; i < gr->nro_vertices; i++) {
            free(gr->arestas[i]);
        }
        free(gr->arestas);

        if(gr->eh_ponderado) {
            for(i = 0; i < gr->nro_vertices; i++) {
                free(gr->pesos[i]);
            }
            free(gr->pesos);
        }
        free(gr->grau);
        free(gr);
    }
}

int insereAresta(Grafo* gr, int orig, int dest, int eh_digrafo, float peso) {
    if(gr == NULL) return 0;
    if(orig < 0 || orig >= gr->nro_vertices) return 0;
    if(dest < 0 || dest >= gr->nro_vertices) return 0;

    gr->arestas[orig][gr->grau[orig]] = dest;
    if(gr->eh_ponderado) {
        gr->pesos[orig][gr->grau[orig]] = peso;
    }
    gr->grau[orig]++;

    if(eh_digrafo == 0) {
        insereAresta(gr, dest, orig, 1, peso);
    }
    return 1;
}

void imprimeVizinhos(Grafo* gr, Info* dados, int atual) {
    printf("\nVoce esta em %s\n", dados[atual].conteudo);
    printf("Voce pode ir para:\n");
    for (int i = 0; i < gr->grau[atual]; i++) {
        int dest = gr->arestas[atual][i];
        printf("[%d] %s\n", i + 1, dados[dest].conteudo);
    }
}

int executaEvento(Info* dados, int vertice, int vidas, int contaux) {
    char nomeJogador[50];
    int escolha;
    char nomeJogadorAux[50];
    char resposta[50];

    switch (dados[vertice].numEvento) {
        case 0:
        if (contaux == 0) {
            printf(MAGENTA "Alguem: Ola, viajante!\n" RESET);
            printf("Pressione Enter para continuar...\n");
            getchar();
            printf(MAGENTA "Alguem: Qual e o seu nome? " RESET);
            fgets(dados[0].nomeJogador, 50, stdin);
            dados[0].nomeJogador[strcspn(dados[0].nomeJogador, "\n")] = '\0';

            printf(MAGENTA "\nAlguem: Ah, %s... Vejo que voce e novo por aqui. Bem-vindo a Vila do Pao!\n" RESET, dados[0].nomeJogador);
            getchar();
            printf(BLUE "%s: Sou sim, acabei de chegar na regiao :)\n" RESET, dados[0].nomeJogador);
            getchar();
            printf(MAGENTA "Rubia: Muito prazer! Eu me chamo Rubia, sou a brux... digo, a maga da vila!\n" RESET);
            getchar();
            printf(BLUE "%s: Serio? Que incrivel! Eu nunca conheci uma maga antes. Voce sabe se alguem precisa de ajuda?\n" RESET, dados[0].nomeJogador);
            getchar();
            printf(MAGENTA "Rubia: Hmm... %s, na verdade, eu mesma estou precisando de um ajudante. E pago bem!\n" RESET, dados[0].nomeJogador);
            getchar();
            printf(BLUE "%s: Serio? Que tipo de trabalho seria esse?\n" RESET, dados[0].nomeJogador);
            getchar();
            printf(MAGENTA "Rubia: Ah, nada demais... apenas buscar um cristalzinho para mim!\n\n" RESET);

            do {
                printf(BLUE "[1]-Aceitar\n" RESET);
                printf(BLUE "[2]-Recusar\n" RESET);
                printf(BLUE "---> " RESET);
                scanf("%d", &escolha);
            } while (escolha != 1 && escolha != 2);

            if (escolha == 1) {
                printf(BLUE "\nPerfeito %s!!!\n" RESET, dados[0].nomeJogador);
                printf(BLUE "Tome este mapa magico. /~/\n" RESET);
                printf(BLUE "Boa sorte! Ate mais.\n" RESET);
                printf(BLUE "\nPuf! Hahaha!\n" RESET);
                printf(BLUE "Nossa... nunca tinha visto alguem desaparecer assim.\n" RESET);
            } else {
                printf(BLUE "\nNossa, %s... como voce e preguicoso!\n" RESET, dados[0].nomeJogador);
                printf(BLUE "Rubia lanca um feitico em voce!\n" RESET);
                vidas -= 40;
            }
        } else {
            printf(BLUE "\nVoce volta para a vila inicial, mas nada de novo acontece\n" RESET);
        }
        break;

        case 1:
            printf(MAGENTA "\nOh meu deus, como aqui esta escuro! Voce nao esta enxergando nada :0\n" RESET);
            do {
                printf(MAGENTA "[1] - Continuar assim mesmo\n" RESET);
                printf(MAGENTA "[2] - Procurar luz\n" RESET);
                printf(MAGENTA"---> "RESET);
                scanf("%d", &escolha);
            } while (escolha != 1 && escolha != 2);

            if (escolha == 1) {
                printf(MAGENTA "\nVoce se perde e perde 10 vidas!\n" RESET);
                vidas -= 10;
            } else {
                printf(MAGENTA "\nVoce sente o chao sumir sob seus pes...\n" RESET);
                sleep(2);
                printf(MAGENTA "Aaaaaaaahhhhhh!\n" RESET);
                printf(MAGENTA "Voce caiu em um buraco e perdeu 4 vidas.\n" RESET);
                vidas -= 4;
            }
            break;

        case 2:
            printf(CYAN "\nVoce chega a Ponte Quebrada. Um duende aparece com um enigma:\n" RESET);
            printf(CYAN "\"O que entra na agua, mas nao se molha?\"\n" RESET);
            printf(CYAN"---> "RESET);
            getchar();
            fgets(resposta, 50, stdin);
            resposta[strcspn(resposta, "\n")] = '\0';
            if (strcmp(resposta, "sombra") == 0 || strcmp(resposta, "Sombra") || strcmp(resposta, "SOMBRA")) {
                printf(CYAN "Resposta correta! Voce passa sem perder vidas.\n" RESET);
            } else {
                printf(CYAN "Resposta errada! Voce leva uma paulada e perde 5 vidas.\n" RESET);
                vidas -= 5;
            }
            break;

        case 3:
            printf(GREEN "Voce esta cansado e encontra uma torre.\n" RESET);
            do {
                printf(GREEN "[1] - Pedir ajuda.\n" RESET);
                printf(GREEN "[2] - Ignorar.\n" RESET);
                printf(GREEN"---> "RESET);
                scanf("%d", &escolha);
            } while (escolha != 1 && escolha != 2);

            if (escolha == 1) {
                printf(GREEN "\nVoce ganha comida e descanso. Ganha 8 vidas!\n" RESET);
                vidas += 8;
            } else {
                printf(GREEN "\nVoce segue viagem.\n" RESET);
            }
            break;

        case 4:
            printf(YELLOW "A Caverna Misteriosa emite sons estranhos.\n" RESET);
            do {
                printf(YELLOW "[1] - Entrar.\n" RESET);
                printf(YELLOW "[2] - Ficar fora.\n" RESET);
                printf(YELLOW"---> "RESET);
                scanf("%d", &escolha);
            } while (escolha != 1 && escolha != 2);

            if (escolha == 1) {
                printf(YELLOW "\nVoce encontra um hobbit que te bate. Perde 1 vida!\n" RESET);
                vidas -= 1;
            } else {
                printf(YELLOW "\nVoce descansa fora. Nenhuma vida perdida.\n" RESET);
            }
            break;

        case 5:
            printf(BLUE "\nVoce chega ao Lago das Serpentes. Tudo esta calmo.\n" RESET);
            printf(BLUE "Nada acontece e nenhuma vida e perdida.\n" RESET);
            break;

        case 6:
            printf(MAGENTA "No Castelo Abandonado, vozes misteriosas ecoam.\n" RESET);
            do {
                printf(MAGENTA "[1] - Investigar.\n" RESET);
                printf(MAGENTA "[2] - Sair.\n" RESET);
                printf(MAGENTA"---> "RESET);
                scanf("%d", &escolha);
            } while (escolha != 1 && escolha != 2);

            if (escolha == 1) {
                printf(MAGENTA "\nVoce encontra uma armadura magica! Ganha 5 vidas!\n" RESET);
                vidas += 5;
            } else {
                printf(MAGENTA "\nVoce foge em seguranca.\n" RESET);
            }
            break;

        case 7:
            printf(CYAN "Na Montanha Gelida, o vento te desgasta.\n" RESET);
            printf(CYAN "Voce perde 5 vidas.\n" RESET);
            vidas -= 5;
            break;

        case 8:
            printf(GREEN "Na Vila dos Ancioes, oferecem quentao.\n" RESET);
            do {
                printf(GREEN "[1] - Aceitar e conversar.\n" RESET);
                printf(GREEN "[2] - Recusar e seguir.\n" RESET);
                printf(GREEN"---> "RESET);
                scanf("%d", &escolha);
            } while (escolha != 1 && escolha != 2);

            if (escolha == 1) {
                printf(GREEN "\nVoce fica bebado e perde 2 vidas.\n" RESET);
                vidas -= 2;
            } else {
                printf(GREEN "\nVoce segue viagem sem problemas.\n" RESET);
            }
            break;

        case 9:
            printf(GREEN "As Ruinas Antigas estao cobertas por trepadeiras.\n" RESET);
            printf(GREEN "Voce nao consegue entrar. Nenhuma vida perdida.\n" RESET);
            break;

        case 10:
            printf(BLUE "Voce chega ao Jardim Encantado.\n" RESET);
            printf(BLUE "Voce se sente revigorado. Ganha 2 vidas!\n" RESET);
            vidas += 2;
            break;

        case 11:
            printf(MAGENTA "A Torre de Vigia parece vazia.\n" RESET);
            do {
                printf(MAGENTA "[1] - Explorar.\n" RESET);
                printf(MAGENTA "[2] - Evitar.\n" RESET);
                printf(MAGENTA"---> "RESET);
                scanf("%d", &escolha);
            } while (escolha != 1 && escolha != 2);

            if (escolha == 1) {
                printf(MAGENTA "\nNada acontece. Nenhuma vida perdida.\n" RESET);
            } else {
                printf(MAGENTA "\nVoce evita problemas e segue viagem.\n" RESET);
            }
            break;

        case 12:
            printf(CYAN "No Mercado Secreto, itens raros sao vendidos.\n" RESET);
            do {
                printf(CYAN "[1] - Comprar pocao.\n" RESET);
                printf(CYAN "[2] - Nao comprar.\n" RESET);
                printf(CYAN"---> "RESET);
                scanf("%d", &escolha);
            } while (escolha != 1 && escolha != 2);

            if (escolha == 1) {
                printf(CYAN "\nVoce sente energia renovada. Ganha 5 vidas!\n" RESET);
                vidas += 5;
            } else {
                printf(CYAN "\nVoce sai sem comprar nada.\n" RESET);
            }
            break;

        case 13:
            printf(YELLOW "No Deserto Ardente, surge uma esfinge com um enigma:\n" RESET);
            printf(YELLOW "\"O que e cheio de buracos, mas ainda assim segura agua?\"\n" RESET);
            printf(YELLOW"---> "RESET);
            getchar();
            fgets(resposta, 50, stdin);
            resposta[strcspn(resposta, "\n")] = '\0';
            if (strcmp(resposta, "esponja") == 0 || strcmp(resposta, "Esponja") == 0 || strcmp(resposta, "ESPONJA") == 0) {
                printf(GREEN "Correto! Voce passa sem perder vidas.\n" RESET);
            } else {
                printf(GREEN "Errado! Voce perde 6 vidas ao atravessar.\n" RESET);
                vidas -= 6;
            }
            break;

        case 14:
            printf(YELLOW "No Porto dos Piratas, marujos suspeitos te olham.\n" RESET);
            do {
                printf(YELLOW "[1] - Desafiar pirata.\n" RESET);
                printf(YELLOW "[2] - Evitar confusao.\n" RESET);
                printf(YELLOW"---> "RESET);
                scanf("%d", &escolha);
            } while (escolha != 1 && escolha != 2);

            if (escolha == 1) {
                printf(YELLOW "\nVoce vence e ganha respeito! Ganha 5 vidas!\n" RESET);
                vidas += 5;
            } else {
                printf(YELLOW "\nVoce evita problemas e sai discretamente.\n" RESET);
            }
            break;

        case 15:
            printf(GREEN "A Ilha Flutuante parece vazia, cercada de nuvens.\n" RESET);
            printf(GREEN "Nada acontece aqui.\n" RESET);
            break;

        case 16:
            printf(RED "No Templo Perdido, o ar e pesado e misterioso.\n" RESET);
            do {
                printf(RED "[1] - Decifrar inscricoes.\n" RESET);
                printf(RED "[2] - Nao arriscar.\n" RESET);
                printf(RED"---> "RESET);
                scanf("%d", &escolha);
            } while (escolha != 1 && escolha != 2);

            if (escolha == 1) {
                printf(MAGENTA "\nVoce desbloqueia habilidade espiritual! Ganha 10 vidas!\n" RESET);
                vidas += 10;
            } else {
                printf(MAGENTA "\nVoce respeita e vai embora.\n" RESET);
            }
            break;

        case 17:
            printf(MAGENTA "No Santuario da Lua, cantos ecoam.\n" RESET);
            do {
                printf(MAGENTA "[1] - Participar do ritual.\n" RESET);
                printf(MAGENTA "[2] - Apenas observar.\n" RESET);
                printf(MAGENTA"---> "RESET);
                scanf("%d", &escolha);
            } while (escolha != 1 && escolha != 2);

            if (escolha == 1) {
                printf(MAGENTA "\nVoce recebe uma bencao lunar! Ganha 8 vidas!\n" RESET);
                vidas += 8;
            } else {
                printf(MAGENTA "\nVoce sente paz observando.\n" RESET);
            }
            break;

        case 18:
            printf(RED "No Vale Proibido, neblina densa esconde perigos.\n" RESET);
            printf(RED "Voce e picado e perde 1 vida.\n" RESET);
            vidas -= 1;
            break;

        case 19:
            printf(GREEN "\nVoce finalmente chega a Caverna do Cristal.\n" RESET);
            printf(GREEN "Ao tocar no cristal, uma luz intensa envolve seu corpo...\n" RESET);
            printf(GREEN "Em um piscar de olhos, voce e teletransportado de volta para a vila!\n" RESET);
            printf("Pressione Enter para continuar...\n");
            getchar();
            printf(MAGENTA "\nRubia: Incrivel, %s! Vejo que voce chegou ate aqui!\n" RESET, dados[0].nomeJogador);
            getchar();
            printf(MAGENTA "\nRubia: Com o cristal em maos, finalmente poderei concluir meu grande feitico...\n" RESET);
            getchar();
            printf(BLUE "\n%s: O que exatamente voce vai fazer com ele?\n" RESET, dados[0].nomeJogador);
            getchar();
            printf(MAGENTA "Rubia: Hehehe... Nao se preocupe, jovem aventureiro. Gracas a voce, a vila sera protegida para sempre!\n" RESET);
            getchar();
            printf(MAGENTA "Rubia: Tome estas moedas magicas como recompensa!\n" RESET);
            getchar();
            printf(BLUE "Voce concluiu sua missao com sucesso! Parabens!\n" RESET);
            getchar();
            printf(YELLOW "\n=== FIM DE JOGO ===\n\n" RESET);
            break;

        default:
            printf(RED "\nLocal desconhecido ou sem evento.\n" RESET);
            break;
    }

    if (vidas < 0) vidas = 0;
    return vidas;
}



void jogar(Grafo* gr, Info* dados, int inicio, int vidas_iniciais) {
    int atual = inicio;
    int vidas = vidas_iniciais;
    int escolha;
    int contaux = 0;

    while (atual <= 19 && vidas > 0) {

        if(atual != 0){
            contaux++;
        }

        if (atual != 0) {
            printf("\n" YELLOW "=== STATUS ===" RESET "\nVoce possui " RED "%d" RESET " vidas restantes\n\n", vidas);
        }

        if (vidas == 8) {
            printf("\n" RED "Se eu fosse voce tomaria cuidado, suas vidas estao perigosamente baixas!\n" RESET);
        }

        if (vidas == 5) {
            printf("\n" RED "Vish, nao vai da nao viu, logo tu vai descobrir se no ceu tem pao (~~~~)\n" RESET);
        }

        if (vidas == 3) {
            printf("\n" RED "Esperava mais de voce :(\n" RESET);
        }

        if (vidas == 1) {
            int tifu;
            printf("\n" RED "Tifu Tifu Tifu, quantos tifu deu? " RESET);
            scanf("%d", &tifu);

            if (tifu == 3) {
                printf("\n" GREEN "Parabens, voce ganhou uma vida!\n" RESET);
                vidas += 1;
            }
        }

        vidas = executaEvento(dados, atual, vidas, contaux);
        if (vidas <= 0) {
            printf("\n" RED "Voce morreu no caminho! Seu fraco.\n" RESET);
            return;
        }

        if(atual == 19){
            return;
        }

        imprimeVizinhos(gr, dados, atual);
        printf(YELLOW "Escolha para onde deseja ir: " RESET);
        scanf("%d", &escolha);

        if (escolha < 1 || escolha > gr->grau[atual]) {
            printf("\n" RED "Escolha invalida! Tente novamente.\n" RESET);
            continue;
        }

        int prox = gr->arestas[atual][escolha - 1];
        float custo = gr->pesos[atual][escolha - 1];

        printf("\n" CYAN "Indo para %s, o percurso lhe custou " RED "%.0f" RESET CYAN " em vidas\n" RESET, dados[prox].conteudo, custo);
        vidas -= custo;

        if (vidas <= 0) {
            printf("\n" RED "Voce morreu no caminho! Seu fraco.\n" RESET);
            return;
        }


        atual = prox;
    }
}






