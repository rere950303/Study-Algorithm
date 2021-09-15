//
//  main.c
//  BaekJun Algorithm 7(그룹 단어 체커, 1316)
//  https://www.acmicpc.net/problem/1316
//  Created by hyungwook on 2021/02/28.
//

#include <stdio.h>
#include <string.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int n = 0;
    char ptr[100][101];
    int count = 0;
    
    scanf("%d", &n);
    
    for(int i = 0; i < n; i++)
    {
        scanf("%s", ptr[i]);
    }
    
    for(int i = 0; i < n; i++)
    {
        int len = strlen(ptr[i]);
        for(int j = len - 1; j >= 2; j--)
        {
            for(int k = j - 2; k >= 0; k--)
            {
                if((ptr[i][j] == ptr[i][k]) && (ptr[i][j] != ptr[i][j - 1]))
                {
                    count++;
                    break;
                }
            }
            break;
        }
    }
    
    printf("%d\n", n - count);

    return 0;
}
