package am.itspace.myfriend.service;

import am.itspace.myfriend.db.DBConnectionProvider;
import am.itspace.myfriend.model.Comment;
import am.itspace.myfriend.model.Images;
import am.itspace.myfriend.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommentService {
    Connection connection = DBConnectionProvider.getInstance().getConnection();

    public List<Comment> getAllCommentsByImgId(int imgId) {
        List<Comment> comments = new ArrayList<>();
        String sql = "select * from comment INNER JOIN user ON comment.user_id = user.id " +
                    "INNER JOIN images ON comment.img_id = images.id WHERE img_id = " + imgId;
        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Comment comment = Comment.builder()
                        .user(User.builder()
                                .id(resultSet.getInt(4))
                                .name(resultSet.getString(5))
                                .surname(resultSet.getString(6))
                                .email(resultSet.getString(7))
                                .password(resultSet.getString(8))
                                .image_name(resultSet.getString(9))
                                .build())
                        .images(Images.builder()
                                .id(resultSet.getInt(10))
                                .userId(resultSet.getInt(11))
                                .imgName(resultSet.getString(12))
                                .like(resultSet.getBoolean(13))
                                .build())
                        .comment(resultSet.getString(3))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }
}
