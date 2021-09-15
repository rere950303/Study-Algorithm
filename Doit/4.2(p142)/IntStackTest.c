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

        printf("현재 데이터 개수 : A:%d B:%d / %d\n", Size(&s, 0), Size(&s, 1), Capacity(&s));
        printf("(1) A푸쉬 (2) A팝 (3) A피크 (4) A출력 (5) A검색 (6) A초기화\n(7) B푸쉬 (8) B팝 (9) B피크 (10) B출력 (11) B검색 (12) B초기화 (0) 종료 : ");
        scanf("%d", &menu);
        if (menu == 0) break;
        
        switch (menu) {
        case 1:
            printf("데이터 : ");
            scanf("%d", &x);
            if (Push(&s, 0, x) == -1)
                puts("\a오류 : 푸시에 실패하였습니다.");
            break;
        
        case 2:
            if (Pop(&s, 0, &x) == -1)
                puts("\a오류 : 팝에 실패하였습니다.");
            else
                printf("팝 데이터는 %d입니다.\n", x);
            break;
        
        case 3:
            if (Peek(&s, 0, &x) == -1)
                puts("\a오류 : 피크에 실패하였습니다.");
            else
                printf("피크 데이터는 %d입니다.\n", x);
            break;
                
        case 4:
            Print(&s, 0);
            break;
                
        case 5:
                printf("찾고자 하는 데이터: ");
                scanf("%d", &x);
                
                int idx0 = Search(&s, 0, x);
                
                if(idx0 == -1)
                {
                    printf("찾고자 하는 데이터가 스택에 없습니다.\n");
                }
                else
                {
                    printf("%d는 데이터 인덱스 %d에 위치해 있습니다.\n", x, idx0);
                }
                
        case 6:
                Clear(&s, 0);
                break;
                
        case 7:
            printf("데이터 : ");
            scanf("%d", &x);
            if (Push(&s, 1, x) == -1)
                puts("\a오류 : 푸시에 실패하였습니다.");
            break;
        
        case 8:
            if (Pop(&s, 1, &x) == -1)
                puts("\a오류 : 팝에 실패하였습니다.");
            else
                printf("팝 데이터는 %d입니다.\n", x);
            break;
        
        case 9:
            if (Peek(&s, 1, &x) == -1)
                puts("\a오류 : 피크에 실패하였습니다.");
            else
                printf("피크 데이터는 %d입니다.\n", x);
            break;
                    
        case 10:
            Print(&s, 1);
            break;
                    
        case 11:
                printf("찾고자 하는 데이터: ");
                scanf("%d", &x);
                
                int idx1 = Search(&s, 1, x);
                
                if(idx1 == -1)
                {
                    printf("찾고자 하는 데이터가 스택에 없습니다.\n");
                }
                else
                {
                    printf("%d는 데이터 인덱스 %d에 위치해 있습니다.\n", x, idx1);
                }
                    
        case 12:
                Clear(&s, 1);
                break;
        }
    }

    Terminate(&s);

    return 0;
}
