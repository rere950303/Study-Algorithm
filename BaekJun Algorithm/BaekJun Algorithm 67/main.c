//
//  main.c
//  BaekJun Algorithm 67(1966, 프린터 큐)
//  https://www.acmicpc.net/problem/1966
//  Created by hyungwook on 2021/04/02.
//

#include <stdio.h>
#include <stdlib.h>

int *buff;

typedef struct {
    int priority;
    int marking;
} Memberdata;

typedef struct {
    int max;
    int num;
    int front;
    int rear;
    Memberdata *Memberdata;
} IntQueue;

int Initialize(IntQueue *q, int max)
{
    q->front = q->rear = q->num = 0;
    if((q->Memberdata = calloc(max, sizeof(Memberdata))) == NULL)
    {
        q->max = 0;
        return -1;
    }
    q->max = max;
    
    for(int i = 0; i < 100; i++)
    {
        q->Memberdata[i].marking = 0;
    }
    
    return 0;
}

int Enque(IntQueue *q, Memberdata x)
{
    if(q->num >= q->max)
        return -1;
    else
    {
        q->num++;
        q->Memberdata[q->rear++] = x;
        if(q->rear == q->max)
            q->rear = 0;
        return 0;
    }
}

int Deque(IntQueue *q, Memberdata *x)
{
    if(q->num <= 0)
        return -1;
    else
    {
        q->num--;
        *x = q->Memberdata[q->front];
        q->front++;
        if(q->front == q->max)
            q->front = 0;
        return 0;
    }
}

int IsEmpty(IntQueue *q)
{
    if(q->num <= 0)
        return 1;
    return 0;
}

void __mergesort(int a[], int left, int right)
{
    if(left < right)
    {
        int center = (left + right) / 2;
        int p = 0;
        int i;
        int j = 0;
        int k = left;
        __mergesort(a, left, center);
        __mergesort(a, center + 1, right);
        for(i = left; i <= center; i++)
        {
            buff[p++] = a[i];

        }
        while(i <= right && j < p)
        {
            a[k++] = (buff[j] >= a[i]) ? buff[j++] : a[i++];
        }
        while(j < p)
        {
            a[k++] = buff[j++];
        }
    }
}

int mergesort__(int a[], int n)
{
    if((buff = calloc(n, sizeof(int))) == NULL)
       return -1;
       __mergesort(a, 0, n - 1);
       free(buff);
       return 0;
}

void Peek(IntQueue *q, Memberdata *x)
{
    *x = q->Memberdata[q->front];
}

void Clear(IntQueue *q)
{
    q->num = q->front = q->rear = 0;
}

void Terminate(IntQueue *q)
{
    if(q->Memberdata != NULL)
    {
        free(q->Memberdata);
    }
    q->max = q->num = q->front = q->rear = 0;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int m, n, t;
    IntQueue q;
    Memberdata x;
    int priority[100];
    
    Initialize(&q, 100);
    
    scanf("%d", &t);
    
    for(int i = 0; i < t; i++)
    {
        int count = 0;
        int k = 0;
        x.marking = 0;
        
        scanf("%d %d", &n, &m);
        for(int j = 0; j < n; j++)
        {
            scanf("%d", &priority[j]);
            x.priority = priority[j];
            Enque(&q, x);
        }
        q.Memberdata[m].marking = 1;
        mergesort__(priority, n);
        while(IsEmpty(&q) == 0)
        {
            Peek(&q, &x);
            if(x.priority != priority[k])
            {
                Deque(&q, &x);
                Enque(&q, x);
            }
            else
            {
                count++;
                k++;
                Deque(&q, &x);
                if(x.marking == 1)
                    break;
            }
        }
        printf("%d\n", count);
        Clear(&q);
    }

    return 0;
}
