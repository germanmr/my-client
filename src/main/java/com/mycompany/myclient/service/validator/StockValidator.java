package com.mycompany.myclient.service.validator;


import org.springframework.stereotype.Component;

@Component
public class StockValidator {

//    private final Set<ItemDto> dummyItems;
//
//    public StockValidator() {
//        this.dummyItems = new HashSet<>();
//        dummyItems.add(new ItemDto(1, "KEYBOARD", BigInteger.TEN));
//        dummyItems.add(new ItemDto(2, "MONITOR", BigInteger.ONE));
//        dummyItems.add(new ItemDto(2, "RAM", BigInteger.ZERO));
//    }
//
//    public void validate(@Nonnull ItemDto itemDto) {
//        requireNonNull(itemDto);
//
//        // TODO CONSUME A validator service!!
//        // Consume another service with Retrofit, RestEasy or ??
//        // We could alse use rabbitMq, Apache Camel, Kafka or any Jms
//        // We can use a Functional Interface "CONVERTER" something Item2ItemDto
//
//        Predicate<ItemDto> predicateId = item -> itemDto.getId().equals(item.getId());
//        Predicate<ItemDto> predicateQuantity = it -> itemDto.getQuantity().compareTo(it.getQuantity()) > 0;
//
//        dummyItems.stream()
//                .filter(predicateId.and(predicateQuantity))
//                .findAny()
//                .orElseThrow(NoStockFoundException::new);
//
//
//    }
}
