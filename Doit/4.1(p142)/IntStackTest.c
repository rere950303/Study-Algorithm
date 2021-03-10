//
//  IntStackTest.c
//  4.1(p142)
//
//  Created by hyungwook on 2021/03/08.
//

#include <stdio.h>
#include "IntStack.h"

int main(void)
{
    IntStack s;
    if (Initialize(&s, 64) == -1)
    {
        puts("스택 성공에 실패하였습니다.");
        return 1;
    }

    while (1) {
        int menu, x;

        printf("현재 데이터 수 : %d / %d\n", Size(&s), Capacity(&s));
        printf("(1) 푸쉬 (2) 팝 (3) 피크 (4) 클리어 (5) 용량 (6) 크기 (7) 스택비어있느지 (8) 가득찼는지 (9) 검색 (10) 출력 (0) 종료 : ");
        scanf("%d", &menu);
        if (menu == 0) break;
        
        switch (menu) {
        case 1:
            printf("데이터 : ");
            scanf("%d", &x);
            if (Push(&s, x) == -1)
                puts("\a오류 : 푸시에 실패하였습니다.");
            break;
        
        case 2:
            if (Pop(&s, &x) == -1)
                puts("\a오류 : 팝에 실패하였습니다.");
            else
                printf("팝 데이터는 %d입니다.\n", x);
            break;
        
        case 3:
            if (Peek(&s, &x) == -1)
                puts("\a오류 : 피크에 실패하였습니다.");
            else
                printf("피크 데이터는 %d입니다.\n", x);
            break;
                
        case 4:
                Clear(&s);
                printf("클리어하였습니다.\n");
                break;
                
        case 5:
                printf("스택의 용량은 %d입니다.\n", Capacity(&s));
                break;
                
        case 6:
                printf("스택의 현재 크기는 %d입니다.\n", Size(&s));
                break;
                
        case 7:
            if (IsEmpty(&s))
                puts("스택이 비어있습니다.\n");
            else
                printf("스택이 비어있지 않습니다.\n");
            break;
                
        case 8:
            if (IsFull(&s))
                puts("스택이 꽉찼습니다.\n");
            else
                printf("스택이 꽉 차지 않았습니다.\n");
            break;
                
        case 9:
                printf("찾고자 하는 데이터: ");
                scanf("%d", &x);
                
                int idx = Search(&s, x);
                
                if(idx == -1)
                {
                    printf("찾고자 하는 데이터가 스택에 없습니다.\n");
                }
                else
                {
                    printf("%d는 데이터 인덱스 %d에 위치해 있습니다.\n", x, idx);
                }
  
        case 10:
            Print(&s);
            break;
        }
    }

    Terminate(&s);

    return 0;
}
