package com.garylaurenceau.rxjavaretrofit.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.garylaurenceau.rxjavaretrofit.R;
import com.garylaurenceau.rxjavaretrofit.model.Post;
import com.garylaurenceau.rxjavaretrofit.network.NetworkRequest;
import com.garylaurenceau.rxjavaretrofit.network.RestAPI;
import com.garylaurenceau.rxjavaretrofit.network.RestAPIBuilder;

import rx.Subscription;

public class MainActivity extends AppCompatActivity {

	private TextView mTitle;
	private TextView mBody;

	private Subscription mGetPostSubscription;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mTitle = (TextView) findViewById(R.id.title);
		mBody = (TextView) findViewById(R.id.body);

		RestAPI api = RestAPIBuilder.buildRetrofitService();
		mGetPostSubscription =  NetworkRequest.performAsyncRequest(api.getPost(1), (data) -> {
			// Update UI on the main thread
			displayPost(data);
		}, (error) -> {
			// Handle error

		});
	}

	private void displayPost(Post post) {
		mTitle.setText("Title: " + post.getTitle());
		mBody.setText("Body: " + post.getBody());
	}

	@Override
	protected void onPause() {
		super.onPause();
		if (mGetPostSubscription != null) {
			mGetPostSubscription.unsubscribe();
		}
	}
}
