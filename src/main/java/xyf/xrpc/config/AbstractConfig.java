package xyf.xrpc.config;

/**
 * The abstract config that implemented Config
 * 
 * @see xyf.frpc.config.Config
 * 
 * @author xyf
 *
 */
public class AbstractConfig implements Config {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7989845807234206774L;
	
	/**
	 * The id of this config.
	 */
	private String id;

	/**
	 * Get the id of this config.
	 * @return The id of this config.
	 */
	public String getId() {
		return id;
	}

	/** 
	 * Set the id of this config.
	 * @param id The id.
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	


}
