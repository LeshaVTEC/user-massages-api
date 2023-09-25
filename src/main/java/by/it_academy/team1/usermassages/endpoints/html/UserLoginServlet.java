package by.it_academy.team1.usermassages.endpoints.html;

import by.it_academy.team1.usermassages.core.dto.UserLoginDto;
import by.it_academy.team1.usermassages.service.UserLoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author qeliathus@gmail.com
 */
public class UserLoginServlet extends HttpServlet {

    private static final String USER_PARAM_USERNAME = "username";
    private static final String USER_PARAM_PASSWORD = "password";

    UserLoginService userLoginService = UserLoginService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String username = req.getParameter(USER_PARAM_USERNAME);
        String password = req.getParameter(USER_PARAM_PASSWORD);

        UserLoginDto userLoginDto = new UserLoginDto();
        userLoginDto.setUsername(username);
        userLoginDto.setPassword(password);

        userLoginService.authenticate(userLoginDto);


    }
}
