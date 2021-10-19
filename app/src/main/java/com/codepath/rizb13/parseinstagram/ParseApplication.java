package com.codepath.rizb13.parseinstagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);
        // set applicationId, and server server based on the values in the Heroku settings.
        // clientKey is not needed unless explicitly configured
        // any network interceptors must be added with the Configuration Builder given this syntax
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("qIADkGkolG2gV3Tk7sQWAoWKs0dwoDeH6n3VKfnf")
                .clientKey("nl8lXdDRo36GNWzpaOAzaKKKRiWcP9tCjxcDtLcC")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
