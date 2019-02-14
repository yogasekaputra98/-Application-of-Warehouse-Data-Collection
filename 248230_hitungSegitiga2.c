#include <stdio.h>
#include <stdlib.h>
#include <math.h>

void tukar (double *bil1, double *bil2){
    double temp = 0;
    temp = *bil1;
    *bil1 = *bil2;
    *bil2 = temp;
}

void urut (double *a, double *b, double *c){
    while(!((*a<=*b) && (*b<=*c))){
        if(*a>*b){
            tukar(a, b);
        } else if(*b>*c){
            tukar(b, c);
        }
    }
}

void cekSelisih(double *a, double *b, double *c){
    if((abs(*b-*a)<=0.01) && (abs(*c-*b)>0.01)){
        *a=*b;
    }
    else if ((abs(*c-*b)<=0.01) && (abs(*b-*a)>0.01)){
        *b=*c;
    }
    else if ((abs(*b-*a)<=0.01) && (abs(*c-*b)<=0.01)){
        *a=*b;
        *c=*b;
    }
}

int main(){
    double a, b, c;
    printf("Masukkan panjang sisi-sisi (a, b, c):\n");
    scanf("%lf %lf %lf", &a, &b, &c);
    printf("Panjang sisi asal: %lf %lf %lf\n", a, b, c);
    urut(&a, &b, &c);
    printf("Panjang sisi terurut: %lf %lf %lf\n", a, b, c);
    cekSelisih(&a, &b, &c);
    printf("Panjang sisi terbaru: %lf %lf %lf\n", a, b, c);

    if((a<=0) || (b<=0) || (c<=0)){
        printf("TIDAK DAPAT MEMBANGUN SEGITIGA");
    } else if (a+b<=c){
        printf("TIDAK DAPAT MEMBANGUN SEGITIGA");
    } else{
        if((a==b) && (b==c)){
            printf("SEGITIGA SAMA SISI");
        }else if(((a==b) && (b!=c)) || ((b==c) && (c!=a))){
            printf("SEGITIGA SAMA KAKI");
        }else if(a*a+b*b == c*c){
            printf("SEGITIGA SIKU-SIKU");
        }else{
            printf("SEGITIGA SEMBARANG");
        }
    }
    return 0;
}
