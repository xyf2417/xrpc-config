package xyf.xrpc.config;

/**
 * The Application config
 * @author xyf
 */
public class ApplicationConfig extends AbstractConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = -834575415871327104L;
	
	/**
	 * The config of this application.
	 */
	private static ApplicationConfig application;
	
	
	/**
	 * The name of Application.
	 */
	private String applicationName;
	
	/**
	 * Get the name of application.
	 * @return The name of application.
	 */
	public String getApplicationName() {
		return applicationName;
	}
	
	/**
	 * Set the name of application.
	 * @param applicationName The application name.
	 */
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	/**
	 * Get the application of whole app.
	 * @return The application of this app.
	 */
	public static ApplicationConfig getApplication() {
		return application;
	}

	/**
	 * Set the application that represent this app.
	 * @param application The application config.
	 */
	public static void setApplication(ApplicationConfig application) {
		ApplicationConfig.application = application;
	}
	
	@Override
	public String toString() {
		return "Application(" + applicationName + ")";
	}
}
