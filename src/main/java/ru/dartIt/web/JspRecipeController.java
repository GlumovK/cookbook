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
public class JspRecipeController  extends AbstractRecipeController {

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "recipeForm";
    }

    @PostMapping("/getByUser")
    public String getByUser(HttpServletRequest request, Model model) {
        int userId = Integer.parseInt(request.getParameter("user"));
        model.addAttribute("recipies", super.getByUser(userId));
        return "recipies";
    }

    @PostMapping("/getByIngredient")
    public String getByIngredient(HttpServletRequest request, Model model) {
        int ingredientId = Integer.parseInt(request.getParameter("ingredient"));
        model.addAttribute("recipies", super.getByIngredient(ingredientId));
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

       // if (request.getParameter("id").isEmpty()) {
            super.create(recipe);
//        } else {
//            super.update(meal, getId(request));
//        }
            return "redirect:/recipies";
        }
    }


