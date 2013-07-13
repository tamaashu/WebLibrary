/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hu.tamaas.weblibrary.persistence.entity;

import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

/**
 *
 * @author tamaas
 */
@Entity
@Table(name="users")
@SequenceGenerator(
    name="user_seq",
    allocationSize=1,
    sequenceName="public.user_seq"
)
public class User implements Serializable{
    @Id
    @Column(name="userid")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "user_seq")
    private Long id;
    @Transient
    private boolean selected = false;
    /**
     * value for version
     */
    @Column(name="version")
    @Version
    private Long version;
    private String name;
    private String email;
    private String firstname;
    private String lastname;
    private String password;
    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name="dateofbirth")
    private Date dateOfBirth;
    @Column(name="placeofbirth")
    private String placeOfBirth;
    private String timezone;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    private static String encrypt(String data) {
        StringBuffer sb = new StringBuffer();

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(data.getBytes("UTF-8"));
            byte[] digestBytes = messageDigest.digest();


            String hex = null;

            for (int i = 0; i < digestBytes.length; i++) {
                //Convert it to positive integer and then to Hex String

                hex = Integer.toHexString(0xFF & digestBytes[i]);

                //Append "0" to the String to made it exactly 128 length (SHA-512 alogithm)
                if (hex.length() < 2){
                    sb.append("0");
                    }
                sb.append(hex);
                }
            }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            }

        return new String(sb);
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = encrypt(password);
    }

    /**
     * TODO: Activate checking
     * @param passwd the password to check
     */
    public boolean checkPassword(String passwd){
        //return true;
        if(password.compareTo(encrypt(passwd))==0)
            return true;
        else
            return false;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the dateOfBirth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the placeOfBirth
     */
    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    /**
     * @param placeOfBirth the placeOfBirth to set
     */
    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    /**
     * @return the selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * @return the timezone
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     * @param timezone the timezone to set
     */
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @Override
    public boolean equals(Object o){
        if ( this == o ){
            return true;
        }
        if ( !(o instanceof User) ){
            return false;
        }
        User u = (User)o;
        return this.id.longValue()==u.id.longValue();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + (int) (this.id.longValue() ^ (this.id.longValue() >>> 32));
        return hash;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}