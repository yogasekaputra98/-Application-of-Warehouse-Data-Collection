#include <stdio.h>
#include <string.h>
void menuadmin();
int main(){
    char username[15];
    char password[12];
    printf("Enter your username = ");
    scanf("%s",&username);

    printf("Enter your password = ");
    scanf("%s",&password);

    if(strcmp(username,"ILHAM")==0){
        if(strcmp(password,"243")==0){
            printf("\nWelcome Login Success!");
            system("cls");
            menuadmin();
        }else{
    printf("\nwrong password");
}
    }else{
    printf("\nUser doesn't exist");
}
    return 0;
}

void menuadmin(){
    int pilihan;
    printf(" 1. INPUT DATA BARANG\n");
    printf(" 2. KASIR \n");
    printf("MASUKAN PILIHAN ");
    scanf("%d",&pilihan);
    system("cls");
    if(pilihan == 1){
        printf("FORM INPUT DATA BARANG");
    }else if(pilihan == 2){
        printf("SISTEM KASIR");
    }else{
        printf("TIDAK ADA PILIHAN");
    }
}
