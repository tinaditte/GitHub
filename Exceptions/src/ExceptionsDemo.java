/**
 * Created by tinab on 17-Mar-17.
 */
public class ExceptionsDemo {

    public static void main(String[] args) {

        try {
            double result = divide(4.5, null);
            System.out.println(result);
        } catch (DivideException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println("Generel besked" + e.toString());
        }
    }

    public static double divide (double a, String b) throws DivideException{
        if(b == null){
            throw new DivideException();
        }
        return a/b.length();
    }
}

//Exception - nullPointerException
//