package sample.cafekiosk.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import sample.cafekiosk.spring.api.controller.order.OrderController;
import sample.cafekiosk.spring.api.controller.product.ProductController;
import sample.cafekiosk.spring.api.service.order.OrderService;
import sample.cafekiosk.spring.api.service.product.ProductService;
import tools.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = {
        OrderController.class,
        ProductController.class,
})
public abstract class ControllerTestSupport {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @MockitoBean
    protected OrderService orderService;

    @MockitoBean // 테스트 스프링 컨테이너에 Mockito 로 만든 Mock 객체를 넣어준다.
    // ProductService 에 @MockitoBean 을 적용하면 ProductService 대신에 'ProductService Mock 객체' 를 대신 컨테이너에 넣는다.
    // @MockitoBean 이 없으면 ProductService 를 못 찾는다고 하면서 테스트가 불가능 할 것이다.
    // 왜냐하면 ProductController 는 ProductService 가 있어야 생성될 수 있는 Bean 인데,
    // @WebMvcTest 에서는 ProductService Bean 이 자동으로 안 올라올 수 있다.
    // 그래서 ProductService 자리에 Mock 객체를 넣어줘야
    // ProductController Bean 을 만들 수 있고, Controller 테스트를 진행할 수 있다.
    protected ProductService productService;

}
