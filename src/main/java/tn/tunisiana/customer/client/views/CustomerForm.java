package tn.tunisiana.customer.client.views;

import java.util.Date;
import java.util.List;

import tn.tunisiana.customer.client.services.IOfferManagerService;
import tn.tunisiana.customer.client.services.IOfferManagerServiceAsync;
import tn.tunisiana.customer.shared.model.CustomerDto;
import tn.tunisiana.customer.shared.model.OfferDto;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DatePicker;
//import tn.tunisiana.customer.client.services.CustomerManagerService;
import com.sun.org.apache.xerces.internal.impl.dv.xs.YearDV;

public class CustomerForm extends Composite implements HasText {

	@UiField
	Button button;

	@UiField
	DatePicker birthday;

	// private final CustomerManagerServiceAsync custoSrv = GWT
	// .create(CustomerManagerService.class);
	private final IOfferManagerServiceAsync offerService = GWT
			.create(IOfferManagerService.class);
	private static CustomerFormUiBinder uiBinder = GWT
			.create(CustomerFormUiBinder.class);

	interface CustomerFormUiBinder extends UiBinder<Widget, CustomerForm> {
	}

	public CustomerForm() {
		initWidget(uiBinder.createAndBindUi(this));
	}

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
		CustomerDto customer = new CustomerDto();
		customer.setAge(calculateAge());

		offerService.getOffersFor(customer,
				new AsyncCallback<List<OfferDto>>() {

					public void onSuccess(List<OfferDto> offres) {
						OfferBox ob = new OfferBox(offres);
						ob.show();
						System.out.println("nombre offres " + offres.size());

					}

					public void onFailure(Throwable arg0) {
						System.out.println("failure");

					}
				});

		// custoSrv.getOffer(new AsyncCallback<Offer>() {
		// public void onFailure(Throwable caught) {
		// // Show the RPC error message to the user
		// // dialogBox.setText("Remote Procedure Call - Failure");
		// // serverResponseLabel.addStyleName("serverResponseLabelError");
		// // serverResponseLabel.setHTML(SERVER_ERROR);
		// // dialogBox.center();
		// // closeButton.setFocus(true);
		// System.out.println("failure");
		// }
		//
		// public void onSuccess(Offer result) {
		// // dialogBox.setText("Remote Procedure Call");
		// // serverResponseLabel.removeStyleName("serverResponseLabelError");
		// // serverResponseLabel.setHTML(result);
		// // dialogBox.center();
		// // closeButton.setFocus(true);
		// OfferBox ob = new OfferBox(result);
		// ob.getDialogBox().show();
		//
		// }
		// });
	}

	private int calculateAge() {

		Date birthdate = birthday.getFirstDate();
		int day = birthdate.getDay();
		int month = birthdate.getMonth();
		int year = birthdate.getYear();

		Date now = new Date();
		int nowMonth = now.getMonth() + 1;
		int nowYear = now.getYear() + 1900;
		int result = nowYear - year;

		if (month > nowMonth) {
			result--;
		} else if (month == nowMonth) {
			int nowDay = now.getDate();

			if (day > nowDay) {
				result--;
			}
		}
		return result;
	}
}
