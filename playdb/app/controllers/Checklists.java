package controllers;

import models.Checklist;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.checklist;

import com.avaje.ebean.*;

/**
 * Created by Z on 15/12/3.
 */
public class Checklists extends Controller {

    /**
     * Display the paginated list of computers.
     *
     * @param page Current page number (starts from 0)
     * @param sortBy Column to be sorted
     * @param order Sort order (either asc or desc)
     * @param filter Filter applied on computer names
     */
    public static Result checklist(int page, String sortBy, String order, String filter, String zxrq) {
        return ok(
                checklist.render(
                        Checklist.page(page, 10, sortBy, order, filter,zxrq),
                        sortBy, order, filter,zxrq
                )
        );
    }





}
