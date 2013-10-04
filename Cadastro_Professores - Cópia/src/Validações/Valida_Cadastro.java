/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validações;

import java.util.ArrayList;

/**
 *
 * @author Tiago
 */
public class Valida_Cadastro {

    private StringBuilder msn = new StringBuilder();

    public StringBuilder validar(String nome, String nascimento, String rg, String uf, String emissão, String cpf, String telefone, String email) {
        if (nome.equals("") || nome.equals(" ")) {
            msn.append("Informe o Nome.\n");
        } else {
            try {
                Integer.parseInt(nome);
                msn.append("Nome possui caracteres inválidos.\n");
            } catch (Exception e) {
            }
        }
       
        if (!rg.equals("") || !rg.equals(" ")) {
            try {
                Integer.parseInt(rg);
            } catch (Exception e) {
                msn.append("Insira somente números no RG.\n");
            }
        }
        if (uf.equals("")) {
            msn.append("Informe a UF do RG.\n");
        }
        if (emissão.equals("")) {
            msn.append("Informe a Emissão do RG");
        }
        if (!cpf.equals("00000000000")) {
            if (!cpf.equals("")) {
                if (!new valida_Cpf().validar(cpf)) {
                    msn.append("CPF inválido.\n");
                }
            } else {
                msn.append("CPF vazio.\n");
            }
        }
        if (ver_Telefone(telefone)) {
            msn.append("Insira somente números no Telefone.\n");
        }
        if (ver_Email(email)) {
            msn.append("Email inválido.\n");
        }
        if (!new Valida_Datas().validações(nascimento)) {
            msn.append("Data de nascimento inválida.\n");
        }
        if (!new Valida_Datas().validações(emissão)) {
            msn.append("Data de emissão do RG inválida.\n");
        }
        return msn;
    }

    private boolean ver_Telefone(String fone) {
        if (!fone.equals("")) {
            try {
                Integer.parseInt(fone);
            } catch (Exception e) {
                return true;
            }
        }
        return false;
    }

    public static boolean ver_Email(String email) {
        if (!email.equals("")) {
            int last = email.lastIndexOf("@");
            if (email.indexOf("@") != last || !email.contains("@") || email.substring(last + 1).equals("")) {
                return true;
            } else {
                try {
                    Integer.parseInt(email);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return false;
    }
}
