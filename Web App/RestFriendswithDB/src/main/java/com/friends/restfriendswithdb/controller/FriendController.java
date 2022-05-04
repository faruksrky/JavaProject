package com.friends.restfriendswithdb.controller;

import com.friends.restfriendswithdb.model.Friend;
import com.friends.restfriendswithdb.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FriendController {
    @Autowired
    FriendService friendService;

    @PostMapping("/friend")
    Friend create(@RequestBody Friend friend){
        return friendService.save(friend);
    }

    @GetMapping ("/friend")
    Iterable<Friend> read(){
        return friendService.findAll();
    }

    @PutMapping ("/friend")
    Friend update (@RequestBody Friend friend){
        return friendService.save(friend);
    }



}
