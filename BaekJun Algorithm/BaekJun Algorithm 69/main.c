//
//  main.c
//  BaekJun Algorithm 69(회전하는 큐, 1021번)
//  https://www.acmicpc.net/problem/1021
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

void Terminate(IntQueue *q)
{
    if(q->que != NULL)
    {
        free(q->que);
    }
    q->max = q->num = q->front = q->rear = 0;
}

int Search(IntQueue *q, int x)
{
    int i, idx;
    
    for(i = 0; i < q->num; i++)
    {
        if(q->que[idx = (i +q->front) % q->max] == x)
            return idx;
    }
    return -1;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int n, m;
    IntQueue q;
    int target[50];
    
    Initialize(&q, 50);
    scanf("%d %d", &n, &m);
    for(int i = 0; i < m; i++)
    {
        scanf("%d", &target[i]);
    }
    for(int i = 0; i < n; i++)
    {
        push_back(&q, i + 1);
    }
    
    int count = 0;
    
    for(int i = 0; i < m; i++)
    {
        int x = Search(&q, target[i]);
        int count1 = 0;
        int count2 = 0;
        
        while(x != q.front)
        {
            x--;
            count1++;
            if(x == -1)
                x += q.max;
        }
        
        x = Search(&q, target[i]);
        
        while(x != q.rear)
        {
            x++;
            count2++;
            if(x == q.max)
                x = 0;
        }
        
        if(count1 <= count2)
        {
            count += count1;
            for(int j = 0; j < count1; j++)
            {
                pop_front(&q, &x);
                push_back(&q, x);
            }
            pop_front(&q, &x);
        }
        else
        {
            count += count2;
            for(int j = 0; j < count2; j++)
            {
                pop_back(&q, &x);
                push_front(&q, x);
            }
            pop_front(&q, &x);
        }
    }
    
    printf("%d\n", count);
    
    Terminate(&q);

    return 0;
}
