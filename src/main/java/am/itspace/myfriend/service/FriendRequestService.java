package am.itspace.myfriend.service;

import am.itspace.myfriend.db.DBConnectionProvider;
import am.itspace.myfriend.model.FriendRequest;
import am.itspace.myfriend.model.User;
import am.itspace.myfriend.util.DateUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FriendRequestService {

    Connection connection = DBConnectionProvider.getInstance().getConnection();

    public void add(FriendRequest friendRequest) {
        String sql = "insert into friend_request (from_id, to_id, date) values (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, friendRequest.getFromUser().getId());
            ps.setInt(2, friendRequest.getToUser().getId());
            ps.setString(3, DateUtil.fromDateToSqlString(friendRequest.getDate()));
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                friendRequest.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<FriendRequest> getAllFriendRequestByToId(int fromId) {
        List<FriendRequest> result = new ArrayList<>();
        String sql = "SELECT * FROM friend_request " +
                "INNER JOIN user u1 ON friend_request.from_id = u1.id " +
                "INNER JOIN user u2 ON friend_request.to_id = u2.id " +
                "WHERE to_id = " + fromId;
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                result.add(FriendRequest.builder()
                                .id(resultSet.getInt(1))
                                .fromUser(User.builder()
                                        .id(resultSet.getInt(5))
                                        .name(resultSet.getString(6))
                                        .surname(resultSet.getString(7))
                                        .email(resultSet.getString(8))
                                        .password(resultSet.getString(9))
                                        .image_name(resultSet.getString(10))
                                        .build())
                                .toUser(User.builder()
                                        .id(resultSet.getInt(11))
                                        .name(resultSet.getString(12))
                                        .surname(resultSet.getString(13))
                                        .email(resultSet.getString(14))
                                        .password(resultSet.getString(15))
                                        .image_name(resultSet.getString(16))
                                        .build())
                                .date(resultSet.getDate(4))
                        .build());
            }
        } catch (SQLException  e) {
            e.printStackTrace();
        }
        return result;
    }

    public void delete(int id){
        String sql = "DELETE FROM friend_request WHERE id = " + id;
        try(Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public FriendRequest getFriendRequestById(int fromId) {
        FriendRequest result = null;
        String sql = "SELECT * FROM friend_request " +
                "INNER JOIN user u1 ON friend_request.from_id = u1.id " +
                "INNER JOIN user u2 ON friend_request.to_id = u2.id " +
                "WHERE to_id = " + fromId;
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                result = FriendRequest.builder()
                        .id(resultSet.getInt(1))
                        .fromUser(User.builder()
                                .id(resultSet.getInt(5))
                                .name(resultSet.getString(6))
                                .surname(resultSet.getString(7))
                                .email(resultSet.getString(8))
                                .password(resultSet.getString(9))
                                .image_name(resultSet.getString(10))
                                .build())
                        .toUser(User.builder()
                                .id(resultSet.getInt(11))
                                .name(resultSet.getString(12))
                                .surname(resultSet.getString(13))
                                .email(resultSet.getString(14))
                                .password(resultSet.getString(15))
                                .image_name(resultSet.getString(16))
                                .build())
                        .date(resultSet.getDate(4))
                        .build();
            }
        } catch (SQLException  e) {
            e.printStackTrace();
        }
        return result;
    }



    public List<FriendRequest> getAllFriendRequestByFromId(int fromId) {
        List<FriendRequest> result = new ArrayList<>();
        String sql = "SELECT * FROM friend_request " +
                "INNER JOIN user u1 ON friend_request.from_id = u1.id " +
                "INNER JOIN user u2 ON friend_request.to_id = u2.id " +
                "WHERE from_id = " + fromId;
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                result.add(FriendRequest.builder()
                        .id(resultSet.getInt(1))
                        .fromUser(User.builder()
                                .id(resultSet.getInt(5))
                                .name(resultSet.getString(6))
                                .surname(resultSet.getString(7))
                                .email(resultSet.getString(8))
                                .password(resultSet.getString(9))
                                .image_name(resultSet.getString(10))
                                .build())
                        .toUser(User.builder()
                                .id(resultSet.getInt(11))
                                .name(resultSet.getString(12))
                                .surname(resultSet.getString(13))
                                .email(resultSet.getString(14))
                                .password(resultSet.getString(15))
                                .image_name(resultSet.getString(16))
                                .build())
                        .date(resultSet.getDate(4))
                        .build());
            }
        } catch (SQLException  e) {
            e.printStackTrace();
        }
        return result;
    }


}
