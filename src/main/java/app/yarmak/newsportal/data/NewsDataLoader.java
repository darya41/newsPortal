package app.yarmak.newsportal.data;

import java.io.IOException;
import java.io.InputStreamReader;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import app.yarmak.newsportal.adapter.ZonedDateTimeDeserializer;
import app.yarmak.newsportal.adapter.ZonedDateTimeSerializer;
import app.yarmak.newsportal.bean.News;

public class NewsDataLoader {
	public List<News> loadNews() {
        List<News> newsList = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeSerializer())
                .registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeDeserializer())
                .create();
        try (InputStreamReader reader = new InputStreamReader(getClass().getClassLoader().getResourceAsStream("News.json"))) {
            java.lang.reflect.Type newsListType = new TypeToken<List<News>>() {}.getType();
            newsList = gson.fromJson(reader, newsListType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newsList;
    }
}
