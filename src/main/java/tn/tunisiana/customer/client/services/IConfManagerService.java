package tn.tunisiana.customer.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("ConfManagerService")
public interface IConfManagerService extends RemoteService {
	
	public List<String> getGouvernorats();
}
