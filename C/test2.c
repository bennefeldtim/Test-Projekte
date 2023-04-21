#include <stdio.h>

int main() {
    int x = -1;
    while (x < 0) {
        printf("Bitte eine positive Zahl eingeben: ");
        scanf("%d", &x);
    }

    printf("Ausgabe 1:\n");
    function1(x);
    printf("Ausgabe 2:\n");
    function2(x);
    printf("Ausgabe 3:\n");
    function3(x);
}

void function1 (int x) {
    for (int i = 0; i < x; i++) {
        printf("*");
    }
    printf("\n");
}

void function2 (int x) {
    int i = 1;

    while (i <= x) {
        function1(i);
        i++;
    }
}

void function3 (int x) {
    for (int i = 1; i <= x; i++) {
        for (int y = x - i; y > 0; y--) {
            printf(" ");
        }
        function1(2*i-1);
    }
}