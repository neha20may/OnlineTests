class ex1{
    public int a=0;
    public void show(){
        System.out.println("a "+a);
    }
    private void show2(){
        System.out.println("a "+a);
    }
}
class ex2 extends ex1{
//    int a=20;

    public void show(){
        System.out.println("childs show a "+a);
    }
}

/**
 * Run-Time Polymorphism: Whenever an object is bound with the functionality at run time, this is known as runtime polymorphism.
 * The runtime polymorphism can be achieved by method overriding. Java virtual machine determines the proper method to call at the runtime, not at the compile time.
 * It is also called dynamic or late binding. Method overriding says the child class has the same method as declared in the parent class. It means if the child class provides the specific implementation of the method that has been provided by one of its parent classes then it is known as method overriding. The following is an example where runtime polymorphism can be observed.
 */
public class Polymorphism {

    public static void main(String[] args) {
        ex1 e1= new ex1();
        ex2 e2=  new ex2();
        e1.show();
        e2.show();

        ex1 e3= new ex2();
        e3.show();
    }
}
