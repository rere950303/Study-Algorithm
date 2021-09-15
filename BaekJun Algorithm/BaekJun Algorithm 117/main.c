//
//  main.c
//  BaekJun Algorithm 117(연산자 끼워넣기, 14888)
//  https://www.acmicpc.net/problem/14888
//  Created by hyungwook on 2021/06/19.
//

#include <stdio.h>
#include <stdlib.h>

int *buff;
int digital[11];
int flag[4];
int pos[10];
int n;
int dp[100000];
int count = 0;

void __mergesort(int a[], int pl, int pr)
{
    if(pl < pr)
    {
        int j = 0;
        int p = 0;
        int pc = (pl + pr) / 2;
        int i;
        int k = pl;
        
        __mergesort(a, pl, pc);
        __mergesort(a, pc + 1, pr);
        
        for(i = pl; i <= pc; i++)
        {
            buff[p++] = a[i];
        }
        while(i <= pr && j < p)
        {
            a[k++] = (buff[j] >= a[i] ? buff[j++] : a[i++]);
        }
        while(j < p)
        {
            a[k++] = buff[j++];
        }
    }
}

void mergesort1(int a[], int n)
{
    buff = calloc(n, sizeof(int));
    __mergesort(a, 0, n - 1);
    free(buff);
}

void store(int a[])
{
    int i;
    int temp[11];
    
    for(i = 0; i < n; i++)
    {
        temp[i] = digital[i];
    }
    
    for(i = 0; i < n - 1; i++)
    {
        switch (a[i])
        {
            case 0:
                temp[i + 1] = temp[i] + temp[i + 1];
                break;
            case 1:
                temp[i + 1] = temp[i] - temp[i + 1];
                break;
            case 2:
                temp[i + 1] = temp[i] * temp[i + 1];
                break;
            case 3:
                if(temp[i] < 0)
                {
                    temp[i] *= -1;
                    temp[i + 1] = (temp[i] / temp[i + 1]) * -1;
                    break;
                }
                else
                {
                    temp[i + 1] = temp[i] / temp[i + 1];
                    break;
                }
        }
    }
    
    dp[count++] = temp[i];
}

void set(int i)
{
    for(int j = 0; j < 4; j++)
    {
        if(flag[j] != 0)
        {
            pos[i] = j;
            if(i == n - 2)
            {
                store(pos);
            }
            else
            {
                flag[j]--;
                set(i + 1);
                flag[j]++;
            }
        }
    }
}

int main(int argc, const char * argv[]) {
    // insert code here...
    scanf("%d", &n);
    
    for(int i = 0; i < n; i++)
    {
        scanf("%d", &digital[i]);
    }
    
    for(int i = 0; i < 4; i++)
    {
        scanf("%d", &flag[i]);
    }
    
    set(0);
    mergesort1(dp, count);
    
    printf("%d\n", dp[0]);
    printf("%d\n", dp[count - 1]);

    return 0;
}
