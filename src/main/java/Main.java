import main.java.service.Consult;
import service.ProductManager;

public class Main {

    public static void main(final String[] args) {
        Consult consult = new Consult();
        ProductManager productManager = new ProductManager();
        productManager.deliveryOfGoods("D", "shale", 38, 12, 2000);
        consult.getHelp();

    }
}
