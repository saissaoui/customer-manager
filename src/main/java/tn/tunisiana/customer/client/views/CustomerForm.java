package tn.tunisiana.customer.client.views;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;

import tn.tunisiana.customer.client.services.IConfManagerService;
import tn.tunisiana.customer.client.services.IConfManagerServiceAsync;
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

	private CustomerDto customer = new CustomerDto();

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

	private final IConfManagerServiceAsync confService = GWT
			.create(IConfManagerService.class);

	interface CustomerFormUiBinder extends UiBinder<Widget, CustomerForm> {
	}

	public CustomerForm() {
		initWidget(uiBinder.createAndBindUi(this));
		// birthday = new DatePickerWithYearSelector();
		final List<String> gouvsList = null;
		confService.getGouvernorats(new AsyncCallback<List<String>>() {

			public void onSuccess(List<String> gouvs) {
				if (gouvs != null) {
					for (String gouv : gouvs) {
						gouvernorat.addItem(gouv);
						gouvernoratUtilisateur.addItem(gouv);
					}
				}

			}

			public void onFailure(Throwable arg0) {

			}
		});

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
		updateCustomer();

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

	private void updateCustomer() {

		customer.setName(nom.getText());
		customer.setLastname(prenom.getText());
		customer.setAge(calculateAge());
		 customer.setGouvernorat(gouvernorat.getItemText(gouvernorat
		 .getSelectedIndex()));
		customer.setAdress(adresse.getText());
		customer.setCountry(nationalite.getText());
		customer.setPhone(tel.getText());
		customer.setEmail(email.getText());
		customer.setIdNumber(numId.getText());
		customer.setNomUtilisateur(nomUtilisateur.getText());
		customer.setPrenomUtilisateur(prenomUtilisateur.getText());
		customer.setDateNaissanceUtilisateur(birthdayUtilisateur.getFirstDate());
		customer.setDateNaissance(birthday.getFirstDate());
		customer.setVilleUtilisateur(villeUtilisateur.getText());
		// customer.setCodePostalUtilisateur(Long.parseLong(postCodeUtilisateur
		// .getText()));
		customer.setCodePostal(Long.parseLong(postcode.getText()));

	}

	/*
	 * checkboxes handlers
	 */

	@UiHandler({ "mr", "mme", "mlle" })
	void selectCivilite(ClickEvent event) {

		RadioButton source = (RadioButton) event.getSource();
		if (source.isChecked()) {
			customer.setCivilite(source.getText());

		}
	}

	@UiHandler({ "cin", "passeport", })
	void selectTypeId(ClickEvent event) {
		RadioButton source = (RadioButton) event.getSource();

		if (source.isChecked())
			customer.setIdType(source.getText());
	}

	@UiHandler({ "primaire", "sec", "sup", })
	void selectNivEtud(ClickEvent event) {
		RadioButton source = (RadioButton) event.getSource();
		if (source.isChecked())
			;

		// customer.set
	}

	@UiHandler({ "sal", "liberal", "etudiant", })
	void selectActivite(ClickEvent event) {
		RadioButton source = (RadioButton) event.getSource();
		if (source.isChecked())
			customer.setProfession(source.getText());
	}

	@UiHandler({ "perso", "pro", "autrui", })
	void selectUsage(ClickEvent event) {
		RadioButton source = (RadioButton) event.getSource();
		if (source.isChecked())
			customer.setRaisonAchat(Integer.parseInt(source.getFormValue()));
	}

	@UiHandler({ "salUtil", "liberalUtil", "etudiantUtil", })
	void selectActiviteUtil(ClickEvent event) {
		RadioButton source = (RadioButton) event.getSource();
		if (source.isChecked())
			customer.setProfessionUtilisateur(source.getText());
	}

	@UiHandler({ "mUtil", "mmeUtil", "mlleUtil" })
	void selectCiviliteUtil(ClickEvent event) {
		RadioButton source = (RadioButton) event.getSource();
		if (source.isChecked())
			customer.setCiviliteUtilisateur(source.getText());
	}

	@UiHandler({ "oui", "non" })
	void selectAchatAccompagne(ClickEvent event) {
		RadioButton source = (RadioButton) event.getSource();
		if (source.isChecked()) {

			boolean achat = source.getText() == "oui" ? true : false;
			customer.setAchatAccompagne(achat);
		}
	}

	@UiHandler({ "Ami", "parents", "vendeur" })
	void selectAccompagnant(ClickEvent event) {
		RadioButton source = (RadioButton) event.getSource();
		if (source.isChecked())
			customer.setAccompagnant(source.getText());
	}

	@UiHandler({ "image", "prix", "qos", "offre" })
	void selectRaisonAchat(ClickEvent event) {
		RadioButton source = (RadioButton) event.getSource();
		if (source.isChecked())
			customer.setRaisonChoix(source.getText());
	}

}
