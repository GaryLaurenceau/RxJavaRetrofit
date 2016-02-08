package com.garylaurenceau.rxjavaretrofit.network;

import android.util.Log;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class NetworkRequest {

	private static final String TAG = "NetworkRequest";

	// Default error handling
	private static Action1<Throwable> mOnError = new Action1<Throwable>() {
		@Override
		public void call(Throwable throwable) {
			Log.e(TAG, throwable.getMessage());
			throwable.printStackTrace();
		}
	};

	public static <T> Subscription performAsyncRequest(Observable<T> observable, Action1<? super T> onAction) {
		// Use default error handling
		return performAsyncRequest(observable, onAction, mOnError);
	}

	public static <T> Subscription performAsyncRequest(Observable<T> observable, Action1<? super T> onAction, Action1<Throwable> onError) {
		// Specify a scheduler (Scheduler.newThread(), Scheduler.immediate(), ...)
		// We choose Scheduler.io() to perform network request in a thread pool
		return observable.subscribeOn(Schedulers.io())
				// Observe result in the main thread to be able to update UI
				.observeOn(AndroidSchedulers.mainThread())
						// Set callbacks actions
				.subscribe(onAction, onError);
	}

}