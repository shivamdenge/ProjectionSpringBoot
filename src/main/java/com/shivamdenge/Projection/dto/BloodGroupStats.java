package com.shivamdenge.Projection.dto;

import com.shivamdenge.Projection.entity.type.BloodGroupType;
import lombok.Data;

@Data
public class BloodGroupStats {
    private final BloodGroupType bloodGroupType;
    private final Long count;
}
