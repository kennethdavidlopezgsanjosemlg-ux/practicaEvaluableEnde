package modelo;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Clase de pruebas parametrizadas para validar los posible error en el cálculo
 * del tiempo de respuesta de la clase: {@link DronMaritimo}. * Se pruban estos
 * casos: distancias negativas, poca autonomía y estado no operativo.
 * 
 * @author kenneth
 * @since 26-02-2026
 * @version 0.0
 */
@RunWith(Parameterized.class)
public class DronMaritimoTestErrores {
	/** Variable donde se almacena la distancia de cada prueba */
	private int distancia;
	/** Variable donde se alamacena el estado operativo del dron en cada prueba */
	private boolean estadoDron;
	/** Variable donde se almacena el mensaje del error Esperado */
	private String mensajeError;

	/**
	 * Constructor para la prueba de errores
	 * 
	 * @param distancia       -Distancia a recorrer en km
	 * @param estadoDron      -Estado operativo del dron
	 * @param descripcionCaso -Texto para identificar el error esperado
	 */
	public DronMaritimoTestErrores(int distancia, boolean estadoDron, String descripcionCaso) {
		this.distancia = distancia;
		this.estadoDron = estadoDron;
		this.mensajeError = descripcionCaso;
	}

	/**
	 * colección de los casos de prueba que deben producir un error.
	 * 
	 * <li>Casos con valor negativo</li>
	 * <li>Caso por exceso de autonomía</li>
	 * <li>Caso de exceso de autonomía</li>
	 * <li>Caso de dron no operativo</li>
	 */
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { -10, true, "La distancia de la misión no puede ser negativa" }, // valor
																												// negativo
				{ 150090, true, "El tiempo de mision no puede ser menor a la autonomía del dron" }, // Error por exceso
																									// de
																									// tiempo
				{ 20, false, "El dron no esta operativo" } // Estado del drón no operativo
		});
	}

	/**
	 * Test que verifica que el método tiempoRespuesta lance las debidas
	 * excepciones.
	 * <p>
	 * Verifica los erroes: IllegalStateException e IllegalArgumentException y
	 * muestra el mensaje de error por consola.
	 * </p>
	 * 
	 * * @see DronMaritimo#tiempoRespuesta(int)
	 */
	@Test
	public void testTiempoRespuestaDebeLanzarExcepcion() {
		// creamos el objeto
		DronMaritimo dron = new DronMaritimo(1, 60, 50, estadoDron, 5);

		// capturamos el error
		Exception exception = assertThrows(Exception.class, () -> {
			dron.tiempoRespuesta(distancia);
		});

		// verificamos que el mensaje de error es igual al de mensajeError
		assertEquals("El mensaje de error no coincide con el mensaje lanzado", mensajeError, exception.getMessage());

		// verificamos que el mensaje del error no sea nulo
		assertNotNull("La excepción debería tener un mensaje explicativo", exception.getMessage());

		// mostramos los mensajes de error
		System.out.println("Error capturado correctamente: " + exception.getMessage());
	}
}