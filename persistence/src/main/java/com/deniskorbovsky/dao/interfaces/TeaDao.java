package com.deniskorbovsky.dao.interfaces;


    import com.deniskorbovsky.model.Tea;
    import org.hibernate.criterion.Criterion;

    import java.util.List;

    public interface TeaDao {

        Tea getById(int id);
        List<Tea> getAll(int numberOfPage, int amountOnPage);
        List<Tea> getAll();
        List<Tea> getByCriterion(Criterion criterion);
        List<Tea> getByCriterion(Criterion criterion, int numberOfPage, int amountOnPage);
    }
