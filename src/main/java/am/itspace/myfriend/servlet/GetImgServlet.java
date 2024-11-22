package am.itspace.myfriend.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/getImg")
public class GetImgServlet extends HttpServlet {

    private final String IMG_FOLDER = "C:\\Users\\NITRO\\IdeaProjects\\My friend\\images\\";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String imgName = req.getParameter("imgName");
        File imgFile = new File(IMG_FOLDER + imgName);
        try(FileInputStream inputStream = new FileInputStream(imgFile)) {

            resp.setContentType("image/jpeg");
            resp.setContentLength((int) imgFile.length());

            OutputStream outputStream = resp.getOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException  e) {
            throw new RuntimeException(e);
        }
    }
}
