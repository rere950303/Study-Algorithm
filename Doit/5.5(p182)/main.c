//
//  main.c
//  5.5(p182)
//
//  Created by hyungwook on 2021/03/08.
//

#include <stdio.h>
#include "IntStack.h"

IntStack nstk, sstk;

void recur3(int n)
{
    int sw = 0;

    Initialize(&nstk, 100);
    Initialize(&sstk, 100);

    while (1)
    {
        if (n > 0)
        {
            Push(&nstk, n);
            Push(&sstk, sw);

            if (sw == 0)
                n = n - 1;
            else if (sw == 1)
            {
                n = n - 2;
                sw = 0;
            }
            continue;
        }
        
        do {
            Pop(&nstk, &n);
            Pop(&sstk, &sw);
            sw++;

            if (sw == 2)
            {
                printf("%d\n", n);
                if (IsEmpty(&nstk))
                    return;
            }
        } while (sw == 2);
    }
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int x;
    
    printf("정수를 입력하세요: ");
    scanf("%d", &x);
    
    recur3(x);
    
    Terminate(&nstk);
    Terminate(&sstk);
    
    return 0;
}
