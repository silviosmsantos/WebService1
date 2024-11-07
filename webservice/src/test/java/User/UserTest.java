package User;

import com.smsantos.webservice.entities.User;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    void testUserCreation() {
        User user = new User(1L, "Bruce Wayne", "bruce.weyne@example.com", "123456789", "password123");
        assertNotNull(user);
        assertEquals(1L, user.getId());
        assertEquals("Bruce Wayne", user.getName());
        assertEquals("bruce.weyne@example.com", user.getEmail());
        assertEquals("123456789", user.getPhone());
    }

    @Test
    void testUserEqualsAndHashCode() {
        User user1 = new User(1L, "John", "john@example.com", "123456789", "password123");
        User user2 = new User(1L, "Jane", "jane@example.com", "987654321", "password321");
        User user3 = new User(2L, "John", "john@example.com", "123456789", "password123");

        assertEquals(user1, user2);
        assertNotEquals(user1, user3);
        assertEquals(user1.hashCode(), user2.hashCode());
    }

}
