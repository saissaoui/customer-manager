package tn.tunisiana.customer.server.services;

import java.util.List;

import tn.tunisiana.customer.client.services.IConfManagerService;
import tn.tunisiana.customer.util.GlobalConf;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ConfManagerServiceImpl extends RemoteServiceServlet implements
		IConfManagerService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1635684379022456397L;

	/**
	 * 
	 */

	public List<String> getGouvernorats() {

		return GlobalConf.getGouvernorats();
	}

}
