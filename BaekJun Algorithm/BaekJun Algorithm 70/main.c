//
//  main.c
//  BaekJun Algorithm 70(5430, AC)
//  https://www.acmicpc.net/problem/5430
//  Created by hyungwook on 2021/04/27.
//

#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int max;
    int num;
    int front;
    int rear;
    int *que;
} IntQueue;

void Clear(IntQueue *q)
{
    q->front = q->num = q->rear = 0;
}

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
            q->rear += q->max;
        *x = q->que[q->rear];
        return 0;
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

void Peek1(IntQueue *q, int *x)
{
    *x = q->que[q->front];
    q->front++;
    if(q->front == q->max)
        q->front = 0;
}

void Peek2(IntQueue *q, int *x)
{
    q->rear--;
    if(q->rear == -1)
        q->rear += q->max;
    *x = q->que[q->rear];
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int t, n, x = 0;
    char function[400001];
    IntQueue q;
    
    Initialize(&q, 100005);
    scanf("%d", &t);
    
    for(int i = 0; i < t; i++)
    {
        int flag = 1;
        int pc = 0;
        
        scanf("%s", function);
        scanf("%d", &n);
        getchar();
        if(n == 0)
        {
            getchar();
            getchar();
        }
        else
        {
            getchar();
        }
        for(int j = 0; j < n; j++)
        {
            scanf("%d", &x);
            getchar();
            push_back(&q, x);
        }
        
        while(function[pc] != '\0')
        {
            if(function[pc] == 'R')
            {
                flag *= -1;
            }
            else
            {
                if(flag == 1)
                {
                    pop_front(&q, &x);
                    if(x == -1)
                        break;
                }
                else
                {
                    pop_back(&q, &x);
                    if(x == -1)
                        break;
                }
            }
            pc++;
        }
        
        if(x == -1)
        {
            printf("error\n");
        }
        else
        {
            if(q.num == 0)
            {
                printf("[]\n");
            }
            else
            {
                printf("[");
                if(flag == 1)
                {
                    for(int j = 0; j < q.num - 1; j++)
                    {
                        Peek1(&q, &x);
                        printf("%d,", x);
                    }
                    Peek1(&q, &x);
                    printf("%d]\n", x);
                }
                else
                {
                    for(int j = 0; j < q.num - 1; j++)
                    {
                        Peek2(&q, &x);
                        printf("%d,", x);
                    }
                    Peek2(&q, &x);
                    printf("%d]\n", x);
                }
            }
        }
        x = 1;
        Clear(&q);
    }
    Terminate(&q);
    return 0;
}
