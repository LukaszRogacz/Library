package com.crud.kodillalibrary.mapper;

import com.crud.kodillalibrary.domain.Title;
import com.crud.kodillalibrary.domain.TitleDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TitleMapper {
    public Title mapToTitle(TitleDto titleDto) {
        return new Title(
                titleDto.getId(),
                titleDto.getTitle(),
                titleDto.getAuthor(),
                titleDto.getIssueDate(),
                titleDto.getBooks()
        );
    }

    public TitleDto mapToTitleDto(Title title) {
        return new TitleDto(
                title.getId(),
                title.getTitle(),
                title.getAuthor(),
                title.getIssueDate(),
                title.getBooks()
        );
    }

    public List<TitleDto> mapToTitleDtoList(List<Title> titleList) {
        return titleList.stream()
                .map(n -> new TitleDto(n.getId(), n.getTitle(), n.getAuthor(), n.getIssueDate(), n.getBooks()))
                .collect(Collectors.toList());
    }
}
