import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        try {
            view.view();
        }catch (NullPointerException e){
            System.out.println("0 нельзя вводить!");
        }catch (InputMismatchException e){
            System.out.println("Вводить только цифры больше 1 !!");
        }


    }
}
