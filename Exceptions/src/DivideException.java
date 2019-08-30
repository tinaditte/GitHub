/**
 * Created by tinab on 17-Mar-17.
 */
public class DivideException extends Exception{

    @Override
    public String toString(){
        return super.toString() + "Du kaldte sikkert divide() med et null objekt";
    }
}
