package com.athensarenabox.subscription.models.client;

import com.athensarenabox.subscription.models.Model;
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
public class UpdateClientDetailsModel implements Model {

    private String temp;
}
