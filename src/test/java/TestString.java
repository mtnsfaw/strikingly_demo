import com.strikingly.service.StringTaskService;
import com.strikingly.service.impl.StringTaskServiceImpl;
import org.junit.Test;

/**
 * @Description TODO
 * @Author linjie
 * @Date 2022/9/29 22:41
 * @Version 1.0
 */
public class TestString {

    /**
     * Given the following parameters:
     *
     * - content: "My name is {{ name }} and I am forever {{ age }}."
     *
     * - values: { "name": "Bill", "age": 21 } (This is a JSON representation just for the purpose of demonstrating the test case, but you should choose the key-value pair object type supported by the language you choose)
     *
     * Your function/method should return "My name is Bill and I am forever 21.".
     * @throws Exception
     */
    @Test
    public void testCase1() throws Exception {
        StringTaskService service = new StringTaskServiceImpl();
        String content = "My name is {{ name }} and I am forever {{ age }}.";
        String values = "{'name':'Bill','age':21}";

        String result = service.rebuildString(content, values);
        System.out.println(result);
    }

    /**
     * Given the following parameters:
     *
     * - content: "Say hello to {{ name }}. He is {{ age }}."
     *
     * - values: { "name": "Bill", "age": 21, "male": true} (This is a JSON representation just for the purpose of demonstrating the test case, but you should choose the key-value pair object type supported by the language you choose)
     *
     * Your function/method should return "Say hello to Bill. He is 21.". You can see that the key "male" is ignored because it's not one of the variables in the content.
     * @throws Exception
     */
    @Test
    public void testCase2() throws Exception {
        StringTaskService service = new StringTaskServiceImpl();
        String content = "Say hello to {{ name }}. He is {{ age }}..";
        String values = "{'name':'Bill','age':21,'male':true}";

        String result = service.rebuildString(content, values);
        System.out.println(result);
    }

    /**
     * Given the following parameters:
     *
     * - content: "Tommy is a good friend of {{ name }}. He lives in {{ city }}."
     *
     * - values: { "name": "Bill" } (This is a JSON representation just for the purpose of demonstrating the test case, but you should choose the key-value pair object type supported by the language you choose)
     *
     * Your function/method should throw exception/error because the variable "city" is missing from the keys of the values object.
     * @throws Exception
     */
    @Test
    public void testCase3() throws Exception {
        StringTaskService service = new StringTaskServiceImpl();
        String content = "Tommy is a good friend of {{ name }}. He lives in {{ city }}.";
        String values = "{'name':'Bill'}";

        String result = service.rebuildString(content, values);
        System.out.println(result);
    }

}
