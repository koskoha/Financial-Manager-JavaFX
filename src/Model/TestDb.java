package Model;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

/**
 * Created by igor on 02.12.15.
 */
public class TestDb {
    public static void main(String[] args) throws IOException, URISyntaxException {
//        DbHelper dbHelper = new DbHelper();
//        DbHelper dbHelper2 = new DbHelper();

        DbHelper instance = DbHelper.getInstance();
//        DbHelper instance2 = DbHelper.getInstance();
        Model model = new Model();
        //****************************************************

       /* User user = new User("kos","1");
        Account account = new Account("gen",111,"kos");
        Set<Record> names = model.getRecords(account);
        for (Record record:names){
            System.out.println(record);
        }*/

        //****************************************************
        //System.out.println(names.toString());


 //       System.out.println(instance.getResult("SELECT * FROM users where name = \"Bob\";"));
//        System.out.println(instance.getAllCategories());
  //      System.out.println(instance.getAllCategoriesPS());
    }
}
