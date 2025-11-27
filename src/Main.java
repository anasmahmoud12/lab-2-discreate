import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Pair {
    public int first;
    public int second;
public Pair(int a,int b){
    first=a;
    second=b;
}
}
public  class Main  {

boolean isPrime(int n){
    if(n==1||n%2==0||n%3==0){
        return  false;
    }
    for (int i=5;i*i<n;i+=6){
        if(n%i==0||n%(i+2)==0){
            return false;
        }
    }
    return true;
}

List<Integer> primesToN(int n){
    boolean [] prime=new boolean[n+1];

for(int i=0;i<n+1;++i){
    prime[i]=true;
}
prime[0]=prime[1]=false;
for (int i=2;i*i<=n;++i){
    if(prime[i]){
        int j=i;
//        System.out.printf("i= %d  j= %d  ",i,j);

        while (j*i<=n){
//             System.out.println(i*j);
            prime[j*i]=false;
            ++j;
        }
    }
}
List<Integer>p=new ArrayList<>();
for (int i=2;i<=n;++i){
    if(prime[i]){
        p.add(i);
    }
}
return p;
}

List<Integer>factorization(int n,List<Integer>factors,List<Integer>primeston,int j){

    for (int i=j;i<primeston.size();++i){
        if(n% primeston.get(i) ==0){
            factors.add(primeston.get(i));
          return factorization(n/primeston.get(i),factors,primeston,i);
        }
    }
    return factors;

}




   List<Pair>factorization2 (int n,List<Pair> factors,List<Integer>primeston,int j){

        for (int i=j;i<primeston.size();++i){
            int a=primeston.get(i);
            if(n%a ==0){
                Pair p=new Pair(a,1);
                if(!factors.isEmpty()){
                    if(factors.getLast().first==a){
                        factors.getLast().second++;
                    }
                    else{
                        factors.add(p);
                    }

                }
                else {
                    factors.add(p);
                }
             return    factorization2(n/a,factors,primeston,i);
            }
        }
        return factors;


    }



int gcd(int a,int b){
    while (b!=0){
        int temp=b;
        b=a%b;
        a=temp;
    }
    return  a;
}

int lcm(int a,int b){
    return (a*b)/this.gcd(a,b);
}




public static void main(String[] args) {

Main obj=new Main();
    Scanner input=new Scanner(System.in);
System.out.println("give me the number to get prime factors ");
int n=input.nextInt();

List<Integer>primeton=obj.primesToN(n);

//for(int i=0;i<primeton.size();++i){
//    System.out.println(primeton.get(i));
//}
    List<Integer> factors=obj.factorization(n,new ArrayList<>(),primeton,0);

//for(int i=0;i<factors.size();++i){
//    System.out.println(factors.get(i));
//}

    List<Pair> factors2=obj.factorization2(n,new ArrayList<>(),primeton,0);

//for(int i=0;i<factors2.size();++i){
//    System.out.printf("%d^%d\n", factors2.get(i).first,  factors2.get(i).second);
////    System.out.println(factors2.get(i).second);
//}

    for(int i=0;i<factors2.size();++i){
        System.out.printf("%d^%d\n", factors2.get(i).first,  factors2.get(i).second);
//    System.out.println(factors2.get(i).second);
    }


    }



}