//
//  main.c
//  5.7(p182)
//
//  Created by hyungwook on 2021/03/10.
//

#include <stdio.h>
#include "IntStack.h"

IntStack sstk, xstk, ystk;

void move1(int no, int x, int y)
{
    int sw = 0;
    
    Initialize(&sstk, 100);
    Initialize(&xstk, 100);
    Initialize(&ystk, 100);
    
    while(1)
    {
        if(no > 1 && sw == 0)
        {
            Push(&sstk, sw);
            Push(&xstk, x);
            Push(&ystk, y);
            
            no = no - 1;
            y = 6 - x - y;
            
            continue;
        }
        
        printf("원반[%d]을 %d 기둥에서 %d 기둥으로 옮김\n", no, x, y);

        
        if(no > 1 && sw == 1)
        {
            Push(&sstk, sw);
            Push(&xstk, x);
            Push(&ystk, y);
            
            no = no - 1;
            x = 6 - x - y;
            sw = 0;
            
            continue;
        }
        
        do {
            if(IsEmpty(&xstk) ==  1)
                return;
            Pop(&sstk, &sw);
            Pop(&xstk, &x);
            Pop(&ystk, &y);
            
            no++;
            sw++;
        } while(sw == 2);
    }
}

int main(void)
{
    int n;
    printf("하노이의 탑\n원반 개수 : ");
    scanf("%d", &n);

    move1(n, 1, 3);
    
    Terminate(&xstk);
    Terminate(&ystk);
    Terminate(&sstk);

    return 0;
}
