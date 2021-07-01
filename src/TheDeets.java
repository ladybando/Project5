import java.util.Scanner;

public class TheDeets {

    public static void main(String[] argv) {
        testApp();
    }

    public static void testApp() {
        while (true) {
            System.out.print("""
                     \nEnter the information you are searching for -->
                      Zip Code    = zip\s
                      TV Show     = show\s
                      Song/Artist = song\s
                      Wiki Things = wiki\s
                      End Session = quit\s
                     """);
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
        ServiceCommunicator zip = new Zipcode("http://api.zippopotam.us/us/", cmd);
        String result = zip.get();
        PrettyPrint.prettify(result);
    }

    public static void getShow(){
        System.out.print("Enter Show information --> ");
        Scanner user_input = new Scanner(System.in);
        String cmd = user_input.next().replaceAll("\\s", "-");
        ServiceCommunicator show = new Television("http://api.tvmaze.com/singlesearch/shows?q=", cmd);
        String result = show.get();
        PrettyPrint.prettify(result);
    }

    public static void getSong(){
        System.out.print("Enter Song information --> ");
        Scanner user_input = new Scanner(System.in);
        String cmd = user_input.next().replaceAll("\\s", "-");
        ServiceCommunicator song = new Music("https://itunes.apple.com/search?term=", cmd + "&limit=1");
        String result = song.get();
        PrettyPrint.prettify(result);
    }

    public static void getWiki(){
        System.out.print("Enter Wiki search information --> ");
        Scanner user_input = new Scanner(System.in);
        String cmd = user_input.next().replaceAll("\\s", "-");
        ServiceCommunicator wiki = new Wiki("https://en.wikipedia.org/w/api.php?action=query&list=search&srsearch=", cmd + "&format=json");
        String result = wiki.get();
        PrettyPrint.prettify(result);
    }
}
