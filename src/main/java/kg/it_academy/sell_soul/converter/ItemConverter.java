package kg.it_academy.sell_soul.converter;

import kg.it_academy.sell_soul.converter.base_converter.BaseConverter;
import kg.it_academy.sell_soul.entity.Item;
import kg.it_academy.sell_soul.model.ItemModel;

public class ItemConverter extends BaseConverter<ItemModel, Item> {
    public ItemConverter() {
        super(ItemConverter::convertToEntity, ItemConverter::convertToModel);
    }

    private static ItemModel convertToModel(Item entityToConvert) {
        if (entityToConvert == null) return null;

        return ItemModel.builder()
                .name(entityToConvert.getName())
                .description(entityToConvert.getDescription())
                .category(entityToConvert.getCategory())
                .build();
    }

    private static Item convertToEntity(ItemModel modelToConvert) {
        if (modelToConvert == null) return null;

        return Item.builder()
                .name(modelToConvert.getName())
                .description(modelToConvert.getDescription())
                .category(modelToConvert.getCategory())
                .build();
    }
}
