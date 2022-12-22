package com.test.task.ConnectionManagerUtilTest;

import com.test.task.util.ConnectionManagerUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtilTest {

    @Test
    void connectionTest(){
        try {
            Connection connectionTest = ConnectionManagerUtil.openConnection();
            Assertions.assertFalse(connectionTest.isClosed());
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }
}
