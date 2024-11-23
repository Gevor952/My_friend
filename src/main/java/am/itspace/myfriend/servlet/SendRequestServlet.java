package am.itspace.myfriend.servlet;

import am.itspace.myfriend.model.FriendRequest;
import am.itspace.myfriend.model.User;
import am.itspace.myfriend.service.FriendRequestService;
import am.itspace.myfriend.service.UserService;

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
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        boolean friendOrNo = friendOrNo(((User) req.getSession().getAttribute("user")).getId(), userId);
        StringBuilder msg = new StringBuilder();
        if (friendRequestService.getFriendRequestByToAndFromId(((User) req.getSession().getAttribute("user")).getId(), userId) == null && friendOrNo) {
            FriendRequest friendRequest = null;
            friendRequestService.add(FriendRequest.builder()
                    .fromUser(((User) req.getSession().getAttribute("user")))
                    .toUser(User.builder()
                            .id(userId)
                            .build())
                    .date(new Date())
                    .build());
            resp.sendRedirect("/users");
        } else if(!friendOrNo) {
            msg.append("you are already friend");
            req.setAttribute("msg", msg.toString());
            req.setAttribute("users", userService.getAllUsers(((User) req.getSession().getAttribute("user")).getId()));
            req.getRequestDispatcher("/WEB-INF/users.jsp").forward(req, resp);
        }else {
            msg.append("you are already sent a request");
            req.setAttribute("msg", msg.toString());
            req.setAttribute("users", userService.getAllUsers(((User) req.getSession().getAttribute("user")).getId()));
            req.getRequestDispatcher("/WEB-INF/users.jsp").forward(req, resp);
        }

    }

    private boolean friendOrNo(int userId, int friendId) {
        return userService.getFriends(userId, friendId) == null;
    }
}
