//
//  CircDblLinkedList.c
//  9.4(p401)
//
//  Created by hyungwook on 2021/03/15.
//

#include <stdio.h>
#include <stdlib.h>
#include "CircDblLinkedList.h"
#include "Member.h"

void Purge(Dlist *list, int compare(const Member *x, const Member *y))
{
    Dnode *ptr = list->head->next;
    
    while(ptr->next != list->head)
    {
        Dnode *ptr2 = ptr;
        Dnode *pre = ptr;
        while(ptr2->next != list->head)
        {
            ptr2 = pre->next;
            if(!compare(&ptr->data, &ptr2->data))
            {
                pre->next = ptr2->next;
                free(ptr);
            }
            else
            {
                pre = ptr2;
            }
        }
        ptr = ptr->next;
    }
    list->crnt = list->head;
}

Dnode *Retrieve(Dlist *list, int n)
{
    Dnode *ptr = list->head->next;
    
    while(--n >= 0 && ptr->next != list->head)
    {
        ptr = ptr->next;
    }
    
    if(n == -1)
        return ptr;
    else
        return NULL;
}

