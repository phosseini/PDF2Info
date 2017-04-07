/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symple.project;

import java.io.IOException;

/**
 *
 * @author phosseini
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // First, we read the pdf file
        PDF objPdf = new PDF();
        String pdfText = objPdf.Read(System.getProperty("user.dir") + "\\data\\sample_invoice.pdf");
        System.out.print(pdfText);
    }
    
}
