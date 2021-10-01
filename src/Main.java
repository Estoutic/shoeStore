import Db.DbManager;
import service.Consult;

public class Main {

    public static void main(final String[] args) {
        Consult consult = new Consult();
        DbManager dbManager = DbManager.getInstance();
        System.out.println(String.format("Hello, i`m your consult !s , what you looking for?",consult.getName()));
        dbManager.insertProduct("D", "mockasins", 36,10,15000);
        System.out.println(dbManager.getProductInfo("D"));

    }

}
