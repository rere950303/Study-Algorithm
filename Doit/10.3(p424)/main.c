//
//  main.c
//  10.3(p424)
//
//  Created by hyungwook on 2021/03/17.
//

#include <stdio.h>
#include "Member.h"
#include "BinTree.h"

BinNode *GetMinNode(const BinNode *p)
{
    if(p == NULL)
    {
        return NULL;
    }
    
    else
    {
        while(p->left != NULL)
        {
            p = p->left;
        }
        return p;
    }
}

BinNode *GetMaxNode(const BinNode *p)
{
    if(p == NULL)
    {
        return NULL;
    }
    
    else
    {
        while(p->right != NULL)
        {
            p = p->right;
        }
        return p;
    }
}
