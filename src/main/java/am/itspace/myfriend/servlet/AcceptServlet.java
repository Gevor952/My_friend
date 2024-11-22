package am.itspace.myfriend.servlet;

import am.itspace.myfriend.model.FriendRequest;
import am.itspace.myfriend.service.FriendRequestService;
import am.itspace.myfriend.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/accept")
public class AcceptServlet extends HttpServlet {

    FriendRequestService friendRequestService = new FriendRequestService();
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        FriendRequest friendRequest = friendRequestService.getFriendRequestById(id);
        userService.acceptFriend(friendRequest.getFromUser(), friendRequest.getToUser());
    }
}
