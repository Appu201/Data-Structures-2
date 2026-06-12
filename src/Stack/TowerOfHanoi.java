package Stack;
import java.util.*;
class TowerOfHanoi{
    static Stack<Integer> sor=new Stack<>();
    static Stack<Integer> aux=new Stack<>();
    static Stack<Integer> des=new Stack<>();
    static void changes(Stack<Integer> disk1,Stack<Integer> disk2,char p1,char p2){
        int v1,v2;
        if(disk1.isEmpty()){
            v1=Integer.MIN_VALUE;
        }else{
            v1=disk1.pop();
        }
        if(disk2.isEmpty()){
            v2=Integer.MIN_VALUE;
        }else{
            v2=disk2.pop();
        }
        if(v1==Integer.MIN_VALUE){
            disk1.push(v2);
            System.out.println(p2+" to "+p1);
        }else if(v2==Integer.MIN_VALUE){
            disk2.push(v1);
            System.out.println(p1+" to "+p2);
        }else if(v1<v2){
            disk2.push(v2);
            disk2.push(v1);
            System.out.println(p1+" to "+p2);
        }else{
            disk1.push(v1);
            disk1.push(v2);
            System.out.println(p2+" to "+p1);
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        char s='s',a='a',d='d';
        if(n%2==0){
            char temp=d;
            d=a;
            a=temp;
        }
        int moves=(int)Math.pow(2,n)-1;
        System.out.println("No. of moves: "+moves);
        for(int i=n;i>0;i--){
            sor.push(i);
        }
        for(int i=1;i<=moves;i++){
            if(i%3==1){
                changes(sor,des,s,d);
            }else if(i%3==2){
                changes(sor,aux,s,a);
            }else{
                changes(aux,des,a,d);
            }
        }
    }
}