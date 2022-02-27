package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier{

    //Couplage Faible
    @Autowired
    private IDao dao;
    @Override
    public double calcul() {
        double moyenne = (dao.getData()+15)/2;
        return moyenne;
    }

    public void setDao(IDao dao){
        this.dao = dao;
    }
}
