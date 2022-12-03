package backend;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*
    This class represents a production that candidates should be assigned to.
 */
public class Production {

    // Fields
    private String name;
    // Crew list maps a role to a particular crew member.
    private List<String[]> crew;

    public Production(List<String> roles, List<String> assignments, String name) {
        /*
        Creates a new production with a set roles list and assignments.
        Throws an illegal argument exception if the roles and assignments lists are
        not the same length.
         */
        this.name = name;

        if (roles.size() != assignments.size()) {
            throw new IllegalArgumentException("Roles and assignment lists are not the same length.");
        }

        this.crew = new ArrayList<>();

        for (int i = 0; i < roles.size(); i++) {
            String role = roles.get(i);
            if (assignments.get(i).length() == 0) {
                this.crew.add(new String[] { role, null });
            } else {
                this.crew.add(new String[] { role, assignments.get(i) });
            }
        }

    }

    public boolean place(Candidate person, String intendedRole) {
        /*
        Attempts to place a candidate with their desired role on this production.
        If the role is not available, the method returns false indicating a failure to assign.
         */
        for (String[] role : this.crew) {
            if (role[0].equals(intendedRole) && role[1] == null) {
                role[1] = person.getName();
                return true;
            }
        }
        return false;
    }

    // Getters for name.
    public String getName() {
        return "Production: " + this.name;
    }


}
