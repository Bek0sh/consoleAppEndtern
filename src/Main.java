import controller.AuthenticatorController;
import controller.MarketController;
import controller.UserController;
import data.IDB;
import data.PostgresDB;
import repositories.ProductRepository;
import repositories.interfaces.IProductRepository;
import repositories.interfaces.IUserRepositories;
import repositories.UserRepositories;

public class Main {
    public static void main(String[] args) {


        IDB db = new PostgresDB();
        IUserRepositories repo = new UserRepositories(db);
        IProductRepository productRepo = new ProductRepository(db);
        UserController controller = new UserController(repo);
        AuthenticatorController authController = new AuthenticatorController(repo);
        MarketController marketController = new MarketController(productRepo);

        MyApplication app = new MyApplication(controller, authController, marketController);
        app.start();
    }


}