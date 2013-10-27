package tn.tunisiana.customer.client.validation;

import javax.validation.Validator;

import tn.tunisiana.customer.shared.model.CustomerDto;

import com.google.gwt.core.client.GWT;
import com.google.gwt.validation.client.AbstractGwtValidatorFactory;
import com.google.gwt.validation.client.GwtValidation;
import com.google.gwt.validation.client.impl.AbstractGwtValidator;

public final class SimpleValidatorFactory {//extends AbstractGwtValidatorFactory {

	//@GwtValidation(CustomerDto.class)
	public interface GwtValidator extends Validator {
	}

	//@Override
	public AbstractGwtValidator createValidator() {
		return GWT.create(GwtValidator.class);
	}
}