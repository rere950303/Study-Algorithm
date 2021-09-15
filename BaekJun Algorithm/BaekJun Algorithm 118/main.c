//
//  main.c
//  BaekJun Algorithm 118(스타트와 링크, 14889)
//  https://www.acmicpc.net/problem/14889
//  Created by hyungwook on 2021/06/20.
//

#include <stdio.h>
#include <stdlib.h>

int *buff;
int n;
int flag[21];
int comp[21][21];
int pos[21];
int subtract[100001];
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
            a[k++] = (buff[j] <= a[i] ? buff[j++] : a[i++]);
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

void CompSub(int a[])
{
    int temp[21];
    int pc = 0;
    
    for(int i = 0; i < n; i++)
    {
        if(flag[i] == 0)
        {
            temp[pc++] = i;
        }
    }
    
    int startteam = 0;
    int linkteam = 0;
    
    for(int i = 0; i < n / 2; i++)
    {
        for(int j = 0; j < n / 2; j++)
        {
            startteam += comp[a[i]][a[j]];
        }
    }
    
    for(int i = 0; i < n / 2; i++)
    {
        for(int j = 0; j < n / 2; j++)
        {
            linkteam += comp[temp[i]][temp[j]];
        }
    }
    
    int sub = startteam - linkteam;
    
    if(sub < 0)
        subtract[count++] = sub * -1;
    else
        subtract[count++] = sub;
}

void set(int i)
{
    for(int j = pos[i - 1] + 1; j < n; j++)
    {
        if(flag[j] == 0)
        {
            pos[i] = j;
            if(i == n / 2 - 1)
            {
                flag[j] = 1;
                CompSub(pos);
                flag[j] = 0;
            }
            else
            {
                flag[j] = 1;
                set(i + 1);
                flag[j] = 0;
            }
        }
    }
}

int main(int argc, const char * argv[]) {
    // insert code here...
    
    // 불필요한 계산제거 위해 pos[0]은 0으로 고정
    flag[0] = 1;
    pos[0] = 0;
    
    scanf("%d", &n);
    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < n; j++)
        {
            scanf("%d", &comp[i][j]);
        }
    }
    
    set(1);
    mergesort1(subtract, count);
    
    printf("%d\n", subtract[0]);

    return 0;
}
