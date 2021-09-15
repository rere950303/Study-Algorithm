//
//  main.c
//  10.1(p1)
//
//  Created by hyungwook on 2021/03/17.
//

#include <stdio.h>
#include "Member.h"
#include "BinTree.h"

void PrintTreeReverse(const BinNode *p)
{
    if (p != NULL)
    {
        PrintTreeReverse(p->right);
        PrintLnMember(&p->data);
        PrintTreeReverse(p->left);
    }
}
