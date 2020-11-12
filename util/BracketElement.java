package test.util;

import lombok.Data;

import java.util.*;

@Data
public class BracketElement {
    private boolean value;

    // 待解析字符串
    private String elementStr;

    // 子括号元素
    private List<BracketElement> innerBracket;

    // 不可分的元字符
    private String schemaStr;

    public boolean valid(String str){
        return true;
    }

    public boolean judge(){
        if(this.schemaStr!=null){
            List<Character> logics = new ArrayList<>();
            for(char c: schemaStr.toCharArray()){
                if(c=='!'||c=='&'|| c=='|'){
                    logics.add(c);
                }
            }
            List<String> list = Arrays.asList(schemaStr.split("[\\!,\\&,\\^]?"));

            Iterator<String> str = list.iterator();
            boolean former = str.next().equals("true");
            int logicIndex = 0;

            while (str.hasNext()){
                if(logics.get(logicIndex).equals("true")){

                }
            }
        }
    }
}
