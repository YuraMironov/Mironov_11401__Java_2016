//package ru.kpfu.itis.Mironov.SE.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import ru.kpfu.itis.khakov.entity.User;
//import ru.kpfu.itis.khakov.forms.RegistrationForm;
//import ru.kpfu.itis.khakov.service.UserService;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;
//import java.math.BigInteger;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//
///**
// * Created by Rus on 26.04.2016.
// */
//@Controller
//public class RegistrationController {
//    public static final String ATTR_REGISTRATION_FORM = "regForm";
//    @Autowired
//    private HttpServletRequest request;
//    @Autowired
//    private UserService userService;
//    /**
//     * Отображение страницы регистрации
//     */
//    @RequestMapping(value = "/registration", method = RequestMethod.GET)
//    public String renderRegistrationPage() {
//        if(request.getRemoteUser() != null){
//            return "redirect:/";
//        }
//        request.setAttribute("regForm", new RegistrationForm());
//        return "registration";
//    }
//
//    /**
//     * Обработка формы Регистрации
//     * Отправка письма с ссылкой для подтверждения регистрации
//     * Без подтвреждения регистрации пользователь не сможет авторизоваться
//     */
//    @RequestMapping( value = "/registration", method = RequestMethod.POST)
//    public String registrationForm(
//            @Valid @ModelAttribute("regForm") RegistrationForm regForm,
//            BindingResult bindingResult,
//            Model model
//    ) {
//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }
//        if(userService.getByLogin(regForm.getEmail()) != null){
//            model.addAttribute("error","User with this email already exist");
//            return "registration";
//        }
//        userService.add(new User(regForm.getFirstName(), regForm.getLastName(), regForm.getEmail(),
//                md5Decoder(regForm.getPassword()),"ROLE_USER"));
////        Long user_id = userService.getByLogin(email).getId();
////        Sender sender = new Sender("bookstoreitis@gmail.com","parolparol");
////        sender.send("REGISTRATION","Вы прошли успешную регистрацию на сайте bookStore\n" +
////                "Для подтверждения регистрации пройдте по ссылке : http://localhost:8081/reg/activate?id="+ user_id + "\n" +
////                "Ваш логин : "+email,"bookstoreitis@gmail.com",email);
//        System.out.println(regForm);
//        return "redirect:/";
//    }
//
//    /**
//     * Обработка ссылки активации
//     * @param id - id пользователя,достаётся из url
//     */
////    @RequestMapping(value = "/activate",method = RequestMethod.GET)
////    public String activateUser(Long id){
////        User user=userService.getById(id);
////        user.setActive(true);
////        userService.update(user);
////        return "redirect:/login";
////    }
//
//    /**
//     * MD5 хэширование пароля
//     */
//    private String md5Decoder(String password){
//        MessageDigest messageDigest = null;
//        try {
//            messageDigest = MessageDigest.getInstance("MD5");
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        messageDigest.update(password.getBytes(),0, password.length());
//        String pass = new BigInteger(1,messageDigest.digest()).toString(16);
//        if (pass.length() < 32) {
//            pass = "0" + pass;
//        }
//        return pass;
//    }
//}
