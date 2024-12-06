package am.itspace.myfriend.servlet;

import am.itspace.myfriend.model.Comment;
import am.itspace.myfriend.model.User;
import am.itspace.myfriend.service.CommentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/commentImg")
public class CommentImgServlet extends HttpServlet {

    CommentService commentService = new CommentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int imgId = Integer.parseInt(req.getParameter("id"));
        List<Comment> comments = commentService.getAllCommentsByImgId(imgId);
        req.setAttribute("comments", comments);
        req.getRequestDispatcher("/WEB-INF/commentImg.jsp").forward(req, resp);
    }
}
