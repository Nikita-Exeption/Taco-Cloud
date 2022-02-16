package org.Nikita.Taco.Cloud.repository;

import org.Nikita.Taco.Cloud.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {


}
