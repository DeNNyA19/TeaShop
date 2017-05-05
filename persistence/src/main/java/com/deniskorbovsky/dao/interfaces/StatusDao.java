package com.deniskorbovsky.dao.interfaces;

import com.deniskorbovsky.model.Status;

import java.util.List;

/**
 * Created by denis on 20.04.2017.
 */
public interface StatusDao {

    List<Status> getStatuses();
}
