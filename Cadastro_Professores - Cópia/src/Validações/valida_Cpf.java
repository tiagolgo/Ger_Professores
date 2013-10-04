package Validações;

public class valida_Cpf {

    private String cpf;
    private String verificador;

    public boolean validar(String cpf) {
        this.cpf = cpf;
        if (cpf.length() == 11 & verificar_Dígitos()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean verificar_Dígitos() {
        int dig1 = Integer.parseInt(cpf.substring(0, 1));
        int dig2 = Integer.parseInt(cpf.substring(1, 2));
        int dig3 = Integer.parseInt(cpf.substring(2, 3));
        int dig4 = Integer.parseInt(cpf.substring(3, 4));
        int dig5 = Integer.parseInt(cpf.substring(4, 5));
        int dig6 = Integer.parseInt(cpf.substring(5, 6));
        int dig7 = Integer.parseInt(cpf.substring(6, 7));
        int dig8 = Integer.parseInt(cpf.substring(7, 8));
        int dig9 = Integer.parseInt(cpf.substring(8, 9));

        dig_Verificador1(dig1, dig2, dig3, dig4, dig5, dig6, dig7, dig8, dig9);
        dig_Verificador2(dig1, dig2, dig3, dig4, dig5, dig6, dig7, dig8, dig9);

        if (this.verificador.equals(this.cpf.substring(9))) {
            return true;
        }
        return false;
    }

    private void dig_Verificador1(int dig1, int dig2, int dig3, int dig4, int dig5, int dig6, int dig7, int dig8, int dig9) {
        int d1 = dig1 * 1 + dig2 * 2 + dig3 * 3 + dig4 * 4 + dig5 * 5 + dig6 * 6 + dig7 * 7 + dig8 * 8 + dig9 * 9;

        int resto = d1 % 11;
        if (resto == 10) {
            this.verificador = "0";
        } else {
            this.verificador = String.valueOf(resto);
        }
    }

    private void dig_Verificador2(int dig1, int dig2, int dig3, int dig4, int dig5, int dig6, int dig7, int dig8, int dig9) {
        int d2 = dig1 * 0 + dig2 * 1 + dig3 * 2 + dig4 * 3 + dig5 * 4 + dig6 * 5 + dig7 * 6 + dig8 * 7 + dig9 * 8 + Integer.parseInt(this.verificador) * 9;
        int resto = d2 % 11;
        if (resto == 10) {
            this.verificador = verificador.concat("0");
        } else {
            this.verificador = verificador.concat(String.valueOf(resto));
        }
    }
}
