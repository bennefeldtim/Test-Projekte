#include <stdio.h>
#include <math.h>
#define PI 3.14159265358979323846



void function1() {
    for (int i = 0; i <= 36; i++) {
        double value = PI / 180;
        printf("Winkel: %d Grad => Sinus-Funktionswert: %.3f\n",i*10 ,sin(i*10*value));
    }
}

void function2() {
    int i = 0;
    while (i <= 36) {
        double value = PI / 180;
        printf("Winkel: %d Grad => Sinus-Funktionswert: %.3f\n",i*10 ,sin(i*10*value));
        i++;
    }


}

int main() {
    function1();
    function2();
}