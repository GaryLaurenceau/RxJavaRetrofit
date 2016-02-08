package com.garylaurenceau.rxjavaretrofit.network;

import com.garylaurenceau.rxjavaretrofit.model.Post;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by gary on 08/02/16.
 */
public interface RestAPI {
	String API_ENDPOINT = "http://jsonplaceholder.typicode.com";

	@GET("/posts/{id}")
	Observable<Post> getPost(@Path("id") int id);
}