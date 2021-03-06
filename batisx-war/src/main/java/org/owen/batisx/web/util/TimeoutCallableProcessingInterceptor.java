/**
 * owen.org Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package org.owen.batisx.web.util;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.CallableProcessingInterceptorAdapter;

import java.util.concurrent.Callable;

public class TimeoutCallableProcessingInterceptor extends CallableProcessingInterceptorAdapter {

	@Override
	public <T> Object handleTimeout(NativeWebRequest request, Callable<T> task) throws Exception {
		throw new IllegalStateException("[" + task.getClass().getName() + "] timed out");
	}

}
