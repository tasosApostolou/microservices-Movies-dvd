//package com.example.rentalsservice.model;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import java.io.Serializable;
//
//@Getter
//@Setter
//public class CustomerMovieID implements Serializable {
//    private Long customer;
//    private Long movie;
//
//    public CustomerMovieID(Long customer, Long movie) {
//        this.customer = customer;
//        this.movie = movie;
//    }
//
//    public CustomerMovieID() {
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof CustomerMovieID)) return false;
//        CustomerMovieID that = (CustomerMovieID) o;
//        return customer.equals(that.customer) && movie.equals(that.movie);
//    }
////    public boolean equals(Object o) {
////        if (this == o) return true;
////        if (!(o instanceof CustomerMovieID that)) return false;
////
////        if (!customer.equals(that.customer)) return false;
////        return movie.equals(that.movie);
////    }
//
//    @Override
//    public int hashCode() {
//        int result = customer.hashCode();
//        result = 31 * result + movie.hashCode();
//        return result;
//    }
//
//}
