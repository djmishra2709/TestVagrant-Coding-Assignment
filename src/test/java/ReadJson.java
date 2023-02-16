import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.util.Iterator;
public class ReadJson {

    @Test
    public void readjson() {
        int count=0;
        int foreigncount =0;

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("TestJson.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray subjects = (JSONArray) jsonObject.get("player");
            int jsonarraysize = ((JSONArray) jsonObject.get("player")).size();

            for(int i=0;i<jsonarraysize;i++)
            {
                JSONObject records = (JSONObject)  subjects.get(i);
                if(records.get("role").toString().equals("Wicket-keeper"))
                    count=count+1;
                if(!records.get("country").toString().equals("India"))
                    foreigncount=foreigncount+1;
            }
          /*  Iterator iterator = subjects.iterator();

            while (iterator.hasNext())
            {

                System.out.println(iterator.next());

                if(iterator.next().toString().contains("Wicket-keeper"))
                {
                    count=count+1;
                }
                if(!(iterator.next().toString().contains("India")))
                {
                    foreigncount=foreigncount+1;
                }
            }*/
            
            if(count==1)
                System.out.println("There is only one Wicket keeper in list");
            else
                System.out.println("There is more than one Wicket keeper in list");

            if(foreigncount==4)
                System.out.println("There is only 4 foreign players in list");
            else
                System.out.println("There is more than 4 foreign players in list");

        }
        catch (Exception e) {
            System.out.println("There is some error in list");
        }
    }
}
