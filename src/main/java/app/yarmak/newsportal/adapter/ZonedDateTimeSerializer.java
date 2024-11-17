package app.yarmak.newsportal.adapter;

import java.lang.reflect.Type;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class ZonedDateTimeSerializer implements JsonSerializer<ZonedDateTime>{

	@Override
	public JsonElement serialize(ZonedDateTime src, Type typeOfSrc, JsonSerializationContext context) {
		return context.serialize(src.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
	}

}
