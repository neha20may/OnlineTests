class FinalTest {
    /**
     * variable
     * | not static | not final | normal variable ; example variable: (C)
     * |static      | not final | all object share static. (D)
     * |not static  | final     |you can't change or inherit it. (A)
     * |static      | final     |all objects share plus its constant. (B)
     */

    /**
     * !! Point 1: final is final; you can't change the value once initialised.
     */
    public final int a;
    public static final int b = 10;
    int c = 10;
    /**
     * !! Point 2:  all objects share static.
     */
    public static int d;

    /**
     * Note: final variable if not initialized directly needs to be initialized in constructor
     */
    FinalTest(int x) {
        a = x;
    }

    /**
     * Note:
     * Setter on final does not work; its like const!
     *
     * @param a
     */
//    public void setA(int a){
//        this.a= a;
//    }
    public void setC(int c) {
        this.c = c;
    }

    public void setD(int d) {

        // FinalTest.d = d; bcz this is class variable!
        // or
        this.d = d;
    }

    public void showA() {
        System.out.println("a " + a);
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

    FinalTestChild(int x) {
        /**
         * Super needs to be first statement in child's constructor!
         */
        super(x);
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

class example3 extends example2 {
    /**
     * you cant override final method!
     */
//    public void showA(){
//        System.out.println(this.a);
//    }
//
    public void showNotFinalA() {
        System.out.println(this.a);
    }
}

class static_ex1 {
    public static void show() {
        System.out.println("hi");
    }
}

class static_ex2 extends static_ex1 {
    public static void show() {
        System.out.println("bye");
    }
}

public class Keyword_Revise {

    public static void main(String[] args) {
        /**
         * variable
         * | not static | not final | normal variable ; example variable: (C)
         * |static      | not final | all object share static. (D)
         * |not static  | final     |you can't change or inherit it. (A)
         * |static      | final     |all objects share plus its constant. (B)
         */
        FinalTest t = new FinalTest(12);
        t.showA(); //12
        t.showB();//10
        t.showC();//10
        t.setC(19);
        t.showC();//19
        t.setD(100);
        t.showD();//100<--------

        FinalTestChild fc = new FinalTestChild(80);
        fc.showA(); //80
        fc.showB(); //10
        fc.showC(); //10
        fc.setC(12);
        fc.showC();//12
        fc.showD();//100
        fc.setD(101);
        fc.showD();//101
        t.showD();//101 <---------
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


        static_ex1 sex1 = new static_ex1();
        //both object and class can access this!
        sex1.show();
        static_ex1.show();
        static_ex2 sex2 = new static_ex2();
        sex2.show();
        static_ex2.show();
    }
}
