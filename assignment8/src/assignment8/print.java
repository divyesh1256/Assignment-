package assignment8;

import java.awt.Graphics2D;
import java.io.FileOutputStream;
import java.io.PipedWriter;

import javax.swing.JFrame;

import org.jdom.Document;

import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

public class print {
public static void main(String args[])
{
	
}


public  print(JFrame bill)
{
	try
	{
		com.itextpdf.text.Document d=new com.itextpdf.text.Document();
		PdfWriter w=PdfWriter.getInstance(d, new FileOutputStream("E:\\sample.pdf"));
		d.open();
		
		 PdfContentByte cb = w.getDirectContent( );
		float height = 0;
		float width = 0;
		PdfTemplate template = cb.createTemplate(width, height);
        Graphics2D g2d = template.createGraphics(width, height);
        bill.print(g2d);
        bill.addNotify();
        bill.validate();
        g2d.dispose();

        d.close ();
		
	}catch(Exception e)
	{
		
	}
}}
