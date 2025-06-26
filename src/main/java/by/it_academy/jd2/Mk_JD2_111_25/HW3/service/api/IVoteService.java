package by.it_academy.jd2.Mk_JD2_111_25.HW3.service.api;

import by.it_academy.jd2.Mk_JD2_111_25.HW3.dto.Stats;
import by.it_academy.jd2.Mk_JD2_111_25.HW3.dto.Vote;

public interface IVoteService {
    void add(Vote vote) throws ClassNotFoundException;
    Stats getStats() throws ClassNotFoundException;
}
