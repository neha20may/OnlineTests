/**
 *
 * Found educative course on try catch!! Vow!!
 * https://www.educative.io/courses/java-exception-handling-made-simple
 */
class Exceptions {
    public static void main( String args[] ) {

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

