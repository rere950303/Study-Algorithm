//
//  main.c
//  BaekJun Algorithm 66(11866, 요세푸스 문제 0)
//  https://www.acmicpc.net/problem/11866
//  Created by hyungwook on 2021/04/02.
//

#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int flag;
    int data;
} Memberdata;

typedef struct {
    int max;
    int num;
    int front;
    int rear;
    Memberdata *que;
} IntQueue;

int Initialize(IntQueue *q, int max)
{
    q->front = q->rear = q->num = 0;
    if((q->que = calloc(max, sizeof(Memberdata))) == NULL)
    {
        q->max = 0;
        return -1;
    }
    q->max = max;
    return 0;
}

int Enque(IntQueue *q, Memberdata x)
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

int IsEmpty(IntQueue *q)
{
    if(q->num <= 0)
        return 1;
    return 0;
}

void Peek(IntQueue *q)
{
    q->front++;
    if(q->front == q->max)
        q->front = 0;
}

void Decrease(IntQueue *q)
{
    q->num--;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int n, k;
    IntQueue q;
    Memberdata x;
    
    scanf("%d %d", &n, &k);
    Initialize(&q, n);
    
    for(int i = 0; i < n; i++)
    {
        x.data = i + 1;
        x.flag = 0;
        Enque(&q, x);
    }
    
    for(int i = 0; i < k - 1; i++)
    {
        Peek(&q);
    }
    
    printf("<%d", q.que[q.front].data);
    Decrease(&q);
    q.que[q.front].flag = 1;
    
    while(!IsEmpty(&q))
    {
        int count = 0;
        
        while(1)
        {
            if(count == k)
                break;
            Peek(&q);
            if(q.que[q.front].flag == 0)
                count++;
        }
        printf(", %d", q.que[q.front].data);
        Decrease(&q);
        q.que[q.front].flag = 1;
    }
    
    printf(">\n");
    
    return 0;
}
