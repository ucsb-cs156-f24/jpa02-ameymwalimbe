package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team"); 
        team.addMember("amey");   
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[amey])", team.toString());
    }

    @Test
    public void equals_returns_true_for_same_team() {
        assert(team.equals(team));
    }

    @Test
    public void equals_returns_false_for_different_team() {
        int x = 0;
        assert(!team.equals(x));
    }

    @Test
    public void equals_returns_true_for_team_with_same_name_and_members() {
        Team team2 = new Team("test-team");
        team2.addMember("amey");
        assert(team.equals(team2));
    }

    @Test
    public void equals_returns_true_for_team_with_different_name_and_same_members() {
        Team team2 = new Team("test123-team");
        team2.addMember("amey");
        assert(!team.equals(team2));
    }

    @Test
    public void equals_returns_true_for_team_with_different_name_and_different_members() {
        Team team2 = new Team("test123-team");
        team2.addMember("bob");
        assert(!team.equals(team2));
    }

    @Test
    public void equals_returns_true_for_team_with_same_name_and_different_members() {
        Team team2 = new Team("test-team");
        team2.addMember("bob");
        assert(!team.equals(team2));
    }

    @Test
    public void test_hashcode() {
        int result = team.hashCode();
        int expectedResult = -1225932801;
        assertEquals(result, expectedResult);
    }
}
