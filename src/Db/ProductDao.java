package Db;

import com.j256.ormlite.field.DatabaseField;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDao {
    @DatabaseField(id = true)
    public String article;
    @DatabaseField
    public String name;
    @DatabaseField
    public Integer size;
    @DatabaseField
    public Integer numberPair;
    @DatabaseField
    public Integer price;

}
