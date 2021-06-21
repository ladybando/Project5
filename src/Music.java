public class Music extends ServiceCommunicator{
    public Music(String serviceURL, String song) {
        super(serviceURL);
        this.song = song;
    }

    private String song;

    public String get(){
        return super.get() + song;
    }
}
