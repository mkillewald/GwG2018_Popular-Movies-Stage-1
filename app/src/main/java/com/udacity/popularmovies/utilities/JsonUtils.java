package com.udacity.popularmovies.utilities;

import com.udacity.popularmovies.model.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils {

    public static Movie[] parseTmdbJson(String json) {

        final String KEY_RESULTS = "results";
        final String KEY_TITLE = "title";
        final String KEY_ORIGINAL_TITLE = "original_title";
        final String KEY_POSTER_PATH = "poster_path";
        final String KEY_OVERVIEW = "overview";
        final String KEY_VOTE_AVERAGE = "vote_average";
        final String KEY_RELEASE_DATE = "release_date";

        Movie[] movies = null;

        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray results = jsonObject.getJSONArray(KEY_RESULTS);

            movies = new Movie[results.length()];

            for (int i = 0; i < results.length(); i++) {
                Movie movie = new Movie();

                JSONObject movieJson = results.getJSONObject(i);

                movie.setTitle(movieJson.getString(KEY_TITLE));
                movie.setOriginalTitle(movieJson.getString(KEY_ORIGINAL_TITLE));
                movie.setPosterPath(movieJson.getString(KEY_POSTER_PATH));
                movie.setOverview(movieJson.getString(KEY_OVERVIEW));
                movie.setReleaseDate(movieJson.getString(KEY_RELEASE_DATE));
                movie.setVoteAverage(movieJson.getDouble(KEY_VOTE_AVERAGE));

                movies[i] = movie;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return movies;
    }
}
