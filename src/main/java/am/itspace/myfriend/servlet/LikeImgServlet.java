package am.itspace.myfriend.servlet;

import am.itspace.myfriend.service.ImagesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/likeImg")
public class LikeImgServlet extends HttpServlet {

    ImagesService imagesService = new ImagesService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String booleanLike = req.getParameter("boolean");
        imagesService.updateLikeById(id, booleanLike.equals("0"));
        resp.sendRedirect("/myProfil");
    }
}
