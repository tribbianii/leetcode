package leetcode;

public class StringNode implements GenericNode{
    String value;

    @Override
    public String getValue() {
        return value;
    }

    StringNode(String str) {
        this.value = str;
    }
}
