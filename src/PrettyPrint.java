import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.HashMap;

public class PrettyPrint extends ServiceCommunicator{
    public PrettyPrint(String serviceURL, String param){
        super(serviceURL + param);
        try {
            String str = new ServiceCommunicator(serviceURL + param).get();
            HashMap<String, Object> obj_map = new ObjectMapper().readValue(str, HashMap.class);
            for (String obj : obj_map.keySet()) {
                System.out.println(obj + ": " + obj_map.get(obj));
            }
        } catch (JsonProcessingException jpe) {
            jpe.getMessage();
        } catch(IOException ie){
            ie.printStackTrace();
        }
    }


    public static void main(String[] args) {
        System.out.println(new PrettyPrint("http://api.zippopotam.us/us/" , "10553"));
        System.out.println(new PrettyPrint("https://itunes.apple.com/search?term=" , "bbking" + "\\&limit=1"));
        System.err.println("==================================");
        System.out.println(new PrettyPrint("http://api.tvmaze.com/singlesearch/shows?q=","Lovecraft Country"));
    }
}
