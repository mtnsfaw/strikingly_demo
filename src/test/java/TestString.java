import com.strikingly.service.StringTaskService;
import com.strikingly.service.impl.StringTaskServiceImpl;

/**
 * @Description TODO
 * @Author linjie
 * @Date 2022/9/29 22:41
 * @Version 1.0
 */
public class TestString {
    public static void main(String[] args) throws Exception {
        StringTaskService service = new StringTaskServiceImpl();
        String content = "My name is {{ name }} and I am forever {{ age }}.";
        String values = "{'name':'Bill','age':21, 'male':true}";

        String result = service.rebuildString(content, values);
        System.out.println(result);


        content = "Tommy is a good friend of {{ name }}. He lives in {{ city }}.";
        values = "{'name':'Bill'}";
        result = service.rebuildString(content, values);
        System.out.println(result);
    }

}
