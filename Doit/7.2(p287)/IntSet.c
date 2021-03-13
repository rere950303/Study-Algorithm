//
//  IntSet.c
//  7.2(p287)
//
//  Created by hyungwook on 2021/03/13.
//

#include <stdio.h>
#include <stdlib.h>
#include "IntSet.h"
#include <string.h>

int Initialize(SortedIntSet *s, int max)
{
    s->num = 0;
    if ((s->set = calloc(max, sizeof(int))) == NULL) {
        s->max = 0;
        return -1;
    }
    s->max = max;
    return 0;
}

int IsMember(const SortedIntSet *s, int n)
{
    int pl = 0;
    int pr = s->num - 1;
    int pc;
    
    do {
        pc = (pl + pr) / 2;
        if(s->set[pc] == n)
            return pc;
        else if(s->set[pc] < n)
            pl = pc + 1;
        else
            pr = pc - 1;
    } while(pl <= pr);

    return -1;
}

void Add(SortedIntSet *s, int n)
{
    if (s->num < s->max && IsMember(s, n) == -1)
    {
        int key = n;
        int pl = 0;
        int pr = s->num - 1;
        int pc;
        int pd;
        
        do {
            pc = (pl + pr) / 2;
        
            if(n == s->set[pc])
            {
                break;
            }
            
            else if(n > s->set[pc])
            {
                pl = pc + 1;
            }
            
            else
            {
                pr = pc - 1;
            }
        } while(pl <= pr);
        
        pd = (pl <= pr) ? pc + 1 : pr + 1;
        
        memmove(&s->set[pd + 1], &s->set[pd], sizeof(int) * (s->num - pd));

        s->set[pd] = key;
    }
}

void Remove(SortedIntSet *s, int n)
{
    int idx;
    if ((idx = IsMember(s, n)) != -1)
    {
        memmove(&s->set[idx + 1], &s->set[idx], sizeof(int) * (s->num - idx - 1));
        s->num--;
    }
}

int Capacity(const SortedIntSet *s)
{
    return s->max;
}

int Size(const SortedIntSet *s)
{
    return s->num;
}

void Assign(SortedIntSet *s1, const SortedIntSet *s2)
{
    int i;
    int n = (s1->max < s2->num) ? s1->max : s2->num;
    for (i = 0; i < n; i++)
        s1->set[i] = s2->set[i];
    s1->num = n;
}

int Equal(const SortedIntSet *s1, const SortedIntSet *s2)
{
    if (Size(s1) != Size(s2))
        return 0;
    for (int i = 0; i < s1->num; i++)
    {
        if(s1->set[i] != s2->set[i])
            return 0;
    }
    return 1;
}

SortedIntSet *Union(SortedIntSet *s1, const SortedIntSet *s2, const SortedIntSet *s3)
{
    int i;
    Assign(s1, s2);
    for (i = 0; i < s3->num; i++)
        Add(s1, s3->set[i]);
    return s1;
}

SortedIntSet *Intersection(SortedIntSet *s1, const SortedIntSet *s2, const SortedIntSet *s3)
{
    int i, j;
    s1->num = 0;
    for (i = 0; i < s2->num; i++)
        for (j = 0; j < s3->num; j++)
            if (s2->set[i] == s3->set[j])
                Add(s1, s2->set[i]);
    return s1;
}

SortedIntSet *Difference(SortedIntSet *s1, const SortedIntSet *s2, const SortedIntSet *s3)
{
    int i, j;
    s1->num = 0;
    for (i = 0; i < s2->num; i++) {
        for (j = 0; j < s3->num; j++)
            if (s2->set[i] == s3->set[j])
                break;
        if (j == s3->num)
            Add(s1, s2->set[i]);
    }
    return s1;
}

void Print(const SortedIntSet *s)
{
    int i;

    printf("{ ");
    for (i = 0; i < s->num; i++)
        printf("%d ", s->set[i]);
    printf("}");
}

void PrintLn(const SortedIntSet *s)
{
    Print(s);
    putchar('\n');
}

void Terminate(SortedIntSet *s)
{
    if (s->set != NULL) {
        free(s->set);
        s->max = s->num = 0;
    }
}
