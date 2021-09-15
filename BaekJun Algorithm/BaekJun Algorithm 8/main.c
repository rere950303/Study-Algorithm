//
//  main.c
//  BaekJun Algorithm 8(수 정렬하기, 2150)
//  https://www.acmicpc.net/problem/2750
//  Created by hyungwook on 2021/02/28.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int n = 0;
    int arr[1000] = {0};
    
    scanf("%d", &n);
    
    for(int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }
    
    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < n - i - 1; j++)
        {
            if(arr[j] > arr[j + 1])
            {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
    
    for(int i = 0; i < n; i++)
    {
        printf("%d\n", arr[i]);
    }

    return 0;
}
