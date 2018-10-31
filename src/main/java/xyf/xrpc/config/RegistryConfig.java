package xyf.xrpc.config;

import java.util.ArrayList;
import java.util.List;

/**
 * The config of registry, which can config the multi registries with host(or ip) and port, along with it's type(e.g. zookeeper, redis, mysql etc.).
 * @author xyf
 *
 */
public class RegistryConfig extends AbstractConfig {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7715718518557788713L;
	
	/**
	 * The address of a registry.
	 * @author xyf
	 *
	 */
	public static class RegistryAddress
	{
		/**
		 * The host(ip) of registry.
		 */
		private final String host;
		
		/**
		 * The port number of registry.
		 */
		private final int port;
		
		/**
		 * Constructs a registry address.
		 * @param host The host(ip) of registry.
		 * @param port The port number of registry.
		 */
		public RegistryAddress(String host, int port)
		{
			this.host = host;
			this.port = port;
		}
		
		/**
		 * Get the host(ip) of registry.
		 * @return The host(ip) of registry.
		 */
		public String getHost() {
			return host;
		}

		/**
		 * Get the port number of registry
		 * @return The port number of registry.
		 */
		public int getPort() {
			return port;
		}

		
		@Override
		public String toString() {
			return "Registry(" + toUrlFormat() + ")";
		}
		
		/**
		 * Convert to the url format(e.g. 127.0.0.1:2181).
		 * @return The url format of this registry.
		 */
		public String toUrlFormat() {
			return host + ":" + port;
		}
		
		@Override
		public boolean equals(Object o) {
			if(!(o instanceof RegistryAddress))
				return false;
			
			RegistryAddress that = (RegistryAddress)o;
			
			return (this.host == that.host || (this.host != null && this.host.equals(that.host)))
					&& (this.port == that.port);
		}
		
		@Override
		public int hashCode() {
			int res = 17;
			res = res * 31 + (this.host == null ? 0: this.host.hashCode());
			res = res * 31 + this.port;
			return res;
		}
		
	}

	
	
	/**
	 * The type(e.g. zookeeper, redis, mysql etc.) of this registry
	 */
	private String type;
	
	/**
	 * The list of multi registry address.
	 */
	private List<RegistryAddress> addresses;
	

	/**
	 * Get the type of registry.
	 * @return The type of registry.
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Set the type of registry.
	 * @param type The type of registry.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Set the list of the registries.
	 * @param addrs The list adddresses of registries.
	 * @throws IllegalConfigException 
	 */
	public void setAddresses(List<String> addrs) throws IllegalConfigException {
		if(addresses == null) {
			addresses = new ArrayList<RegistryAddress>();
		}
		for(String ad : addrs)
		{
			String host = ad.split(":")[0];
			String port = ad.split(":")[1];
			int iport = Integer.valueOf(port);
			RegistryAddress address = new RegistryAddress(host,iport);
			if(addresses.contains(address)) {
				throw new IllegalConfigException("Can't not config a address twice : " + address);
			}
			else
			{
				addresses.add(address);
			}
		}
	}
	
	/**
	 * Get the list of registry address.
	 * @return The list of registry address.
	 */
	public List<RegistryAddress> getAddresses()
	{
		return addresses;
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder("RegistryConfig(");
		for(RegistryAddress address : addresses) {
			res.append(address);
			res.append(",");
		}
		res.replace(res.length() - 1, res.length(), ")");
		return res.toString(); 
	}
	
}
