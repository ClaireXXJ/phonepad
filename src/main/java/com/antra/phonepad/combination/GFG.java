package com.antra.phonepad.combination;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class GFG {
    static final String codes[]
            = {" ", " ", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz",
            };

    // Function that returns an Arraylist
    // which contains all the generated words
    public ArrayList<String> printKeyWords(String str) throws IOException {

        // If str is empty
        if (str.length() == 0) {
            ArrayList<String> baseRes = new ArrayList<>();
            baseRes.add("");

            // Return an Arraylist containing
            // empty string
            return baseRes;
        }

        // First character of str
        char ch = str.charAt(0);

        // Rest of the characters of str
        String restStr = str.substring(1);

        ArrayList<String> prevRes = printKeyWords(restStr);
        ArrayList<String> Res = new ArrayList<>();

        String code = codes[ch - '0'];

        for (String val : prevRes) {

            for (int i = 0; i < code.length(); i++) {
                Res.add(code.charAt(i) + val);
            }
        }

        ArrayList<String> result = new ArrayList<>();

        Path path = Paths.get("words.txt");
        byte[] readBytes = Files.readAllBytes(path);
        String wordListContents = new String(readBytes, "UTF-8");
        String[] words = wordListContents.split("\\s");

        HashSet<String> wordsSet = new HashSet<>();
        Collections.addAll(wordsSet, words);
//        Dictionary dc = new Dictionary();

        for(String e: Res){
            if(wordsSet.contains(e)){
                result.add(e);
            }
        }
//        for(String w: wordsSet){
//            result.add(w);
//        }
        return result;
    }
}
