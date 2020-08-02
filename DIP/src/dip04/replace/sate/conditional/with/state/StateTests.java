package dip04.replace.sate.conditional.with.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StateTests {
    private SystemUser user;
    private SystemAdmin admin;
    private SystemProfile profile;
    private SystemPermission permission;

    @BeforeEach
    public void setup() throws Exception {
        user = new SystemUser();
        admin = new SystemAdmin();
        profile = new SystemProfile();
        permission = new SystemPermission(user, profile);
        permission.setAdmin(admin);
    }

    @Test
    public void grantedBy() throws Exception {
        permission.grantedBy(admin);
        assertEquals(SystemPermission.REQUESTED, permission.getState(), "requested");
        assertFalse(permission.isGranted(), "not granted");

        permission.claimedBy(admin);
        permission.grantedBy(admin);
        assertEquals(SystemPermission.GRANTED, permission.getState(), "granted");
        assertTrue(permission.isGranted(), "granted");
    }
}
