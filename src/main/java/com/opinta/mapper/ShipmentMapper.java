package com.opinta.mapper;

import com.opinta.dto.ShipmentDto;
import com.opinta.entity.Client;
import com.opinta.entity.Shipment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = ParcelMapper.class)
public interface ShipmentMapper extends BaseMapper<ShipmentDto, Shipment> {

    @Override
    @Mappings({
            @Mapping(source = "sender.id", target = "senderId"),
            @Mapping(source = "recipient.id", target = "recipientId"),
            @Mapping(source = "parcels", target = "parcelDtos"),

    })
    ShipmentDto toDto(Shipment shipment);

    @Override
    @Mappings({
            @Mapping(target = "sender", expression = "java(createClientById(shipmentDto.getSenderId()))"),
            @Mapping(target = "recipient", expression = "java(createClientById(shipmentDto.getRecipientId()))"),
            @Mapping(source = "parcelDtos", target = "parcels")
    })
    Shipment toEntity(ShipmentDto shipmentDto);

    default Client createClientById(long id) {
        Client client = new Client();
        client.setId(id);
        return client;
    }
}
