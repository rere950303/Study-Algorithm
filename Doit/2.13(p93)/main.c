//
//  main.c
//  2.13(p93)
//
//  Created by hyungwook on 2021/03/07.
//

#include <stdio.h>

typedef struct {
    int y;
    int m;
    int d;
} Date;

int mdays[][12] = {
    { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
    { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }
};

int isleap(int year)
{
    return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
}

Date DateOf(int y, int m, int d)
{
    Date temp;
    
    temp.y = y;
    temp.m = m;
    temp.d = d;
    
    return temp;
}

Date After(Date temp, int n)
{
    while(n > 0)
    {
        temp.d += 1;
        if(temp.d > mdays[isleap(temp.y)][(temp.m) - 1])
        {
            if(temp.m == 12)
            {
                temp.y += 1;
                temp.d = 1;
                temp.m = 1;
            }
            else
            {
                temp.d = 1;
                temp.m += 1;
            }
        }
        n--;
    }
    
    return temp;
}

Date Before(Date temp, int n)
{
    while(n > 0)
    {
        temp.d -= 1;
        if(temp.d <= 0)
        {
            if(temp.m == 1)
            {
                temp.y -= 1;
                temp.d = 31;
                temp.m = 12;
            }
            else
            {
                temp.d = mdays[isleap(temp.y)][temp.m - 2];
                temp.m -= 1;
            }
        }
        n--;
    }
    
    return temp;
}

void Print(Date temp)
{
    printf("%d년 %d월 %d일 입니다.", temp.y, temp.m, temp.d);
}

int main(void)
{
    int n;
    int y, m, d;
    Date x;

    printf("날짜를 입력하세요.\n");
    printf("년 : "); scanf("%d", &y);
    printf("월 : "); scanf("%d", &m);
    printf("일 : "); scanf("%d", &d);

    x = DateOf(y, m, d);

    printf("며칠 앞 / 뒤의 날짜를 구할까요? : ");
    scanf("%d", &n);

    printf("%d 일 뒤의 날짜 : ", n); Print(After(x, n)); putchar('\n');
    printf("%d 일 앞의 날짜 : ", n); Print(Before(x, n)); putchar('\n');

    return 0;
}
