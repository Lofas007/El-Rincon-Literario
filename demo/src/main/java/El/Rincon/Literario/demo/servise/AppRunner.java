package El.Rincon.Literario.demo.servise;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AppRunner implements CommandLineRunner {

    private final GutendexService gutendexService;
    private final LibroRepository libroRepo;
    private final AutorRepository autorRepo;

    public AppRunner(GutendexService gutendexService, LibroRepository libroRepo, AutorRepository autorRepo) {
        this.gutendexService = gutendexService;
        this.libroRepo = libroRepo;
        this.autorRepo = autorRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Listar todos los libros");
            System.out.println("3. Listar libros por idioma");
            System.out.println("4. Listar autores");
            System.out.println("5. Listar autores vivos en determinado año");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese título: ");
                    String titulo = sc.nextLine();
                    Libros libro = gutendexService.buscarLibroPorTitulo(titulo);
                    if (libro != null) {
                        libroRepo.save(libro);
                        System.out.println("Libro guardado: " + libro);
                    } else {
                        System.out.println("No encontrado.");
                    }
                }
                case 2 -> libroRepo.findAll().forEach(System.out::println);
                case 3 -> {
                    System.out.print("Ingrese idioma (ej: en, es): ");
                    String idioma = sc.nextLine();
                    libroRepo.findByIdioma(idioma).forEach(System.out::println);
                }
                case 4 -> autorRepo.findAll().forEach(System.out::println);
                case 5 -> {
                    System.out.print("Ingrese año: ");
                    int año = sc.nextInt();
                    autorRepo.findByAnioNacimientoBeforeAndAnioFallecimientoAfter(año, año)
                            .forEach(System.out::println);
                }
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }
}

