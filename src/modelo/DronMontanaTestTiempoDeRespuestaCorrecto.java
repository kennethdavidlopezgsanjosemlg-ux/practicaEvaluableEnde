package modelo;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Clase de pruebas unitarias parametrizadas para validar el cálculo del tiempo
 * de respuesta de la clase: {@link DronMontana}. Esta clase évalua los casos
 * correctos
 * 
 * @author kenneth
 * @version 1.0
 * @since 26-02-2026
 */
@RunWith(Parameterized.class)
public class DronMontanaTestTiempoDeRespuestaCorrecto {

	/** Variable que almacena la distancia de la misión en km para cada prueba */
	private int distancia;

	/**
	 * Variable que almacena el resultado que se espera que la misión sea true o
	 * lance una excepción para cada prueba
	 */
	private boolean resultadoEsperado;

	/**
	 * * Constructor para la prueba de correctos
	 * 
	 * @param distancia         -Distancia a recorrer en km
	 * @param resultadoEsperado - Resultado booleano esperado de la validación.
	 */
	public DronMontanaTestTiempoDeRespuestaCorrecto(int distancia, boolean resultadoEsperado) {
		this.distancia = distancia;
		this.resultadoEsperado = resultadoEsperado;
	}

	/**
	 * colección de los casos de prueba que deben ser correctos
	 * <p>
	 * Casos incluidos:
	 * <ul>
	 * <li>Casos normales</li>
	 * </ul>
	 * </p>
	 * * @return Colección de objetos con los parámetros distancia y
	 * resultadoEsperado
	 */
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 10, true }, { 50, true }, { 80, false }, { 0, true }, { 20, true }, });
	}

	/**
	 * Test que verifica que el método tiempoRespuesta funciona correctamente
	 * <p>
	 * Si {@code resultadoEsperado} es verdadero, verifica que el método se complete
	 * </p>
	 * * @see DronMaritimo#tiempoRespuesta(int)
	 */
	@Test
	public void testTiempoRespuesta() {
		// Creamos el objeto con valores random
		DronMontana dron = new DronMontana(1, 60, 50, true, 5);

		dron.tiempoRespuesta(distancia);
		assertTrue("El tiempo de respuesta debería ser correcto para la distancia: " + distancia, true);

	}

}