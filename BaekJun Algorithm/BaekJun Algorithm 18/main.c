//
//  main.c
//  BaekJun Algorithm 18
//
//  Created by hyungwook on 2021/03/19.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int n = 0;
    int x;
    int arr[10001] = {0};
    
    scanf("%d", &n);
    
    for(int i = 0; i < n; i++)
    {
        scanf("%d", &x);
        (arr[x])++;
    }
        
    for(int i = 1; i <= 10000; i++)
    {
        for(int j = 1; j <= arr[i]; j++)
        {
            printf("%d\n", i);
        }
    }
    
    return 0;
}
