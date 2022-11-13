/**
 *
 * Found educative course on try catch!! Vow!!
 * https://www.educative.io/courses/java-exception-handling-made-simple
 */
class Exceptions1 {
    public static void run(  ) {

        try{
            throw new ArithmeticException();
        }catch(Exception e){
            System.out.println("Catch");
            throw new NullPointerException();
        }finally{
            System.out.println("Finally");
            throw new NumberFormatException();
        }
    }
}
class Exceptions2 {
    public static void run( ) {

        try{
            throw new NullPointerException(); // exception 1
//            throw new ArithmeticException();  // exception 2 ==>java: unreachable statement; does not compile
        }catch(Exception e){
            System.out.print(e);
        }

    }
}
class Exceptions3 {
    public static void main( String args[] ) {

        try{
            // exception thrown here
            throw new NumberFormatException();
        }catch(Exception e){
            // exception caught here
            System.out.print("A");
        } //--->---->>>>>> below code doesnt compile
//        catch(NumberFormatException e){
//            System.out.print("B");
//            // Unreachable statement here
//        }catch(ArithmeticException e){
//            System.out.print("C");
//            // Unreachable statement here
//        }

    }
}
class Exceptions4 {
    public static void run( ) {
        int a = 1;
        int b = 0;

        try{
            // exception thrown here
            System.out.print(a/b);
        }catch(NullPointerException|ArithmeticException e){
            // exception caught here
            System.out.println(e);
            System.out.println("A");
        }
    }

}

class Exceptions5 {
    public static void run(  ) {
        int months = 5;
        int salary = 0;

        try{
            System.out.print(months/salary); // 5/0 will throw a Arithmetic Exception
        }catch(NullPointerException e){
            System.out.println("Exception caught");
        }finally{ // this is an optional block
            // will always be executed
            System.out.println("Finally executed");
        }
    }
}

class Exceptions6 {
    public static void run() {
        System.out.print("Returned Value is: " + method1());
    }

    public static int method1() {
        int value = 1;
        try {
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            value = 2;
            System.out.println("Exception caught value is " + value);
            return value; // value is being returned inside catch
        } finally {
            value = 3;
            System.out.println("Finally value is now " + value);
            return value; // value is being returned inside finally and it Will Overwrite! rule of finally > rule of return!
        }

    }
}

class Driver{
    public static void main(String[] args) {
        Exceptions1 e1 = new Exceptions1();
        System.out.println("eg 1 ###################");
        try{
            e1.run();
        }
        catch (Exception e){
            System.out.println(e);
        }

        System.out.println("eg 2 ###################");
        Exceptions4.run();

        System.out.println("eg 3 ###################");
        try{
            Exceptions5.run();
        }
        catch (Exception e){
            System.out.println(e);
        }

        System.out.println("eg 4 ###################");
        Exceptions6.run();

    }
}
/**
 * Note: I stumble upon not reachable part of the code; that it doesnt compile if some part of the code is unreachable.
 */

