package extension;

import dao.IDao;
import org.springframework.stereotype.Component;

@Component("dao")
public class DaoImpl2 implements IDao {
    @Override
    public double getData() {
        System.out.println("Moyenne de MBARAKO Youness");
        double Moyenne = 18.25;
        return Moyenne;
    }
}
