package com.globe.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;

import com.google.common.base.Objects;

@Entity
@Table(name = "AUTHORITIES")
public class Authority implements Serializable, GrantedAuthority  {

    private static final long serialVersionUID = 6874667425302308430L;
    static Logger logger = LoggerFactory.getLogger(Authority.class);
    /*
        CREATE TABLE `AUTHORITIES` (
        	ID_Authorities   INT   NOT NULL  auto_increment,
            `USERNAME` VARCHAR(50) NOT NULL PRIMARY KEY,
            `AUTHORITY`  VARCHAR(50) NOT NULL,
            constraint fk_authorities_users
			foreign key(username) references users(username)); 
        )
        
        
CREATE TABLE authorities
(       ID_Authorities   INT   NOT NULL  auto_increment
,username     varchar(50)    NOT null
,authority varchar(50)   NOT NULL
     
   , CONSTRAINT authorities_PK PRIMARY KEY (ID_Authorities))
;
     */
    
    @Id
    @GeneratedValue
    @Column(name = "id_authorities")
    private int id_authorities;
    
	@NotNull(message = "null")
    @NotEmpty(message = "empty")
    @Size(max = 50, message = "max=50")
    @Column(name = "username", length = 50)
    private String username;

	@NotNull(message = "null")
    @NotEmpty(message = "empty")
    @Size(max = 50, message = "max=50")
    @Column(name = "authority", length = 50)
    private String authority;
	
	public int getId_authorities() {
			return id_authorities;
	}

	public void setId_authorities(int id_authorities) {
			this.id_authorities = id_authorities;
	}
	
    /*
    //@OneToMany(cascade = CascadeType.ALL)  
    @OneToMany(fetch = FetchType.EAGER)  
    @JoinTable(name = "user_authorities",   
        joinColumns        = {@JoinColumn(name = "authority_username", referencedColumnName = "username")},  
        inverseJoinColumns = {@JoinColumn(name = "user_username", referencedColumnName = "username")}  
    )  
    private Set<User> userAuthorities;
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_permissions",
        joinColumns        = { @JoinColumn(name = "role_id",       referencedColumnName = "id") },
        inverseJoinColumns = { @JoinColumn(name = "permission_id", referencedColumnName = "id") }
    )    
    //private Set<Permission> permissions;
*/
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return getAuthority();
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

   
/*
    public Set<Permission> getPermissions() { 
        return permissions; 
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }*/
    
    @Override
    public String toString() {
        return String.format("%s(id=%d, authorityname='%s')", 
                this.getClass().getSimpleName(), 
                this.getUsername(), this.getAuthority());
    }

   
/*
	public Set<User> getUserAuthorities() {
		return userAuthorities;
	}

	public void setUserAuthorities(Set<User> userAuthorities) {
		this.userAuthorities = userAuthorities;
	}*/

	@Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;

        if (o instanceof Authority) {
            final Authority other = (Authority) o;
            return Objects.equal(getUsername(), other.getUsername())
                    && Objects.equal(getAuthority(), other.getAuthority());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getUsername(), getAuthority());
    }

	
   
}
