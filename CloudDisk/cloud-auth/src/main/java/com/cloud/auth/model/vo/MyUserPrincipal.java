package com.cloud.auth.model.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cloud.auth.model.entity.Role;
import com.cloud.auth.model.entity.User;



public class MyUserPrincipal implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;
	
	private Role role;
	

	
	/**
     * 是否可用
     */
    private Boolean enabled =true;

    /**
     *用户所拥有的权限
     */
    private List<GrantedAuthority> authorities;

    /**
     * 用户的账号是否过期,过期的账号无法通过授权验证. true 账号未过期
     */
    private Boolean accountNonExpired = true;

    /**
     * 用户的账户是否被锁定,被锁定的账户无法通过授权验证. true 账号未锁定
     */
    private Boolean accountNonLocked = true;

    /**
     * 用户的凭据(pasword) 是否过期,过期的凭据不能通过验证. true 没有过期,false 已过期
     */
    private Boolean credentialsNonExpired = true;
	
	
	
	
	
    public MyUserPrincipal(User user,Role role) {
    	
        this.user = user;
        this.role=role;
    }
    
    
    
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// 此处注入角色
		

		
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+role.getRoleName());
		authorities=new ArrayList<GrantedAuthority>();
		authorities.add(grantedAuthority);
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.user.getUsername();
	}

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
	
	
	

}
