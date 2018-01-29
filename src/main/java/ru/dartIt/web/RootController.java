package ru.dartIt.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;
import ru.dartIt.AuthorizedUser;
import ru.dartIt.service.CatalogService;
import ru.dartIt.service.RecipeService;
import ru.dartIt.to.UserTo;
import ru.dartIt.util.UserUtil;

import javax.validation.Valid;


@Controller
public class RootController extends AbstractUserController {

    @Autowired
    private CatalogService catalogService;

    @Autowired
    private RecipeService recipeService;

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/recipies";
    }

    @GetMapping("/catalogs")
    public String catalogs(Model model) {
        model.addAttribute("catalogs", catalogService.getAll());
        return "catalogs";
    }

    @GetMapping("/recipies")
    public String recipies(Model model) {
        model.addAttribute("recipies", recipeService.getAll());
        return "recipies";
    }

    @PostMapping("/profile")
    public String updateProfile(@Valid UserTo userTo, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "profile";
        } else {
            super.update(userTo, AuthorizedUser.id());
            AuthorizedUser.get().update(userTo);
            status.setComplete();
            return "redirect:meals";
        }
    }

    @GetMapping("/register")
    public String register(ModelMap model) {
        model.addAttribute("userTo", new UserTo());
        model.addAttribute("register", true);
        return "profile";
    }

    @PostMapping("/register")
    public String saveRegister(@Valid UserTo userTo, BindingResult result, SessionStatus status, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("register", true);
            return "profile";
        } else {
            super.create(UserUtil.createNewFromTo(userTo));
            status.setComplete();
            return "redirect:login?message=app.registered&username=" + userTo.getEmail();
        }
    }


}
