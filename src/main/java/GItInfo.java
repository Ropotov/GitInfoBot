import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class GItInfo {
    public static String getInfo(String message, Model model) throws IOException {

        URL url = new URL("https://api.github.com/users/" + message);

        Scanner in = new Scanner((InputStream) url.getContent());
        String result = "";

        while (in.hasNext()) {
            result += in.nextLine();
        }
        try {
            JSONObject object = new JSONObject(result);
            model.setName(object.getString("name"));
            model.setAvatar(object.getString("avatar_url"));
            model.setEmail(object.getString("email"));
            model.setPublicRepos(object.getInt("public_repos"));
            model.setFollowers(object.getInt("followers"));
            model.setFollowing(object.getInt("following"));

        } catch (JSONException e) {

        }

        return "Имя: " + model.getName() + "\n" + "Email: " + model.getEmail() + "\n"+ "Публичных репозиториев: " + model.getPublicRepos()+"\n"
                +"Подписчики : " + model.getFollowers()+"\n"+"Подписки : " + model.getFollowing()+"\n"+model.getAvatar();


    }
}

