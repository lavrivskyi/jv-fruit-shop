package core.basesyntax.service.files;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.validation.DataValidator;
import core.basesyntax.service.validation.DataValidatorImpl;
import java.util.ArrayList;
import java.util.List;

public class InputRowParserImpl implements InputRowParser {
    private static final String DATA_DIVIDER = ",";
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int OPERATION_TYPE = 0;
    private static final int FRUITS_AMOUNT = 2;

    @Override
    public List<FruitRecord> parse(List<String> fileData) {
        List<FruitRecord> fruitRecords = new ArrayList<>();
        for (String row : fileData) {
            String[] inputRowData = row.split(DATA_DIVIDER);
            DataValidator isInputRowValid = new DataValidatorImpl();
            isInputRowValid.validate(inputRowData);
            String fruitName = inputRowData[FRUIT_NAME_INDEX];
            FruitRecord.Type operationType = FruitRecord.Type.getType(inputRowData[OPERATION_TYPE]);
            int fruitsAmount = Integer.parseInt(inputRowData[FRUITS_AMOUNT]);
            Fruit newFruit = new Fruit(fruitName);
            fruitRecords.add(new FruitRecord(fruitsAmount, newFruit, operationType));
        }
        return fruitRecords;
    }
}
