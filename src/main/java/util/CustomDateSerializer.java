package util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zwl on 2017/9/7.
 * May god bless me
 */
public class CustomDateSerializer  extends JsonSerializer<Date> {
    public void serialize(Date date, JsonGenerator gen, SerializerProvider provider)throws IOException, JsonProcessingException
    {
        SimpleDateFormat format =new SimpleDateFormat("YYYY-mm-dd HH:MM:SS");
        String formattedDate = format.format(date);
        gen.writeString(formattedDate);
    }
}
