package ru.dartIt.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dartIt.model.Recipe;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Controller
@RequestMapping(value = "/catalogs")
public class JspCatalogController {

//    @GetMapping("/create")
//    public String create(Model model) {
//        model.addAttribute("recipe", new Recipe());
//        return "recipeForm";
//    }
//@PostMapping("/getByRecipe")
//public String getByIngredient(HttpServletRequest request, Model model) {
//    int ingredientId = Integer.parseInt(request.getParameter("catalog"));
//    model.addAttribute("recipies", super.g(ingredientId));
//    return "recipies";
}
