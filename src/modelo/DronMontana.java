package modelo;

/**
 * Clase que representa el tipo de dron montaña. Esta clase extiende de
 * {@link DronGenerico} e incluye la estructura del dron montaña vuelo.
 * 
 * @author kenneth
 * @version 1.0
 * @since 24-02-2026
 */
public class DronMontana extends DronGenerico {
	/**
	 * Varible que indica la altitud máxima del dron, tiene que ser mayor a 0 y se
	 * calcula en metros
	 */
	private double altitud;

	/**
	 * Constructor por defecto parametrizado para el dron montaña
	 * 
	 * @param id           - identificador único
	 * @param autonomiaMax - duración en mínutos del dron
	 * @param velocidadMax - velocidad pico que alcanza el dron
	 * @param estadoDron   - estado operativo del dron
	 * @param altitud      - altitud a la que pueda volar el dron
	 */
	public DronMontana(int id, int autonomiaMax, int velocidadMax, boolean estadoDron, double altitud) {
		super(id, autonomiaMax, velocidadMax, estadoDron);
		this.altitud = altitud;
	}

	/**
	 * Calcula el tiempo de respuesta considerando la altitud de la misión.
	 * 
	 * @param distanciaMision - La distancia de la misión en kilómetros
	 * 
	 * @throws IllegalStateException    Si el dron no está operativo o si el tiempo
	 *                                  calculado es mayor a la autonomía máxima del
	 *                                  dron
	 * @throws IllegalArgumentException Si la distancia es negativa
	 */

	@Override
	public void tiempoRespuesta(int distanciaMision) {

		this.comprobarEstado();

		if (distanciaMision < 0) {
			throw new IllegalArgumentException("La distancia de la misión no puede ser negativa");
		}

		double tiempo = distanciaMision / this.getVelocityMax();

		double tiempoFinal = tiempo * altitud;

		if (tiempoFinal > this.getAutonomiaMax()) {
			throw new IllegalStateException("El tiempo no puede ser mayor a la autonomía máx del dron");
		}

		System.out.println("Misión con tiempo correcto. Tiempo estimado: " + tiempo + " minutos.");

	}

	// Getters y Setters

	/**
	 * Obtiene la altitud máxima del dron
	 * 
	 * @return La altitud en metros
	 */
	public double getAltitud() {
		return altitud;
	}

	/**
	 * Define o modifica la altitud máxima del dron.
	 * 
	 * @param altitud - La nueva altitud, debe ser mayor a 0.
	 */
	public void setAltitud(int altitud) {
		this.altitud = altitud;
	}
}
