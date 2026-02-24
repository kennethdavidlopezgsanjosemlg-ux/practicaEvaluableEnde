package modelo;

public class DronMontana extends DronGenerico {
	/**
	 * Varible que indica la altitud en al puede volar en dron, tiene que ser mayor
	 * a 0
	 */
	private int altitud;

	/**
	 * Constructor por defecto parametrizado para el dron montaña
	 * 
	 * @param id           - identificador único
	 * @param autonomiaMax - duración en mínutos del dron
	 * @param velocidadMax - velocidad pico que alcanza el dron
	 * @param estadoDron   - estado operativo del dron
	 * @param altitud      - altitud a la que pueda volar el dron
	 */
	public DronMontana(int id, int autonomiaMax, int velocidadMax, boolean estadoDron, int altitud) {
		super(id, autonomiaMax, velocidadMax, estadoDron);
		this.altitud = altitud;
	}

	@Override
	public void tiempoRespuesta(int distanciaMision) {
		// TODO Auto-generated method stub

		if (!this.isEstadoDron()) {
			System.out.println("El dron no esta operativo");
			return;
		}

		int tiempo = distanciaMision / this.getVelocityMax();

		int tiempoFinal = tiempo * altitud;

		if (tiempoFinal > this.getAutonomiaMax()) {
			throw new IllegalStateException("El tiempo no puede ser mayor a la autonomía máx del dron");
		}

		if (distanciaMision < 0) {
			throw new IllegalArgumentException("La distancia de la misión no puede ser negativa");
		}

	}

}
