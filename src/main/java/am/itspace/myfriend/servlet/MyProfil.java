package am.itspace.myfriend.servlet;

import am.itspace.myfriend.model.Images;
import am.itspace.myfriend.model.User;
import am.itspace.myfriend.service.ImagesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;

@WebServlet("/myProfil")
@MultipartConfig(
        maxFileSize = 1024 * 1024 * 5, //5mb
        maxRequestSize = 1024 * 1024 * 10,
        fileSizeThreshold = 1024 * 1024 * 1
)
public class MyProfil extends HttpServlet {

    ImagesService imagesService = new ImagesService();
    private final String IMG_FOLDER = "C:\\Users\\NITRO\\IdeaProjects\\My friend\\images\\";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Images> images = imagesService.getAllImages(((User)(req.getSession().getAttribute("user"))).getId());
        System.out.println(images);
        req.setAttribute("images", images);
        req.getRequestDispatcher("/WEB-INF/myProfil.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part img = req.getPart("img");
        String imgName = System.nanoTime() + "_" + img.getSubmittedFileName();
        img.write(IMG_FOLDER + imgName);
        imagesService.addImage(Images.builder()
                        .userId(((User)(req.getSession().getAttribute("user"))).getId())
                        .imgName(imgName)
                .build());
        List<Images> images = imagesService.getAllImages(((User)(req.getSession().getAttribute("user"))).getId());
        req.setAttribute("images", images);
        req.getRequestDispatcher("/WEB-INF/myProfil.jsp").forward(req, resp);
    }
}
