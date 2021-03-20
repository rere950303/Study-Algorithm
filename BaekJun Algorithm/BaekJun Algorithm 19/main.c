//
//  main.c
//  BaekJun Algorithm 19
//
//  Created by hyungwook on 2021/03/19.
//

#include <stdio.h>
#include <stdlib.h>

int *buff;

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

int main(int argc, const char * argv[]) {
    // insert code here...
    int n = 0;
    int arr[500001];
    int index[8001] = {0};
    int flag = 0;
    int most;

    scanf("%d", &n);
    for(int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
        index[arr[i] + 4000]++;
    }
    
    mergesort1(arr, n);
    
    int max = index[0];
    
    for(int i = 1; i < 8001; i++)
    {
        if(max < index[i])
        {
            max = index[i];
            flag = 0;
        }
        else if(max == index[i])
        {
            flag++;
        }
    }
    
    if(flag == 0)
    {
        for(int i = 0; i < 8001; i++)
        {
            if(index[i] == max)
            {
                most = i - 4000;
                break;
            }
        }
    }
    
    else
    {
        int j;
        
        for(int i = 0; i < 8001; i++)
        {
            if(index[i] == max)
            {
                j = i;
                break;
            }
        }
        for(int k = j + 1; k < 8001; k++)
        {
            if(index[k] == max)
            {
                most = k - 4000;
                break;
            }
        }
    }

    int sum = 0;
    
    for(int i = 0; i < n; i++)
    {
        sum += arr[i];
    }
        
    printf("%.0f\n", (double)sum / n);
    printf("%d\n", arr[(n - 1) / 2]);
    printf("%d\n", most);
    printf("%d\n", arr[n - 1] - arr[0]);

    return 0;
}
