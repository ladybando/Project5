import java.util.Scanner;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

public class TheDeets {

    public static void main(String[] argv) {
        testApp();
    }

    public static void testApp() {
        System.out.print("""
                 Enter the information you are searching for -->
                  Zip Code    = zip\s
                  TV Show     = show\s
                  Song/Artist = song\s
                  Wiki Things = wiki\s
                  End Session = quit\s                  
                 """);
        while (true) {
            Scanner user_input = new Scanner(System.in);
            String info = user_input.next();
            if (info.equalsIgnoreCase("zip")) {
                getZipcode();
            }else if(info.equalsIgnoreCase("show")) {
                getShow();
            }else if(info.equalsIgnoreCase("song")) {
                getSong();
            }else if(info.equalsIgnoreCase("wiki")){
                getWiki();
            }else if (info.equalsIgnoreCase("quit")){
                System.out.println("Session ended");
                System.exit(0);
            }else if (!user_input.equals(info)) {
                System.out.println("Incorrect command entered. Please try again!\n");
            }
        }
    }

    public static void getZipcode(){
        System.out.print("Enter Zip Code information --> ");
        Scanner user_input = new Scanner(System.in);
        String cmd = user_input.next();
        PrettyPrint zip = new PrettyPrint("http://api.zippopotam.us/us/", cmd);
        System.out.println(zip.get());
    }

    public static void getShow(){
        System.out.print("Enter Show information --> ");
        Scanner user_input = new Scanner(System.in);
        String cmd = user_input.next().replaceAll("\\s", "-");
        PrettyPrint show = new PrettyPrint("http://api.tvmaze.com/singlesearch/shows?q=", cmd);
        System.out.println(show.get());
    }

    public static void getSong(){
        System.out.print("Enter Song information --> ");
        Scanner user_input = new Scanner(System.in);
        String cmd = user_input.next().replaceAll("\\s", "-");
        PrettyPrint song = new PrettyPrint("https://itunes.apple.com/search?term=", cmd + "&limit=1");
        System.out.println(song.get());
    }

    public static void getWiki(){
        System.out.print("Enter Wiki search information --> ");
        Scanner user_input = new Scanner(System.in);
        String cmd = user_input.next().replaceAll("\\s", "-");
        PrettyPrint wiki = new PrettyPrint("https://en.wikipedia.org/w/api.php?action=query&list=search&srsearch=", cmd + "&format=json");
        System.out.println(wiki.get());
    }
}
