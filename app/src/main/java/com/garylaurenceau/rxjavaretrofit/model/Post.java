package com.garylaurenceau.rxjavaretrofit.model;

/**
 * Created by gary on 08/02/16.
 */
import com.google.gson.annotations.SerializedName;

public class Post {

	@SerializedName("userId")
	private long mUserId;

	@SerializedName("id")
	private long mId;

	@SerializedName("title")
	private String mTitle;

	@SerializedName("body")
	private String mBody;

	public long getUserId() {
		return mUserId;
	}

	public void setUserId(long userId) {
		mUserId = userId;
	}

	public long getId() {
		return mId;
	}

	public void setId(long id) {
		mId = id;
	}

	public String getTitle() {
		return mTitle;
	}

	public void setTitle(String title) {
		mTitle = title;
	}

	public String getBody() {
		return mBody;
	}

	public void setBody(String body) {
		mBody = body;
	}
}
