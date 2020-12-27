package controllers;

import models.CheckFee;
import models.Device;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.fee;
import views.html.useForm;
import views.html.monthdevfee;

import java.util.*;

import com.avaje.ebean.*;

import static play.data.Form.form;

/**
 * Created by Z on 15/12/3.
 */
public class CheckFees extends Controller {

    public static Result fee(int page, String sortBy, String order, String filter, String zxrq) {
        return ok(
                fee.render(
                        CheckFee.fee(page, 10, sortBy, order, filter,zxrq,-1L),
                        sortBy, order, filter,zxrq
                )
        );
    }


    /**
     * Display the 'edit form' of a existing Device.
     *
     * @param id Id of the computer to edit
     */
    public static Result use(Long id, int page, String sortBy, String order, String filter, String zxrq) {
        Device dev=Device.find.byId(id);
        Form<Device> deviceForm = form(Device.class).fill(
                dev
        );
        PagedList<CheckFee> devfee=CheckFee.fee(page,10,sortBy, order, filter,zxrq,id);
        Double tfee=CheckFee.tfee(id);
        return ok(
                useForm.render(id, deviceForm,devfee,tfee,sortBy, order, filter,zxrq)
        );
    }


  public static Result monthdevfee(Long id) {
        Device dev=Device.find.byId(id);
        Form<Device> deviceForm = form(Device.class).fill(
                dev
        );
        List<SqlRow> devfee=CheckFee.monthdevfee(id,9);
        Double tfee=CheckFee.tfee(id);
        return ok(
                monthdevfee.render(id,deviceForm,devfee,tfee)
        );
    }

}
