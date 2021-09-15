//
//  IntStack.h
//  4.1(p142)
//
//  Created by hyungwook on 2021/03/08.
//

#ifndef ___IntStack
#define ___IntStack

typedef struct {
    int max;
    int ptr0;
    int ptr1;
    int *stk;
} IntStack;

int Initialize(IntStack *s, int max);

int Push(IntStack *s, int stack, int x);

int Pop(IntStack *s, int stack, int *x);

int Peek(const IntStack *s, int stack, int *x);

void Clear(IntStack *s, int stack);

int Capacity(const IntStack *s);

int Size(const IntStack *s, int stack);

int Search(const IntStack *s, int stack, int x);

void Print(const IntStack *s, int stack);

void Terminate(IntStack *s);

#endif
