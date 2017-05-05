package com.deniskorbovsky.service.implementations;

import com.deniskorbovsky.dao.interfaces.StatusDao;
import com.deniskorbovsky.model.Status;
import com.deniskorbovsky.service.interfaces.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("statusService")
public class StatusServiceImpl implements StatusService {

    @Autowired
    StatusDao statusDao;

    public List<Status> getStatuses() {
        return statusDao.getStatuses();
    }
}
