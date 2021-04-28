//
//  main.c
//  BaekJun Algorithm 65(18258, 큐 2)
//  https://www.acmicpc.net/problem/18258
//  Created by hyungwook on 2021/04/02.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    int max;
    int num;
    int front;
    int rear;
    int *que;
} IntQueue;

int Initialize(IntQueue *q, int max)
{
    q->front = q->rear = q->num = 0;
    if((q->que = calloc(max, sizeof(int))) == NULL)
    {
        q->max = 0;
        return -1;
    }
    q->max = max;
    return 0;
}

int push(IntQueue *q, int x)
{
    if(q->num >= q->max)
        return -1;
    else
    {
        q->num++;
        q->que[q->rear++] = x;
        if(q->rear == q->max)
            q->rear = 0;
        return 0;
    }
}

int pop(IntQueue *q, int *x)
{
    if(q->num <= 0)
    {
        *x = -1;
        return  -1;
    }
    
    else
    {
        q->num--;
        *x = q->que[q->front];
        q->front++;
        if(q->front == q->max)
            q->front = 0;
        return 0;
    }
}

int empty(const IntQueue *q)
{
    if(q->num <= 0)
        return 1;
    return 0;
}

void front(IntQueue *q)
{
    if(q->num <= 0)
        printf("-1\n");
    else
    {
        printf("%d\n", q->que[q->front]);
    }
}

void back(IntQueue *q)
{
    if(q->num <= 0)
        printf("-1\n");
    else
    {
        int idx = q->rear;
        printf("%d\n", q->que[--idx]);
    }
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int n, x;
    char command[10];
    IntQueue q;
    
    Initialize(&q, 2000000);
    
    scanf("%d", &n);
    for(int i = 0; i < n; i++)
    {
        scanf("%s", command);
        if(strcmp(command, "push") == 0)
        {
            scanf("%d", &x);
            push(&q, x);
        }
        else if(strcmp(command, "front") == 0)
        {
            front(&q);
        }
        else if(strcmp(command, "pop") == 0)
        {
            pop(&q, &x);
            printf("%d\n", x);
        }
        else if(strcmp(command, "size") == 0)
        {
            printf("%d\n", q.num);
        }
        else if(strcmp(command, "empty") == 0)
        {
            printf("%d\n", empty(&q));
        }
        else if(strcmp(command, "back") == 0)
        {
            back(&q);
        }
    }
 
    return 0;
}
