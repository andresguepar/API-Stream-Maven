package apiStream.mapping.dtos;

import apiStream.domain.enums.CustomerType;

public record CustomerDto(long id,
                          String name,
                          CustomerType tier) {


}
