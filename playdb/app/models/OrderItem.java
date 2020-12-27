package models;

import javax.persistence.*;
import java.util.*;

import play.data.validation.*;

import com.avaje.ebean.*;



/**
 * Created by Z on 15/12/20.
 */
@Entity
public class OrderItem extends Model {
    @Id
    public Long id;
    // optional=true，在数据库中允许为null
    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, optional = true)// 级联更新，级联刷新
    public Purchase purchase;

    @ManyToOne
    public Product product;
   // private String productName;

    public Long quantity;
    public Float price;
    public String sale;
}
