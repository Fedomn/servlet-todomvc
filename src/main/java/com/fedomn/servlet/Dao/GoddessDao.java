package com.fedomn.servlet.Dao;

import com.fedomn.servlet.Model.Goddess;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoddessDao extends Dao {

    public void add(Goddess goddess) throws SQLException {
        String sql = "INSERT INTO goddess (id, user_name, sex, age, birthday, email, mobile, create_date, update_date)" +
                "VALUES(?, ?, ?, ?, ?, ?, ?, current_date(), current_date());";

        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, goddess.getId());
        preparedStatement.setString(2, goddess.getUser_name());
        preparedStatement.setInt(3, goddess.getSex());
        preparedStatement.setInt(4, goddess.getAge());
        preparedStatement.setDate(5, new Date(goddess.getBirthday().getTime()));
        preparedStatement.setString(6, goddess.getEmail());
        preparedStatement.setString(7, goddess.getMobile());
        preparedStatement.execute();

        close();
    }

    public void update(Goddess goddess) throws SQLException {
        String sql = " UPDATE goddess SET user_name=?, sex=?, age=?, birthday=?, email=?, mobile=?, " +
                "update_date=current_date() " +
                "WHERE id = ?";

        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, goddess.getUser_name());
        preparedStatement.setInt(2, goddess.getSex());
        preparedStatement.setInt(3, goddess.getAge());
        preparedStatement.setDate(4, new Date(goddess.getBirthday().getTime()));
        preparedStatement.setString(5, goddess.getEmail());
        preparedStatement.setString(6, goddess.getMobile());
        preparedStatement.setInt(7, goddess.getId());
        preparedStatement.execute();

        close();
    }

    public void deleteById(Goddess goddess) throws SQLException {
        String sql = "delete from goddess where id = ?";
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, goddess.getId());
        preparedStatement.execute();

        preparedStatement.close();
        close();
    }

    public Goddess queryById(Integer id) throws SQLException {
        Goddess goddess = null;
        String sql = "SELECT * FROM goddess WHERE id = ?";
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            goddess = new Goddess(resultSet.getInt("id"), resultSet.getString("user_name"),
                    resultSet.getInt("sex"), resultSet.getInt("age"), resultSet.getDate("birthday"),
                    resultSet.getString("email"), resultSet.getString("mobile"));
        }

        resultSet.close();
        close();
        return goddess;
    }

    public List<Goddess> query() throws SQLException {
        List<Goddess> queryRes = new ArrayList<Goddess>();
        String sql = "select * from goddess";
        preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            queryRes.add(new Goddess(resultSet.getInt("id"), resultSet.getString("user_name"),
                    resultSet.getInt("sex"), resultSet.getInt("age"), resultSet.getDate("birthday"),
                    resultSet.getString("email"), resultSet.getString("mobile")));
        }

        resultSet.close();
        close();
        return queryRes;
    }


}
