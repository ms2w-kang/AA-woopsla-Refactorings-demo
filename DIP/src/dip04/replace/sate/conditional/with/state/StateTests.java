package dip04.replace.sate.conditional.with.state;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StateTests
{
	private SystemUser user;
	private SystemAdmin admin;
	private SystemProfile profile;
	private SystemPermission permission;
	
	@Before
	public void setup() throws Exception
	{
		user = new SystemUser();
		admin = new SystemAdmin();
		profile = new SystemProfile();
		permission = new SystemPermission(user, profile);
		permission.setAdmin(admin);
	}
	
	@Test
	public void grantedBy() throws Exception
	{
		permission.grantedBy(admin);
		assertEquals("requested", SystemPermission.REQUESTED, permission.getState());
		assertEquals("not granted", false, permission.isGranted());
		
		permission.claimedBy(admin);
		permission.grantedBy(admin);
		assertEquals("granted", SystemPermission.GRANTED, permission.getState());
		assertEquals("granted", true, permission.isGranted());
	}
}
