package leetcode;

import java.util.ArrayList;
import java.util.List;

public class StringTextJustification {
    public static class LineProperty{
        int wordsNum;
        int spacesNum;
        boolean lastLine;
        LineProperty(int w, int s, boolean l) {
            this.wordsNum = w;
            this.spacesNum = s;
            this.lastLine = l;
        }
    }
    public ArrayList<String> fullJustify(String[] words, int width) {
        ArrayList<String> res = new ArrayList<>();
        dfs(words, res, 0, width);
        return res;
    }
    public void dfs(String[] words, List<String> res, int index, int len) {
        if (index == words.length) {
            return;
        }
        LineProperty property = getLineProperty(words, index, len);
        int spacesBetween = property.wordsNum > 2 ? property.spacesNum / (property.wordsNum - 1) : property.spacesNum;
        int spacesExtra = property.spacesNum - (spacesBetween * (property.wordsNum - 1));
        res.add(combineWords(words, index, property.wordsNum, property.spacesNum, spacesBetween, spacesExtra, property.lastLine));
        dfs(words, res, index + property.wordsNum, len);
    }
    public LineProperty getLineProperty(String[] dict, int fromIdx, int lineLen) {
        int strLenLen = 0;
        int wordsNum = 0;
        int wordsLen = 0;
        boolean lastLine = false;
        for (int i = fromIdx; i < dict.length; i ++) {
            if (strLenLen + dict[i].length() <= lineLen) {
                wordsNum ++;
                strLenLen += dict[i].length();
                wordsLen += dict[i].length();
                lastLine = i == dict.length - 1;
            } else {
                break;
            }
            if (strLenLen < lineLen) {
                strLenLen ++;
            } else {
                break;
            }
        }
        return new LineProperty(wordsNum, lineLen - wordsLen, lastLine);
    }
    public String combineWords(String[] dict, int fromIdx, int wordsNum, int spacesTotal, int spacesBetween, int spacesExtra, boolean lastLine) {
        StringBuilder sb = new StringBuilder();
        if (!lastLine) {
            for (int i = 0; i < wordsNum; i ++) {
                sb.append(dict[fromIdx + i]);
                if (wordsNum == 1 && i == 0) {
                    appendSpaces(sb, spacesBetween);
                } else if (i != wordsNum - 1){
                    appendSpaces(sb, spacesBetween + (spacesExtra-- > 0 ? 1 : 0));
                }
            }
        } else {
            for (int l = 0; l < wordsNum; l ++) {
                sb.append(dict[fromIdx + l]);
                if (l == wordsNum - 1) {
                    appendSpaces(sb, spacesTotal - wordsNum + 1);
                } else {
                    sb.append(" ");
                }
            }
        }
        return new String(sb);
    }
    public StringBuilder appendSpaces(StringBuilder sb, int num) {
        for (int i = 0; i < num; i ++) {
            sb.append(" ");
        }
        return sb;
    }
}
