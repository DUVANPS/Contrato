import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class GeneradorContrato {
    public void crearContrato(String contratoFileName){

        String contrato = cargarContrato(contratoFileName);
        contrato = remplazrdotos(contrato,"[Nombre del Cliente]", "Ingresa el nombre de la empresa: ");
        contrato = remplazrdotos(contrato,"[Nombre del Desarrollador]", "Ingresa el nombre del empleado: ");
        contrato = remplazrdotos(contrato,"[Dirección del Desarrollador]", "Ingresa el nombre de la ciudad: ");

        System.out.println(contrato);
        guardarAnchivo(contrato);

    }

    private void guardarAnchivo(String contrato) {
        try {
            Path ruta = Paths.get("contratoProcesado.txt");
        }catch (Exception e){
            System.out.println(e);
        }

    }

    private String remplazrdotos(String contrato,String etiqueta, String pregunta) {
        System.out.println(pregunta);
        Scanner teclado = new Scanner(System.in);
        String nombreEmpresa = teclado.nextLine();

        return contrato.replace( etiqueta, nombreEmpresa);

    }

    public String cargarContrato(String fileName){
        String content = " ";

        try {
            Path ruta = Paths.get(fileName);
            List<String> lineas = Files.readAllLines(ruta);
            for(String line: lineas){
                content += line + "\n";
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return content;

    }
}
