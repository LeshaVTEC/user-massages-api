package by.it_academy.team1.usermessages.endpoints.html;

import by.it_academy.team1.usermessages.core.dto.MessageDto;
import by.it_academy.team1.usermessages.core.dto.UserLoginDto;
import by.it_academy.team1.usermessages.core.entity.Message;
import by.it_academy.team1.usermessages.core.exceptions.UserNotFoundException;
import by.it_academy.team1.usermessages.service.api.IMessageService;
import by.it_academy.team1.usermessages.service.factory.MessageServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

/**
 * @author makatrov_anton@mail.ru
 */

@WebServlet("/api/message")
public class MessageServlet extends HttpServlet {


    private static final String RECIPIENT_PARAM_NAME = "recipient";
    private static final String MESSAGE_TEXT_PARAM_NAME = "text";

    private final IMessageService messageService;


    public MessageServlet() {
        this.messageService = MessageServiceFactory.getInstance();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        HttpSession session = req.getSession();

        try{

            UserLoginDto currentUser = (UserLoginDto) session.getAttribute("user");
        // Получите параметры из POST-запроса
            String recipient = req.getParameter(RECIPIENT_PARAM_NAME);
            String messageText = req.getParameter(MESSAGE_TEXT_PARAM_NAME);

        // Создайте новое сообщение
            MessageDto message = new MessageDto();
            message.setUsernameFrom(currentUser.getUsername()); // Установите отправителя как текущего пользователя
            message.setUsernameTo(recipient);
            message.setText(messageText);

        // Отправьте сообщение


            try{
                this.messageService.sendMessage(message);
                req.setAttribute("success", true);
            } catch (IllegalArgumentException e){
                req.setAttribute("error", true);
                req.setAttribute("message",  e.getMessage());
            }
            req.getRequestDispatcher("/template/ui/user/message/").forward(req, resp);

            resp.setStatus(HttpServletResponse.SC_CREATED);
            } catch (UserNotFoundException e){
                resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                resp.getWriter().write(e.getMessage());
        }

    }
}
