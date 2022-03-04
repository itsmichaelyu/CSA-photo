package classes;

public class UrStupidException extends RuntimeException {
    @java.io.Serial
    private static final long serialVersionUID = 6872163983674311267L;

    /**
     * Constructs a {@code StupidException} with no detail message.
     */
    public UrStupidException() {
        super();
    }

    /**
     * Constructs a {@code StupidException} with the specified
     * detail message.
     *
     * @param   s   the detail message.
     */
    public UrStupidException(String s) {
        super(s);
    }

    /**
     * Creates a {@code StupidException} with the specified
     * detail message and cause.
     *
     * @param message the detail message (which is saved for later retrieval
     *        by the {@link #getMessage()} method).
     * @param cause the cause (which is saved for later retrieval by the
     *        {@link #getCause()} method).  (A {@code null} value is permitted,
     *        and indicates that the cause is nonexistent or unknown.)
     * @since 1.5
     */
    public UrStupidException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Creates a {@code StupidException} with the specified cause
     * and a detail message of {@code (cause==null ? null : cause.toString())}
     * (which typically contains the class and detail message of
     * {@code cause}).
     *
     * @param cause the cause (which is saved for later retrieval by the
     *        {@link #getCause()} method).  (A {@code null} value is permitted,
     *        and indicates that the cause is nonexistent or unknown.)
     * @since 1.5
     */
    public UrStupidException(Throwable cause) {
        super(cause);
    }
}