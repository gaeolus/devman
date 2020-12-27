package models;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.*;

import play.data.validation.*;

import com.avaje.ebean.*;


/**
 * Created by Z on 15/12/20.
 */
@Entity
public class StockItem extends Model {
   // public Warehouse warehouse;
   @Id
    public Long id;
    public Product product;
 //sell
 //price
    public Long quantity;
    public String udi;
    public String sn;
    public Purchase purchase;
}
