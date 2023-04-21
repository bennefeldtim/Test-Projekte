import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswortGenerator {
    private String password;

    public void erstellePasswort(String sentence) {
        this.password = "";
        sentence = sentence.replaceAll("[^a-zA-Z ]+", "");
        Pattern pattern = Pattern.compile("\\b(\\w)");
        Matcher matcher = pattern.matcher(sentence);

        while(matcher.find()) {
            if(this.password.length() % 2 == 0) {
                this.password += matcher.group().toLowerCase();
            } else {
                this.password += matcher.group().toUpperCase();
            }
        }
    }

    @Override
    // Umwandlung zu einem String
    public String toString() {
        return this.password;
    }
}
