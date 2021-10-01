import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.net.URLEncoder;

public class GetApiData {

    public static CryptocurrencyData getApiData() throws UnirestException {
    String host = "https://api.coindesk.com/v1/bpi/currentprice.json";
    String charset = "UTF-8";

    String query = String.format("s=%s", URLEncoder.encode((charset)));

    HttpResponse<JsonNode> response =
            Unirest.get(host + "?" + query).asJson();

            System.out.print(response);


    JsonParser jp = new JsonParser();

    //retrieve cryptocode from JSON response
    JsonElement jsonChartName = jp.parse(String.valueOf(response.getBody().getObject().get("chartName")));
    String chartName = new Gson().fromJson(jsonChartName, String.class);

    //JsonElement jsonDisclaimer = jp.parse(String.valueOf(response.getBody().getObject().get("disclaimer")));
    //String disclaimer = new Gson().fromJson(jsonChartName, String.class);

    //retrieve price indexes for all currencies from JSON response;
    JsonElement JsonEurBpi = jp.parse(String.valueOf(response.getBody().getObject().getJSONObject("bpi").getJSONObject("EUR")));
    JsonElement JsonGbpBpi = jp.parse(String.valueOf(response.getBody().getObject().getJSONObject("bpi").getJSONObject("GBP")));
    JsonElement JsonUsdBpi = jp.parse(String.valueOf(response.getBody().getObject().getJSONObject("bpi").getJSONObject("USD")));
    CurrencyBPI EurBpi = new Gson().fromJson(JsonEurBpi, CurrencyBPI.class);
    CurrencyBPI GbpBpi = new Gson().fromJson(JsonGbpBpi, CurrencyBPI.class);
    CurrencyBPI UsdBpi = new Gson().fromJson(JsonUsdBpi, CurrencyBPI.class);
    //retrieve timestamps from JSON response;
    JsonElement JsonTime = jp.parse(String.valueOf(response.getBody().getObject().getJSONObject("time")));
    Time time = new Gson().fromJson(JsonTime, Time.class);

    //create CryptocurrencyData object
    CryptocurrencyData cryptocurrencyData = new CryptocurrencyData(chartName, EurBpi, GbpBpi, UsdBpi, time);//, disclaimer);


            /* Gson fun
            Gson gson = new GsonBuilder().create();
            String prettyJsonString = gson.toJson(je);
            System.out.print("\nA TO JEST PRETTYJSON:\n");
            System.out.println(prettyJsonString);
            */
            System.out.println("\n"+ response.getStatus()+"\n");
            System.out.println(response.getHeaders().get("Content-Type")+"\n");

    return cryptocurrencyData;
    }
}
