package org.Nikita.Taco.Cloud.service;

import org.Nikita.Taco.Cloud.model.Ingredient;
import org.Nikita.Taco.Cloud.model.Type;
import org.Nikita.Taco.Cloud.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ConvertStringToIngredient implements Converter<String , Ingredient> {

    private IngredientRepository ingredientRepository;

    @Autowired
    public ConvertStringToIngredient(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient convert(String source) {
        return ingredientRepository.findById(source).orElse(null);
    }
}
