import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class for_if_while {
    public static void main(String[] args) {
        List<Integer> l= new ArrayList<>();
        l.add(1);
        l.add(2);
        /**
         * forEach (takes lamba ()->{})
         *
         */
        l.forEach((x)->{
            System.out.println(x);
        });

        List<Integer> l2= new ArrayList<>(Arrays.asList(1,2,3));
        for(int i=0; i< l2.size(); i++){
            System.out.println(l2.get(i));
        }

        int[] l3= {1,2,3};
        for(int i=0; i< l3.length; i++){
            System.out.println(l2.get(i));
        }
        if(true)
            System.out.println("true");

        int a=1;
        while(a==1){
            System.out.println(a);
            a=2;
        }

        String baby="abc";

        String baby2 = baby;
        String baby3= "abc";
        if(baby==baby2){
            System.out.println("equal");//this
        }else{
            System.out.println("not equal");
        }
        String baby4= new String("abc");
        if(baby3==baby){
            System.out.println("equal");//this
        }else{
            System.out.println("not equal");
        }

        if(baby4 ==baby){
            System.out.println("eq");
        }
        else{
            System.out.println("nt eq");//this
        }

        if(baby4.equals(baby)){
            System.out.println("eq");//this
        }else{
            System.out.println("nt eq");
        }


    }
}
