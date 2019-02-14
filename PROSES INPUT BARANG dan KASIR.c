#include <stdio.h>
#include <stdlib.h>
struct barang{
      char* namabarang;
      int harga;
      int hargajual;
      int kode;
};
int jumlah, a, i;
void menuadmin();
void input_data();
int main(){
      menuadmin();
}
//Yogas EKa Putra
void menuadmin(){
    int pilihan;
    printf(" 1. INPUT DATA BARANG\n");
    printf(" 2. KASIR \n");
    printf("MASUKAN PILIHAN ");
    scanf("%d",&pilihan);
    system("cls");
    if(pilihan == 1){
        printf("FORM INPUT DATA BARANG\n");
        printf("######################\n");
        input_data();
    }else if(pilihan == 2){
        printf("SISTEM KASIR\n");
        printf("######################\n");
    }else{
        printf("TIDAK ADA PILIHAN\n");
    }
}
// VITA JULIANI
void input_data(){
    struct barang arrBarang[20];
       int jumlah, a;
  // clrscr();
   printf("Masukkan jumlah data : ");
   scanf("%d",&jumlah);
   a=0;
   do
   {
      printf("==========================\n");
      printf("Data ke-%d :\n",a+1);
      printf("==========================\n");
      printf("Nama Barang : ");
      scanf("%s",arrBarang[a].namabarang);
      printf("Harga Beli  : ");
      scanf("%d",&arrBarang[a].harga);
      arrBarang[a].hargajual=1.1*arrBarang[a].harga;
      printf("**************************\n");
      printf("Harga Jual  : %d\n",arrBarang[a].hargajual);
      arrBarang[i].kode = arrBarang[i-1].kode + a;
      a++;
   } while (a<jumlah);
   a=0;
   do
   {
      printf("");
      printf("==========================\n");
      printf("==========================\n");
      printf("Data Transaksi ke-%d :\n",a+1);
      printf("==========================\n");
      printf("Nomer       : %d\n",arrBarang[i].kode);
      printf("Nama Barang : %s\n",arrBarang[i].namabarang);
      printf("Harga Beli  : %d\n",arrBarang[i].harga);
      printf("Harga Jual  : %d\n",arrBarang[i].hargajual);
      printf("**************************\n");
      a++;
   } while (a<jumlah);
   getch();
}
