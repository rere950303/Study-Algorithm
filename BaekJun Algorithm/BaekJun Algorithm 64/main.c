//
//  main.c
//  BaekJun Algorithm 64(2164, 카드2)
//  https://www.acmicpc.net/problem/2164
//  Created by hyungwook on 2021/04/02.
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

int Enque(IntQueue *q, int x)
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

int Deque(IntQueue *q, int *x)
{
    if(q->num <= 0)
        return -1;
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

int main(int argc, const char * argv[]) {
    // insert code here...
    int n, x;
    IntQueue q;
    
    scanf("%d", &n);
    Initialize(&q, n);
    
    for(int i = 1; i <= n; i++)
    {
        Enque(&q, i);
    }
    
    while(q.num > 2)
    {
        Deque(&q, &x);
        Deque(&q, &x);
        Enque(&q, x);
    }
    
    Deque(&q, &x);
    Deque(&q, &x);
    
    printf("%d\n", x);
  
    return 0;
}
