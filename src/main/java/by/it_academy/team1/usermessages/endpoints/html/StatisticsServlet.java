package by.it_academy.team1.usermessages.endpoints.html;

import by.it_academy.team1.usermessages.service.StatisticsService;
import by.it_academy.team1.usermessages.service.api.IStatisticsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static by.it_academy.team1.usermessages.service.StatisticsService.*;


@WebServlet(urlPatterns = "/api/admin/statistics")
public class StatisticsServlet extends HttpServlet {

    private final IStatisticsService statisticsService = StatisticsService.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        req.setAttribute(TOTAL_USERS_KEY, statisticsService.getStats().get(TOTAL_USERS_KEY));
        req.setAttribute(TOTAL_MESSAGES_KEY, statisticsService.getStats().get(TOTAL_MESSAGES_KEY));
        req.setAttribute(TOTAL_ACTIVE_USERS_KEY, statisticsService.getStats().get(TOTAL_ACTIVE_USERS_KEY));

        req.getRequestDispatcher("/template/ui/admin/statistics/index.jsp").forward(req, resp);
    }
}
