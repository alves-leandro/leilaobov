package com.bovauction.bovwallet.controller;

import com.bovauction.bovwallet.dto.CardInfoDto;
import com.bovauction.bovwallet.service.CardInfoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/card-info")
public class CardInfoController {
    private final CardInfoService cardInfoService;

    public CardInfoController(CardInfoService cardInfoService) {
        this.cardInfoService = cardInfoService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<CardInfoDto> createCardInfo(@Valid @RequestBody CardInfoDto cardInfoDto, @PathVariable Long userId) {
        try {
            CardInfoDto createdCardInfo = cardInfoService.createCardInfo(cardInfoDto, userId);
            return new ResponseEntity<>(createdCardInfo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardInfoDto> retrieveCardInfo(@PathVariable Long id) {
        try {
            CardInfoDto cardInfo = cardInfoService.retrieveCardInfo(id);
            return new ResponseEntity<>(cardInfo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardInfoDto> updateCardInfo(@Valid @RequestBody CardInfoDto cardInfoDto, @PathVariable Long id) {
        try {
            CardInfoDto updatedCardInfo = cardInfoService.updateCardInfo(cardInfoDto, id);
            return new ResponseEntity<>(updatedCardInfo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCardInfo(@PathVariable Long id) {
        try {
            cardInfoService.deleteCardInfo(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
