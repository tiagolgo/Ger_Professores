/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validações;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 *
 * @author tiago
 */
public class DataDoSistema {

    public String getDataAtual() {
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/YYYY");
        return d.format(new Timestamp(System.currentTimeMillis())).toString().replaceAll("/", "");
        
    }
    
//    public void formataDataAtual(){
//        
//    }
}
