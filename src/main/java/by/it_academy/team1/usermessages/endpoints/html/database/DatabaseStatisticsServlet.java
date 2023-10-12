package by.it_academy.team1.usermessages.endpoints.html.database;

import by.it_academy.team1.usermessages.dao.api.IMessageDao;
import by.it_academy.team1.usermessages.dao.api.IUserDao;
import by.it_academy.team1.usermessages.dao.database.factory.DatabaseMessageDaoFactory;
import by.it_academy.team1.usermessages.dao.database.factory.DatabaseUserDaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/database/api/admin/statistics")
public class DatabaseStatisticsServlet extends HttpServlet {

        private IUserDao userDao = DatabaseUserDaoFactory.getInstance();
        private IMessageDao messageDao = DatabaseMessageDaoFactory.getInstance();

    public DatabaseStatisticsServlet() throws PropertyVetoException, SQLException, IOException {
    }

    @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");

            ;

            getServletContext().getRequestDispatcher("/template/database/admin/statistics/index.jsp").forward(req, resp);
        }
    }
