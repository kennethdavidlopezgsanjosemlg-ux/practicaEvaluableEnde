package modelo;

// importaciones
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DronMontanaTestTiempoRespuesta {
	// variables
	private int distancia;
	private boolean resultadoEsperado;

	// constructor por defecto
	public DronMontanaTestTiempoRespuesta(int distancia, boolean resultadoEsperado) {
		this.distancia = distancia;
		this.resultadoEsperado = resultadoEsperado;
	}

	// Método parametrizado
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 10, true }, // caso normal
				{ 50, true }, // Caso límite
				{ 700, false }, // caso exceso
				{ 0, true }, // debería ser correto
				{ 20, true }, // caso normal
				{ -30, false } // caso con número negativo
		});
	}

	@Test
	public void testTiempoRespuesta() {
		// Creamos el objeto
		DronMontana dron = new DronMontana(1, 60, 50, true, 5);

		// si es true
		if (resultadoEsperado) {
			// llamamos al método
			dron.tiempoRespuesta(distancia);
			// usamos el assert true
			assertTrue("El tiempo de respuesta deberia ser correcto: " + distancia, true);
		} else {
			// Como tenemos dos errores posible usamos el Exception.class que es el padre de
			// IllegalStateException y IllegalArgumentException. De esta forma nos
			// aseguramos
			// que estamos controlando los dos tipos de exception
			Exception exception = assertThrows(Exception.class, () -> dron.tiempoRespuesta(distancia));

		}
	}

}