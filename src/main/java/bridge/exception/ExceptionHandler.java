package bridge.exception;

import bridge.io.writer.Writer;

public class ExceptionHandler {
	
	private static final String EXCEPTION_MESSAGE_FORMAT = "\n[ERROR] %s\n";
	
	private final Writer writer;
	
	public ExceptionHandler(final Writer writer) {
		this.writer = writer;
	}
	
	public void handleException(final RuntimeException exception) {
		writer.write(EXCEPTION_MESSAGE_FORMAT.formatted(exception.getMessage()));
	}
}
