package controllers;

import play.mvc.*;

import play.data.*;
import static play.data.Form.*;

import views.html.*;

import models.*;

/**
 * Created by Z on 15/12/3.
 */
public class Application extends Controller{

    /**
     * Handle default path requests
     */
    public static Result index() {
        return ok(
                index.render()
        );
        //return GO_HOME;
    }

}
