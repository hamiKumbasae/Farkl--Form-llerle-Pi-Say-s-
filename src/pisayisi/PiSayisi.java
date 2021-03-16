
package pisayisi;

import java.util.Scanner;


public class PiSayisi {
    public static int faktoriyel (int sayi){ // çoğu pi saysı bulan seriler faktoriyel den yararlanır.bu yüzden
                                            // çoğu fonksiyonda çağırılmıştır 
        int fact=1;
    if(sayi==0){
    return 1;
    }
    else {
    int n=sayi;
    while(n>=1){
    
    fact*=n;
    n--;
    }
    
    return fact;
    }}

   public static float piMahdavaSerisi(int terim){
   float pi=0;
   for(int i=0;i<=terim;i++){
   
   pi+=Math.pow(-1, i)/(2*i+1);
   
   
   }
   
   return 4*pi;
   }
   public static double piPlouffleFormülü(int terim){
   double pi = 0;
int n = 0;
while (n < terim)
{
    double a = (1.0/(Math.pow(16.0, n)));
    double b = (4.0/((8.0*n) + 1.0));
    double c = (2.0/((8.0*n) + 4.0));
    double d = (1.0/((8.0*n) + 5.0));
    double e = (1.0/((8.0*n) + 6.0));
    pi += a*( b - c - d - e );
    n++;
}
return pi;
   }
   
   public static double piBellardFormülü(int terim){
  double  pi=0;
  double x=1.0/(double)Math.pow(2,6);
  int n=0;
  while( n<=terim){
  double y=(double)Math.pow(-1,n)/(double)Math.pow(2,10*n);
  double z=Math.pow(2.0, 5.0)/(4.0*n+1.0);
  double t=1.0/(4.0*n+3.0);
  double u=Math.pow(2.0, 8.0)/(10.0*n+1.0);
  double v=Math.pow(2.0, 6.0)/(10.0*n+3.0);
  double a=Math.pow(2.0, 2.0)/(10.0*n+5.0);
  double b=Math.pow(2.0, 2.0)/(10.0*n+7);
  double c=1.0/(10.0*n+9);
  pi+=y*(-1*z-t+u-v-a-b+c);
  n++;
  }
  
  
   return pi*x;
   }
   
   public static double piChudnovskyAlgoritmasi(int terim){
   float pi=1;
   for(int i=0;i<=terim;i++){
   pi+=(float)(Math.pow(-1.0, i)*faktoriyel(6*i)*(13591409+545140134*i))   /(faktoriyel(3*i)*Math.pow(faktoriyel(i), 3)*Math.pow(640320,(3*i+3)/2.0));
   
   }
   pi=(float) (pi*12.0);
   pi=(float) (1.0/pi);
   return pi;
   }
   
   
    public static double piWallisCarpimi(int terim){
    float pi=1;
    for(int i=1;i<=terim;i++){
    pi*=(4*Math.pow(i, 2))/((4*Math.pow(i, 2))-1);
    
    
    
    }
    return 2*pi;
    }
    
    public static double aritmetikGeometrikOrtalamaPi(double diziA[],double diziB[],double diziT[],double diziP[]){
    diziA[0]=1.0;
    diziB[0]=1.0/(double)Math.sqrt(2);
    diziT[0]=1.0/4.0;
    diziP[0]=1.0;
        
    for(int i=1;i<diziA.length;i++){
    diziA[i]=(diziA[i-1]+diziB[i-1])/2;
    diziB[i]=Math.sqrt(diziA[i-1]*diziB[i-1]);
    diziT[i]=diziT[i-1]-diziP[i-1]*Math.pow(diziA[i-1]-diziA[i],2);
    diziP[i]=2*diziP[i-1];
    
    }
    double sonuc=Math.pow(diziA[diziA.length-1]+diziB[diziA.length-1], 2)/(4*diziT[diziA.length-1]);
    
    return sonuc;
    }
    

    public static double piNilakathaSomayaji(int terim){
       int j=2;
      double toplam=0;
      double pi;
        for(int i=1;i<=terim;i++){
        
        if(i%2!=0){
        toplam=toplam+(double)(1.0/(j*(j+1)*(2+j)));
        j=j+2;
        }
        else{
        toplam=toplam-(double)(1.0/(j*(j+1)*(2+j)));
        }
        
        }
        
      pi=(toplam*4.0)+3.0;  
        
    return pi;
    }
     public static double piIsaacNewton(int terim){
     double pi=0;
     double sonuc=0;
     for(int i=0;i<terim;i++){
         sonuc+=faktoriyel(2*i)/(Math.pow(2,4*i+1)*Math.pow(faktoriyel(i),2)*(2*i+1));
     }
     pi=sonuc*6;
     return pi;
     }
    public static void main(String[] args) {
        int terim;
       System.out.println("bir terim sayisi giriniz:");
        Scanner scan=new Scanner(System.in);
        terim=scan.nextInt();
       System.out.println("pi sayisi mahdava serisi ile: "+piMahdavaSerisi(terim));
       System.out.println("pi sayisi plouffle Formülü serisi ile: "+piPlouffleFormülü(terim));
        System.out.println("pi sayisi Bellatd Formülü serisi ile: "+piBellardFormülü(terim));
        System.out.println("pi sayisi Wallis Carpimi ile: "+piWallisCarpimi(terim));
       double diziA[]=new double[terim];
       double diziB[]=new double[terim];
       double diziT[]=new double[terim];
       double diziP[]=new double[terim];
       
       System.out.println("pi sayisi geo-arit ort ile: "+aritmetikGeometrikOrtalamaPi(diziA,diziB,diziT,diziP));
        
       System.out.println("pi sayisi isaca newton ile: "+ piIsaacNewton(terim));
       
        System.out.println("pi sayisi NilakathaSomayaji ile: "+ piNilakathaSomayaji(terim));
    }
    
}
