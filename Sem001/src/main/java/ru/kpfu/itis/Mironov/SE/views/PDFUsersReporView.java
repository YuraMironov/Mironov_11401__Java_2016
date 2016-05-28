package ru.kpfu.itis.Mironov.SE.views;

import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import ru.kpfu.itis.Mironov.SE.entities.MyUser;
import ru.kpfu.itis.Mironov.SE.services.MyUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by Юра on 11.05.2016.
 */
//@Component
public class PDFUsersReporView extends AbstractPdfView {
//    @Autowired
//    private MyUserService myUserService;
//    @Override
    protected void buildPdfDocument(Map<String, Object> model, com.lowagie.text.Document document, com.lowagie.text.pdf.PdfWriter pdfWriter, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
//        document.add(new Paragraph("Users"));
//        List<MyUser> users = myUserService.getAll("login");
//        if (users != null) {
//            PdfPTable t2 = new PdfPTable(4);
//            t2.setSpacingBefore(25);
//            t2.setSpacingAfter(25);
//            PdfPCell c11 = new PdfPCell(new Phrase("Login"));
//            t2.addCell(c11);
//            PdfPCell c21 = new PdfPCell(new Phrase("Email"));
//            t2.addCell(c21);
//            PdfPCell c31 = new PdfPCell(new Phrase("Last"));
//            t2.addCell(c31);
//            PdfPCell c41 = new PdfPCell(new Phrase("Role"));
//            t2.addCell(c41);
//            int price_attr;
//            for (MyUser user : users) {
//                t2.addCell(user.getLogin());
//                t2.addCell(user.getEmail());
//                t2.addCell(user.getLast() + "");
//                t2.addCell(user.getRole());
//            }
//            document.add(t2);
//            document.add(new Paragraph("summ = " + users.size()));
//        }
    }
}
