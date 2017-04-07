# pdf-to-info

In this project, we are going to extract some useful information from PDF documents.

In the follwoing, I am going to explain what we are going to do in this simple project. Lets say we have a sample invoice document which is in pdf format. All we are going to is extracting information related to some fields.

## 1- Reading text from PDF file. 
In this project, I used the [PDFBox](https://pdfbox.apache.org/index.html) library to extract text from pdf files. PDFBox library is an open source Java tool for working with PDF documents. We have another tool named [iText](http://itextpdf.com/) which has good features, however, it is not free and that is why I prefered to use PDFBox in this project. 

## 2- Extracting information from text
In here, we are going to extract the information of two fields from our sample pdf file namely including: **Customer Name** and **Invoice Amount**
