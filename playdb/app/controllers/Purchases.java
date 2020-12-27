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
 * Created by Z on 15/12/24.
 */
public class Purchases extends Controller {

    public static Result list(int page, String sortBy, String order, String filter) {
        return ok(
                purchaselist.render(
                        Purchase.page(page, 10, sortBy, order, filter), sortBy, order, filter
                )
        );
    }


    public static Result create(Long id) {
        Form<Purchase> pForm = form(Purchase.class);

        Product p = Product.find.byId(id);



        return ok(
                purchaseForm.render(pForm,p)
        );
    }

    public static Result save(Long id) {
        Form<Purchase> pForm = form(Purchase.class).bindFromRequest();  //bind params /device?id=123
        if(pForm.hasErrors()) {
            return badRequest(purchaseForm.render(pForm,null));
        }
/*
        Order order = new Order();
        9         order.setAmoutn(120f);
        10         order.setOrderId("");// UUID.randomUUID().toString()
        11
        12         OrderItem item = new OrderItem();
        13         item.setProductName("足球");
        14         item.setSellPrice(90f);
        15
        16         OrderItem item2 = new OrderItem();
        17         item2.setProductName("排球");
        18         item2.setSellPrice(30f);
        19
        20         // 设置两者之间的关联
        21         order.addOrderItem(item);
        22         order.addOrderItem(item2);
        23
        24         // 保存Order，此时也会保持OrderItem
        25         manager.persist(order);
*/

        Purchase purchase=new Purchase();

        purchase=pForm.get();

        OrderItem item =new OrderItem();
        Product p = Product.find.byId(id);
        item.product=p;
        //item.price=
        purchase.additem(purchase,item);

        purchase.save();
        item.save();

            flash("success", "Product " + pForm.get().id + " has been created");

        return GO_HOME;
    }

    public static Result delete(Long id) {
        Purchase.find.ref(id).delete();
        flash("success", "Device has been deleted");
        return GO_HOME;
    }


    public static Result GO_HOME = redirect(
            routes.Purchases.list(0, "id", "asc", "")
    );

    public static Result order(long id) {

        List<OrderItem> items = Purchase.find.byId(id).orderItems;
        return ok(
                order.render(items)
        );
    }

}
