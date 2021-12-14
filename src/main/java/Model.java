import java.util.ArrayList;
import java.util.Date;

public class Model {
    int char_id;
    String name;
    Date birthday;
    ArrayList<String> occupation;
    String img;
    String status;
    String nickname;
    String portrayed;
    String category;
    ArrayList<Integer> appearance;
    ArrayList<Integer> better_call_saul_appearance;

    public Model(int char_id, String name, Date birthday, ArrayList<String> occupation, String img, String status, String nickname, String portrayed, String category, ArrayList<Integer> appearance, ArrayList<Integer> better_call_saul_appearance) {
        this.char_id = char_id;
        this.name = name;
        this.birthday = birthday;
        this.occupation = occupation;
        this.img = img;
        this.status = status;
        this.nickname = nickname;
        this.portrayed = portrayed;
        this.category = category;
        this.appearance = appearance;
        this.better_call_saul_appearance = better_call_saul_appearance;
    }

    @Override
    public String toString() {
        return "Model{" +
                "char_id=" + char_id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", occupation=" + occupation +
                ", img='" + img + '\'' +
                ", status='" + status + '\'' +
                ", nickname='" + nickname + '\'' +
                ", portrayed='" + portrayed + '\'' +
                ", category='" + category + '\'' +
                ", appearance=" + appearance +
                ", better_call_saul_appearance=" + better_call_saul_appearance +
                '}';
    }
}
