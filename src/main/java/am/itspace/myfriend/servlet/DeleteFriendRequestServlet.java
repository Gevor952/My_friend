package am.itspace.myfriend.servlet;

import am.itspace.myfriend.service.FriendRequestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteFriendRequest")
public class DeleteFriendRequestServlet extends HttpServlet {

    FriendRequestService friendRequestService = new FriendRequestService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int friendRequestId = Integer.parseInt(req.getParameter("id"));
        friendRequestService.delete(friendRequestId);
        resp.sendRedirect("/friendResponses");
    }
}
