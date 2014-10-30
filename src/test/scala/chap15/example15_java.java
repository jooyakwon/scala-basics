package chap15;

import org.junit.Test;
import java.io.IOException;

/**
 * Created by kwonyoungjoo on 14. 10. 30..
 */
public class example15_java{

    @Test
    public void testScalaFunction() throws IOException {

        example15.readAll("/dump.txt");
        System.out.print( data );
        System.out.print("call scal function ");
    }

    @Test
    public void testScalaFunction2() {
        try {
            String data = example15.readAll("/dump.txt");
            System.out.print( data );
        } catch(IOException e) {
            System.out.print("IOException");
        }
    }

}
