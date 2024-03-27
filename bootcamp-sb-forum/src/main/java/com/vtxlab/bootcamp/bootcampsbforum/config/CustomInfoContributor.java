package com.vtxlab.bootcamp.bootcampsbforum.config;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class CustomInfoContributor implements InfoContributor {

    @Autowired
    private Environment env;

    private static final Map<String, Object> application = new HashMap<>();
    private static final Map<String, Object> author = new HashMap<>();

    @Override
    public void contribute(Info.Builder builder) {
        application.put("Name", env.getProperty("info.application.name"));
        application.put("Description", env.getProperty("info.application.description"));
        author.put("Author Name", env.getProperty("info.application.author.name"));
        author.put("Author Bio", env.getProperty("info.application.author.bio"));
        application.put("Author", author);
        builder.withDetail("Application", application);
    }
}