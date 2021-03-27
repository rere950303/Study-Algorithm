//
//  main.c
//  BaekJun Algorithm 45(9012, 괄호)
//  https://www.acmicpc.net/problem/9012
//  Created by hyungwook on 2021/03/27.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    int max;
    int ptr;
    char *stk;
} CharStack;

int Initialize(CharStack *s, int max)
{
    s->max = max;
    s->ptr = 0;
    s->stk = malloc(sizeof(char) * max);
    
    return 0;
}

void Clear(CharStack *s)
{
    s->ptr = 0;
}

int Push(CharStack *s, char x)
{
    if(s->max <= s->ptr)
        return -1;
    
    s->stk[s->ptr] = x;
    s->ptr++;
    
    return 0;
}

int Pop(CharStack *s)
{
    if(s->ptr == 0)
        return -1;
    
    s->ptr--;
    
    return 0;
}

int Isempty(CharStack *s)
{
    if(s->ptr == 0)
        return 1;
    else
        return 0;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    CharStack s;
    int t;
    char vps[51];
    
    Initialize(&s, 51);

    scanf("%d", &t);
        
    for(int i = 0; i < t; i++)
    {
        int flag = 0;
        int x;
        
        scanf("%s", vps);
        
        unsigned long len = strlen(vps);
        
        for(int j = 0; j < len; j++)
        {
            Push(&s, vps[j]);
            if(vps[j] == ')')
            {
                Pop(&s);
                x = Pop(&s);
                if(x == -1)
                {
                    flag = 1;
                    printf("NO\n");
                    break;
                }
            }
        }
        
        if(flag == 0 && Isempty(&s) == 1)
            printf("YES\n");
        else if(flag == 0 && Isempty(&s) == 0)
            printf("NO\n");
        
        Clear(&s);
    }

    return 0;
}
