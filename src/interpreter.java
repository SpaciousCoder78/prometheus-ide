//importing modules
import javax.script.*;
import java.io.*;
public class interpreter {
    public static void main(String[] args) throws Exception{
        //calling nashorn js engine
        ScriptEngine ee = new ScriptEngineManager().getEngineByName("Nashorn");
        ee.eval(new FileReader("C:/Users/aryan/OneDrive/Documents/Github/prometheus-ide/src/holyc-interpreter.js"));
    }
}
