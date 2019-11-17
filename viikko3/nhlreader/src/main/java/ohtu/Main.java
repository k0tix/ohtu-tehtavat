package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Date;
import java.util.stream.Stream;

import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        
        Date date = new Date();
        System.out.printf("Players from FIN %tc \n\n", date);

        Stream.of(players)
            .filter(p -> p.getNationality().equals("FIN"))
            .sorted((p1, p2) -> p2.getPoints() - p1.getPoints())
            .forEach(p -> System.out.println(p));
    }
  
}
