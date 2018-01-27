package ru.dartIt.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import ru.dartIt.service.CatalogService;
import ru.dartIt.service.RecipeService;
import ru.dartIt.service.UserService;


import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
public class RootController  extends AbstractRecipeController {
//    @Autowired
//    private UserService userService;
//
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
    public String recipies( Model model) {
        model.addAttribute("recipies", recipeService.getAll());
        return "recipies";
    }
//    @GetMapping("catalogs/getByRecipe")
//    public String getByIngredient(HttpServletRequest request, Model model) {
//        int catalogId = Integer.parseInt(request.getParameter("catalog"));
//        model.addAttribute("recipies", recipeService.getByCatalog(catalogId));
//        return "recipies";
//    }




}
