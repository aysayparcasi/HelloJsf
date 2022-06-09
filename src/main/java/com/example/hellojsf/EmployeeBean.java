package com.example.hellojsf;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.validator.ValidatorException;

@ToString
@ManagedBean
@SessionScoped
@Getter
@Setter
public class EmployeeBean {

    private String empName;
    private String gender;
    private Date dob;
    private String address;
    private String emailAddress;
    private String mobileNumber;
    private String maritalStatus;
    private String designation;
    private String department;
    private boolean employeeType;

    // Validate Email
    public void validateEmail(FacesContext context,UIComponent toValidate, Object value) throws ValidatorException {
        String emailStr = (String) value;
        if ( emailStr.indexOf("@")==-1 ) {
            FacesMessage message = new FacesMessage("E-posta adresi geçerlidir.");
            throw new ValidatorException(message);
        }
    }

    //Action Methods
    public String storedEmployeeInfo() {
        boolean stored = true;
        FacesMessage message = null;
        String outcome = null;
        if(stored){
            message = new FacesMessage("Çalışan Bilgileri Başarıyla kaydedildi.");
            outcome = "success";
        }else{
            message = new FacesMessage("Çalışan Bilgileri Başarıyla KAYDEDİLMEMEKTEDİR.");
            outcome = "employee";
        }
        FacesContext.getCurrentInstance().addMessage(null,message);
        return outcome;
    }






}
