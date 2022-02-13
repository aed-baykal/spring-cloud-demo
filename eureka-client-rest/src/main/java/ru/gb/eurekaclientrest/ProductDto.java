package ru.gb.eurekaclientrest;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ProductDto {

    private Long id;

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    private String price;

    @NotNull
    private String category;
}
