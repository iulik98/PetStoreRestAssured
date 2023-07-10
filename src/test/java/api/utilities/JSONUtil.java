package api.utilities;

import org.joda.time.DateTime;
public class JSONUtil {

    public static String createJSON(int id, int petId, int quantity, String shipDate, String status, boolean complete) {

        StringBuilder sb = new StringBuilder();
        sb.append( "{\n" +
                "  \"id\": "+id+",\n" +
                "  \"petId\": "+petId+",\n" +
                "  \"quantity\": "+quantity+",\n" +
                "  \"shipDate\": \""+shipDate+"\",\n" +
                "  \"status\": \""+status+"\",\n" +
                "  \"complete\": "+complete+"\n" +
                "}");

        return sb.toString();
    }
}
