package com.subscriptionservice.test.integration;

import com.subscriptionservice.SubscriptionserviceApplication;
import com.subscriptionservice.backend.persistence.domain.backend.Plan;
import com.subscriptionservice.backend.persistence.domain.backend.Role;
import com.subscriptionservice.backend.persistence.domain.backend.User;
import com.subscriptionservice.backend.persistence.domain.backend.UserRole;
import com.subscriptionservice.backend.persistence.repositories.PlanRepositories;
import com.subscriptionservice.backend.persistence.repositories.RoleRepositories;
import com.subscriptionservice.backend.persistence.repositories.UserRespositories;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SubscriptionserviceApplication.class)
public class RepositoriesIntegrationTest {

    @Autowired
    private PlanRepositories planRepository;

    @Autowired
    private UserRespositories userRepository;

    @Autowired
    private RoleRepositories roleRepository;

    private static final int BASIC_PLAN_ID = 1;
    private static final int BASIC_ROLE_ID = 1;

    @Before
    public void init() {
        Assert.assertNotNull(planRepository);
        Assert.assertNotNull(roleRepository);
        Assert.assertNotNull(userRepository);
    }

    @Test
    public void testCreateNewPlan() throws Exception {
        Plan basicPlan = createBasicPlan();
        planRepository.save(basicPlan);
        Plan retrievedPlan = planRepository.findOne(BASIC_PLAN_ID);
        Assert.assertNotNull(retrievedPlan);
    }

    private Plan createBasicPlan(){
        Plan plan = new Plan();
        plan.setId(BASIC_PLAN_ID);
        plan.setName("Basic");
        return plan;
    }

    @Test
    public void testCreateNewRole() throws Exception {
       Role basicRole = createBasicRole();
       roleRepository.save(basicRole);
       Role retrievedRole = roleRepository.findOne(BASIC_PLAN_ID);
       Assert.assertNotNull(retrievedRole);
    }

    private Role createBasicRole(){
        Role role = new Role();
        role.setId(BASIC_PLAN_ID);
        role.setName("Basic");
        return role;
    }

    @Test
    public void createNewUser() throws Exception {

        Plan basicPlan = createBasicPlan();
        planRepository.save(basicPlan);

        User basicUser = createBasicUser();
        basicUser.setPlan(basicPlan);

        Role basicRole = createBasicRole();
        Set<UserRole> userRoles = new HashSet<>();
        UserRole userRole = new UserRole();
        userRole.setUser(basicUser);
        userRole.setRole(basicRole);
        userRoles.add(userRole);

        basicUser.getUserRoles().addAll(userRoles);

        for(UserRole ur: userRoles){
            roleRepository.save(ur.getRole());
        }

        basicUser = userRepository.save(basicUser);
        User newlyCreatedUser = userRepository.findOne((int) basicUser.getId());
        Assert.assertNotNull(newlyCreatedUser);
        Assert.assertTrue(newlyCreatedUser.getId()!=0);
        Assert.assertNotNull(newlyCreatedUser.getPlan());
        Assert.assertNotNull(newlyCreatedUser.getPlan().getId());
        Set<UserRole> newlyCreatedUserUserRoles = newlyCreatedUser.getUserRoles();
        for(UserRole ur: newlyCreatedUserUserRoles){
            Assert.assertNotNull(ur.getRole());
            Assert.assertNotNull(ur.getRole().getId());
        }

    }

    public User createBasicUser(){
        User user = new User();
        user.setUsername("basicUser");
        user.setPassword("secret");
        user.setEmail("me@example.com");
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setPhoneNumber("0123456789");
        user.setCountry("US");
        user.setEnabled(true);
        user.setDescription("A Basic user");
        user.setProfileImageUrl("https://blabla.images.com/basicuser");

        return user;
    }

}
