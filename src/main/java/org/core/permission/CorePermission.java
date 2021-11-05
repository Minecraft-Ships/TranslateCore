package org.core.permission;

public class CorePermission implements Permission {

    private final String[] permissions;
    private final boolean isForDefault;

    public CorePermission(boolean forDefault, String... permissions) {
        this.isForDefault = forDefault;
        this.permissions = permissions;
    }

    @Override
    public String getPermissionValue() {
        return String.join(".", this.permissions);
    }

    public boolean shouldDefaultHave() {
        return this.isForDefault;
    }


}
