package xyf.xrpc.config;

/**
 * The exception throwed when get illegal configuration.
 * @author xyf
 *
 */
public class IllegalConfigException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5445621069061353320L;
	
	public IllegalConfigException(String errorMsg) 
	{
		super(errorMsg);
	}

}
