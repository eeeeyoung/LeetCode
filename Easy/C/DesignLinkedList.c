#include <stddef.h>

struct LinkedList{
    int val;
    struct LinkedList *next;
};

/* Define node as pointer of data type struct LinkedList */
typedef struct LinkedList *node;

node createNode() {
    node temp;
    /* Allocates memory using malloc */
    temp = (node)malloc(sizeof(struct LinkedList));
    temp->next = NULL;
    return temp;
}