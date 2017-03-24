package whereToLunch.web.user;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import whereToLunch.model.User;
import whereToLunch.to.UserTo;
import whereToLunch.util.UserUtil;
import whereToLunch.web.AbstractControllerTest;
import whereToLunch.web.json.JsonUtil;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static whereToLunch.testData.UserTestData.MATCHER;
import static whereToLunch.testData.UserTestData.USER;
import static whereToLunch.testUtil.TestUtil.userHttpBasic;
import static whereToLunch.web.user.ProfileRestController.REST_URL;

/**
 * Created by Eugene on 24.03.2017.
 */
public class ProfileRestControllerTest extends AbstractControllerTest {



    @Test
    @Transactional
    public void testUpdate() throws Exception {
        UserTo updatedTo = new UserTo(null, "newName", "newemail@ya.ru", "newPassword");

        mockMvc.perform(put(REST_URL).contentType(MediaType.APPLICATION_JSON)
                .with(userHttpBasic(USER))
                .content(JsonUtil.writeValue(updatedTo)))
                .andDo(print())
                .andExpect(status().isOk());

        MATCHER.assertEquals(UserUtil.updateFromTo(new User(USER), updatedTo), userService.getByEmail("newemail@ya.ru"));
    }


}
