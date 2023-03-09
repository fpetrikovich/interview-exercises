import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SQLParser {

    private static Map<String, List<Map<String, Object>>> db = new HashMap<>();

    //     "birds"
//             [{:id 1, :name "Parroty Parakeet", :owner_id 1}
//    {:id 2, :name "Lemon Parakeet", :owner_id 1}
//    {:id 3, :name "Lime Parakeet", :owner_id 1}
//    {:id 4, :name "Katie Parakeet", :owner_id 1}
//    {:id 5, :name "Lucky Pigeon", :owner_id 1}
//    {:id 6, :name "Rasta Toucan", :owner_id 1}]})
    public static void main(String[] args) {
        Map<String, Object> e1 = new HashMap<>();
        e1.put("id", 2);
        e1.put("name", "Lemon Parakeet");
        e1.put("owner_id", 1);
        Map<String, Object> e2 = new HashMap<>();

        e2.put("id", 3);
        e2.put("name", "Lemon Parakeet 2");
        e2.put("owner_id", 3);
        List<Map<String, Object>> birds = new LinkedList<>();
        birds.add(e1);
        birds.add(e2);
        db.put("birds", birds);

        parseSQLQuery("SELECT * FROM birds");
        parseSQLQuery("SELECT id, name FROM birds");
    }

    public static void parseSQLQuery(String query) {
        // "id|name"
        String[] select = query.substring(query.indexOf("SELECT") + 7, query.indexOf("FROM")-1).split(", ");
        String table = query.substring(query.indexOf("FROM") + 5, query.length()).split(" ")[0];
        String where = query.substring(query.indexOf("WHERE") + 6);

        System.out.println(select);
        System.out.println(table);
        System.out.println(where);


        List<Map<String, Object>> data = db.get(table);

//        if (select[0] == "*") {
//            data.stream().forEach(e-> System.out.println(e));
//        }

//        List<Map<String, Object>> returnData = new LinkedList<> >();

        for (Map<String, Object> dbEntry : data) {
//            Map<String, Object> currEntry = new HashMap<>();
            for (String key: select) {
//                currEntry.put(key, dbEntry.get(key));
                System.out.println(key  +" "+ dbEntry.get(key));
            }
//            returnData.add(currEntry.clone());
        }
//        returnData.stream().forEach(e-> System.out.println(e));

    }
}
