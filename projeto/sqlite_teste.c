

#include <stdio.h>
// lib do SQLite
#include <sqlite3.h>
#include <stdlib.h>
#include <string.h>

#define MAX 20

int main(int argc, char** args)
{
    char *sql, nome[MAX],*end;
    int retval, i;
    int q_cnt = 5, q_size = 500, ind = 0;
    char **queries = malloc(sizeof(char) * q_cnt * q_size);

// definindo ponteiros
    sqlite3_stmt *stmt;
    sqlite3 *handle;

    retval = sqlite3_open("exemplo.db",&handle); // abrindo o banco

    if(retval)  // caso de erro na conexão vai mostrar msg
    {
        printf("Erro no banco\n");
        return -1;
    }


    printf("Deu certo\n"); // caso nao tenha dado erro continua

    printf("digite um nome para adicionar no banco\n");
    getchar();
    fgets(nome, MAX, stdin);

    i = strlen(nome)-1;
    if(nome[i] == '\n')
    {
        nome[i] = '\0';
    }

    sql = (char *)malloc( sizeof(char) * q_size ); // vai adicionar no banco na tabela cliente no campo nome o nome digitado pelo usuario
    strcpy(sql, "INSERT INTO agenda VALUES('" );
    strcat(sql, nome);
    strcat(sql,"', '43432222')");

    retval = sqlite3_exec(handle, sql, 0, 0, 0); // executa nosso comando no banco

    sqlite3_close(handle); // fecha a conexão

    return 0;
}
