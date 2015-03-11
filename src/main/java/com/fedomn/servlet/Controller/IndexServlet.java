package com.fedomn.servlet.Controller;

import com.fedomn.servlet.Model.Goddess;
import com.fedomn.servlet.Service.GoddessService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IndexServlet extends HttpServlet {

    private List<Goddess> goddessList = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            goddessList = new GoddessService().query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("goddessList", goddessList);
        req.getRequestDispatcher("WEB-INF/pages/userList.jsp").forward(req, resp);
    }
}
