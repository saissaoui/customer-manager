package tn.tunisiana.customer.client.views;

import java.util.Date;
import java.util.List;

import tn.tunisiana.customer.client.services.IOfferManagerService;
import tn.tunisiana.customer.client.services.IOfferManagerServiceAsync;
import tn.tunisiana.customer.client.views.customui.DatePickerWithYearSelector;
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
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

//import tn.tunisiana.customer.client.services.CustomerManagerService;

public class CustomerForm extends Composite implements HasText {

	@UiField
	Button button;

	@UiField
	DatePickerWithYearSelector birthday, birthdayUtilisateur;
	@UiField
	TextBox nom, prenom, nationalite, tel, email, numId, adresse, ville,
			postcode, autreProfession, nomUtilisateur, prenomUtilisateur,
			nationaliteUtilisateur, adresseUtilisateur, villeUtilisateur,
			postCodeUtilisateur, AutreRaison;

	@UiField
	ListBox gouvernorat, operateur, gouvernoratUtilisateur;

	@UiField
	RadioButton
	// civilité
			mr,
			mme, mlle,
			// type piece identité
			cin, passeport,
			// niveau etudes
			primaire, sec, sup,
			// activité
			sal, liberal, etudiant,
			// usage
			perso, pro, autrui,
			// activité utilisateur
			salUtil, liberalUtil, etudiantUtil,
			// civilité utilisateur
			mUtil, mmeUtil, mlleUtil,
			// achat accompagné
			oui, non,
			// accompagant
			Ami, parents, vendeur,
			// raison achat
			image, prix, qos, offre;

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
		// birthday = new DatePickerWithYearSelector();
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

		offerService.getOffersFor(createCustomer(),
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
		int nowYear = now.getYear();
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

	private CustomerDto createCustomer() {

		CustomerDto customer = new CustomerDto(nom.getText(), prenom.getText(),
				calculateAge(), gouvernorat.getItemText(gouvernorat
						.getTabIndex()), adresse.getText(),
				nationalite.getText(), null, tel.getText(), email.getText(),
				null, numId.getText(), null, null, null,
				nomUtilisateur.getText(), prenomUtilisateur.getText(),
				birthdayUtilisateur.getFirstDate(), null,
				birthday.getFirstDate(), villeUtilisateur.getText(),
				Long.parseLong(postCodeUtilisateur.getText()),
				Long.parseLong(postcode.getText()), null, null, null, null,
				null);

		return customer;
	}

	/*
	 * checkboxes handlers
	 */

	@UiHandler({ "mr", "mme", "mlle" })
	void selectCivilite(ClickEvent event) {

	}

	@UiHandler({ "cin", "passeport", })
	void selectTypeId(ClickEvent event) {

	}

	@UiHandler({ "primaire", "sec", "sup", })
	void selectNivEtud(ClickEvent event) {

	}

	@UiHandler({ "sal", "liberal", "etudiant", })
	void selectActivite(ClickEvent event) {

	}

	@UiHandler({ "perso", "pro", "autrui", })
	void selectUsage(ClickEvent event) {

	}

	@UiHandler({ "salUtil", "liberalUtil", "etudiantUtil", })
	void selectActiviteUtil(ClickEvent event) {

	}

	@UiHandler({ "mUtil", "mmeUtil", "mlleUtil" })
	void selectCiviliteUtil(ClickEvent event) {

	}

	@UiHandler({ "oui", "non" })
	void selectAchatAccompagne(ClickEvent event) {

	}

	@UiHandler({ "Ami", "parents", "vendeur" })
	void selectAccompagnant(ClickEvent event) {

	}

	@UiHandler({ "image", "prix", "qos", "offre" })
	void selectRaisonAchat(ClickEvent event) {

	}
}
