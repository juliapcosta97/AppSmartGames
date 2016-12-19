package helper;

/**
 * Created by 15160046 on 07/11/2016.
 */
public class HttpRequestFabric {

    public static HttpRequest getHttpRequest(boolean acessarInternet){

        if(acessarInternet)
            return new WebHttpRequest();
        else
            return new FakeHttpRequest();

    }
}
