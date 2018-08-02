import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Damo {
    public static void main(String[] args) {
        try {
            System.out.println("start");
            String[] args1=new String[]{"python","/root/python_workspace/SSM-Demo/test.py"};
            Process pr=Runtime.getRuntime().exec(args1);

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    pr.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            pr.waitFor();
            System.out.println("end");
        } catch (Exception e) {
            e.printStackTrace();
        }}
    public void test(){
        System.out.println("我的第一个方法C");
    }
}
