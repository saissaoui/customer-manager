package tn.tunisiana.customer.client.views;

import java.util.List;

import tn.tunisiana.customer.shared.model.OfferDto;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.user.client.ui.Widget;

public class OfferBox extends DialogBox implements HasText {

	private static OfferBoxUiBinder uiBinder = GWT
			.create(OfferBoxUiBinder.class);
	private List<OfferDto> offers;
	@UiField
	Label offerLabel;
	@UiField
	Button close;
	@UiField
	StackPanel offersStack;
	@UiField
	Label errorMessage;
	interface OfferBoxUiBinder extends UiBinder<Widget, OfferBox> {
	}

	public OfferBox(List<OfferDto> _offers) {
		
		this.center();
		//this.setWidth("395px");
	
		setWidget(uiBinder.createAndBindUi(this));
		if(_offers!= null){
		this.offers = _offers;
		
		
		for (OfferDto offer : offers)
			offersStack.add(new OfferInfos(offer),offer.getOfferName());
	}
		else {
			
			offersStack.setVisible(false);
			errorMessage.setVisible(true);
		}
		}

	public OfferBox(String firstName) {

	}

	@UiHandler("close")
	void onClick(ClickEvent e) {
		this.hide();
	}

}
