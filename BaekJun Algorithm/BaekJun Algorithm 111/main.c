//
//  main.c
//  BaekJun Algorithm 111(숫자의 개수, 2577)
//  https://www.acmicpc.net/problem/2577
//  Created by hyungwook on 2021/06/07.
//

#include <stdio.h>

int arr[10];

int main(int argc, const char * argv[]) {
    // insert code here...
    int a, b, c;
    
    scanf("%d", &a);
    scanf("%d", &b);
    scanf("%d", &c);
    
    int multiple = a * b * c;
    
    while(multiple > 0)
    {
        int rest = multiple % 10;
        
        arr[rest]++;
        multiple /= 10;
    }
    
    for(int i = 0; i < 10; i++)
    {
        printf("%d\n", arr[i]);
    }
    
    return 0;
}
