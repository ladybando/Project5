public class Television extends ServiceCommunicator{
    public Television(String serviceURL, String show) {
        super(serviceURL + show);
    }

/*tester method
    public static void main(String[] args) {
        Television show = new Television("http://api.tvmaze.com/singlesearch/shows?q=","Lovecraft Country");
        System.out.println(show.get());
    }*/
}
