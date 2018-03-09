package guru.springframework.springrestclientexamples.services;

import guru.springframework.api.domain.User;
import guru.springframework.api.domain.UserData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@AllArgsConstructor
@Service
public class ApiServiceImpl implements ApiService {

    private static final String URL = "http://apifaketory.com/api/user?limit=";
    private RestTemplate restTemplate;

    @Override
    public List<User> getUsers(Integer limit) {

        UserData userData = restTemplate.getForObject(URL + limit, UserData.class);
        return userData.getData();
    }
}
