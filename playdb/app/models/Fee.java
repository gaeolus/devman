package models;
import java.util.*;
import javax.persistence.*;

import play.data.format.*;
import play.data.validation.*;

//import play.db.ebean.*;
import com.avaje.ebean.*;


/**
 * Created by Z on 15/11/26.
 */
@Entity
public class Fee extends Model{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    public int sjid;  //checklist.yjxh
    public int ylxh;
    public float yldj;
    public int ylsl;
    public float hjje;

    public static Finder<Long, Fee> cfind = new Finder<Long, Fee>(Long.class, Fee.class);


}
