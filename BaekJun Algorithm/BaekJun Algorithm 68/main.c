//
//  main.c
//  BaekJun Algorithm 68(10866번, 덱)
//  https://www.acmicpc.net/problem/10866
//  Created by hyungwook on 2021/04/27.
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

int push_front(IntQueue *q, int x)
{
    if(q->num >= q->max)
        return -1;
    else
    {
        q->num++;
        q->front--;
        if(q->front == -1)
        {
            q->front = q->front + q->max;
        }
        q->que[q->front] = x;
        return 0;
    }
}

int push_back(IntQueue *q, int x)
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

int pop_front(IntQueue *q, int *x)
{
    if(q->num <= 0)
    {
        *x = -1;
        return -1;
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

int pop_back(IntQueue *q, int *x)
{
    if(q->num <= 0)
    {
        *x = -1;
        return -1;
    }
    else
    {
        q->num--;
        q->rear--;
        if(q->rear == -1)
        {
            q->rear += q->max;
        }
        *x = q->que[q->rear];
        return 0;
    }
}

int IsEmpty(IntQueue *q)
{
    if(q->num <= 0)
        return 1;
    return 0;
}

void front(IntQueue *q)
{
    if(q->num == 0)
    {
        printf("-1\n");
    }
    else
    {
        printf("%d\n", q->que[q->front]);
    }
}

void back(IntQueue *q)
{
    if(q->num == 0)
    {
        printf("-1\n");
    }
    else
    {
        int x = q->rear;
        x--;
        if(x == -1)
        {
            x += q->max;
        }
        printf("%d\n", q->que[x]);
    }
}

void Terminate(IntQueue *q)
{
    if(q->que != NULL)
    {
        free(q->que);
    }
    q->max = q->num = q->front = q->rear = 0;
}

void size(IntQueue *q)
{
    printf("%d\n", q->num);
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int n, x;
    char command[15];
    IntQueue q;
    Initialize(&q, 500);
    
    scanf("%d", &n);
    for(int i = 0; i < n; i++)
    {
        scanf("%s", command);
        if(strcmp(command, "push_back") == 0)
        {
            scanf("%d", &x);
            push_back(&q, x);
        }
        else if(strcmp(command, "push_front") == 0)
        {
            scanf("%d", &x);
            push_front(&q, x);
        }
        else if(strcmp(command, "front") == 0)
        {
            front(&q);
        }
        else if(strcmp(command, "back") == 0)
        {
            back(&q);
        }
        else if(strcmp(command, "pop_front") == 0)
        {
            pop_front(&q, &x);
            printf("%d\n", x);
        }
        else if(strcmp(command, "pop_back") == 0)
        {
            pop_back(&q, &x);
            printf("%d\n", x);
        }
        else if(strcmp(command, "size") == 0)
        {
            size(&q);
        }
        else if(strcmp(command, "empty") == 0)
        {
            if(IsEmpty(&q) == 1)
            {
                printf("1\n");
            }
            else
            {
                printf("0\n");
            }
        }
    }
    Terminate(&q);
        
    return 0;
}
