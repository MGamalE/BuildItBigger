package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by Mohammad on 12/02/2018.
 */
@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest extends AndroidTestCase implements IAsyncTask {

    @Test
    public void testDoInBackground() throws Exception {
        String joke;
        try {
            AsyncTask asyncTask = (AsyncTask) new AsyncTask(this).execute();
            joke = asyncTask.get(30, TimeUnit.SECONDS);
            assertThat(joke, notNullValue());
            assertTrue(joke.length() > 0);
        } catch (Exception e) {
            fail("Timed out");
        }
    }

    @Override
    public void IAsyncTask(String result) {

    }
}
