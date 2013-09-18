package tn.tunisiana.customer.client.views;

import tn.tunisiana.customer.client.services.CustomerManagerService;
import tn.tunisiana.customer.client.services.CustomerManagerServiceAsync;
import tn.tunisiana.customer.shared.model.Offer;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class CustomerForm extends Composite implements HasText {

	private final CustomerManagerServiceAsync custoSrv = GWT
			.create(CustomerManagerService.class);
	private static CustomerFormUiBinder uiBinder = GWT
			.create(CustomerFormUiBinder.class);

	interface CustomerFormUiBinder extends UiBinder<Widget, CustomerForm> {
	}

	public CustomerForm() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Button button;

	public CustomerForm(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		button.setText(firstName);
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		evaluateCustomer();
	}

	public void setText(String text) {
		button.setText(text);
	}

	public String getText() {
		return button.getText();
	}

	private void evaluateCustomer() {

		custoSrv.getOffer(new AsyncCallback<Offer>() {
			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user
				// dialogBox.setText("Remote Procedure Call - Failure");
				// serverResponseLabel.addStyleName("serverResponseLabelError");
				// serverResponseLabel.setHTML(SERVER_ERROR);
				// dialogBox.center();
				// closeButton.setFocus(true);
				System.out.println("failure");
			}

			public void onSuccess(Offer result) {
				// dialogBox.setText("Remote Procedure Call");
				// serverResponseLabel.removeStyleName("serverResponseLabelError");
				// serverResponseLabel.setHTML(result);
				// dialogBox.center();
				// closeButton.setFocus(true);
				OfferBox ob = new OfferBox(result);
				ob.getDialogBox().show();

			}
		});
	}
}
