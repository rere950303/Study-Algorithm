//
//  main.c
//  1.18(p40)
//
//  Created by hyungwook on 2021/03/06.
//

#include <stdio.h>

void nrpira(int n)
{
    for(int i = 1; i <= n; i++)
    {
        for(int j = 0; j < i - 1; j++)
        {
            printf(" ");
        }
        for(int j = 1; j <= -2 * i + 2 * n + 1; j++)
        {
            printf("%d", i % 10);
        }
        printf("\n");
    }
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int n = 0;
    
    scanf("%d", &n);
    nrpira(n);
    
    return 0;
}
