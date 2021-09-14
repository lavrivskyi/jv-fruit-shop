package core.basesyntax.service.files;

import core.basesyntax.model.FruitRecord;

import java.util.List;

public interface InputRowParser {
    List<FruitRecord> parse(List<String> fileData);
}