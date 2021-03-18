package codes.showme.tech.ioc;

public class IocException extends RuntimeException {
    public IocException() {
    }

    public IocException(String message) {
        super(message);
    }

    public IocException(Throwable cause) {
        super(cause);
    }

    public IocException(String message, Throwable cause) {
        super(message, cause);
    }
}
