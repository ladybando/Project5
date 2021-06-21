public class Television extends ServiceCommunicator{
    public Television(String serviceURL, String show) {
        super(serviceURL);
        this.show = show;
    }

    private String show;

    public String get(){
        return super.get() + show;
    }
}
