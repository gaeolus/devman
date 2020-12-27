import play.*;
import play.libs.Json;

/*
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
*/

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Global extends GlobalSettings {
@Override
public void onStart(Application app) {
    Logger.info("Application has started");
        // Setup the ObjectMapper to support JodaTime (Un)marshalling
        ObjectMapper mapper = new ObjectMapper();
// to write java.util.Date, Calendar as number (timestamp):
         mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//        mapper.registerModule(new JodaModule());
        Json.setObjectMapper(mapper);

        }
}
