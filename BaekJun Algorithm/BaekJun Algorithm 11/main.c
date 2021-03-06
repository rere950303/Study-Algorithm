//
//  main.c
//  BaekJun Algorithm 11
//
//  Created by hyungwook on 2021/03/06.
//

#include <stdio.h>
#include <stdlib.h>

struct Person {
    int age;
    char s[101];
};

int compare(const void *a, const void *b)
{
    struct Person ** p1 = (struct Person **)a;
    struct Person ** p2 = (struct Person **)b;
    
    return (*p1)->age > (*p2)->age;
}


int main(int argc, const char * argv[]) {
    // insert code here...
    int n = 0;
    struct Person *list[100000];
    
    scanf("%d", &n);
    for(int i = 0; i < n; i++)
    {
        list[i] = malloc(sizeof(struct Person));
        scanf("%d %s", &list[i]->age, list[i]->s);
    }
    
    qsort(list, n, sizeof(struct Person *), compare);
    


    for(int i = 0; i < n; i++)
    {
        printf("%d %s\n", list[i]->age, list[i]->s);
    }

    return 0;
}
