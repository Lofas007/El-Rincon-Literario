package El.Rincon.Literario.demo.servise;
import El.Rincon.Literario.demo.ElRinconLiterarioApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class GutendexService {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Libros buscarLibroPorTitulo(String titulo) throws Exception {
        String url = "https://gutendex.com/books/?search=" + titulo.replace(" ", "%20");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ElRinconLiterarioApplication.GutendexResponse apiResponse = objectMapper.readValue(response.body(), ElRinconLiterarioApplication.GutendexResponse.class);

        if (apiResponse.getResults().isEmpty()) {
            return null;
        }

        Libros libro = (Libros) apiResponse.getResults().get(0);
        // Solo el primer idioma
        if (libro.getIdioma() == null && !apiResponse.getResults().get(0).getClass().isEnum()) {
            libro.getClass(apiResponse.getResults().get(0).getClass());
        }
        return libro;
    }
}

