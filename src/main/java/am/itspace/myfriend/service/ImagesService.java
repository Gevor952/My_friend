package am.itspace.myfriend.service;

import am.itspace.myfriend.db.DBConnectionProvider;
import am.itspace.myfriend.model.Images;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImagesService {
    Connection connection = DBConnectionProvider.getInstance().getConnection();

    public List<Images> getAllImages(int id) {
        List<Images> images = new ArrayList<>();
        String sql = "SELECT * FROM images WHERE user_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Images image = Images.builder()
                        .id(rs.getInt("id"))
                        .userId(rs.getInt("user_id"))
                        .imgName(rs.getString("img_name"))
                        .like(rs.getBoolean("like"))
                        .comment(rs.getString("comment"))
                        .build();
                images.add(image); // Add the image to the list
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return images;
    }


    public void addImage(Images image) {
        String sql = "INSERT INTO images (user_id, img_name) VALUES (?, ?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, image.getUserId());
            preparedStatement.setString(2, image.getImgName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateLikeById(int id, boolean like) {
        String sql = "UPDATE images SET `like` = ? WHERE `id` = " + id;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setBoolean(1, like);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
