import org.junit.*;

import java.util.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

import models.*;

import com.avaje.ebean.*;

public class ModelTest {
    
    private String formatted(Date date) {
        return new java.text.SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    @Test
    public void findById() {
        running(fakeApplication(), new Runnable() {
           public void run() {
               Device macintosh = Device.find.byId(21l);
               assertThat(macintosh.name).isEqualTo("Macintosh");
               assertThat(formatted(macintosh.introduced)).isEqualTo("1984-01-24");
           }
        });
    }
    
    @Test
    public void pagination() {
        running(fakeApplication(inMemoryDatabase()), new Runnable() {
           public void run() {
               Page<Device> computers = Device.page(1, 20, "name", "ASC", "");
               assertThat(computers.getTotalRowCount()).isEqualTo(574);
               assertThat(computers.getList().size()).isEqualTo(20);
           }
        });
    }
    
}
