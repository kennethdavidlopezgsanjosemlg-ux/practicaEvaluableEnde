package modelo;

/**
 * Clase principal abstracta para cada dron. Define la estructura base del dron.
 * 
 * @author kenneth
 * @version v.1.0. 
 * @since 24-02-2026
 */
public abstract class DronGenerico {
	/** Variable para identificar cada dron de forma única */
	private int id;
	/** Variable que indica la autonomía en minutos máxima del dron */
	private int autonomiaMax;
	/** Variable que indica la velocidad máxima que alcanza el dron */
	private int velocidadMax;
	/** Varibale que indica si el dron esta operativo o no */
	private boolean estadoDron;

	/**
	 * Constructor por defecto parametrizado
	 * 
	 * @param id           - identificador único
	 * @param autonomiaMax - duración en mínutos del dron
	 * @param velocidadMax - velocidad pico que alcanza el dron
	 * @param estadoDron   - estado operativo del dron
	 */
	public DronGenerico(int id, int autonomiaMax, int velocidadMax, boolean estadoDron) {
		this.id = id;
		this.autonomiaMax = autonomiaMax;
		this.velocidadMax = velocidadMax;
		this.estadoDron = estadoDron;
	}

	// Métodos

	// Método que indica si el dron esta disponible para uso
	/**
	 * Verifica si el dron está disponible para su uso
	 * 
	 * @throws IllegalStateException Si el dron no está operativo.
	 */
	public void comprobarEstado() {

		if (this.estadoDron) {
			System.out.print("Dron Operativo.");

		} else {
			throw new IllegalStateException("El dron no esta operativo");

		}

	}

	/*
	 * Método abstracto que será implementado por cada tipo de dron específico para
	 * calcular el tiempo de respuesta
	 */
	/**
	 * Método abstracto que se implementara en cada tipo de dron específico, que
	 * indica el tiempo de respuesta
	 */
	public abstract void tiempoRespuesta(int distanciaMision);

	// Getters y Setters

	/**
	 * Obtiene el identificador único del dron
	 * 
	 * @return El id del dron
	 */
	public int getId() {
		return id;
	}

	/**
	 * Define o modifica el identificador único del dron
	 * 
	 * @param id El nuevo identificador
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtiene la autonomía máxima de vuelo del dron
	 * 
	 * @return La autonomía en minutos
	 */
	public int getAutonomiaMax() {
		return autonomiaMax;
	}

	/**
	 * Define o modifica la autonomía máxima de vuelo.
	 * 
	 * @param autonomiaMax La duración en minutos
	 */
	public void setAutonomiaMax(int autonomiaMax) {
		this.autonomiaMax = autonomiaMax;
	}

	/**
	 * Obtiene la velocidad máxima del dron
	 * 
	 * @return La velocidad máxima
	 */
	public int getVelocidadMax() {
		return velocidadMax;
	}

	/**
	 * Define o modifica la velocidad máxima que puede alcanzar el dron
	 * 
	 * @param velocidadMax - nueva La velocidad pico
	 */
	public void setVelocidadMax(int velocidadMax) {
		this.velocidadMax = velocidadMax;
	}

	/**
	 * Indica si el dron se encuentra operativo
	 * 
	 * @return
	 *         <ul>
	 *         <li>true: si está operativo</li>
	 *         <li>false: en caso contrario</li>
	 *         </ul>
	 */
	public boolean isEstadoDron() {
		return estadoDron;
	}

	/**
	 * Actualiza el estado operativo del dron
	 * 
	 * @param estadoDron - El nuevo estado (true para operativo).
	 */
	public void setEstadoDron(boolean estadoDron) {
		this.estadoDron = estadoDron;
	}

}
