package edu.miu.cs.cs425.fairfieldlibrarywebapi.dto;

import edu.miu.cs.cs425.fairfieldlibrarywebapi.model.PrimaryAddress;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class PublisherRequest {
    @NotBlank(message = "Publisher name cannot be null, empty or blank")
    private String name;
    private PrimaryAddress primaryAddress;

    public String getName() {
        return name;
    }
}
