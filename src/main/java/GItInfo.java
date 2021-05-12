import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class GItInfo {
    public static String getInfo(String message, Model model) throws IOException {
        URL url =  new URL("https://api.github.com/users/"+message);

        Scanner in = new Scanner((InputStream) url.getContent());
        String result = "";
        while (in.hasNext()) {
            result +=in.nextLine();
        }
        JSONObject object = new JSONObject(result);
        model.setName(object.getString("name"));
        model.setType(object.getString("type"));


        return result;
    }
}




