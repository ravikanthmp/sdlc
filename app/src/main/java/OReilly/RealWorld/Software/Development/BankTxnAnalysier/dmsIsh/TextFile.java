package OReilly.RealWorld.Software.Development.BankTxnAnalysier.dmsIsh;

import OReilly.RealWorld.Software.Development.BankTxnAnalysier.BankStatementCSVParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TextFile {
    private final File file;
    private List<String> lines;
    private final Map<String, String> attributeMap;

    public TextFile(File file) {
        this.file = file;
        this.attributeMap = new HashMap<>();
        setLines(file);
    }

    private void setLines(File file){
        if (lines != null){
            return;
        }

        try{
            String fileName = file.toPath().toString();
            InputStream is = BankStatementCSVParser.class.getResourceAsStream(fileName);

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));


            lines = reader.lines().collect(Collectors.toList());
            return;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        lines = new ArrayList<>();
    }

    public void addLine(String prefix, String attrName){
        for (String line : lines) {
            if (line.startsWith(prefix)){
                attributeMap.put(attrName, line.substring(prefix.length()));
                break;
            }
        }
    }

    public Map<String, String> getAttributes(){
        return attributeMap;
    }

}
