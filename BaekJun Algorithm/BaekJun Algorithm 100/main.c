//
//  main.c
//  BaekJun Algorithm 100(4344, 평균은 넘겠지)
//  https://www.acmicpc.net/problem/4344
//  Created by hyungwook on 2021/05/20.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int c;
    
    scanf("%d", &c);
    
    for(int i = 0; i < c; i++)
    {
        int n;
        int arr[1000];
        int sum = 0;
        int count = 0;
        
        scanf("%d", &n);
        for(int j = 0; j < n; j++)
        {
            scanf("%d", &arr[j]);
            sum += arr[j];
        }
        
        float average = (float)sum / n;
        
        for(int j = 0; j < n; j++)
        {
            if(arr[j] > average)
            {
                count++;
            }
        }
        
        printf("%.3f%%\n", (float)count / n * 100);
    }

    return 0;
}
