import org.example.TextProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TextProcessorTest {
    private static TextProcessor textProcessor;

    @BeforeEach
    public void iniciar(){
        textProcessor = new TextProcessor();
    }

    @Test
    void usuarioIngresaTextoValido() {
        String texto = "hola";
        String resultado = textProcessor.reverseAndCapitalize(texto);
        String esperado = "ALOH";

        Assertions.assertEquals(esperado, resultado, "El texto debería invertirse y estar en mayúsculas");
    }

    @Test
    void usuarioIngresaNull() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            textProcessor.reverseAndCapitalize(null);
        });

        String mensaje = "El texto no puede ser nulo";

        Assertions.assertEquals(mensaje, exception.getMessage());
    }

    @Test
    void usuarioIngresaTextoConLongitudIncorrecta() {
        String texto = "a".repeat(1001);

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            textProcessor.reverseAndCapitalize(texto);
        });
        Assertions.assertEquals("El texto excede el límite de 1000 caracteres", exception.getMessage());
    }

    @Test
    public void Usuarioingresatextovacío(){
        String texto = "";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            textProcessor.reverseAndCapitalize(texto);
        });
    }

    @Test
    public void Usuarioingresatextoconfullespacios(){
        String texto = "     ";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            textProcessor.reverseAndCapitalize(texto);
        });
    }

    @Test
    void usuarioIngresaTextoConEspacioAlPrincipioYAlFinal() {
        String texto = "  mundo  ";
        String esperado = "ODNUM";
        String resultado = textProcessor.reverseAndCapitalize(texto);

        Assertions.assertEquals(esperado, resultado);
    }
}
