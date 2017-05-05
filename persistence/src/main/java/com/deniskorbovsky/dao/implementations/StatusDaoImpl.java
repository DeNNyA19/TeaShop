package com.deniskorbovsky.dao.implementations;

import com.deniskorbovsky.dao.interfaces.StatusDao;
import com.deniskorbovsky.model.Status;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("statusDao")
public class StatusDaoImpl implements StatusDao {


    public List<Status> getStatuses() {
        List<Status> statuses = new ArrayList<>();
        statuses.add(Status.NEW);
        statuses.add(Status.PAID);
        statuses.add(Status.WAIT);
        return statuses;
    }
}
