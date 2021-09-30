package FunctionalInterface;

public class FTImplementation {
    public void display(int a){
        System.out.println("calling display method " + a);
    }
    public static void call(int a){
        System.out.println("in the call method");
    }

    public static void main(String[] args) {

        FTInterface ft = new FTImplementation()::display;
        ft.display(23);
        FTInterface ft1 = FTImplementation::call;
        ft1.display(32);
    }
}
