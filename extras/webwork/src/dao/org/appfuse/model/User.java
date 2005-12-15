package org.appfuse.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * User class - also used to generate the Hibernate mapping file.
 *
 * <p><a href="User.java.html"><i>View Source</i></a></p>
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *         Updated by Dan Kibler (dan@getrolling.com)
 *
 * @hibernate.class table="app_user"
 */
public class User extends BaseObject implements Serializable {
    private static final long serialVersionUID = 3832626162173359411L;

    protected String username;
    protected String password;
    protected String confirmPassword;
    protected String firstName;
    protected String lastName;
    protected Address address = new Address();
    protected String phoneNumber;
    protected String email;
    protected String website;
    protected String passwordHint;
    protected Integer version;
    protected Set roles = new HashSet();
    protected Boolean enabled;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    /**
     * Returns the username.
     *
     * @return String
     *
     * @hibernate.id column="username" length="20" generator-class="assigned"
     *               unsaved-value="version"
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns the password.
     * @return String
     *
     * @hibernate.property column="password" not-null="true"
     */
    public String getPassword() {
        return password;
    }

    /**
     * Returns the confirmedPassword.
     * @return String
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * Returns the firstName.
     * @return String
     *
     * @hibernate.property column="first_name" not-null="true" length="50"
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the lastName.
     * @return String
     *
     * @hibernate.property column="last_name" not-null="true" length="50"
     */
    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + ' ' + lastName;
    }

    /**
     * Returns the address.
     *
     * @return Address
     *
     * @hibernate.component
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Returns the email.  This is an optional field for specifying a
     * different e-mail than the username.
     * 
     * @return String
     *
     * @hibernate.property name="email" not-null="true" unique="true"
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the phoneNumber.
     * @return String
     *
     * @hibernate.property column="phone_number" not-null="false"
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Returns the website.
     * @return String
     *
     * @hibernate.property column="website" not-null="false"
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Returns the passwordHint.
     * @return String
     *
     * @hibernate.property column="password_hint" not-null="false"
     */
    public String getPasswordHint() {
        return passwordHint;
    }

    /**
     * Returns the user's roles.
     * @return Set
     *
     * @hibernate.set table="user_role" cascade="save-update" lazy="false"
     * @hibernate.collection-key column="username"
     * @hibernate.collection-many-to-many class="org.appfuse.model.Role"
     *                                    column="role_name"
     */
    public Set getRoles() {
        return roles;
    }

    /**
     * Adds a role for the user
     *
     * @param role
     */
    public void addRole(Role role) {
        getRoles().add(role);
    }

    /**
     * Sets the username.
     * @param username The username to set
     * @spring.validator type="required"
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets the password.
     * @param password The password to set
     *
     * @spring.validator type="required"
     * @spring.validator type="twofields" msgkey="errors.twofields"
     * @spring.validator-args arg1resource="user.password"
     * @spring.validator-args arg1resource="user.confirmPassword"
     * @spring.validator-var name="secondProperty" value="confirmPassword"
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the confirmedPassword.
     * @param confirmPassword The confirmed password to set
     * @spring.validator type="required"
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     * Sets the firstName.
     * @spring.validator type="required"
     * @param firstName The firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the lastName.
     * @param lastName The lastName to set
     *
     * @spring.validator type="required"
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the address.
     * @param address The address to set
     *
     * @spring.validator
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Sets the email.
     * @param email The email to set
     *
     * @spring.validator type="required"
     * @spring.validator type="email"
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the phoneNumber.
     * @param phoneNumber The phoneNumber to set
     *
     * @spring.validator type="mask" msgkey="errors.phone"
     * @spring.validator-var name="mask" value="${phone}"
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Sets the website.
     * @param website The website to set
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * @param passwordHint The password hint to set
     *
     * @spring.validator type="required"
     */
    public void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }

    /**
     * Sets the roles.
     * @param roles The roles to set
     */
    public void setRoles(Set roles) {
        this.roles = roles;
    }

    /**
     * @return Returns the updated version.
     * @hibernate.version
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * @param version The updated version to set.
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
    
    /**
     * @return Returns if the user is enabled
     * @hibernate.property column="enabled" type="true_false"
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * @param enabled Enable/disable this user
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    

    /**
     * Convert user roles to LabelValue objects for convenience.  
     */
    public List getRoleList() {
        List userRoles = new ArrayList();

        if (this.roles != null) {
            for (Iterator it = roles.iterator(); it.hasNext();) {
                Role role = (Role) it.next();

                // convert the user's roles to LabelValue Objects
                userRoles.add(new LabelValue(role.getName(),
                                             role.getName()));
            }
        }

        return userRoles;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        final User user = (User) o;

        if (username != null ? !username.equals(user.getUsername()) : user.getUsername() != null) return false;

        return true;
    }

    public int hashCode() {
        return (username != null ? username.hashCode() : 0);
    }

    /**
     * Generated using Commonclipse (http://commonclipse.sf.net)
     */
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("roles", this.roles)
                .append("firstName", this.firstName).append("lastName",
                        this.lastName)
                .append("passwordHint", this.passwordHint).append("username",
                        this.username).append("fullName", this.getFullName())
                .append("email", this.email).append("phoneNumber",
                        this.phoneNumber).append("password", this.password)
                .append("address", this.address).append("confirmPassword",
                        this.confirmPassword).append("website", this.website)
                .append("version", this.getVersion())
                .append("enabled", this.getEnabled()).toString();
    }
}
