package ru.dartIt.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.dartIt.service.CatalogService;
import ru.dartIt.service.UserService;


import javax.servlet.http.HttpServletRequest;

@Controller
public class RootController {
    @Autowired
    private UserService userService;

    @Autowired
    private CatalogService catalogService;

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }

//    @PostMapping("/users")
//    public String setUser(HttpServletRequest request) {
//        int userId = Integer.valueOf(request.getParameter("userId"));
//      //  AuthorizedUser.setId(userId);
//        return "redirect:meals";
//    }

    @GetMapping("/catalogs")
    public String meals(Model model) {
        model.addAttribute("catalogs", catalogService.getAll());
        return "catalogs";
    }
}
