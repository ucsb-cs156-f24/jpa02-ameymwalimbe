package edu.ucsb.cs156.spring.hello;

/**
 * A class with static methods to provide information about the developer.
 */

public class Developer {

    // This class is not meant to be instantiated
    // so we make the constructor private

    private Developer() {}
    
    /**
     * Get the name of the developer
     */

    public static String getName() {
        return "Amey W.";
    }

    /**
     * Get the github id of the developer
     * @return github id of the developer
     */

    public static String getGithubId() {
        return "ameymwalimbe";
    }

    /**
     * Get the developers team
     * @return developers team as a Java object
     */
    
    public static Team getTeam() {
        Team team = new Team("f24-00");
        team.addMember("Amey");
        team.addMember("Grace");
        team.addMember("Sangita");
        team.addMember("Daniel");
        team.addMember("Jenil");
        team.addMember("Hongrui");
        return team;
    }
}
