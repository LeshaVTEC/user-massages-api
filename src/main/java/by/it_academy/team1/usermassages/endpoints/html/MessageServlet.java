package by.it_academy.team1.usermassages.endpoints.html;

import by.it_academy.team1.usermassages.core.dto.MessageDto;
import by.it_academy.team1.usermassages.core.exceptions.UserNotFoundException;
import by.it_academy.team1.usermassages.service.api.IMessageService;
import by.it_academy.team1.usermassages.service.factory.MessageServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author makatrov_anton@mail.ru
 */

@WebServlet("/api/message")
public class MessageServlet extends HttpServlet {

    private IMessageService messageService = MessageServiceFactory.getInstance();
    private static final String RECIPIENT_PARAM_NAME = "recipient";
    private static final String MESSAGE_TEXT_PARAM_NAME = "messageText";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        try{
            String currentUser = (String) session.getAttribute("user");
            req.setAttribute("messages", this.messageService.getMessagesOfUser(currentUser));
            req.getRequestDispatcher("/ui/user/chats.jsp").forward(req, resp);
        } catch (UserNotFoundException e){
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.getWriter().write(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        HttpSession session = req.getSession();

        try{
        String currentUser = (String) session.getAttribute("user");
        // Получите параметры из POST-запроса
        String recipient = req.getParameter(RECIPIENT_PARAM_NAME);
        String messageText = req.getParameter(MESSAGE_TEXT_PARAM_NAME);

        // Создайте новое сообщение
        MessageDto message = new MessageDto();
        message.setUsernameFrom(currentUser); // Установите отправителя как текущего пользователя
        message.setUsernameTo(recipient);
        message.setText(messageText);

        // Отправьте сообщение
        messageService.sendMessage(message);

        // Отправьте успешный ответ
        resp.setStatus(HttpServletResponse.SC_CREATED);
        } catch (UserNotFoundException e){
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.getWriter().write(e.getMessage());
        }
    }
}
