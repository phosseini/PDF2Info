# pdf-to-info

In this project, we are going to extract some useful information from PDF documents.

In the following, I am going to explain what we are going to do in this simple project. Let’s say we have a sample invoice document which is in pdf format. All we are going to do is extracting information related to some fields.

## 1- Reading text from PDF file. 
In this project, I used the [PDFBox](https://pdfbox.apache.org/index.html) library to extract text from pdf files. PDFBox library is an open source Java tool for working with PDF documents. We have another tool named [iText](http://itextpdf.com/) which has good features, however, it is not free and that is why I preferred to use PDFBox in this project. 

## 2- Extracting information from text
After reading the text from pdf file, now we are going to extract the information of two fields from our sample pdf file namely including: **Customer Name** and **Invoice Amount**. It is worth pointing out that if the pdf file contains some standard fields, we can use PDFBox to read the fieldType and fieldValue pairs (I have already added this method to the project.) However, since we do not have such fields in current pdf file, I used another method to extract our desired values and information.

## Method pipeline:

### A. Cleaning the text:
First of all we should clean the text that we have already read from our pdf file. For example, the text contains many extra white space and new line characters that should be removed. After cleaning the text, we store all the useful lines of text as different items in a list.

### B. Finding the pairs of field and value:
After creating a cleaned list of all lines, we use regular expression in order to find the specific field that we are looking for and its corresponding value. For example, if we have a line like: "Total Amount: $1,000" by searching "total", "amount", or "total amount" we can find the field and the value associated with it from the pdf file.

## How to run the project:
Download the zip file of the repository, extract the zip file, and then cut and paste the JAR file named `pdf-to-info-v1.0.jar` to the `pdf-to-info` folder where the `data` folder exists. Be sure that you have a pdf file named `sample_invoice.pdf` in your `data` folder. After running the project, you can enter the search keys for two fields. For instance, you can enter `company` for the customer name search key and `total` as the invoice amount search key. Then press `Read Data` and you will see the results. You should have [Java](https://java.com/en/download/) runtime installed on your machine.
