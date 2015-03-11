import com.fedomn.servlet.Model.Goddess;
import com.fedomn.servlet.Service.GoddessService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServiceTests {

    private static Date birthday;
    static {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthday = format.parse("1991-10-21");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_01_addDb_success() throws SQLException, ParseException {
        Goddess goddess = new Goddess(10, "小夏", 1, 10, birthday, "1111@qq.com", "10086");
        new GoddessService().add(goddess);
    }

    @Test
    public void test_02_queryDbById_success() throws SQLException {
        Goddess goddess1 = new GoddessService().queryById(10);
        Goddess goddess2 = new Goddess(10, "小夏", 1, 10, new java.sql.Date(birthday.getTime()), "1111@qq.com", "10086");
        System.out.println(goddess1);
        System.out.println(goddess2);
        Assert.assertEquals(goddess1, goddess2);
    }

    @Test
    public void test_03_updateDbById_success() throws SQLException {
        Goddess goddess = new Goddess(10, "小夏", 1, 30, birthday, "1111@qq.com", "10086");
        new GoddessService().update(goddess);
    }

    @Test
    public void test_04_deleteBdById_success() throws SQLException {
        Goddess goddess = new Goddess(10, "小夏", 2, 1, birthday, "1111@qq.com", "10086");
        new GoddessService().deleteById(goddess);
    }


}
