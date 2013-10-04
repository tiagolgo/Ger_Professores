/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validações;

/**
 *
 * @author Tiago
 */
public class Valida_Email {

    public Valida_Email(String email) {
        validações(email);
    }

    public String validações(String email) {
        String msn = "";
        int last = email.lastIndexOf("@");
        if (email.indexOf("@") != last || !email.contains("@") || email.substring(last + 1).equals("")) {
            msn = "E-mail inválido!";
        } 
        return msn;
    }
}
