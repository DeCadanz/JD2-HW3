package by.it_academy.jd2.Mk_JD2_111_25.HW3.storage;

import by.it_academy.jd2.Mk_JD2_111_25.HW3.dto.Vote;
import by.it_academy.jd2.Mk_JD2_111_25.HW3.storage.api.IVoteStorage;

import java.util.ArrayList;
import java.util.List;

public class VoteStorageRam implements IVoteStorage {
    private final List<Vote> votes = new ArrayList<>();

    @Override
    public void add(Vote vote) {
        this.votes.add(vote);
    }

    @Override
    public List<Vote> getAll() {
        return this.votes;
    }
}
