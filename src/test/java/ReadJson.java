import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.util.Iterator;
public class ReadJson {

    @Test
    public void readjson() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("TestJson.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray subjects = (JSONArray) jsonObject.get("player");
            Iterator iterator = subjects.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
