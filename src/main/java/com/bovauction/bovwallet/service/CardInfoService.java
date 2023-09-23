package com.bovauction.bovwallet.service;

import com.bovauction.bovwallet.dto.CardInfoDto;
import com.bovauction.bovwallet.exception.AppException;
import com.bovauction.bovwallet.model.CardInfo;
import com.bovauction.bovwallet.model.Client;
//import com.bovauction.bovwallet.model.User;
import com.bovauction.bovwallet.repository.CardInfoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CardInfoService {
    private final CardInfoRepository cardInfoRepository;

    public CardInfoService(CardInfoRepository cardInfoRepository) {
        this.cardInfoRepository = cardInfoRepository;
    }

    public CardInfoDto createCardInfo(CardInfoDto cardInfoDto, Long clientId) {
        CardInfo cardInfo = new CardInfo();
        cardInfo.setRace(cardInfoDto.getRace());
        cardInfo.setAge(cardInfoDto.getAge());
        cardInfo.setPrice(cardInfoDto.getPrice());
        cardInfo.setUrlImage(cardInfoDto.getUrlImage());

//        User user = new User();
//        user.setId(userId);
//        cardInfo.setUser(user);

        Client client = new Client();
        client.setId(clientId);
        cardInfo.setClient(client);

        CardInfo createdCardInfo = cardInfoRepository.save(cardInfo);

        return mapToCardInfoDto(createdCardInfo);
    }

    public CardInfoDto retrieveCardInfo(long id) throws Exception {
        Optional<CardInfo> cardInfoOptional = cardInfoRepository.findById(id);

        if (cardInfoOptional.isPresent()) {
            return mapToCardInfoDto(cardInfoOptional.get());
        } else {
            throw new AppException("CardInfo not found", HttpStatus.NOT_FOUND);
        }
    }

    public CardInfoDto updateCardInfo(CardInfoDto cardInfoDto, long id) {
        Optional<CardInfo> cardInfoOptional = cardInfoRepository.findById(id);

        if (cardInfoOptional.isPresent()) {
            CardInfo existingCardInfo = cardInfoOptional.get();
            existingCardInfo.setRace(cardInfoDto.getRace());
            existingCardInfo.setAge(cardInfoDto.getAge());
            existingCardInfo.setPrice(cardInfoDto.getPrice());
            existingCardInfo.setUrlImage(cardInfoDto.getUrlImage());

            CardInfo updatedCardInfo = cardInfoRepository.save(existingCardInfo);

            return mapToCardInfoDto(updatedCardInfo);
        } else {
            throw new AppException("CardInfo not found", HttpStatus.NOT_FOUND);
        }
    }

    public void deleteCardInfo(long id) {
        Optional<CardInfo> cardInfoOptional = cardInfoRepository.findById(id);

        if (cardInfoOptional.isPresent()) {
            cardInfoRepository.delete(cardInfoOptional.get());
        } else {
            throw new AppException("CardInfo not found", HttpStatus.NOT_FOUND);
        }
    }

    public List<CardInfoDto> getAllCardInfoByUserId(Long clientId) {
        List<CardInfo> cardInfoList = cardInfoRepository.findByClient_Id(clientId);
        return cardInfoList.stream().map(this::mapToCardInfoDto).collect(Collectors.toList());
    }

    private CardInfoDto mapToCardInfoDto(CardInfo cardInfo) {
        CardInfoDto cardInfoDto = new CardInfoDto();
        cardInfoDto.setRace(cardInfo.getRace());
        cardInfoDto.setAge(cardInfo.getAge());
        cardInfoDto.setPrice(cardInfo.getPrice());
        cardInfoDto.setUrlImage(cardInfo.getUrlImage());
        return cardInfoDto;
    }
}
