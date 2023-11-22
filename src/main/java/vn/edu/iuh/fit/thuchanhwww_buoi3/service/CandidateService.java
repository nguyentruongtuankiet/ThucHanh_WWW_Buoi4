package vn.edu.iuh.fit.thuchanhwww_buoi3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.thuchanhwww_buoi3.daos.AddressRepositories;
import vn.edu.iuh.fit.thuchanhwww_buoi3.daos.CandidateRepositories;
import vn.edu.iuh.fit.thuchanhwww_buoi3.entities.Address;
import vn.edu.iuh.fit.thuchanhwww_buoi3.entities.Candidate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CandidateService {
    private final CandidateRepositories candidateRepositories;

    @Autowired
    public CandidateService(CandidateRepositories candidateRepositories) {
        this.candidateRepositories = candidateRepositories;
    }

    public List<Candidate> getAll() throws Exception {
        return candidateRepositories.getAll();
    }

    public Optional<Candidate> getByID(UUID uuid) throws Exception {
        return candidateRepositories.getByID(uuid);
    }

    public boolean delete(UUID uuid) throws Exception {
        return candidateRepositories.delete(uuid);
    }

    public boolean add(Candidate entity) throws Exception {
        return candidateRepositories.add(entity);
    }

    public boolean update(Candidate entity) throws Exception {
        return candidateRepositories.update(entity);
    }

}
