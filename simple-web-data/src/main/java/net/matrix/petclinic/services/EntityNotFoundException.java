/**
 *
 */
package net.matrix.petclinic.services;

/**
 * An exception implementation, thrown when a search operation results in entity
 * not found.
 *
 * @author anand.hemadri
 *
 */
public class EntityNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new instance of {@link EntityNotFoundException}.
	 *
	 */
	public EntityNotFoundException() {
		this("");
	}

	/**
	 * Constructs a new instance of {@link EntityNotFoundException}.
	 *
	 * @param message
	 */
	public EntityNotFoundException(String message) {
		super(message);
	}

	/**
	 * Constructs a new instance of {@link EntityNotFoundException}.
	 *
	 * @param cause
	 */
	public EntityNotFoundException(Throwable cause) {
		super(cause);
	}
}
