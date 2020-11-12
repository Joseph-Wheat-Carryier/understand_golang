package test.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.*;

public class LogicStringParser {

    public void parseBraketElemtn(BracketElement element) throws Exception {
        String  subString = element.getElementStr();
        List<BracketElement> list = parseString(subString);
        if(list != null){
            list.forEach(be-> {
                try {
                    parseString(be.getElementStr());
                    parseBraketElemtn(be);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        element.setSchemaStr(subString);
    }

    public List<BracketElement> parseString(String string) throws Exception {
        List<BracketElement> elements = new ArrayList<>();
        // key:括号的下标, value括号的值
        LinkedHashMap<Integer, Character> bracketIndexMap = new LinkedHashMap<>();

        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == ')') {
                bracketIndexMap.put(i, chars[i]);
            }
        }

        Iterator<Entry<Integer, Character>> it = bracketIndexMap.entrySet().iterator();

        int index = 0;
        // 左括号数量
        int leftIndex = 0;
        int leftCount = 0;
        int rightCount = 0;

        // 没有元素
        if(!it.hasNext()){
            return null;
        }

        while (it.hasNext()) {
            Entry<Integer, Character> entry = it.next();
            char c = entry.getValue();
            if (index == 0 && c == ')') {
                throw new Exception("error format");
            }

            if (c == ')') {
                if (leftCount == ++rightCount && leftCount == 1) {
                    BracketElement element = new BracketElement();
                    element.setElementStr(string.substring(leftIndex + 1, entry.getKey() ));
                    elements.add(element);
                    // 匹配完成一个闭合, 归零
                    leftCount = 0;
                }

                if (leftCount > 1 && leftCount == rightCount) {
                    BracketElement element = new BracketElement();
                    element.setElementStr(string.substring(leftIndex + 1, entry.getKey() ));
                    elements.add(element);
                }
            }

            // 左括号
            leftCount++;
            if(leftCount==1) {
                leftIndex = entry.getKey();
            }
        }
        return elements;
    }
}
