package com.fedomn.servlet.Service;

import com.fedomn.servlet.Dao.GoddessDao;
import com.fedomn.servlet.Model.Goddess;

import java.sql.SQLException;
import java.util.List;

public class GoddessService {

    GoddessDao goddessDao;

    public GoddessService() {
        goddessDao = new GoddessDao();
    }

    public void add(Goddess goddess) throws SQLException {
        goddessDao.add(goddess);
    }

    public void update(Goddess goddess) throws SQLException {
        goddessDao.update(goddess);
    }

    public Goddess queryById(Integer id) throws SQLException {
        return goddessDao.queryById(id);
    }

    public void deleteById(Goddess goddess) throws SQLException {
        goddessDao.deleteById(goddess);
    }

    public List<Goddess> query() throws SQLException {
        return goddessDao.query();
    }
}
