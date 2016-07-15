package com.globe.model;


import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.google.common.base.Objects;

@Entity  
@Table(name="USERS")
public class User  implements UserDetails {
    /*
        CREATE TABLE `USERS` (
            `USERNAME` VARCHAR(50) NOT NULL PRIMARY KEY (AUTO_INCREMENT),  
            `PASSWORD` VARCHAR(60) NOT NULL,
            `MAIL` VARCHAR(50) NOT NULL,
            `PHONE` VARCHAR(50) NOT NULL,
            `FNAME` VARCHAR(50) NOT NULL,
            `LNAME` VARCHAR(50) NOT NULL,
            `ENABLED`  BOOLEAN NOT NULL,
           )
      */  
        

    private static final long serialVersionUID = 6311364761937265306L;
    static Logger logger = LoggerFactory.getLogger(User.class);
    
    @NotNull(message = "null")
    @NotEmpty(message = "empty")
    @Size(max = 50, message = "max=50")
    @Id
    @GeneratedValue
    @Column(name = "username", length = 50)
    private String username;

    @NotNull(message = "null")
    @NotEmpty(message = "empty")
    @Size(max = 50, message = "max=50")
    @Column(name = "mail", length = 50)
    private String mail;
    
    @NotNull(message = "null")
    @NotEmpty(message = "empty")
    @Size(max = 50, message = "max=50")
    @Column(name = "phone", length = 50)
    private String phone;
    
    @NotNull(message = "null")
    @NotEmpty(message = "empty")
    @Size(max = 50, message = "max=50")
    @Column(name = "fname", length = 50)
    private String fname;
    
    @NotNull(message = "null")
    @NotEmpty(message = "empty")
    @Size(max = 50, message = "max=50")
    @Column(name = "lname", length = 50)
    private String lname;
    
    @NotNull(message = "null")
    @NotEmpty(message = "empty")
    @Size(max = 60, message = "max=60")
    @Column(name = "password", length = 60)
    private String password;
    
    @Column(name = "enabled")
    private boolean enabled;
    
    public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	/*@OneToOne(fetch = FetchType.EAGER)  
    @JoinTable(name = "user_roles",  
        joinColumns        = {@JoinColumn(name = "user_id", referencedColumnName = "id")},  
        inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}  
    )  
    private Authority authority;
    */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

   

    @Override
    public String toString() {
        return String.format("%s(id=%d, username=%s, password=%s, enabled=%b)", 
                this.getClass().getSimpleName(), 
                this.getUsername(), 
                this.getMail(),
                this.getPhone(),
                this.getFname(),
                this.getLname(),
                this.getPassword(), 
                this.getEnabled());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;

        if (o instanceof User) {
            final User other = (User) o;
            return  Objects.equal(getUsername(), other.getUsername())
            		&& Objects.equal(getMail(), other.getMail())
            		&& Objects.equal(getPhone(), other.getPhone())
            		&& Objects.equal(getFname(), other.getFname())
            		&& Objects.equal(getLname(), other.getLname())
                    && Objects.equal(getPassword(), other.getPassword())
                    && Objects.equal(getEnabled(), other.getEnabled());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getUsername(),getMail(),getPhone(),
        		getFname(),getLname(),getPassword(), getEnabled());
    }

    /*
    @Transient
	public Collection< GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.add(getAuthority());
		return authorities;
		
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
*/
	public boolean isAccountNonExpired() {
		
		return true;
	}

	public boolean isAccountNonLocked() {
		
		return true;
	}

	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	public boolean isEnabled() {
		
		return this.getEnabled();
	}

	public Collection<GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

    /*@Transient
    public Set<Permission> getPermissions() {
        Set<Permission> perms = new HashSet<Permission>();
        perms.addAll(role.getPermissions()); 
        return perms;
    }*/

   
/*
    @Override
    public boolean isAccountNonExpired() {
        //return true = account is valid / not expired
        return true; 
    }

    @Override
    public boolean isAccountNonLocked() {
        //return true = account is not locked
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //return true = password is valid / not expired
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.getEnabled();
    }
    */
}

