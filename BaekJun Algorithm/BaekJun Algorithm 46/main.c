//
//  main.c
//  BaekJun Algorithm 46(4949, 균형잡힌 세상)
//  https://www.acmicpc.net/problem/4949
//  Created by hyungwook on 2021/03/28.
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

int Peek(CharStack *s, char *y)
{
    if(s->ptr <= 0)
        return -1;
    *y = s->stk[s->ptr - 2];
    return 0;
}


int main(int argc, const char * argv[]) {
    // insert code here...
    CharStack s;
    char vps[102];
    
    Initialize(&s, 102);

    while(1)
    {
        char y;
        scanf("%[^\n]s", vps);
        
        if (vps[0] == '.' && vps[1] == '\0')
            break;
        
        unsigned long len = strlen(vps);
        
        for(int i = 0; i < len - 1; i++)
        {
            if (vps[i] == '(')
                Push(&s, vps[i]);
            else if (vps[i] == ')')
            {
                Push(&s, vps[i]);
                Peek(&s, &y);
                if(y == '(')
                {
                    Pop(&s);
                    Pop(&s);
                }
            }
            else if (vps[i] == '[')
                Push(&s, vps[i]);
            else if (vps[i] == ']')
            {
                Push(&s, vps[i]);
                Peek(&s, &y);
                if(y == '[')
                {
                    Pop(&s);
                    Pop(&s);
                }
            }
        }
            
            if(Isempty(&s))
                printf("yes\n");
            else
                printf("no\n");

        getchar();
        Clear(&s);
    }

    return 0;
}
