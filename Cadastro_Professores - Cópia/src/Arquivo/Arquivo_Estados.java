package Arquivo;

import java.util.List;

public class Arquivo_Estados {

    public Arquivo_Estados() {
    }

    public List<String> listaMunicipios(String estado) {
        Arquivo a = new Arquivo();
        switch (estado) {
            case "Acre":
                return a.lêArquivo("Arquivos_Municipios/Acre.txt");
            case "Alagoas":
                return a.lêArquivo("Arquivos_Municipios/Alagoas.txt");
            case "Amapá":
                return a.lêArquivo("Arquivos_Municipios/Amapá.txt");
            case "Amazonas":
                return a.lêArquivo("Arquivos_Municipios/Amazonas.txt");
            case "Bahia":
                return a.lêArquivo("Arquivos_Municipios/Bahia.txt");
            case "Ceará":
                return a.lêArquivo("Arquivos_Municipios/Ceará.txt");
            case "Distrito Federal":
                return a.lêArquivo("Arquivos_Municipios/Distrito_Federal.txt");
            case "Espírito Santo":
                return a.lêArquivo("Arquivos_Municipios/Espirito_Santo.txt");
            case "Goiás":
                return a.lêArquivo("Arquivos_Municipios/Goiás.txt");
            case "Maranhão":
                return a.lêArquivo("Arquivos_Municipios/Maranhão.txt");
            case "Mato Grosso":
                return a.lêArquivo("Arquivos_Municipios/Mato_Grosso.txt");
            case "Mato Grosso do Sul":
                return a.lêArquivo("Arquivos_Municipios/Mato_Grosso_do_Sul.txt");
            case "Minas Gerais":
                return a.lêArquivo("Arquivos_Municipios/Minas_Gerais.txt");
            case "Pará":
                return a.lêArquivo("Arquivos_Municipios/Pará.txt");
            case "Paraíba":
                return a.lêArquivo("Arquivos_Municipios/Paraíba.txt");
            case "Paraná":
                return a.lêArquivo("Arquivos_Municipios/Paraná.txt");
            case "Pernambuco":
                return a.lêArquivo("Arquivos_Municipios/Pernambuco.txt");
            case "Piauí":
                return a.lêArquivo("Arquivos_Municipios/Piauí.txt");
            case "Rio de Janeiro":
                return a.lêArquivo("Arquivos_Municipios/Rio_Grande_do_Norte.txt");
            case "Rio Grande do Norte":
                return a.lêArquivo("Arquivos_Municipios/Rio_Grande_do_Sul.txt");
            case "Rio Grande do Sul":
                return a.lêArquivo("Arquivos_Municipios/Rio_de_Janeiro.txt");
            case "Rondônia":
                return a.lêArquivo("Arquivos_Municipios/Rondônia.txt");
            case "Roraima":
                return a.lêArquivo("Arquivos_Municipios/Roraima.txt");
            case "Santa Catarina":
                return a.lêArquivo("Arquivos_Municipios/Santa_Catarina.txt");
            case "São Paulo":
                return a.lêArquivo("Arquivos_Municipios/Sergipe.txt");
            case "Sergipe":
                return a.lêArquivo("Arquivos_Municipios/São_Paulo.txt");
            case "Tocantins":
                return a.lêArquivo("Arquivos_Municipios/Tocantins.txt");
            default:
                return null;
        }
    }
}
