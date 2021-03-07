//
//  main.c
//  2.7(p75)
//
//  Created by hyungwook on 2021/03/07.
//

#include <stdio.h>

int card_convr(unsigned x, int n, char d[])
{
    char dchar[] = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int digits = 0;
    
    if(x == 0)
    {
        d[digits++] = dchar[0];
    }
    else
    {
        while(x) {
            d[digits] = dchar[x % n];
            x /= n;
            printf("%d|      %d -- %d\n", n, x * n + (d[digits] - '0'), d[digits] - '0');
            printf("  +--------\n");
            digits++;
        }
        printf("        0\n");
    }
    return digits;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int i;
    unsigned no;
    int cd;
    int dno;
    char cno[512];
    int retry;
    puts("10진수를 기수 변환합니다.");
    do {
        printf("변환하는 음이 아닌 정수 : ");
        scanf("%d", &no);
        do {
            printf("어떤 진수로 변환할까요? : ");
            scanf("%d", &cd);
        } while(cd < 2 || cd > 36);
        dno = card_convr(no, cd, cno);
        printf("%d진수로는", cd);
        for(i = dno - 1; i >= 0; i--)
        {
            printf("%c", cno[i]);
        }
        printf("입니다.\n");
        printf("한 번 더 할까요? (1예 0아니요): ");
        scanf("%d", &retry);
    } while(retry == 1);

    return 0;
}
