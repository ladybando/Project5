public class Wiki extends ServiceCommunicator{
    public Wiki(String serviceURL, String wiki){
        super(serviceURL + wiki);
    }
}
