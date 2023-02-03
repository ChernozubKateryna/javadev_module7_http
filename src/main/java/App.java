import com.goit.feature.HttpImageStatusCli;
import com.goit.feature.exception.NotFoundException;

public class App {
    public static void main(String[] args) throws NotFoundException {
        HttpImageStatusCli cli = new HttpImageStatusCli();
        cli.askStatus();
    }
}
