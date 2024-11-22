package am.itspace.myfriend.servlet;

import am.itspace.myfriend.model.FriendRequest;
import am.itspace.myfriend.model.User;
import am.itspace.myfriend.service.FriendRequestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/sendRequest")
public class SendRequestServlet extends HttpServlet {

    FriendRequestService friendRequestService = new FriendRequestService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        FriendRequest friendRequest = null;
        friendRequestService.add( FriendRequest.builder()
                        .fromUser(((User)req.getSession().getAttribute("user")))
                        .toUser(User.builder()
                                .id(userId)
                                .build())
                        .date(new Date())
                .build());
        resp.sendRedirect("/users");

    }
}
