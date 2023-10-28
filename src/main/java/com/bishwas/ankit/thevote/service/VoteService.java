package com.bishwas.ankit.thevote.service;

import com.bishwas.ankit.thevote.model.Vote;
import com.bishwas.ankit.thevote.repository.VoteRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class VoteService {
    Logger LOGGER = LoggerFactory.getLogger(VoteService.class);
    private  List<Vote> votes;
    Vote vote;
    @Autowired
    VoteRepo voteRepo;


    public void addVote(int val,boolean vote1, boolean vote2){

        Optional<Vote> byId = voteRepo.findById(1L);
        Vote vote = byId.get();
        long currVote = vote.getVote1();
        long currVote2 = vote.getVote2();
        if(vote1)
            currVote += val;
        else if(vote2)
            currVote2 +=val;
        vote.setVote1(currVote);
        vote.setVote2(currVote2);
        voteRepo.save(vote);
        LOGGER.info("vote saved successfully");


    }

    public long[] displayVote(){
        Optional<Vote> byId = voteRepo.findById(1L);
        Vote vote = byId.get();
        long currVote = vote.getVote1();
        long currVote2=vote.getVote2();
        return new long [] {currVote,currVote2};
    }




}
