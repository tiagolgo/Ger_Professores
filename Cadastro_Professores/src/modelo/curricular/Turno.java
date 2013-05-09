package modelo.curricular;

public enum Turno {

    MANHÃ, TARDE, NOITE, INTEGRAL;

    @Override
    public String toString() {
        switch (this) {
            case MANHÃ:
                return "Manhã";
            case TARDE:
                return "Tarde";
            case NOITE:
                return "Noite";
            case INTEGRAL:
                return "Integral";
            default:
                return null;
        }
    }
}
