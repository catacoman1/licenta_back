package com.RestAPIdb.RestApiDB.dto;

import com.RestAPIdb.RestApiDB.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GlicemieDto {
    private Long id;
    private Float value;
    private LocalDate date;



}
