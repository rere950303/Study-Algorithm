//
//  ArrayLinkedList.c
//  9.3(p379)
//
//  Created by hyungwook on 2021/03/15.
//

#include <stdio.h>
#include <stdlib.h>
#include "Member.h"
#include "ArrayLinkedList.h"

static void DeleteIndex(List *list, Index idx)
{
    if (list->deleted == Null)
    {
        list->deleted = idx;
        list->n[idx].Dnext = Null;
    }
    else {
        Index ptr = list->deleted;
        list->deleted = idx;
        list->n[idx].Dnext = ptr;
    }
}


void Purge(List *list, int compare(const Member *x, const Member *y))
{
    Index ptr = list->head;

    while (ptr != Null)
    {
        Index ptr2 = ptr;
        Index pre = ptr;

        while (list->n[ptr2].next != Null)
        {
            ptr2 = list->n[pre].next;
            
            if (!compare(&list->n[ptr].data, &list->n[ptr2].data))
            {
                list->n[pre].next = list->n[ptr2].next;
                DeleteIndex(list, ptr2);
            }
            else
            {
                pre = ptr2;
            }
        }
        ptr = list->n[ptr].next;
    }
    list->crnt = list->head;
}

Index Retrieve(List *list, int n)
{
    Index ptr = list->head;
    
    while(--n >= 0 && list->n[ptr].next != Null)
    {
        ptr = list->n[ptr].next;
    }
    
    if(n == -1)
        return ptr;
    else
        return Null;
}

