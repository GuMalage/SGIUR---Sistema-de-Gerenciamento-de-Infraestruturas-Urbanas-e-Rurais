#define RED     "\033[31m"
#define GREEN   "\033[32m"
#define YELLOW  "\033[33m"
#define BLUE    "\033[34m"
#define MAGENTA "\033[35m"
#define CYAN    "\033[36m"
#define RESET   "\033[0m"

typedef struct info Info;
Info *insereNomeVertice();

typedef struct grafo Grafo;

Grafo* cria_Grafo(int nro_vertices, int grau_max, int eh_ponderado);
void libera_Grafo(Grafo* gr);
int insereAresta(Grafo* gr, int orig, int dest, int eh_digrafo, float peso);
void imprimeVizinhos(Grafo* gr, Info* dados, int atual);
int executaEvento(Info* dados, int vertice, int vidas, int contaux);
void jogar(Grafo* gr, Info* dados, int inicio, int vidas_iniciais);
