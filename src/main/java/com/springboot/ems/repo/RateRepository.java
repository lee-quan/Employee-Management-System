package com.springboot.ems.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.ems.dto.RateDto;
import com.springboot.ems.model.Rate;

@Repository
public interface RateRepository extends JpaRepository<Rate, Integer> {

    // @Query(value = "SELECT * FROM USERS u WHERE u.username = :username",
    // nativeQuery = true)
    // public List<Rate> getAllRates(@Param("username") String username);

    @Query(value = "SELECT AVG(rate) FROM rate WHERE rate_to= :id group by rate_to ", nativeQuery = true)
    public Double getAverageRate(@Param("id") Integer id);

    @Query(value = "SELECT * FROM rate WHERE rate_from=:from AND rate_to=:to", nativeQuery = true)
	public Rate getRateByID(@Param("from")Integer from,  @Param("to") Integer to);

    // int communication, int productivity, int creativity, int integrity,int punctuality, int attendance
    @Query("SELECT new com.springboot.ems.dto.RateDto (AVG(communication),AVG(productivity),AVG(creativity),AVG(integrity),AVG(punctuality),AVG(attendance)) FROM Rate WHERE to=:rate_to")
    public RateDto getAvgRateByID(@Param("rate_to") Integer rate_to);

}
