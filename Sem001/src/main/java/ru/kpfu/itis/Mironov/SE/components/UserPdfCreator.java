package ru.kpfu.itis.Mironov.SE.components;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.Mironov.SE.entities.MyUser;
import ru.kpfu.itis.Mironov.SE.services.MyUserService;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Юра on 11.05.2016.
 */
@Component
public class UserPdfCreator {
    @Autowired
    MyUserService myUserService;
    public String pdfCreate() throws DocumentException, IOException {
        String filename = "F:\\users(" + new Date().getTime() + ").pdf";
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();
        document.add(new Paragraph("Users"));
        List<MyUser> users = myUserService.getAll("login");
        if (users != null) {
            PdfPTable t2 = new PdfPTable(4);
            t2.setSpacingBefore(25);
            t2.setSpacingAfter(25);
            PdfPCell c11 = new PdfPCell(new Phrase("Login"));
            t2.addCell(c11);
            PdfPCell c21 = new PdfPCell(new Phrase("Email"));
            t2.addCell(c21);
            PdfPCell c31 = new PdfPCell(new Phrase("Last"));
            t2.addCell(c31);
            PdfPCell c41 = new PdfPCell(new Phrase("Role"));
            t2.addCell(c41);
            for (MyUser user : users) {
                t2.addCell(user.getLogin());
                t2.addCell(user.getEmail());
                t2.addCell(user.getLast() + "");
                t2.addCell(user.getRole());
            }
            document.add(t2);
        }
        document.add(new Paragraph("users: "  + myUserService.getAll().size()));
        document.close();
        return filename;
    }
}
