package com.example.rentalsservice.repository;

//import com.example.rentalsservice.model.CustomerDetails;
//import com.example.rentalsservice.model.CustomerMovieID;
//import com.example.rentalsservice.model.MovieDetails;
import com.example.rentalsservice.model.Rentals;
import com.example.rentalsservice.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//public interface RentalsRepository extends JpaRepository<Rentals, CustomerMovieID> {
public interface RentalsRepository extends JpaRepository<Rentals, Long> {

    @Override
    List<Rentals> findAll();

//    @Override
//    @Modifying
//    @Transactional // Explicit transaction management
//    <S extends Rentals> S save(S entity);

//    Optional<Rentals> findByCustomerAndMovie(CustomerDetails customer, MovieDetails movie);
//    Rentals findRentalsByCustomer_IdAndMovie_Id(Long customerId,Long movieId);
//    List<Rentals> findRentalsByMovie(MovieDetails movies);
//    List<Rentals> findRentalsByCustomer(CustomerDetails customer);
//    List<Rentals> findByMovie_Title(String title);
//    List<Rentals> findByMovie_Id(Long id);
    Optional<Rentals> findByCustomerIdAndMovieId(Long customerId,Long movieId);
    List<Rentals> findRentalsByMovieId(Long movieId);
    List<Rentals> findRentalsByCustomerId(Long customerId);
    List<Rentals> findRentalsByCustomerIdAndStatus(Long customerId, Status  status);
    List<Rentals> findRentalsByMovieIdAndStatus(Long movieId,Status status);
    List<Rentals> findRentalsByStatus(Status status);
}
