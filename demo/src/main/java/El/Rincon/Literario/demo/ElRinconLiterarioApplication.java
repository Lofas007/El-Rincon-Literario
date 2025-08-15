package El.Rincon.Literario.demo;

//import El.Rincon.Literario.demo.servise.ConsumoApi;
import El.Rincon.Literario.demo.servise.Libros;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
@SpringBootApplication
public class ElRinconLiterarioApplication implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

    }
//
//	public static void main(String[] args) {
//		SpringApplication.run(ElRinconLiterarioApplication.class, args);
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		var consumoApi = new ConsumoApi();
//		var json = consumoApi.obtenerDatos("https://gutendex.com/");
//		System.out.println(json);
//	}

//@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GutendexResponse {
    private List<Libros> results;

    public List<Object> getResults() {
        return List.of();
    }
}}
