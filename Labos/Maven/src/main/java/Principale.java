import net.sf.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Principale {

    public static void main(String[] args) {
        int x = 5;
        int y = 76;
        System.out.println("X="+x+", Y="+y);
        int temp=x;
        x=y;
        y=temp;
        System.out.println("X="+x+", Y="+y);
    }

    public static JSONObject fromStringToJSON (String json) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(json);;
        return object;

    }


}
