package com.sabina.registry.validators;

import com.sabina.registry.dao.CompanyDAO;

import java.net.URI;
import java.net.URISyntaxException;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("com.sabina.registry.validators.UniqueValidator")
public class UniqueValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext,
                         UIComponent component, Object value)
            throws ValidatorException {

        Object oldValue = ((UIInput) component).getValue();

        if (value == null || value.equals(oldValue)) {
            return;
        }

        String licenseNumber = value.toString();

        CompanyDAO companyDAO = new CompanyDAO();
        companyDAO.isLicenseNumberUnique(licenseNumber);

        if(!companyDAO.isLicenseNumberUnique(licenseNumber)) {
            FacesMessage msg =
                    new FacesMessage("License number validation failed","License number is not unique");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

    }
}