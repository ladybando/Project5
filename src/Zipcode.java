public class Zipcode extends ServiceCommunicator{
    public Zipcode(String serviceURL, String zipcode) {
        super(serviceURL + zipcode);
    }
    public Zipcode() {}

/*public static void main(String[] args) {
        Zipcode zip = new Zipcode("http://api.zippopotam.us/us/", "10553");
        System.out.println(zip.get());
    }*/
}
