package model;

/**
 * model.Data - working with data set
 *
 * @author Sergey Iryupin
 * @version 0.1 dated Mar 17, 2018
 */
import java.util.List;
import java.util.ArrayList;

import static tools.IConstants.*;
import tools.Tools;

public class Data {
    List<Float> data;
    int pointer;

    public Data() {
        data = new ArrayList<>();
    }

    public void init(ProgramLines programLines) {
        for (Integer line : programLines.keySet()) {
            String str = programLines.get(line);
            if (str.startsWith(OPER_DATA)) {
                String list = Tools.getPartOfString(str, 1);
                String[] numbers = list.split(",");
                for (int i = 0; i < numbers.length; i++)
                    try {
                        data.add(Float.parseFloat(numbers[i]));
                    } catch (NumberFormatException ex) {
                        data.add(0f);
                    }
            }
        }
        pointer = 0;
    }
}