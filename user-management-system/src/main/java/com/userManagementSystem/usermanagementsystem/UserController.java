package com.userManagementSystem.usermanagementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    List<User> userList;
    @PostMapping("api/users/addUser")
    public  String addUser(@RequestBody User user) {
        userList.add(user);
        return "Username : "+user.getUserName()+" added into User Repository !!!!!!!!!!!!";
    }
    @PostMapping("api/users/addMultipleUsers")
    public  String addMultipleUsers(@RequestBody List<User> multipleUsers) {
        userList.addAll(multipleUsers);
        return multipleUsers.size()+" new users added into User Repository !!!!!!!!!!!!";
    }
    @GetMapping("api/users/getUser/{userId}")
    public Object getUser(@PathVariable Long userId) {
        for (User currentUser : userList) {
            if (currentUser.getUserId().equals(userId)) {
                return currentUser; // Return the user if found
            }
        }

        String errorMessage = "User with ID " + userId + " not found";
        return errorMessage; // Return an error message if user is not found
    }


    @GetMapping("api/users/getAllUsers")
    public List<User> getAllUsers() {
        return userList;
    }

    @PutMapping("api/users/updateUserInfo/{userId}")
    public String updateUserInfo(@PathVariable Long userId, @RequestBody User updatedUser) {
        for (User currentUser : userList) {
            if (currentUser.getUserId().equals(userId)) {
                // Update the user's information
                currentUser.setUserId(updatedUser.getUserId());
                currentUser.setName(updatedUser.getName());
                currentUser.setUserName(updatedUser.getUserName());
                currentUser.setAddress(updatedUser.getAddress());
                currentUser.setPhoneNumber(updatedUser.getPhoneNumber());

                return "User information updated successfully";
            }
        }
        return "User with ID " + userId + " not found"; // Return a custom error message if user is not found
    }

    /*
    @PutMapping("api/users/updateUserInfo/removeAdd/{userId}")
    public String updateUserInfoRemoveAdd(@PathVariable Long userId, @RequestBody User updatedUser) {
        for (int i = 0; i < userList.size(); i++) {
            User currentUser = userList.get(i);
            if (currentUser.getUserId().equals(userId)) {
                // Remove the old user and add the updated user
                userList.remove(i);
                userList.add(updatedUser);
                return "User information updated successfully";
            }
        }
        return "User with ID " + userId + " not found"; // Return a custom error message if user is not found
    } */

    @DeleteMapping("api/users/deleteUser/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        User userToDelete = null;
        for (User currentUser : userList) {
            if (currentUser.getUserId().equals(userId)) {
                userToDelete = currentUser;
                break; // Exit the loop once the user is found
            }
        }

        if (userToDelete != null) {
            userList.remove(userToDelete);
            return "User deleted successfully";
        }

        return "User with ID " + userId + " not found"; // Return a custom error message if user is not found
    }

}
