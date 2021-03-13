//
//  IntSet.h
//  7.2(p287)
//
//  Created by hyungwook on 2021/03/13.
//

#ifndef ___IntSet
#define ___IntSet

typedef struct {
    int max;
    int num;
    int *set;
} SortedIntSet;

int Initialize(SortedIntSet *s, int max);

int IsMember(const SortedIntSet *s, int n);

void Add(SortedIntSet *s, int n);

void Remove(SortedIntSet *s, int n);

int Capacity(const SortedIntSet *s);

int Size(const SortedIntSet *s);

void Assign(SortedIntSet *s1, const SortedIntSet *s2);

int Equal(const SortedIntSet *s1, const SortedIntSet *s2);

SortedIntSet *Union(SortedIntSet *s1, const SortedIntSet *s2, const SortedIntSet *s3);

SortedIntSet *Intersection(SortedIntSet *s1, const SortedIntSet *s2, const SortedIntSet *s3);

SortedIntSet *Difference(SortedIntSet *s1, const SortedIntSet *s2, const SortedIntSet *s3);

void Print(const SortedIntSet *s);

void PrintLn(const SortedIntSet *s);

void Terminate(SortedIntSet *s);
#endif
