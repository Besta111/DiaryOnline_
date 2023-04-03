package ru.diakina.diaryonline.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiaryUpdateForm {

    private Long id;
    private Long personId;
    @Size(min = 3, max = 20)
    @NotBlank
    private String name;
}
