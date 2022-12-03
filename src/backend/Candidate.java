package backend;

import java.util.List;

/*
    This class represents a candidate who has expressed interest through the
    role survey.
 */
public class Candidate {

    // Fields
    private String name;
    private String pronouns;
    private String email;
    private String timestamp;
    private int years_in_uw;
    private int quarters_in_lux;
    private List<String> productions;
    private List<String> roles;
    private boolean prodPriority;
    private boolean assigned;

    // Constructors
    public Candidate(String name, String pronouns, String email, String time, int years, int quarters,
                     List<String> prods, List<String> roles, boolean prodPriority) {
        this.name = name;
        this.pronouns = pronouns;
        this.email = email;
        this.timestamp = time;
        this.years_in_uw = years;
        this.quarters_in_lux = quarters;
        this.productions = prods;
        this.roles = roles;
        this.prodPriority = prodPriority;
        this.assigned = false;
    }

    // Getter for name
    public String getName() {
        return this.name;
    }

    public List<String> getRoles() {
        return this.roles;
    }

    public void setAssigned(boolean value) {
        this.assigned = value;
    }

    public boolean getAssigned() {
        return this.assigned;
    }

}
