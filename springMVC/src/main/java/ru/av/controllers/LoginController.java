package ru.av.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.av.bean.AuthorizationInfo;
import ru.av.bean.LoginBean;
import ru.av.bean.SearchBean;
import ru.av.bean.UserAuthorizationInfo;
import ru.av.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Полина on 24.02.2016.
 */
@Controller
public class LoginController {


    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = {"/", "/login"}, method = RequestMethod.POST)
    public ModelAndView greeting(@ModelAttribute("loginBean")LoginBean loginBean, HttpServletRequest request) {
        ModelAndView modelAndView;
        if (loginBean.getUsername() != null && loginBean.getPassword() != null) {
            UserAuthorizationInfo userAuthorizationInfo = userRepository.checkUser(loginBean);
            if (userAuthorizationInfo != null) {
                AuthorizationInfo authorizationInfo = new AuthorizationInfo();
                authorizationInfo.setUserAuthorizationInfo(userAuthorizationInfo);
                request.getSession().setAttribute("authorizationInfo", authorizationInfo);

                modelAndView = new ModelAndView("redirect:/user/");
            } else {
                modelAndView = new ModelAndView("login");
                modelAndView.addObject("loginError", "User name or password is incorrect");
            }
        } else {
            modelAndView = new ModelAndView("login");
        }
        return modelAndView;
    }

    @RequestMapping(path = {"/", "/login"}, method = RequestMethod.GET)
    public String greeting(@ModelAttribute("loginBean")LoginBean loginBean) {
        return "login";
    }
}
