package Arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Arquivo {

    private String caminhoArquivo;
    private BufferedReader arquivoLeitura;

    //construtor
    public Arquivo() {
    }

    private boolean existe_Lista() {
        File arquivo = new File(this.caminhoArquivo);
        if (arquivo.exists()) {

            try {
                this.arquivoLeitura = new BufferedReader(new FileReader(this.caminhoArquivo));
                return true;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public List<String> lêArquivo(String endereço) {
        this.caminhoArquivo = endereço;
        List<String> cidades = null;
        if (existe_Lista()) {

            String linha;
            cidades = new ArrayList();
            cidades.add("");
            try {
                while ((linha = this.arquivoLeitura.readLine()) != null) {
                    cidades.add(linha);
                }
                this.arquivoLeitura.close();

            } catch (IOException ex) {
                Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cidades;
    }
}
