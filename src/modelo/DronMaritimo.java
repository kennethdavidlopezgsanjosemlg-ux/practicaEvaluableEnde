package modelo;

/**
 * Clase hija de DronGenerico que define el tipo de dron Maritimo. Esta clase
 * extiende de {@link DronGenerico} e incluye la estructura del dron marítimo
 * vuelo.
 * 
 * @author kenneth
 * @version 0.0
 * @since 24-02-2025
 */
public class DronMaritimo extends DronGenerico {
	/** Factor de resistencia a la salinidad de rango 0 a 100 */
	private int resistenciaSalinidad;

	/**
	 * Constructor por defecto
	 * 
	 * @param id              - identificador único
	 * @param autonomiaMax    - duración en mínutos del dron
	 * @param velocidadMax    - velocidad pico que alcanza el dron
	 * @param estadoDron      - estado operativo del dron
	 * @param factorSalinidad - indica la resistencia del dron a la salinidad
	 */
	public DronMaritimo(int id, int autonomiaMax, int velocidadMax, boolean estadoDron, int resistenciaSalinidad) {
		super(id, autonomiaMax, velocidadMax, estadoDron);
		this.resistenciaSalinidad = resistenciaSalinidad;
	}

	/**
	 * Calcula el tiempo de respuesta para una misión marítima específica. Si la
	 * resistencia de salinidad es menor a 30 el tiempo aumenta un %20.
	 * 
	 * @param distanciaMision - La distancia del trayecto en kilómetros de la misión
	 * 
	 * @throws IllegalStateException    Si el dron no está operativo o si el tiempo
	 *                                  calculado es mayor la autonomía disponible.
	 * @throws IllegalArgumentException Si la distancia de la misión es negativa.
	 */
	@Override
	public void tiempoRespuesta(int distanciaMision) {

		this.comprobarEstado();

		if (distanciaMision < 0) {
			throw new IllegalStateException("La distancia de la misión no puede ser negativa");
		}

		double tiempo = (double) distanciaMision / this.getVelocityMax();

		if (this.resistenciaSalinidad < 30) {
			tiempo *= 1.20;

		}

		if (tiempo > this.getAutonomiaMax()) {
			throw new IllegalStateException("El tiempo de mision no puede ser menor a la autonomía del dron");

		}

		System.out.println("Misión correcta. Tiempo estimado: " + tiempo + " minutos.");

	}

	/**
	 * Obtiene la resistencia a la salinidad
	 * 
	 * @return Un entero entre 0 y 100.
	 */
	public int getResistenciaSalinidad() {
		return resistenciaSalinidad;
	}

	/**
	 * Define o modifica la resistencia a la salinidad
	 * 
	 * @param resistenciaSalinidad - Nuevo valor de resistencia a la sal
	 */
	public void setResistenciaSalinidad(int resistenciaSalinidad) {
		this.resistenciaSalinidad = resistenciaSalinidad;
	}

}
