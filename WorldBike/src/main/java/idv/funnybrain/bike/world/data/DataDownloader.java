package idv.funnybrain.bike.world.data;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import org.apache.http.client.params.AllClientPNames;

/**
 * Created by freeman on 2014/4/28.
 */
public class DataDownloader {
    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.setTimeout(15000);
        client.setMaxRetriesAndTimeout(10, 1300);
        client.get(url, params, responseHandler);
        client.getHttpClient().getParams().setParameter(AllClientPNames.ALLOW_CIRCULAR_REDIRECTS, true);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.setTimeout(15000);
        client.setMaxRetriesAndTimeout(10, 1300);
        client.post(url, params, responseHandler);
        client.getHttpClient().getParams().setParameter(AllClientPNames.ALLOW_CIRCULAR_REDIRECTS, true);
    }

//    private static String getAbsoluteUrl(String relativeUrl) {
//        return DataURL + relativeUrl;
//    }
}
