package io.pivotal.pal.tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class EnvController {
    String port;
    String memory;
    String index;
    String address;
    public EnvController(@Value("${PORT:NOT SET}") String port,
                       @Value("${MEMORY_LIMIT:NOT SET}") String memory,
                       @Value("${CF_INSTANCE_INDEX:NOT SET}") String index,
                       @Value("${CF_INSTANCE_ADDR:NOT SET}") String address){
        this.port=port;
        this.memory=memory;
        this.index=index;
        this.address=address;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv(){
        Map<String, String> env = new HashMap<>();

        env.put("PORT", port);
        env.put("MEMORY_LIMIT", memory);
        env.put("CF_INSTANCE_INDEX", index);
        env.put("CF_INSTANCE_ADDR", address);

        return env;
    }
}
