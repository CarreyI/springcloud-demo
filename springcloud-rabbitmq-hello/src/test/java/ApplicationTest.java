import com.springcloud.rabbitmq.Application;
import com.springcloud.rabbitmq.mq.producter.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class ApplicationTest {
    @Autowired
    private Sender sender;

    @Test
    public void hello(){
        sender.send();
    }
}
