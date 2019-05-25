import org.jsoup.Jsoup;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Lawrence Huang on 11/9/2016.
 */
public class URLTest {
    public static void main(String[] args) throws Exception{
        String URLStr = "http://www.columbia.edu/~hr2362/shp/";
        URL myURL = null;
        URLConnection myURLConnection = null;
        BufferedReader in = null;
        BufferedReader in2 = null;
        String input = null;

        try {
            myURL = new URL(URLStr);

            in = new BufferedReader(new
                    InputStreamReader(myURL.openStream()));

            myURLConnection = myURL.openConnection();

            in2 = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));

            while((input = in.readLine()) != null){
                System.out.println(Jsoup.parse(input).text().replaceAll("\n",""));
            }
        }
        catch (MalformedURLException e){
            System.out.println("The URL " + URLStr + " is malformed");
            return;
        }
        catch (IOException e){
            System.out.println("IOException");
            e.printStackTrace();
            return;
        }
        finally{
            if(in != null){
                in.close();
            }
            if(in2 != null) {
                in2.close();
            }
        }

        //Print attributes
        System.out.println(myURL.getProtocol());
        System.out.println(myURL.getHost());
        System.out.println(myURL.getPath());
    }
}
