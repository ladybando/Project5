import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.HashMap;

public class PrettyPrint {
    public PrettyPrint() {
    }

    public static String prettify(String result) {
        try {
            HashMap<String, Object> obj_map = new ObjectMapper().readValue(result, HashMap.class);
            for (String obj : obj_map.keySet()) {
                System.out.println(obj + ": " + obj_map.get(obj));
            }
        } catch (JsonProcessingException jpe) {
            jpe.getMessage();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        return result;
    }


/*    public static void main(String[] args) {
        ServiceCommunicator z = new Zipcode("http://api.zippopotam.us/us/", "10553");
        String result = z.get();
        PrettyPrint.prettify(result);
        System.out.println("============================================================");
        ServiceCommunicator m = new Music("https://itunes.apple.com/search?term=", "bbking" + "\\&limit=1");
        String results = m.get();
        PrettyPrint.prettify(results);
        System.err.println("====================================================");
        ServiceCommunicator t = new Television("http://api.tvmaze.com/singlesearch/shows?q=", "Lovecraft Country");
        String resultss = t.get();
        PrettyPrint.prettify(resultss);
        ServiceCommunicator w = new Wiki("https://en.wikipedia.org/w/api.php?action=query&list=search&srsearch=", "orange" + "&format=json");
        String res= w.get();
        PrettyPrint.prettify(res);
    }*/
}
