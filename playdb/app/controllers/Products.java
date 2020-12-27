package controllers;

import play.libs.Json;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import views.html.*;

import models.*;

import com.avaje.ebean.*;

import java.util.*;

/**
 * Created by Z on 15/12/20.
 */
public class Products extends Controller {

    public static Result list(int page, String sortBy, String order, String filter) {
        return ok(
                productlist.render(
                        Product.page(page, 10, sortBy, order, filter), sortBy, order, filter
                )
        );
    }


    public static Result create() {
        Form<Product> pForm = form(Product.class);
        return ok(
                productForm.render(pForm)
        );
    }

    public static Result edit(Long id) {
        Form<Product> pForm = form(Product.class).fill(
                Product.find.byId(id)
        );
        return ok(
                productForm.render(pForm)
        );
    }

    /**
     * Handle the 'new computer form' submission
     */
    public static Result save() {
        Form<Product> pForm = form(Product.class).bindFromRequest();  //bind params /device?id=123
        if(pForm.hasErrors()) {
            return badRequest(productForm.render(pForm));
        }
        Product product=pForm.get();
        if (product.id==null) {
            product.save();
            flash("success", "Product " + pForm.get().name + " has been created");
        } else {

            product.update();
            flash("success", "Device " + pForm.get().name + " has been updated");
        }

        return GO_HOME;
    }

    public static Result delete(Long id) {
        Product.find.ref(id).delete();
        flash("success", "Device has been deleted");
        return GO_HOME;
    }


    public static Result GO_HOME = redirect(
            routes.Products.list(0, "id", "asc", "")
    );



}
