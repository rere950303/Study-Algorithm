//
//  ArrayIntQueue.h
//  4.3(p144)
//
//  Created by hyungwook on 2021/03/08.
//

#ifndef ___IntQueue
#define ___IntQueue

typedef struct {
    int max;
    int num;
    int *que;
} ArrayIntQueue;

int Initialize(ArrayIntQueue *q, int max);

int Enque(ArrayIntQueue *q, int x);

int Deque(ArrayIntQueue *q, int *x);

int Peek(const ArrayIntQueue *q, int *x);

int Capacity(const ArrayIntQueue *q);

int Size(const ArrayIntQueue *q);

void Print(const ArrayIntQueue *q);

void Terminate(ArrayIntQueue *q);

#endif
