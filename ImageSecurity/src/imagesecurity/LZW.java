package imagesecurity;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Suman
 */
public class LZW{
    private FileReader input;
    private FileWriter output;
    private int code;
    private HashMap<String,Integer> dictionery;

    public LZW(){
        input = null;
        output = null;
        dictionery = new HashMap<String,Integer>();
        code = 0;
    }

    public void encode(String in, String out){
        int ch;
        String s,c,temp;
        
        try{
            input = new FileReader(in);
            output = new FileWriter(out);
        
            if((ch = input.read()) != -1){
                s = Integer.toString(ch);
                
                while((ch = input.read()) != -1)
                {
                    c = Integer.toString(ch);
                    temp = s+c;
                    if(dictionery.containsKey(temp)){
                        s = temp;
                    }
                    else
                    {
                        dictionery.put(temp, ++code);
                        s=c;
                        output.write(dictionery.get(s));
                    }
                }
                output.write(dictionery.get(s));
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}