package dao;

import org.springframework.stereotype.Component;

@Component("dao")
public class DaoImpl implements IDao{

    @Override
    public double getData() {
        System.out.println("Moyenne de AZEHAF Issam");
        double Moyenne = 15.50;
        return Moyenne;
    }
}
