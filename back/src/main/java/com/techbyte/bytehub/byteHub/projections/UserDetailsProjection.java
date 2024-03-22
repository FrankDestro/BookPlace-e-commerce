package com.techbyte.bytehub.byteHub.projections;

public interface UserDetailsProjection {

	String getUsername();
	String getPassword();
	Long getRoleId();
	String getAuthority();
	Integer getStatus();

}
