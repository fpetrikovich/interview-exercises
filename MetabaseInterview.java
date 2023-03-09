/**
 *
 (def data
 {"people"
 [{:id 1, :name "Cam Saul"}
 {:id 2, :name "Cam Era"}]

 "birds"
 [{:id 1, :name "Parroty Parakeet", :owner_id 1}
 {:id 2, :name "Lemon Parakeet", :owner_id 1}
 {:id 3, :name "Lime Parakeet", :owner_id 1}
 {:id 4, :name "Katie Parakeet", :owner_id 1}
 {:id 5, :name "Lucky Pigeon", :owner_id 1}
 {:id 6, :name "Rasta Toucan", :owner_id 1}]})

 (defn query [s]
 ;; TODO
 )

 (deftest query-test
 (is (= [{:id 1, :name "Cam Saul"}
 {:id 2, :name "Cam Era"}]
 (query "SELECT * FROM people")))

 (is (= [{:id 2, :name "Cam Era"}]
 (query "SELECT * FROM people WHERE id = 2")))

 (is (= [{:id 5, :name "Lucky Pigeon", :owner_id 1}
 {:id 6, :name "Rasta Toucan", :owner_id 1}]
 (query "SELECT * FROM birds WHERE id > 4")))

 (is (= [{:name "Cam Saul"} {:name "Cam Era"}]
 (query "SELECT name FROM people")))

 (is (= [{:id 1, :name "Cam Saul"} {:id 2, :name "Cam Era"}]
 (query "SELECT id, name FROM people"))))
 */
public class MetabaseInterview {

    private Map<String, List<Map<String, Object>>> db = new HashMap<>();

//     "birds"
//             [{:id 1, :name "Parroty Parakeet", :owner_id 1}
//    {:id 2, :name "Lemon Parakeet", :owner_id 1}
//    {:id 3, :name "Lime Parakeet", :owner_id 1}
//    {:id 4, :name "Katie Parakeet", :owner_id 1}
//    {:id 5, :name "Lucky Pigeon", :owner_id 1}
//    {:id 6, :name "Rasta Toucan", :owner_id 1}]})
    public static void main(String[] args) {
        Map<String, Object> e1 = new HashMap<>();
        e1.add("id", 2);
        e1.add("name", "Lemon Parakeet");
        e1.add("owner_id", 1);
        List<Map<String, Object>> birds = new LinkedList<>();
        birds.add(e1);
        db.put("birds", birds);

        parseSQLQuery('SELECT * FROM birds');
        parseSQLQuery('SELECT id, name FROM birds');
    }

    public static void parseSQLQuery(String query) {
        // "id|name"
        String[] select = query.substring(str.indexOf("SELECT") + 7, str.indexOf("FROM")-1).split(", ");
        String table = query.substring(str.indexOf("FROM") + 5, query.size()).split(" ")[0];
        String where = query.substring(str.indexOf("WHERE") + 6;

        System.out.println(select);
        System.out.println(table);
        System.out.println(where);


        List<Map<String, Object>> data = db.get(table);

        if (select[0] == "*") {
            return data;
        }

        List<Map<String, Object>> returnData = new LinkedList<>>();

        for (Map<String, Object> dbEntry : data) {
            Map<String, Object> currEntry = new HashMap<>();
            for (String key: select) {
                currEntry.put(key, dbEntry.get(key));
            }
            returnData.add(currEntry.clone())
        }
        returnData.entrySet().stream().forEach(e-> System.out.println(e));

        return returnData;

    }
}
