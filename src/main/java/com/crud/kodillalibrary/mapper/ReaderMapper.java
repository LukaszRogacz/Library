package com.crud.kodillalibrary.mapper;

import com.crud.kodillalibrary.domain.Reader;
import com.crud.kodillalibrary.domain.ReaderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReaderMapper {
    public Reader mapToReader(ReaderDto readerDto) {
        return new Reader(
                readerDto.getId(),
                readerDto.getFirstname(),
                readerDto.getLastname(),
                readerDto.getAccountCreationDate(),
                readerDto.getRentals()
        );
    }

    public ReaderDto mapToReaderDto(Reader reader) {
        return new ReaderDto(
                reader.getId(),
                reader.getFirstname(),
                reader.getLastname(),
                reader.getAccountCreationDate(),
                reader.getRentals()
        );
    }

    public List<ReaderDto> mapToReaderDtoList(List<Reader> readerList) {
        return readerList.stream()
                .map(n -> new ReaderDto(n.getId(), n.getFirstname(), n.getLastname(), n.getAccountCreationDate(), n.getRentals()))
                .collect(Collectors.toList());
    }
}
