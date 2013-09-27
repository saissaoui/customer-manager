package tn.tunisiana.customer.client.views;

import tn.tunisiana.customer.shared.model.OfferDto;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class OfferInfos extends Composite implements HasText {
	@UiField
	Label offerLabel;
	@UiField
	Label offerDesc;
	OfferDto offer;

	private static OfferInfosUiBinder uiBinder = GWT
			.create(OfferInfosUiBinder.class);

	interface OfferInfosUiBinder extends UiBinder<Widget, OfferInfos> {
	}

	public OfferInfos(OfferDto _offer) {
		this.offer = _offer;
		initWidget(uiBinder.createAndBindUi(this));
		offerLabel.setText(offer.getOfferName());
		offerDesc.setText(offer.getDescription());
		
	}

	public OfferInfos(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setText(String arg0) {
		// TODO Auto-generated method stub

	}

}
