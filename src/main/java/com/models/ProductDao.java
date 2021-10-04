package com.models;

import com.j256.ormlite.field.DatabaseField;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDao {
    @DatabaseField
    private String article;
    @DatabaseField
    private String name;
    @DatabaseField
    private Integer size;
    @DatabaseField
    private Integer numberPair;
    @DatabaseField
    private Integer price;
    @DatabaseField(generatedId = true, allowGeneratedIdInsert = true)
    private Integer id;
}
