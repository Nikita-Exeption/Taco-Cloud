package org.Nikita.Taco.Cloud.controller;


import org.Nikita.Taco.Cloud.model.Ingredient;
import org.Nikita.Taco.Cloud.model.Taco;
import org.Nikita.Taco.Cloud.model.Type;
import org.Nikita.Taco.Cloud.repository.IngredientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class TacoController {

    private Logger logger = LoggerFactory.getLogger(TacoController.class);

    @ModelAttribute
    public void addIngredientsToModel(Model model){
        Iterable<Ingredient> ingredients = ingredientRepository.findAll();
        Type[] types = Type.values();
        for (Type type : types){
            model.addAttribute(type.toString().toLowerCase(),filterByType((List) ingredients,type));
        }
    }

    private final IngredientRepository ingredientRepository;

    @Autowired
    public TacoController(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @GetMapping
    public String showDesignForm(Model model){
        model.addAttribute("taco", new Taco());
        return "design";
    }

    @PostMapping
    public String processTaco(@Valid @ModelAttribute("taco") Taco taco, Errors errors){
//        if(errors.hasErrors()){
//            return "design";
//        }
        logger.info("Processing taco: " + taco);
        return "redirect:/orders/current";
    }
}
