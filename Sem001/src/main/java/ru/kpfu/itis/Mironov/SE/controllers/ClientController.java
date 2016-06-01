package ru.kpfu.itis.Mironov.SE.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.Mironov.SE.entities.*;
import ru.kpfu.itis.Mironov.SE.services.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Юра on 25.05.2016.
 */
@RestController
@RequestMapping("/app/client/")
public class ClientController {
    @Autowired HttpServletRequest request;
    @Autowired MyUserService myUserService;
    @Autowired NewsesService newsesService;
    @Autowired AdviceService adviceService;
    @Autowired FirmService firmService;
    @Autowired TarifsService tarifsService;
    @Autowired ClaimTarifService claimTarifService;
    @RequestMapping(value = "{path:signin}", method = RequestMethod.GET)
    public SafetyUser signIn(){
        SafetyUser su = myUserService.getByEmail(request.getRemoteUser()).getSafetyUser();
        return su;
    }
    @RequestMapping(value = "{path:getNewses}", method = RequestMethod.GET)
    public NewsList getNewses() {
        NewsList nl = new NewsList();
        nl.addAll(newsesService.get10NewsByPageNumber(1).subList(0, 5));
        return nl;
    }
    @RequestMapping(value = "{path:getAdvices}", method = RequestMethod.GET)
    public ArrayList<?> getAdvicees() {
        class SafAdv{
            private Long id;
            private String advname;
            private String advbody;
            private String filesrc;
            private SafetyUser author;

            public Long getId() {
                return id;
            }

            public void setId(Long id) {
                this.id = id;
            }

            public String getAdvname() {
                return advname;
            }

            public void setAdvname(String advname) {
                this.advname = advname;
            }

            public String getAdvbody() {
                return advbody;
            }

            public void setAdvbody(String advbody) {
                this.advbody = advbody;
            }

            public String getFilesrc() {
                return filesrc;
            }

            public void setFilesrc(String filesrc) {
                this.filesrc = filesrc;
            }

            public SafetyUser getAuthor() {
                return author;
            }

            public void setAuthor(SafetyUser author) {
                this.author = author;
            }
        }
        class AdvList extends ArrayList<SafAdv>{}
        AdvList al = new AdvList();
        for(Advice a: adviceService.findLast7()){
            SafAdv sa = new SafAdv();
            sa.setAdvname(a.getAdvname());
            sa.setAdvbody(a.getAdvbody());
            sa.setAuthor(a.getAuthor().getSafetyUser());
            sa.setFilesrc(a.getFilesrc());
            sa.setId(a.getId());
            al.add(sa);
        }
        return al;
    }
    @RequestMapping(value = "{path:getFirms}", method = RequestMethod.GET)
    public ArrayList<?> getFirms() {
        class FirmList extends ArrayList<Firm>{}
        FirmList fl = new FirmList();
        for(Firm f: firmService.getAll()){
            fl.add(f);
        }
        return fl;
    }
    @RequestMapping(value = "{path:getSimpleFirms}", method = RequestMethod.GET)
    public Map<String,Long> getSimpleFirms() {
        class FirmsMap extends HashMap<String, Long>{}
        FirmsMap fl = new FirmsMap();
        for(Firm f: firmService.getAll()){
            fl.put(f.getNameF(), f.getIdFirm());
        }
        return fl;
    }
    @RequestMapping(value = "{path:getSimpleTarifs}", method = RequestMethod.GET)
    public Map<String,Long> getTarifs() {
        class TarifMap extends HashMap<String, Long>{}
        TarifMap fl = new TarifMap();
        for(Tarif f: tarifsService.getAll()){
            fl.put(f.getNameT(), f.getIdTarif());
        }
        return fl;
    }
    @RequestMapping(value = "{path:addAdv}", method = RequestMethod.POST,produces = "application/json")
    public Advice addAdv(@RequestParam("advname") String advname,
                         @RequestParam("advbody") String advbody,
                         @RequestParam("advfilesrc") String advfilesrc,
                         @RequestParam("uid") Long uid){
        Advice advice = new Advice();
        advice.setAdvname(advname);
        advice.setAdvbody(advbody);
        advice.setFilesrc(advfilesrc);
        advice.setAuthor(myUserService.getById(uid));
        adviceService.addEntity(advice);
        System.out.println(advice);
        return advice;
    }
    @RequestMapping(value = "{path:changeTarif}", method = RequestMethod.POST, produces ="application/json")
    public ClaimTarif changeTarif(@RequestParam("uid") Long uid,
                              @RequestParam("fid") Long fid,
                              @RequestParam("tid") Long tid){
        ClaimTarif ct = new ClaimTarif();
        ct.setUserid(uid);
        ct.setNewtarifid(tid);
        ct.setComment("");
        claimTarifService.addEntity(ct);
        return ct;
    }
}
