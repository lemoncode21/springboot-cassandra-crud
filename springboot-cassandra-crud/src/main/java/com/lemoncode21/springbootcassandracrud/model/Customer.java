package com.lemoncode21.springbootcassandracrud.model;

import jnr.ffi.annotations.In;
import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {

    @PrimaryKey
    private UUID id;
    private String name;
    private Integer age;
    private Boolean customerActive;
}
