package com.athensarenabox.subscription.models.client;

import com.athensarenabox.subscription.models.Model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class NewClientRegistrationModel implements Model {

    @JsonProperty(value = "mobile", required = true)
    private String mobile;

    @JsonProperty(value = "first_name", required = true)
    private String firstName;

    @JsonProperty(value = "last_name", required = true)
    private String lastName;

    @JsonProperty("email")
    private String email;
}
