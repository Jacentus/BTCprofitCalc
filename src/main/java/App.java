import java.net.URLEncoder;

import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class App {

    public static void main( String[] args ) {
        App.launch();
    }

    public static void launch(){

                    GUI myMenu = new GUI();
                    myMenu.printWelcomeMessage();

                    while (true){

                            myMenu.displayMenu();
                            myMenu.navigateMenu();

                    }
    }
}
