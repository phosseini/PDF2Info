/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf.to.info;

import java.io.IOException;

/**
 *
 * @author Pedram Hosseini
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // First, we read text from the pdf file
        PDF objPdf = new PDF();
        String pdfText = objPdf.ReadText(System.getProperty("user.dir") + "\\data\\sample_invoice.pdf");
        TextProcessor objTextProc = new TextProcessor();
        System.out.print("Customer Name: " + objTextProc.ExtractFields(pdfText, "company") + "\n");
        System.out.print("Invoice Amount: " + objTextProc.ExtractFields(pdfText, "grand total") + "\n");
    }

}
