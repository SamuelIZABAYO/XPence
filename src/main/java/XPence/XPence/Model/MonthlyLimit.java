package XPence.XPence.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class MonthlyLimit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long monthlyLimitId;
    private float monthlyLimit;
    private String defaultCurrency;

    @OneToOne(targetEntity = Profile.class)
    private Profile profile;

    public MonthlyLimit() {

    }

    public MonthlyLimit(float monthlyLimit, String defaultCurrency) {

        this.monthlyLimit = monthlyLimit;
        this.defaultCurrency = defaultCurrency;
    }

    public float getMonthlyLimit() {
        return monthlyLimit;
    }

    public void setMonthlyLimit(float monthlyLimit) {
        this.monthlyLimit = monthlyLimit;
    }

    public String getDefaultCurrency() {
        return defaultCurrency;
    }

    public void setDefaultCurrency(String defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    public Long getMonthlyLimitId() {
        return monthlyLimitId;
    }

    public void setMonthlyLimitId(Long monthlyLimitId) {
        this.monthlyLimitId = monthlyLimitId;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

}
