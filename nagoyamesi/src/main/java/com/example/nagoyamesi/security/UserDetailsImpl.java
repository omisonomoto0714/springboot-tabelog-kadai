package com.example.nagoyamesi.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.nagoyamesi.entity.User;

public class UserDetailsImpl implements UserDetails {
	private final User user;
	private final Collection<GrantedAuthority> authorities;

	public UserDetailsImpl(User user, Collection<GrantedAuthority> authorities) {

		this.user = user;
		this.authorities = authorities;
	}

	public User getUser() {
		return user;
	}
	
	//ハッシュ化パスを返す
	@Override
	public String getPassword() {
		return user.getPassword();
		
	}
	
	//ログインの際に利用するメールアドレス(ユーザー名)を返す
	//getUsernameはUserDetailsで定義されているメソッド
	@Override
	public String getUsername() {
		return user.getEmail();
	}
	
	//ロールのコレクションを返す
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	//アカウントが期限切れでないならtrue
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	//ユーザーがロックされてなければtrue
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	//ユーザーのパスワードの期限が切れてないか
	@Override
	public boolean isCredentialsNonExpired() {
		return true;

	}
	
	
	//ユーザーが有効ならtrue
	@Override
	public boolean isEnabled() {
		return user.getEnabled();
	}
}
