package org.Nikita.Taco.Cloud.model;

import lombok.*;
import org.springframework.data.domain.Persistable;
import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@Entity
public class Ingredient implements Persistable<String> {

    @Id
    private String id;

    private String name;

    private Type type;

    public Ingredient(String  id, String name, Type type){
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Ingredient(){}

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getId(){
        return id;
    }

    @Override
    public boolean isNew() {
        return true;
    }
}

