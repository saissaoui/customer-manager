package tn.tunisiana.customer.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IConfManagerServiceAsync {

	void getGouvernorats(AsyncCallback<List<String>> callback);

}
