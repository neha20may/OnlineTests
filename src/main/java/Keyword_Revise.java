class FinalTest {
    /**
     * variable
     * not static, not final
     * static, not final
     * not static, final
     * static, final
     */

    /**
     * !! Point1: final is final; you cant change the value once intialised.
     */
    public final int a;
    public static final int b = 10;
    int c = 10;

    public void setD(int d) {

        // FinalTest.d = d; bcz this is class variable!
        // or
        this.d = d;
    }

    /**
     * !! Point2:  all objects share static.
     */
    public static int d;

    /**
     * Note:
     * final variable if not intialised directly needs to be intitiased in constructor
     */
    FinalTest(int x) {
        a = x;
    }

    public void showA() {
        System.out.println("a " + a);
    }

//    /** Note:
//     *  Setter on final does not work; its like const!
//     *  @param a
//     */
//    public void setA(int a){
//        this.a= a;
//    }

    public void setC(int c) {
        this.c = c;
    }

    public void showB() {
        System.out.println("b " + b);
    }

    public void showD() {
        System.out.println("d " + d);
    }

    public void showC() {
        System.out.println("c " + c);
    }

}

class FinalTestChild extends FinalTest {

    FinalTestChild() {
        /**
         * Super needs to be first statement in child's constructor!
         */
        super(89);
    }

}

final class example {
    int a = 10;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}

/**
 * final class is final| you cant inherit!!
 */

//class exmaple2 extends example{
//
//        }
class example2 {
    int a = 100;

    public final void showA() {
        System.out.println(a);
    }
    public void showNotFinalA() {
        System.out.println(a);
    }
}
class example3 extends  example2{
    /**
     * you cant override final method!
     */
//    public void showA(){
//        System.out.println(this.a);
//    }
//
    public void showNotFinalA(){
        System.out.println(this.a);
    }
}

class static_ex1{
    public static void show(){
        System.out.println("hi");
    }
}
class static_ex2 extends  static_ex1{
    public static void show(){
        System.out.println("bye");
    }
}

public class Keyword_Revise {

    public static void main(String[] args) {
        FinalTest t = new FinalTest(12);
        t.showA();
        t.showB();
        t.showC();
        t.setC(19);
        t.showC();
        t.setD(100);


        FinalTestChild fc = new FinalTestChild();
        fc.showA();
        fc.showB();
        fc.showC();
        fc.setC(12);
        fc.showC();
        fc.setD(101);
        fc.showD();
        t.showD();
/**
 *  Only those points ;
 *  point 1,  point 2 are essence of final and static, rest of the behaviour is drawn from these points.
 *  Their all combinations !!
 */

        example ex = new example();
        System.out.println(ex.getA());

        example2 ex2 = new example2();
        ex2.showA();

        example3 ex3 = new example3();
        ex3.showA();
        ex3.showNotFinalA();


        static_ex1 sex1= new static_ex1();
        //both object and class can access this!
        sex1.show();
        static_ex1.show();
        static_ex2 sex2 = new static_ex2();
        sex2.show();
        static_ex2.show();
    }
}
