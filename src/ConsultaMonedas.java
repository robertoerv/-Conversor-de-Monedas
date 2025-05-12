import com.google.gson.Gson;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ConsultaMonedas {
    private static String API_KEY;
    static {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("src/resources/config.properties"));
            API_KEY = props.getProperty("api.key");
        } catch (Exception e) {
            System.err.println("Error al cargar la API key: " + e.getMessage());
        }
    }
    public static void consultaMonedas (String baseCode, String targetCode, double cantidadFinal){
        String direccion ="https://v6.exchangerate-api.com/v6/"+API_KEY+"/pair/"+baseCode+"/" +targetCode+ "/"+cantidadFinal;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json =response.body();
            System.out.println("La convercion actual es:");
            Gson gson =new Gson();
            Moneda moneda =gson.fromJson(json, Moneda.class);
            System.out.println("El valor de "+cantidadFinal+" " +moneda.base_code()+" => a "+moneda.target_code()+" es de : "+ moneda.conversion_result());


        } catch (IOException | InterruptedException e) {
            System.out.println("Error al consultar el API: " + e.getMessage());
        }

    }
}


