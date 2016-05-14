package ru.kpfu.itis.Mironov.SE.controllers;

import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.Mironov.SE.components.UserPdfCreator;
import ru.kpfu.itis.Mironov.SE.entities.*;
import ru.kpfu.itis.Mironov.SE.services.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by Юра on 07.05.2016.
 */

@Controller
@RequestMapping("/{path:admin}")
public class AdminPageController {
    @Autowired
    MyUserService myUserService;
    @Autowired
    ClaimTarifService claimTarifService;
    @Autowired
    TarifsService tarifsService;
    @Autowired
    private FirmService firmService;
    @Autowired
    PhoneService phoneService;
    @Autowired
    AdviceService adviceService;
    @Autowired
    private NewsesService newsesService;
    @Autowired
    UserPdfCreator userPdfCreator;


    @RequestMapping(value = "/edit/newses/save", method = RequestMethod.POST)
    public String editNewsSaveDoPOST(@RequestParam("nid") String nid,
                                     @RequestParam("title") String title,
                                     @RequestParam("body") String body) {
        News news = newsesService.getById(Long.parseLong(nid));
        news.setBody(body);
        news.setTitle(title);
        newsesService.addEntity(news);
        return "redirect:/admin/edit/newses";
    }

    @RequestMapping(value = "/edit/newses/delete", method = RequestMethod.POST)
    public String editNewsDeleteDoPOST(@RequestParam("nid") String nid) {
        newsesService.delete(Long.parseLong(nid));
        return "redirect:/admin/edit/newses";
    }

    @RequestMapping(value = "/edit/newses/add", method = RequestMethod.POST)
    public String editNewsAddDoPOST(@RequestParam("title") String title,
                                    @RequestParam("body") String body) {
        News news = new News();
        news.setBody(body);
        news.setTitle(title);
        newsesService.addEntity(news);
        return "redirect:/admin/edit/newses";
    }

    @RequestMapping(value = "/edit/newses", method = RequestMethod.GET)
    public ModelAndView editNewsDoGet() {
        ModelAndView mav = new ModelAndView("admin/Main");
        mav.getModelMap().put("footer", "EditNewses.ftl");
        mav.getModelMap().put("newses", newsesService.getAll());
        return mav;
    }

    @RequestMapping(value = "/edit/advices/save", method = RequestMethod.POST)
    public String editFirmsPhonesSaveDoPOST(@RequestParam("aid") String aid,
                                      @RequestParam("advname") String advname,
                                      @RequestParam("advbody") String advbody,
                                      @RequestParam("filesrc") String filesrc) {
        Advice advice = adviceService.getById(Long.parseLong(aid));
        advice.setAdvname(advname);
        advice.setAdvbody(advbody);
        advice.setFilesrc(filesrc);
        adviceService.addEntity(advice);
        return "redirect:/admin/edit/advices";
    }

    @RequestMapping(value = "/edit/advices/delete", method = RequestMethod.POST)
    public String editFirmsPhonesDeleteDoPOST(@RequestParam("aid") String aid) {
        adviceService.delete(Long.parseLong(aid));
        return "redirect:/admin/edit/advices";
    }

    @RequestMapping(value = "/edit/advices", method = RequestMethod.GET)
    public ModelAndView editFirmsPhonesDoGet() {
        ModelAndView mav = new ModelAndView("admin/Main");
        mav.getModelMap().put("footer", "EditAdvices.ftl");
        mav.getModelMap().put("advices", adviceService.getAll());
        return mav;
    }

    @RequestMapping(value = "/edit/firms/save", method = RequestMethod.POST)
    public String editFirmsSaveDoPOST(@RequestParam("fid") String fid,
                                      @RequestParam("director") String director,
                                      @RequestParam("addres") String addres,
                                      @RequestParam("phone") String phone,
                                      @RequestParam("raiting") String raiting) {
        Firm firm = firmService.getById(Long.parseLong(fid));
        firm.setDirector(director);
        firm.setAddres(addres);
        firm.setRaiting(Integer.parseInt(raiting));
        Phone phone1 = phoneService.getById(Long.parseLong(fid));
        phone1.setNumbers(phone);
        phoneService.addEntity(phone1);
        firm.setPhone(phone1);
        firmService.addEntity(firm);

        return "redirect:/admin/edit/firms";
    }

    @RequestMapping(value = "/edit/firms/delete", method = RequestMethod.POST)
    public String editFirmsDeleteDoPOST(@RequestParam("fid") String fid) {
        firmService.delete(Long.parseLong(fid));
        return "redirect:/admin/edit/firms";
    }

    @RequestMapping(value = "/edit/firms/add", method = RequestMethod.POST)
    public String editFirmsAddDoPOST(@RequestParam("nameF") String nameF,
                                     @RequestParam("director") String director,
                                     @RequestParam("addres") String addres,
                                     @RequestParam("phone") String phone,
                                     @RequestParam("raiting") String raiting) {
        Firm firm = new Firm();
        firm.setAddres(addres);
        firm.setDirector(director);
        firm.setNameF(nameF);
        firm.setRaiting(Integer.parseInt(raiting));
        firmService.addEntity(firm);
        Phone phone1 = phoneService.getById(firm.getIdFirm());
        phone1.setNumbers(phone);
        phoneService.addEntity(phone1);
        return "redirect:/admin/edit/firms";
    }

    @RequestMapping(value = "/edit/firms", method = RequestMethod.GET)
    public ModelAndView editFirmsDoGet() {
        ModelAndView mav = new ModelAndView("admin/Main");
        mav.getModelMap().put("footer", "EditFirms.ftl");
        mav.getModelMap().put("tarifs", tarifsService.getAll());
        mav.getModelMap().put("firms", firmService.getAll());
        return mav;
    }

    @RequestMapping(value = "/edit/tarifs/save", method = RequestMethod.POST)
    public String editTarifsSaveDoPOST(@RequestParam("tid") String tid,
                                       @RequestParam("specialty") String specialty,
                                       @RequestParam("cost") String cost) {
        Tarif tarif = tarifsService.getById(Long.parseLong(tid));
        tarif.setSpecialty(specialty);
        tarif.setCost(Double.parseDouble(cost.replaceAll(",", ".")));
        tarifsService.checkedChanges(tarif);

        return "redirect:/admin/edit/tarifs";
    }

    @RequestMapping(value = "/edit/tarifs/delete", method = RequestMethod.POST)
    public String editTarifsDeleteDoPOST(@RequestParam("tid") String tid) {
        tarifsService.delete(Long.parseLong(tid));
        return "redirect:/admin/edit/tarifs";
    }

    @RequestMapping(value = "/edit/tarifs/add", method = RequestMethod.POST)
    public String editTarifsAddDoPOST(@RequestParam("nameT") String nameT,
                                      @RequestParam("specialty") String specialty,
                                      @RequestParam("cost") String cost,
                                      @RequestParam("fid") String fid) {
        Tarif tarif = new Tarif();
        tarif.setNameT(nameT);
        tarif.setCost(Double.parseDouble(cost.replaceAll(",", ".")));
        tarif.setSpecialty(specialty);
        tarif.setProduce(firmService.getById(Long.parseLong(fid)));
        tarifsService.addEntity(tarif);
        return "redirect:/admin/edit/tarifs";
    }

    @RequestMapping(value = "/edit/tarifs", method = RequestMethod.GET)
    public ModelAndView editTarifsDoGet() {
        ModelAndView mav = new ModelAndView("admin/Main");
        mav.getModelMap().put("footer", "EditTarifs.ftl");
        mav.getModelMap().put("tarifs", tarifsService.getAll());
        mav.getModelMap().put("firms", firmService.getAll());
        return mav;
    }

    @RequestMapping(value = "/claimstarif/ok", method = RequestMethod.POST)
    public ModelAndView claimstarifOk(@RequestParam("uid") Long uid,
                                      @RequestParam("tid") Integer tid,
                                      @RequestParam("ctid") Integer ctid) {
        MyUser myUser = myUserService.getById(uid);
        myUser.setTarif(tarifsService.getById(tid));
        myUserService.changeTarif(myUser);
        claimTarifService.delete(ctid);
        ModelAndView mav = new ModelAndView("admin/Main");
        mav.getModelMap().put("claims", claimTarifService.getAll());
        mav.getModelMap().put("footer", "ClaimsTarif.ftl");
        return mav;
    }

    @RequestMapping(value = "/claimstarif/notok", method = RequestMethod.POST)
    public ModelAndView claimstarifNotOk(@RequestParam("tid") Integer tid) {
        ModelAndView mav = new ModelAndView("admin/Main");
        claimTarifService.delete(tid);
        mav.getModelMap().put("claims", claimTarifService.getAll());
        mav.getModelMap().put("footer", "ClaimsTarif.ftl");
        return mav;
    }

    @RequestMapping(value = "/claimstarif", method = RequestMethod.GET)
    public ModelAndView claimstarif() {
        ModelAndView mav = new ModelAndView("admin/Main");
        mav.getModelMap().put("claims", claimTarifService.getAll());
        mav.getModelMap().put("footer", "ClaimsTarif.ftl");
        return mav;
    }

    @RequestMapping(value = "/allusers/change_role", method = RequestMethod.POST)
    public String userChangeRole(@RequestParam("uid") String uid,
                                 @RequestParam("role") String role){
        MyUser myUser = myUserService.getById(Long.parseLong(uid));
        myUser.setRole(role.toUpperCase());
        myUserService.addEntity(myUser);
        return "redirect:/admin/allusers";
    }
    @ResponseBody
    @RequestMapping(value = "/allusers/sort", method = RequestMethod.GET)
    public List<MyUser> sort(@RequestParam("sort") String sort,
                             @RequestParam(value = "new") String newUsers) {
        List<MyUser> users;
        if (newUsers == null || newUsers.equals("") || newUsers.equals("false")) {
            users = myUserService.getAll(sort);
        } else {
            users = myUserService.getNewUsers(sort);
        }
        return users;
    }

    @RequestMapping(value = "/allusers/document", method = RequestMethod.GET , produces = "application/pdf")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public FileSystemResource getPdf() throws IOException, com.itextpdf.text.DocumentException, DocumentException {
        String filePath = userPdfCreator.pdfCreate();
        return new FileSystemResource(filePath);
    }

    @RequestMapping(value = "/allusers", method = RequestMethod.GET)
    public ModelAndView allusers() {
        ModelAndView mav = new ModelAndView("admin/Main");
        mav.getModelMap().put("users", myUserService.getAll());
        mav.getModelMap().put("uri", "allusers");
        mav.getModelMap().put("footer", "Users.ftl");
        return mav;

    }
    @RequestMapping(value = "/activateuser", method = RequestMethod.GET)
    public ModelAndView activateuser() {
        ModelAndView mav = new ModelAndView("admin/Main");
        mav.getModelMap().put("users", myUserService.getNewUsers());
        mav.getModelMap().put("uri", "activateuser");
        mav.getModelMap().put("footer", "Users.ftl");
        return mav;
    }

    @RequestMapping(value = "/activateuser", method = RequestMethod.POST)
    public String activateuserPOST(@RequestParam("uid") Long uid) {
        myUserService.activateUserById(uid, true);
        return "redirect:/admin/activateuser";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/user/uid")
    public MyUser userAPIactivate(@RequestParam("uid") Long uid) {
        return myUserService.getById(uid);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/user/uid/non_locked")
    public MyUser userAPInon_locked(@RequestParam("uid") Long uid,
                                    @RequestParam("checked") Integer checked) {
        MyUser myUser = myUserService.getById(uid);
        if (checked != null) {
            boolean enabled = checked == 1;
            myUserService.nonLockedUserById(uid, enabled);
        }
        return myUser;
    }
}
