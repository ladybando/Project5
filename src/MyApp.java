import java.util.Scanner;
public class MyApp {
    public static void main(String[] argv) {
        testApp();

    }
    public static void testApp() {
//TODO print out information based on user input
        while (true) {

         System.out.print("Enter the information you are searching for > ");
            Scanner user_input = new Scanner(System.in);
            String info = user_input.next();
            if (info.equalsIgnoreCase("zipcode")) {
                getZipcode();
            }else if(info.equalsIgnoreCase("show")) {
                getShow();
            }else if (info.equalsIgnoreCase("quit")){
                System.out.println("Session ended");
                System.exit(0);
            }else if (!user_input.equals(info)) {
                System.out.println("Incorrect command entered. Please try again!");
            }
        }

    }

    public static void getZipcode(){
        System.out.print("Enter Zipcode information > ");
        Scanner user_input = new Scanner(System.in);
        String cmd = user_input.next();
        Zipcode zip = new Zipcode("http://api.zippopotam.us/us/", cmd);
        System.out.println(zip.get());
    }

    public static void getShow(){
        System.out.print("Enter show information > ");
        Scanner user_input = new Scanner(System.in);
        String cmd = user_input.next();
        Television show = new Television("http://api.tvmaze.com/singlesearch/shows?q=", cmd);
        System.out.println(show.get());
    }



}
