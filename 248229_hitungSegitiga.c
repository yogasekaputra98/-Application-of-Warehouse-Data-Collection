#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(){
    int a, b, c;
    printf("Masukkan panjang sisi-sisi (a, b, c):\n");
    scanf("%d %d %d", &a, &b, &c);
    if((a<=0) || (b<=0) || (c<=0)){
        printf("TIDAK DAPAT MEMBANGUN SEGITIGA");
    } else if ((a+b<=c) || (b+c<=a) || (c+a<=b)){
        printf("TIDAK DAPAT MEMBANGUN SEGITIGA");
    } else{
        if((a==b) && (b==c)){
            printf("SEGITIGA SAMA SISI");
        }else if(((a==b) && (b!=c)) || ((b==c) && (c!=a)) || ((c==a) && (a!=b))){
            printf("SEGITIGA SAMA KAKI");
        }else if((a*a+b*b == c*c) || (b*b+c*c == a*a) || (c*c+a*a == b*b)){
            printf("SEGITIGA SIKU-SIKU");
        }else{
            printf("SEGITIGA SEMBARANG");
        }
    }
    return 0;
}
