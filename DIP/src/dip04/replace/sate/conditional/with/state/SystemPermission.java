package dip04.replace.sate.conditional.with.state;

/**
 * <h3>SMELL: Switch Statement</h3>
 * <ul>
 *   <li> The conditional expressions that control an object’s
 *      state transitions are complex.
 * </ul>
 * <h3>TREATMENT: Replace State-Altering Conditionals with State</h3>
 * <ul>
 *   <li> Replace the conditionals with State classes that handle
 *      specific states and transitions between them.
 * </ul>
 */

public class SystemPermission {
    private SystemUser requestor;
    private SystemProfile profile;
    private SystemAdmin admin;
    private boolean isGranted;
    private String state;

    public final static String REQUESTED = "REQUESTED";
    public final static String CLAIMED = "CLAIMED";
    public final static String GRANTED = "GRANTED";
    public final static String DENIED = "DENIED";

    public SystemPermission(SystemUser requestor, SystemProfile profile) {
        this.requestor = requestor;
        this.profile = profile;
        state = REQUESTED;
        isGranted = false;
        notifyAdminOfPermissionRequest();
    }

    public void claimedBy(SystemAdmin admin) {
        if (!state.equals(REQUESTED))
            return;
        willBeHandledBy(admin);
        state = CLAIMED;
    }

    public void deniedBy(SystemAdmin admin) {
        if (!state.equals(CLAIMED))
            return;
        if (!this.admin.equals(admin))
            return;
        isGranted = false;
        state = DENIED;
        notifyUserOfPermissionRequestResult();
    }

    public void grantedBy(SystemAdmin admin) {
        if (!state.equals(CLAIMED))
            return;
        if (!this.admin.equals(admin))
            return;
        state = GRANTED;
        isGranted = true;
        notifyUserOfPermissionRequestResult();
    }

    public boolean isGranted() {
        return isGranted;
    }

    public String getState() {
        return state;
    }

    public void setAdmin(SystemAdmin admin) {
        this.admin = admin;
    }

    private void willBeHandledBy(SystemAdmin admin2) {
    }

    private void notifyAdminOfPermissionRequest() {
    }

    private void notifyUserOfPermissionRequestResult() {
    }
}
