package by.it_academy.jd2.Mk_JD2_111_25.HW3.storage.api;

import by.it_academy.jd2.Mk_JD2_111_25.HW3.dto.Vote;

import java.util.List;

public interface IVoteStorage {
    void add(Vote vote);
    List<Vote> getAll();
}

