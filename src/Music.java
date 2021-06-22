public class Music extends ServiceCommunicator {

    public Music(String serviceURL, String song_or_artist) {
        super(serviceURL + song_or_artist);
    }

/*tester method
  public static void main(String[] args) {
        Music song = new Music("https://itunes.apple.com/search?term=","This-Is-What-You-Came-For"+ "&limit=1");
        System.out.println(song.get());
    }*/

}
