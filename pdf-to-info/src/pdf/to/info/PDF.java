/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf.to.info;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.*;
import java.io.File;
import java.util.*;

/**
 *
 * @author phosseini
 */
public class PDF {

    /**
     * Reading text from PDF file
     *
     * @param filePath
     * @return
     * @throws java.io.IOException
     */
    public String ReadText(String filePath) throws IOException {
        PDFTextStripper pdfStripper = new PDFTextStripper();
        return pdfStripper.getText(ReadPDDoc(filePath));
    }

    /**
     * Creating a PDDocument object
     *
     * @param filePath
     * @return
     * @throws java.io.IOException
     */
    private PDDocument ReadPDDoc(String filePath) throws IOException {
        File file = new File(filePath);
        PDFParser parser = new PDFParser(new RandomAccessFile(file, "r")); // update for PDFBox V 2.0
        parser.parse();
        COSDocument cosDoc = parser.getDocument();
        PDFTextStripper pdfStripper = new PDFTextStripper();
        PDDocument pdDoc = new PDDocument(cosDoc);
        pdDoc.getNumberOfPages();
        pdfStripper.setStartPage(1);
        pdfStripper.setEndPage(1);

        // for reading all pages of pdf file
        // pdfStripper.setEndPage(pdDoc.getNumberOfPages());
        return pdDoc;
    }

    /**
     * Reading fields of a PDF file
     *
     * @param filePath
     * @throws java.io.IOException
     */
    public void PdfFields(String filePath) throws IOException {
        PDDocument pdDoc = ReadPDDoc(filePath);
        PDAcroForm form = pdDoc.getDocumentCatalog().getAcroForm();
        if (form != null) {
            List FieldTy = form.getFields();
            PDField pdfFields;
            for (int i = 0; i < FieldTy.size(); i++) {
                pdfFields = (PDField) FieldTy.get(i);
                String fieldNameTyope = pdfFields.getFieldType();
                System.out.println(fieldNameTyope);
            }
        } else {
            System.out.print("There is no standard field in your PDF file.\n");
        }
    }

}
