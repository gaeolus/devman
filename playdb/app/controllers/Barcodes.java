package controllers;

import org.krysalis.barcode4j.impl.upcean.EAN13Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

import play.mvc.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import views.html.*;

import java.io.IOException;

import play.data.*;
import static play.data.Form.*;
import models.*;
import java.util.*;



/**
 * Created by Z on 15/12/4.
 */
public class Barcodes extends Controller{

   public static Result bar(String ean) {
       ByteArrayOutputStream out = new ByteArrayOutputStream();
       BitmapCanvasProvider provider = new BitmapCanvasProvider(out, "image/png", 144, BufferedImage.TYPE_BYTE_BINARY, false, 0);
       try {
           new EAN13Bean().generateBarcode(provider, ean);
           provider.finish();
           return ok(out.toByteArray());

       } catch (IOException e) {
           return badRequest("Could not render barcode. "+e.getMessage());
       } finally {
           try {
               out.close();
           } catch (Exception e) {
           }
       }
   }

    public static Result barcode(String ean) {

         return ok (bar.render(ean));
    }


    public static Result lineChart() {
         return ok (lineChart.render("Time & Line",null));
    }

  public static Result columnAndBarChart() {
         return ok (columnAndBar.render("Bar & Column"));
    }

      public static Result areaAndPieChart() {
         return ok (pieAndArea.render("Area & Pie"));
    }

      public static Result bubbleChart() {
         return ok (bubble.render("Bubble"));
    }

}
