package tn.tunisiana.customer.client.views;

import tn.tunisiana.customer.shared.model.Offer;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class OfferBox extends DialogBox implements HasText {

	private static OfferBoxUiBinder uiBinder = GWT
			.create(OfferBoxUiBinder.class);
	private Offer offer;
	@UiField
	DialogBox dialog;
	@UiField
	Button validate;

	interface OfferBoxUiBinder extends UiBinder<Widget, OfferBox> {
	}

	public OfferBox(Offer _offer) {

		dialog = (DialogBox) uiBinder.createAndBindUi(this);
		this.offer = _offer;
		validate.setText(offer.getOfferName());
		
		
	}


	public OfferBox(String firstName) {
		setWidget(uiBinder.createAndBindUi(this));
		validate.setText(firstName);
	}

	@UiHandler("validate")
	void onClick(ClickEvent e) {
		Window.alert("Hello!");
	}

	public void setText(String text) {
		validate.setText(text);
	}

	public String getText() {
		return validate.getText();
	}

	DialogBox getDialogBox() {

		return dialog;
	}
}
