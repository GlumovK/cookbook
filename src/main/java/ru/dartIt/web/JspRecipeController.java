package ru.dartIt.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dartIt.model.Recipe;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/recipies")
public class JspRecipeController extends AbstractRecipeController {

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "recipeForm";
    }

    @PostMapping("/getByUser")
    public String getByUser(HttpServletRequest request, Model model) {
        String userName = request.getParameter("user");
        model.addAttribute("recipies", super.getByUser(userName));
        return "recipies";
    }

    @PostMapping("/getByIngredient")
    public String getByIngredient(HttpServletRequest request, Model model) {
        String ingredientName = request.getParameter("ingredient");
        model.addAttribute("recipies", super.getByIngredient(ingredientName));
        return "recipies";
    }

    @PostMapping("/getByCatalog")
    public String getByCatalog(HttpServletRequest request, Model model) {
        String catalogName = request.getParameter("catalog");
        model.addAttribute("recipies", super.getByCatalog(catalogName));
        return "recipies";
    }

    @PostMapping("/getByName")
    public String getByName(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        model.addAttribute("recipies", super.getByName(name));
        return "recipies";
    }

    @PostMapping
    public String updateOrCreate(HttpServletRequest request) {
        Recipe recipe = new Recipe(request.getParameter("name"),
                request.getParameter("description"),
                request.getParameter("cookAlgorithm"));
        super.create(recipe);
        return "redirect:/recipies";
    }

    @GetMapping("/addVote")
    public String addVote(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        super.addVote(id);
        return "redirect:/recipies";
    }

    @GetMapping("/subtractVote")
    public String subtractVote(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        super.subtractVote(id);
        return "redirect:/recipies";
    }
}


