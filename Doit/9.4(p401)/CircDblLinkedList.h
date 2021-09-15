//
//  CircDblLinkedList.h
//  9.4(p401)
//
//  Created by hyungwook on 2021/03/15.
//

#ifndef ___CircDblLinkedList
#define ___CircDblLinkedList

#include "Member.h"

typedef struct __node {
    Member data;
    struct __node *prev;
    struct __node *next;
} Dnode;

typedef struct {
    Dnode *head;
    Dnode *crnt;
} Dlist;

void Initialize(Dlist *list);

void PrintCurrent(const Dlist *list);

void PrintLnCurrent(const Dlist *list);

Dnode *search(Dlist *list, const Member *x, int compare(const Member *x, const Member *y));

void Print(const Dlist *list);

void PrintReverse(const Dlist *list);

int Next(Dlist *list);

int Prev(Dlist *list);

void InsertAfter(Dlist *list, Dnode *p, const Member *x);

void InsertFront(Dlist *list, const Member *x);

void InsertRear(Dlist *list, const Member *x);

void Remove(Dlist *list, Dnode *p);

void RemoveFront(Dlist *list);

void RemoveRear(Dlist *list);

void RemoveCurrent(Dlist *list);

void Clear(Dlist *list);

void Terminate(Dlist *list);
#endif
