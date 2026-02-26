package modelo;

// Importacioens
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Pruebas parametrizadas para la clase {@link DronMaritimo}. Verifica el ciclo
 * de vida del dron y el tiempo de respuesta
 */
@RunWith(Parameterized.class)
public class DronMaritimoTestCompleto {

	private static DronMaritimo dron;
	private int distancia;
	private double tiempoEsperado;

	/**
	 * Constructor parametrizado para la prueba completa
	 * 
	 * @param distancia      -Distancia a recorrer en km
	 * @param tiempoEsperado
	 */
	public DronMaritimoTestCompleto(int distancia, double tiempoEsperado) {
		this.distancia = distancia;
		this.tiempoEsperado = tiempoEsperado;
	}

	/**
	 * Creación del dron en memoria antes de la batería de pruebas.
	 */
	@BeforeClass
	public static void BeforeClass() {
		dron = new DronMaritimo(1, 120, 10, false, 80);
		System.out.println("Dron marítimo creado");
	}

	/**
	 * Liberación de memoria tras finalizar todas las pruebas.
	 */
	@AfterClass
	public static void AfterClass() {
		dron = null;
		System.out.println("Memoria del dron liberada ");
	}

	/**
	 * Activar el dron.
	 */
	@Before
	public void Before() {
		dron.setEstadoDron(true);
		System.out.println("Dron operativo para distancia " + distancia);
	}

	/**
	 * Desactivar el dron.
	 */
	@After
	public void After() {
		dron.setEstadoDron(false);
		System.out.println("Dron desactivado ");
	}

	/**
	 * Coleccion de datos a veficar Parámetros de entrada para el dron marítimo:
	 * {distancia, tiempo}
	 */
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 10, 1.0 }, { 20, 2.0 }, { 5, 0.5 } });
	}

	/**
	 * Test para verifica si el dron esta operativo para la misión
	 */
	@Test
	public void testTiempoRespuesta() {
		dron.tiempoRespuesta(distancia);

		assertTrue("El dron debería estar operativo para ir a  la misión", dron.isEstadoDron());
	}
}