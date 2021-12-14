import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");

        String line;
        BufferedReader reader;
        StringBuilder response = new StringBuilder();

        try {
            HttpURLConnection connection =
                    (HttpURLConnection) new URL("https://www.breakingbadapi.com/api/characters").openConnection();
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                response.append(line).append("\n");
            }
            System.out.println(response);
            reader.close();
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Model> list = new ArrayList<Model>();

        JSONArray obj = new JSONArray(response.toString());

        for (Object o : obj) {
            JSONObject ob = (JSONObject) o;
            int char_id = ob.getInt("char_id");
            String name = ob.getString("name");
            Date birthday = null;
            if (!ob.getString("birthday").equals("Unknown")) {
                birthday = new SimpleDateFormat("MM-dd-yyyy").parse(ob.getString("birthday"));

            }

            String img = ob.getString("img");
            String status = ob.getString("status");
            String nickname = ob.getString("nickname");
            String portrayed = ob.getString("portrayed");
            String category = ob.getString("category");
            JSONArray occupation = ob.getJSONArray("occupation");
            ArrayList<String> occupationModel = new ArrayList<String>();
            for (Object o1 : occupation) {
                occupationModel.add(o1.toString());
            }
            JSONArray appearance = ob.getJSONArray("appearance");
            ArrayList<Integer> appearanceModel = new ArrayList<Integer>();
            for (Object a : appearance) {
                appearanceModel.add(Integer.parseInt(a.toString()));
            }
            JSONArray better_call_saul_appearance = ob.getJSONArray("better_call_saul_appearance");
            ArrayList<Integer> better_call_saul_appearanceModel = new ArrayList<Integer>();
            for (Object a : better_call_saul_appearance) {
                better_call_saul_appearanceModel.add(Integer.parseInt(a.toString()));
            }
            Model model = new Model(char_id, name, birthday, occupationModel, img, status, nickname, portrayed, category, appearanceModel, better_call_saul_appearanceModel);
            list.add(model);


        }

        for (Model model : list) {
            System.out.println(model);
        }

    }
}
