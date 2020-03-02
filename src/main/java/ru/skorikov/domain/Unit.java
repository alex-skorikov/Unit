package ru.skorikov.domain;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

/**
 * Unit.
 */
@Entity
@Table(name = "units")
public class Unit {
    /**
     * Unit id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /**
     * Name.
     */
    private String name;
    /**
     * Pasword.
     */
    private String password;
    /**
     * Count.
     */
    private Integer count;
    /**
     * Description.
     */
    private String description;
    /**
     * Create date.
     */
    private Date createdate;
    /**
     * Is unit active.
     */
    private boolean isactive;

    /**
     * Constructor.
     */
    public Unit() {
    }

    /**
     * Get id.
     * @return id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set id.
     * @param id id.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get name.
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set name.
     * @param name name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get password.
     * @return password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set password.
     * @param password password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get count.
     * @return count.
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Seet count.
     * @param count count.
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * Get description.
     * @return description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set description.
     * @param description description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get create date.
     * @return date.
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * Set unit create date.
     * @param createdate create date.
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * Is unit active.
     * @return is active.
     */
    public boolean isIsactive() {
        return isactive;
    }

    /**
     * Set unit active.
     * @param isactive is active.
     */
    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }
}
