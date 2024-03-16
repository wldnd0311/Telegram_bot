import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class telegram {
    public static void funcTelegram(){

        String Token = "토큰 키";
        String chat_id = "원하는 chat_id";
        String text = "Telegram message Test : ai";

        BufferedReader in = null;

        try {
            URL obj = new URL("https://api.telegram.org/bot" + Token + "/sendmessage?chat_id=" + chat_id + "&text=" + text);

            HttpURLConnection con = (HttpURLConnection)obj.openConnection();
            con.setRequestMethod("GET");
            in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String line;

            while((line = in.readLine()) != null) { // response를 차례대로 출력
                System.out.println(line);
            }

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(in != null) try { in.close(); } catch(Exception e) { e.printStackTrace(); }
        }

    }
    public static void main(String[] args) {
        telegram.funcTelegram();
    }
}