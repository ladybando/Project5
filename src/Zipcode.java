public class Zipcode extends ServiceCommunicator{

    public Zipcode(String serviceURL, String zipcode) {
        super(serviceURL);
        this.zipcode = zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    private String zipcode;

    public Zipcode() {
        super();
    }

    public String get(){
        return super.get() + zipcode;
    }
    public static void main(String[] args) {
       Zipcode zip = new Zipcode("http://api.zippopotam.us/us/" , "10011");
       zip.setZipcode("10552");
    }
}
