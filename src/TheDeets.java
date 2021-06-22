import java.util.Scanner;

public class TheDeets {

    public static void main(String[] argv) {
        testApp();
    }

    public static void testApp() {
        while (true) {
         System.out.print("""
                 Enter the information you are searching for -->
                  Zip Code    = zip\s
                  TV Show     = show\s
                  Song/Artist = song\s
                  End Session = quit\s
                 """);
            Scanner user_input = new Scanner(System.in);
            String info = user_input.next();
            if (info.equalsIgnoreCase("zip")) {
                getZipcode();
            }else if(info.equalsIgnoreCase("show")) {
                getShow();
            }else if(info.equalsIgnoreCase("song")){
                getSong();
            }else if (info.equalsIgnoreCase("quit")){
                System.out.println("Session ended");
                System.exit(0);
            }else if (!user_input.equals(info)) {
                System.out.println("Incorrect command entered. Please try again!");
            }
        }
    }

    public static void getZipcode(){
        System.out.print("Enter Zip Code information --> ");
        Scanner user_input = new Scanner(System.in);
        String cmd = user_input.next();
        Zipcode zip = new Zipcode("http://api.zippopotam.us/us/", cmd);
        System.out.println(zip.get());
    }

    public static void getShow(){
        System.out.print("Enter Show information --> ");
        Scanner user_input = new Scanner(System.in);
        String cmd = user_input.next();
        Television show = new Television("http://api.tvmaze.com/singlesearch/shows?q=", cmd);
        System.out.println(show.get());
    }

    public static void getSong(){
        System.out.print("Enter Song information --> ");
        Scanner user_input = new Scanner(System.in);
        String cmd = user_input.next();
        Television song = new Television("https://itunes.apple.com/search?term=", cmd + "&limit=1");
        System.out.println(song.get());
    }
}
