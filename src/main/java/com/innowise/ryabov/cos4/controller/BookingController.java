package com.innowise.ryabov.cos4.controller;

import com.innowise.ryabov.cos4.dto.BookingDTO;
import com.innowise.ryabov.cos4.request.BookingRequest;
import com.innowise.ryabov.cos4.service.BookingService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingController {
    BookingService bookingService;
    @GetMapping("/get")
    public ResponseEntity<List<BookingDTO>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<BookingDTO> getBooking(@PathVariable Long id){
        return ResponseEntity.ok(bookingService.getBooking(id));
    }
    @PostMapping("/save")
    public ResponseEntity<HttpStatus> saveBooking(@RequestBody @Valid BookingRequest request) {
        bookingService.saveBooking(request);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<BookingDTO> updateBooking(@PathVariable Long id, @RequestBody @Valid BookingRequest request) {
        return ResponseEntity.ok(bookingService.updateBooking(id, request));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
